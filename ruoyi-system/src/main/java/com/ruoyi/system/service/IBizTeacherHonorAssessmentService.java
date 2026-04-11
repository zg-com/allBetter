package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.BizTeacherHonorAssessment;

/**
 * 教师荣誉与历年考核记录Service接口
 * 
 * @author ruoyi
 * @date 2026-04-10
 */
public interface IBizTeacherHonorAssessmentService 
{
    /**
     * 查询教师荣誉与历年考核记录
     * 
     * @param id 教师荣誉与历年考核记录主键
     * @return 教师荣誉与历年考核记录
     */
    public BizTeacherHonorAssessment selectBizTeacherHonorAssessmentById(Long id);

    /**
     * 查询教师荣誉与历年考核记录列表
     * 
     * @param bizTeacherHonorAssessment 教师荣誉与历年考核记录
     * @return 教师荣誉与历年考核记录集合
     */
    public List<BizTeacherHonorAssessment> selectBizTeacherHonorAssessmentList(BizTeacherHonorAssessment bizTeacherHonorAssessment);

    /**
     * 新增教师荣誉与历年考核记录
     * 
     * @param bizTeacherHonorAssessment 教师荣誉与历年考核记录
     * @return 结果
     */
    public int insertBizTeacherHonorAssessment(BizTeacherHonorAssessment bizTeacherHonorAssessment);

    /**
     * 修改教师荣誉与历年考核记录
     * 
     * @param bizTeacherHonorAssessment 教师荣誉与历年考核记录
     * @return 结果
     */
    public int updateBizTeacherHonorAssessment(BizTeacherHonorAssessment bizTeacherHonorAssessment);

    /**
     * 批量删除教师荣誉与历年考核记录
     * 
     * @param ids 需要删除的教师荣誉与历年考核记录主键集合
     * @return 结果
     */
    public int deleteBizTeacherHonorAssessmentByIds(Long[] ids);

    /**
     * 删除教师荣誉与历年考核记录信息
     * 
     * @param id 教师荣誉与历年考核记录主键
     * @return 结果
     */
    public int deleteBizTeacherHonorAssessmentById(Long id);
}
