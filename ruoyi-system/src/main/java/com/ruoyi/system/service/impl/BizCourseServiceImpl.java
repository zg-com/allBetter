package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.BizCourseMapper;
import com.ruoyi.system.domain.BizCourse;
import com.ruoyi.system.service.IBizCourseService;

/**
 * 课程信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-04-03
 */
@Service
public class BizCourseServiceImpl implements IBizCourseService 
{
    @Autowired
    private BizCourseMapper bizCourseMapper;

    /**
     * 查询课程信息
     * 
     * @param id 课程信息主键
     * @return 课程信息
     */
    @Override
    public BizCourse selectBizCourseById(Long id)
    {
        return bizCourseMapper.selectBizCourseById(id);
    }

    /**
     * 查询课程信息列表
     * 
     * @param bizCourse 课程信息
     * @return 课程信息
     */
    @Override
    public List<BizCourse> selectBizCourseList(BizCourse bizCourse)
    {
        return bizCourseMapper.selectBizCourseList(bizCourse);
    }

    /**
     * 新增课程信息
     * 
     * @param bizCourse 课程信息
     * @return 结果
     */
    @Override
    public int insertBizCourse(BizCourse bizCourse)
    {
        bizCourse.setCreateTime(DateUtils.getNowDate());
        return bizCourseMapper.insertBizCourse(bizCourse);
    }

    /**
     * 修改课程信息
     * 
     * @param bizCourse 课程信息
     * @return 结果
     */
    @Override
    public int updateBizCourse(BizCourse bizCourse)
    {
        return bizCourseMapper.updateBizCourse(bizCourse);
    }

    /**
     * 批量删除课程信息
     * 
     * @param ids 需要删除的课程信息主键
     * @return 结果
     */
    @Override
    public int deleteBizCourseByIds(Long[] ids)
    {
        return bizCourseMapper.deleteBizCourseByIds(ids);
    }

    /**
     * 删除课程信息信息
     * 
     * @param id 课程信息主键
     * @return 结果
     */
    @Override
    public int deleteBizCourseById(Long id)
    {
        return bizCourseMapper.deleteBizCourseById(id);
    }
}
