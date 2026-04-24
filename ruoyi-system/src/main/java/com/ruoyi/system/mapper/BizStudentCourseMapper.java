package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.BizStudentCourse;

/**
 * 学生选课与成绩Mapper接口
 * 
 * @author ruoyi
 * @date 2026-04-10
 */
public interface BizStudentCourseMapper 
{
    /**
     * 查询学生选课与成绩
     * 
     * @param id 学生选课与成绩主键
     * @return 学生选课与成绩
     */
    public BizStudentCourse selectBizStudentCourseById(Long id);

    /**
     * 查询学生选课与成绩列表
     * 
     * @param bizStudentCourse 学生选课与成绩
     * @return 学生选课与成绩集合
     */
    public List<BizStudentCourse> selectBizStudentCourseList(BizStudentCourse bizStudentCourse);

    /**
     * 新增学生选课与成绩
     * 
     * @param bizStudentCourse 学生选课与成绩
     * @return 结果
     */
    public int insertBizStudentCourse(BizStudentCourse bizStudentCourse);

    /**
     * 修改学生选课与成绩
     * 
     * @param bizStudentCourse 学生选课与成绩
     * @return 结果
     */
    public int updateBizStudentCourse(BizStudentCourse bizStudentCourse);

    /**
     * 删除学生选课与成绩
     * 
     * @param id 学生选课与成绩主键
     * @return 结果
     */
    public int deleteBizStudentCourseById(Long id);

    /**
     * 批量删除学生选课与成绩
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBizStudentCourseByIds(Long[] ids);

    /**
     * 选课：课程当前人数 +1（原子操作）
     * @param courseId 课程ID
     * @return 影响的行数
     */
    public int incrementCourseNum(Long courseId);

    /**
     * 退选：课程当前人数 -1（原子操作）
     * @param courseId 课程ID
     * @return 影响的行数
     */
    public int decrementCourseNum(Long courseId);

    /**
     * 一键开课：批量更新选课状态
     * * @param courseId 课程ID
     * @return 影响行数
     */
    public int startCourse(Long courseId);
}
