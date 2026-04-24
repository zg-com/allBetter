package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.system.domain.BizCourse;
import com.ruoyi.system.domain.BizStudentCourse;
import com.ruoyi.system.mapper.BizCourseMapper;
import com.ruoyi.system.mapper.BizStudentCourseMapper;
import com.ruoyi.system.mapper.BizTeacherGradeMapper;
import com.ruoyi.system.service.IBizTeacherGradeService;

/**
 * 教师教学与成绩管理 Service 业务层处理
 */
@Service
public class BizTeacherGradeServiceImpl implements IBizTeacherGradeService {

    // 注入我们为老师专属定制的 Mapper
    @Autowired
    private BizTeacherGradeMapper bizTeacherGradeMapper;

    // 注入原生的课程 Mapper (为了复用基础查询)
    @Autowired
    private BizCourseMapper bizCourseMapper;

    // 注入原生的选课 Mapper (为了复用单条数据的更新)
    @Autowired
    private BizStudentCourseMapper bizStudentCourseMapper;

    /**
     * 查询老师负责的课程列表
     */
    @Override
    public List<BizCourse> selectTeacherCourseList(BizCourse course) {
        // 直接复用原生课程查询，Controller 层已经将 teacherId 塞进 course 对象里了
        return bizCourseMapper.selectBizCourseList(course);
    }

    /**
     * 查询某门课下的学生名单（含成绩、档案信息）
     */
    @Override
    public List<BizStudentCourse> selectCourseStudentList(BizStudentCourse studentCourse) {
        // 调用专属 Mapper，执行包含学生信息的 JOIN 复杂查询
        return bizTeacherGradeMapper.selectCourseStudentList(studentCourse);
    }

    /**
     * 开启课程教学
     */
    @Override
    public int startCourse(Long courseId) {
        // 🎯 业务逻辑 1：开课前检查
        // 如果这门课连一个选课的学生都没有，不允许直接开课
        BizStudentCourse query = new BizStudentCourse();
        query.setCourseId(courseId);
        List<BizStudentCourse> list = bizTeacherGradeMapper.selectCourseStudentList(query);
        if (list.isEmpty()) {
            throw new ServiceException("当前课程暂无学生选修，无法开启教学任务！");
        }

        // 调用专属 Mapper 进行批量状态更新 (将 0 变为 1)
        return bizTeacherGradeMapper.updateBatchLearnStatus(courseId);
    }

    /**
     * 录入学生成绩并结课
     */
    @Override
    public int updateGrade(BizStudentCourse studentCourse) {
        // 🎯 业务逻辑 2：成绩合法性校验
        if (studentCourse.getScore() != null) {
            double score = studentCourse.getScore().doubleValue();
            if (score < 0 || score > 100) {
                // 抛出异常，前端会自动弹出红色的错误提示框
                throw new ServiceException("录入失败：成绩必须在 0 到 100 之间！");
            }
        }

        // 教师打分操作，意味着该学生的这门课彻底结束，状态置为 2 (已结课)
        studentCourse.setLearnStatus(2L);

        // 对于单条记录的更新，直接复用原生 Mapper，无需重复写 SQL
        return bizStudentCourseMapper.updateBizStudentCourse(studentCourse);
    }
}