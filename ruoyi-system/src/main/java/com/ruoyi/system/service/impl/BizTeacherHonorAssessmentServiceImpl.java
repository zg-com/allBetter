package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.BizTeacherHonorAssessmentMapper;
import com.ruoyi.system.domain.BizTeacherHonorAssessment;
import com.ruoyi.system.service.IBizTeacherHonorAssessmentService;

/**
 * 教师荣誉与历年考核记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-04-10
 */
@Service
public class BizTeacherHonorAssessmentServiceImpl implements IBizTeacherHonorAssessmentService 
{
    @Autowired
    private BizTeacherHonorAssessmentMapper bizTeacherHonorAssessmentMapper;

    /**
     * 查询教师荣誉与历年考核记录
     * 
     * @param id 教师荣誉与历年考核记录主键
     * @return 教师荣誉与历年考核记录
     */
    @Override
    public BizTeacherHonorAssessment selectBizTeacherHonorAssessmentById(Long id)
    {
        return bizTeacherHonorAssessmentMapper.selectBizTeacherHonorAssessmentById(id);
    }

    /**
     * 查询教师荣誉与历年考核记录列表
     * 
     * @param bizTeacherHonorAssessment 教师荣誉与历年考核记录
     * @return 教师荣誉与历年考核记录
     */
    @Override
    public List<BizTeacherHonorAssessment> selectBizTeacherHonorAssessmentList(BizTeacherHonorAssessment bizTeacherHonorAssessment)
    {
        return bizTeacherHonorAssessmentMapper.selectBizTeacherHonorAssessmentList(bizTeacherHonorAssessment);
    }

    /**
     * 新增教师荣誉与历年考核记录
     * 
     * @param bizTeacherHonorAssessment 教师荣誉与历年考核记录
     * @return 结果
     */
    @Override
    public int insertBizTeacherHonorAssessment(BizTeacherHonorAssessment bizTeacherHonorAssessment)
    {
        bizTeacherHonorAssessment.setCreateTime(DateUtils.getNowDate());
        return bizTeacherHonorAssessmentMapper.insertBizTeacherHonorAssessment(bizTeacherHonorAssessment);
    }

    /**
     * 修改教师荣誉与历年考核记录
     * 
     * @param bizTeacherHonorAssessment 教师荣誉与历年考核记录
     * @return 结果
     */
    @Override
    public int updateBizTeacherHonorAssessment(BizTeacherHonorAssessment bizTeacherHonorAssessment)
    {
        return bizTeacherHonorAssessmentMapper.updateBizTeacherHonorAssessment(bizTeacherHonorAssessment);
    }

    /**
     * 批量删除教师荣誉与历年考核记录
     * 
     * @param ids 需要删除的教师荣誉与历年考核记录主键
     * @return 结果
     */
    @Override
    public int deleteBizTeacherHonorAssessmentByIds(Long[] ids)
    {
        return bizTeacherHonorAssessmentMapper.deleteBizTeacherHonorAssessmentByIds(ids);
    }

    /**
     * 删除教师荣誉与历年考核记录信息
     * 
     * @param id 教师荣誉与历年考核记录主键
     * @return 结果
     */
    @Override
    public int deleteBizTeacherHonorAssessmentById(Long id)
    {
        return bizTeacherHonorAssessmentMapper.deleteBizTeacherHonorAssessmentById(id);
    }
}
