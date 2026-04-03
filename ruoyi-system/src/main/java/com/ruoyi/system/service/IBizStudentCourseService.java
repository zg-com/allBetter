package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.BizStudentCourse;

/**
 * 学生选课与成绩Service接口
 * 
 * @author ruoyi
 * @date 2026-04-03
 */
public interface IBizStudentCourseService 
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
     * 批量删除学生选课与成绩
     * 
     * @param ids 需要删除的学生选课与成绩主键集合
     * @return 结果
     */
    public int deleteBizStudentCourseByIds(Long[] ids);

    /**
     * 删除学生选课与成绩信息
     * 
     * @param id 学生选课与成绩主键
     * @return 结果
     */
    public int deleteBizStudentCourseById(Long id);
}
