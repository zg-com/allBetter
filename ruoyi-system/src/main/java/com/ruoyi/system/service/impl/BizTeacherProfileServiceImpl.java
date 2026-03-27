package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.BizTeacherProfileMapper;
import com.ruoyi.system.domain.BizTeacherProfile;
import com.ruoyi.system.service.IBizTeacherProfileService;

/**
 * 教师人事基础档案Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-03-27
 */
@Service
public class BizTeacherProfileServiceImpl implements IBizTeacherProfileService 
{
    @Autowired
    private BizTeacherProfileMapper bizTeacherProfileMapper;

    /**
     * 查询教师人事基础档案
     * 
     * @param id 教师人事基础档案主键
     * @return 教师人事基础档案
     */
    @Override
    public BizTeacherProfile selectBizTeacherProfileById(Long id)
    {
        return bizTeacherProfileMapper.selectBizTeacherProfileById(id);
    }

    /**
     * 查询教师人事基础档案列表
     * 
     * @param bizTeacherProfile 教师人事基础档案
     * @return 教师人事基础档案
     */
    @Override
    public List<BizTeacherProfile> selectBizTeacherProfileList(BizTeacherProfile bizTeacherProfile)
    {
        return bizTeacherProfileMapper.selectBizTeacherProfileList(bizTeacherProfile);
    }

    /**
     * 新增教师人事基础档案
     * 
     * @param bizTeacherProfile 教师人事基础档案
     * @return 结果
     */
    @Override
    public int insertBizTeacherProfile(BizTeacherProfile bizTeacherProfile)
    {
        bizTeacherProfile.setCreateTime(DateUtils.getNowDate());
        return bizTeacherProfileMapper.insertBizTeacherProfile(bizTeacherProfile);
    }

    /**
     * 修改教师人事基础档案
     * 
     * @param bizTeacherProfile 教师人事基础档案
     * @return 结果
     */
    @Override
    public int updateBizTeacherProfile(BizTeacherProfile bizTeacherProfile)
    {
        bizTeacherProfile.setUpdateTime(DateUtils.getNowDate());
        return bizTeacherProfileMapper.updateBizTeacherProfile(bizTeacherProfile);
    }

    /**
     * 批量删除教师人事基础档案
     * 
     * @param ids 需要删除的教师人事基础档案主键
     * @return 结果
     */
    @Override
    public int deleteBizTeacherProfileByIds(Long[] ids)
    {
        return bizTeacherProfileMapper.deleteBizTeacherProfileByIds(ids);
    }

    /**
     * 删除教师人事基础档案信息
     * 
     * @param id 教师人事基础档案主键
     * @return 结果
     */
    @Override
    public int deleteBizTeacherProfileById(Long id)
    {
        return bizTeacherProfileMapper.deleteBizTeacherProfileById(id);
    }
}
