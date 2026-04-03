package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.BizStudentCourseMapper;
import com.ruoyi.system.domain.BizStudentCourse;
import com.ruoyi.system.service.IBizStudentCourseService;

/**
 * 学生选课与成绩Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-04-03
 */
@Service
public class BizStudentCourseServiceImpl implements IBizStudentCourseService 
{
    @Autowired
    private BizStudentCourseMapper bizStudentCourseMapper;

    /**
     * 查询学生选课与成绩
     * 
     * @param id 学生选课与成绩主键
     * @return 学生选课与成绩
     */
    @Override
    public BizStudentCourse selectBizStudentCourseById(Long id)
    {
        return bizStudentCourseMapper.selectBizStudentCourseById(id);
    }

    /**
     * 查询学生选课与成绩列表
     * 
     * @param bizStudentCourse 学生选课与成绩
     * @return 学生选课与成绩
     */
    @Override
    public List<BizStudentCourse> selectBizStudentCourseList(BizStudentCourse bizStudentCourse)
    {
        return bizStudentCourseMapper.selectBizStudentCourseList(bizStudentCourse);
    }

    /**
     * 新增学生选课与成绩
     * 
     * @param bizStudentCourse 学生选课与成绩
     * @return 结果
     */
    @Override
    public int insertBizStudentCourse(BizStudentCourse bizStudentCourse)
    {
        bizStudentCourse.setCreateTime(DateUtils.getNowDate());
        return bizStudentCourseMapper.insertBizStudentCourse(bizStudentCourse);
    }

    /**
     * 修改学生选课与成绩
     * 
     * @param bizStudentCourse 学生选课与成绩
     * @return 结果
     */
    @Override
    public int updateBizStudentCourse(BizStudentCourse bizStudentCourse)
    {
        bizStudentCourse.setUpdateTime(DateUtils.getNowDate());
        return bizStudentCourseMapper.updateBizStudentCourse(bizStudentCourse);
    }

    /**
     * 批量删除学生选课与成绩
     * 
     * @param ids 需要删除的学生选课与成绩主键
     * @return 结果
     */
    @Override
    public int deleteBizStudentCourseByIds(Long[] ids)
    {
        return bizStudentCourseMapper.deleteBizStudentCourseByIds(ids);
    }

    /**
     * 删除学生选课与成绩信息
     * 
     * @param id 学生选课与成绩主键
     * @return 结果
     */
    @Override
    public int deleteBizStudentCourseById(Long id)
    {
        return bizStudentCourseMapper.deleteBizStudentCourseById(id);
    }
}
