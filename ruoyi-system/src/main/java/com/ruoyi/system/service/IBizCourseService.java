package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.BizCourse;

/**
 * 课程信息Service接口
 * 
 * @author ruoyi
 * @date 2026-04-03
 */
public interface IBizCourseService 
{
    /**
     * 查询课程信息
     * 
     * @param id 课程信息主键
     * @return 课程信息
     */
    public BizCourse selectBizCourseById(Long id);

    /**
     * 查询课程信息列表
     * 
     * @param bizCourse 课程信息
     * @return 课程信息集合
     */
    public List<BizCourse> selectBizCourseList(BizCourse bizCourse);

    /**
     * 新增课程信息
     * 
     * @param bizCourse 课程信息
     * @return 结果
     */
    public int insertBizCourse(BizCourse bizCourse);

    /**
     * 修改课程信息
     * 
     * @param bizCourse 课程信息
     * @return 结果
     */
    public int updateBizCourse(BizCourse bizCourse);

    /**
     * 批量删除课程信息
     * 
     * @param ids 需要删除的课程信息主键集合
     * @return 结果
     */
    public int deleteBizCourseByIds(Long[] ids);

    /**
     * 删除课程信息信息
     * 
     * @param id 课程信息主键
     * @return 结果
     */
    public int deleteBizCourseById(Long id);
}
