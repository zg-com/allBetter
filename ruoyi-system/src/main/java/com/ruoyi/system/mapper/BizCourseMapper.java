package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.BizCourse;

/**
 * 课程信息Mapper接口
 * 
 * @author ruoyi
 * @date 2026-04-10
 */
public interface BizCourseMapper 
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
     * 删除课程信息
     * 
     * @param id 课程信息主键
     * @return 结果
     */
    public int deleteBizCourseById(Long id);

    /**
     * 批量删除课程信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBizCourseByIds(Long[] ids);

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
}
