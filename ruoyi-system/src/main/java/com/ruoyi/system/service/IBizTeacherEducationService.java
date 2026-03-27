package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.BizTeacherEducation;

/**
 * 教师历年学习经历与证书Service接口
 * 
 * @author ruoyi
 * @date 2026-03-27
 */
public interface IBizTeacherEducationService 
{
    /**
     * 查询教师历年学习经历与证书
     * 
     * @param id 教师历年学习经历与证书主键
     * @return 教师历年学习经历与证书
     */
    public BizTeacherEducation selectBizTeacherEducationById(Long id);

    /**
     * 查询教师历年学习经历与证书列表
     * 
     * @param bizTeacherEducation 教师历年学习经历与证书
     * @return 教师历年学习经历与证书集合
     */
    public List<BizTeacherEducation> selectBizTeacherEducationList(BizTeacherEducation bizTeacherEducation);

    /**
     * 新增教师历年学习经历与证书
     * 
     * @param bizTeacherEducation 教师历年学习经历与证书
     * @return 结果
     */
    public int insertBizTeacherEducation(BizTeacherEducation bizTeacherEducation);

    /**
     * 修改教师历年学习经历与证书
     * 
     * @param bizTeacherEducation 教师历年学习经历与证书
     * @return 结果
     */
    public int updateBizTeacherEducation(BizTeacherEducation bizTeacherEducation);

    /**
     * 批量删除教师历年学习经历与证书
     * 
     * @param ids 需要删除的教师历年学习经历与证书主键集合
     * @return 结果
     */
    public int deleteBizTeacherEducationByIds(Long[] ids);

    /**
     * 删除教师历年学习经历与证书信息
     * 
     * @param id 教师历年学习经历与证书主键
     * @return 结果
     */
    public int deleteBizTeacherEducationById(Long id);
}
