package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.BizStudentProfileMapper;
import com.ruoyi.system.domain.BizStudentProfile;
import com.ruoyi.system.service.IBizStudentProfileService;

/**
 * 学生基础学籍档案Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-04-10
 */
@Service
public class BizStudentProfileServiceImpl implements IBizStudentProfileService 
{
    @Autowired
    private BizStudentProfileMapper bizStudentProfileMapper;

    /**
     * 查询学生基础学籍档案
     * 
     * @param id 学生基础学籍档案主键
     * @return 学生基础学籍档案
     */
    @Override
    public BizStudentProfile selectBizStudentProfileById(Long id)
    {
        return bizStudentProfileMapper.selectBizStudentProfileById(id);
    }

    /**
     * 查询学生基础学籍档案列表
     * 
     * @param bizStudentProfile 学生基础学籍档案
     * @return 学生基础学籍档案
     */
    @Override
    public List<BizStudentProfile> selectBizStudentProfileList(BizStudentProfile bizStudentProfile)
    {
        return bizStudentProfileMapper.selectBizStudentProfileList(bizStudentProfile);
    }

    /**
     * 新增学生基础学籍档案
     * 
     * @param bizStudentProfile 学生基础学籍档案
     * @return 结果
     */
    @Override
    public int insertBizStudentProfile(BizStudentProfile bizStudentProfile)
    {
        bizStudentProfile.setCreateTime(DateUtils.getNowDate());
        return bizStudentProfileMapper.insertBizStudentProfile(bizStudentProfile);
    }

    /**
     * 修改学生基础学籍档案
     * 
     * @param bizStudentProfile 学生基础学籍档案
     * @return 结果
     */
    @Override
    public int updateBizStudentProfile(BizStudentProfile bizStudentProfile)
    {
        bizStudentProfile.setUpdateTime(DateUtils.getNowDate());
        return bizStudentProfileMapper.updateBizStudentProfile(bizStudentProfile);
    }

    /**
     * 批量删除学生基础学籍档案
     * 
     * @param ids 需要删除的学生基础学籍档案主键
     * @return 结果
     */
    @Override
    public int deleteBizStudentProfileByIds(Long[] ids)
    {
        return bizStudentProfileMapper.deleteBizStudentProfileByIds(ids);
    }

    /**
     * 删除学生基础学籍档案信息
     * 
     * @param id 学生基础学籍档案主键
     * @return 结果
     */
    @Override
    public int deleteBizStudentProfileById(Long id)
    {
        return bizStudentProfileMapper.deleteBizStudentProfileById(id);
    }
}
