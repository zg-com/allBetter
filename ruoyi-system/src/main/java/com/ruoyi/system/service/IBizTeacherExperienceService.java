package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.BizTeacherExperience;

/**
 * 教师兼职与访学经历Service接口
 * 
 * @author ruoyi
 * @date 2026-04-10
 */
public interface IBizTeacherExperienceService 
{
    /**
     * 查询教师兼职与访学经历
     * 
     * @param id 教师兼职与访学经历主键
     * @return 教师兼职与访学经历
     */
    public BizTeacherExperience selectBizTeacherExperienceById(Long id);

    /**
     * 查询教师兼职与访学经历列表
     * 
     * @param bizTeacherExperience 教师兼职与访学经历
     * @return 教师兼职与访学经历集合
     */
    public List<BizTeacherExperience> selectBizTeacherExperienceList(BizTeacherExperience bizTeacherExperience);

    /**
     * 新增教师兼职与访学经历
     * 
     * @param bizTeacherExperience 教师兼职与访学经历
     * @return 结果
     */
    public int insertBizTeacherExperience(BizTeacherExperience bizTeacherExperience);

    /**
     * 修改教师兼职与访学经历
     * 
     * @param bizTeacherExperience 教师兼职与访学经历
     * @return 结果
     */
    public int updateBizTeacherExperience(BizTeacherExperience bizTeacherExperience);

    /**
     * 批量删除教师兼职与访学经历
     * 
     * @param ids 需要删除的教师兼职与访学经历主键集合
     * @return 结果
     */
    public int deleteBizTeacherExperienceByIds(Long[] ids);

    /**
     * 删除教师兼职与访学经历信息
     * 
     * @param id 教师兼职与访学经历主键
     * @return 结果
     */
    public int deleteBizTeacherExperienceById(Long id);
}
