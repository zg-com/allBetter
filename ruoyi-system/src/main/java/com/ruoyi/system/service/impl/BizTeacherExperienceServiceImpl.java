package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.BizTeacherExperienceMapper;
import com.ruoyi.system.domain.BizTeacherExperience;
import com.ruoyi.system.service.IBizTeacherExperienceService;

/**
 * 教师兼职与访学经历Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-03-27
 */
@Service
public class BizTeacherExperienceServiceImpl implements IBizTeacherExperienceService 
{
    @Autowired
    private BizTeacherExperienceMapper bizTeacherExperienceMapper;

    /**
     * 查询教师兼职与访学经历
     * 
     * @param id 教师兼职与访学经历主键
     * @return 教师兼职与访学经历
     */
    @Override
    public BizTeacherExperience selectBizTeacherExperienceById(Long id)
    {
        return bizTeacherExperienceMapper.selectBizTeacherExperienceById(id);
    }

    /**
     * 查询教师兼职与访学经历列表
     * 
     * @param bizTeacherExperience 教师兼职与访学经历
     * @return 教师兼职与访学经历
     */
    @Override
    public List<BizTeacherExperience> selectBizTeacherExperienceList(BizTeacherExperience bizTeacherExperience)
    {
        return bizTeacherExperienceMapper.selectBizTeacherExperienceList(bizTeacherExperience);
    }

    /**
     * 新增教师兼职与访学经历
     * 
     * @param bizTeacherExperience 教师兼职与访学经历
     * @return 结果
     */
    @Override
    public int insertBizTeacherExperience(BizTeacherExperience bizTeacherExperience)
    {
        bizTeacherExperience.setCreateTime(DateUtils.getNowDate());
        return bizTeacherExperienceMapper.insertBizTeacherExperience(bizTeacherExperience);
    }

    /**
     * 修改教师兼职与访学经历
     * 
     * @param bizTeacherExperience 教师兼职与访学经历
     * @return 结果
     */
    @Override
    public int updateBizTeacherExperience(BizTeacherExperience bizTeacherExperience)
    {
        return bizTeacherExperienceMapper.updateBizTeacherExperience(bizTeacherExperience);
    }

    /**
     * 批量删除教师兼职与访学经历
     * 
     * @param ids 需要删除的教师兼职与访学经历主键
     * @return 结果
     */
    @Override
    public int deleteBizTeacherExperienceByIds(Long[] ids)
    {
        return bizTeacherExperienceMapper.deleteBizTeacherExperienceByIds(ids);
    }

    /**
     * 删除教师兼职与访学经历信息
     * 
     * @param id 教师兼职与访学经历主键
     * @return 结果
     */
    @Override
    public int deleteBizTeacherExperienceById(Long id)
    {
        return bizTeacherExperienceMapper.deleteBizTeacherExperienceById(id);
    }
}
