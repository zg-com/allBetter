package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.BizTeacherEducationMapper;
import com.ruoyi.system.domain.BizTeacherEducation;
import com.ruoyi.system.service.IBizTeacherEducationService;

/**
 * 教师历年学习经历与证书Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-04-10
 */
@Service
public class BizTeacherEducationServiceImpl implements IBizTeacherEducationService 
{
    @Autowired
    private BizTeacherEducationMapper bizTeacherEducationMapper;

    /**
     * 查询教师历年学习经历与证书
     * 
     * @param id 教师历年学习经历与证书主键
     * @return 教师历年学习经历与证书
     */
    @Override
    public BizTeacherEducation selectBizTeacherEducationById(Long id)
    {
        return bizTeacherEducationMapper.selectBizTeacherEducationById(id);
    }

    /**
     * 查询教师历年学习经历与证书列表
     * 
     * @param bizTeacherEducation 教师历年学习经历与证书
     * @return 教师历年学习经历与证书
     */
    @Override
    public List<BizTeacherEducation> selectBizTeacherEducationList(BizTeacherEducation bizTeacherEducation)
    {
        return bizTeacherEducationMapper.selectBizTeacherEducationList(bizTeacherEducation);
    }

    /**
     * 新增教师历年学习经历与证书
     * 
     * @param bizTeacherEducation 教师历年学习经历与证书
     * @return 结果
     */
    @Override
    public int insertBizTeacherEducation(BizTeacherEducation bizTeacherEducation)
    {
        bizTeacherEducation.setCreateTime(DateUtils.getNowDate());
        return bizTeacherEducationMapper.insertBizTeacherEducation(bizTeacherEducation);
    }

    /**
     * 修改教师历年学习经历与证书
     * 
     * @param bizTeacherEducation 教师历年学习经历与证书
     * @return 结果
     */
    @Override
    public int updateBizTeacherEducation(BizTeacherEducation bizTeacherEducation)
    {
        return bizTeacherEducationMapper.updateBizTeacherEducation(bizTeacherEducation);
    }

    /**
     * 批量删除教师历年学习经历与证书
     * 
     * @param ids 需要删除的教师历年学习经历与证书主键
     * @return 结果
     */
    @Override
    public int deleteBizTeacherEducationByIds(Long[] ids)
    {
        return bizTeacherEducationMapper.deleteBizTeacherEducationByIds(ids);
    }

    /**
     * 删除教师历年学习经历与证书信息
     * 
     * @param id 教师历年学习经历与证书主键
     * @return 结果
     */
    @Override
    public int deleteBizTeacherEducationById(Long id)
    {
        return bizTeacherEducationMapper.deleteBizTeacherEducationById(id);
    }
}
