package com.learningmplat.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learningmplat.backend.domain.BizStudentCourse;
import com.learningmplat.backend.domain.vo.CourseScoreVO;
import com.learningmplat.backend.domain.vo.MajorRankVO;
import com.learningmplat.backend.service.BizStudentCourseService;
import com.learningmplat.backend.mapper.BizStudentCourseMapper;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
* @author 13027
* @description 针对表【biz_student_course(学生选课与成绩关联表)】的数据库操作Service实现
* @createDate 2026-03-16 13:41:11
*/
@Service
public class BizStudentCourseServiceImpl extends ServiceImpl<BizStudentCourseMapper, BizStudentCourse>
    implements BizStudentCourseService{
    @Override
    public void selectCourse(Long courseId, Long studentId) {

        // 1. 【核心防御机制】：查一下这个学生是不是已经选过这门课了？
        LambdaQueryWrapper<BizStudentCourse> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(BizStudentCourse::getStudentId, studentId)
                .eq(BizStudentCourse::getTeachingClassId, courseId);

        // 只要能查出哪怕 1 条数据，说明他已经选过了
        long count = this.count(wrapper);

        if (count > 0) {
            // 直接抛出异常，咱们的全局防弹衣会优雅地把错误弹给前端
            throw new RuntimeException("你已经选过这门课啦，请勿重复选择！");
        }

        // 2. 校验通过！生成一条选课记录
        BizStudentCourse studentCourse = new BizStudentCourse();
        studentCourse.setStudentId(studentId);
        studentCourse.setTeachingClassId(courseId);

        // 3. 完美落库！
        this.save(studentCourse);
    }

    //获取学分
    @Override
    public Integer getCredit(Long studentId){
        Integer totalCredit = this.baseMapper.sumCreditByStudentId(studentId);

        if(totalCredit == null) {
            return 0;
        }

        return totalCredit;
    }

    //获取各科成绩
    @Override
    public List<CourseScoreVO> getScore(Long studentId){
        List<CourseScoreVO> allScore = this.baseMapper.getAllCourseScore(studentId);

        if(allScore == null) {
            return Collections.emptyList();
        }

        return allScore;
    }

    //获取专业排名
    @Override
    public MajorRankVO getRanking(Long studentId){
        MajorRankVO rankingData = this.baseMapper.getRanking(studentId);

        if(rankingData == null){
            return null;
        }

        return rankingData;
    }
}




