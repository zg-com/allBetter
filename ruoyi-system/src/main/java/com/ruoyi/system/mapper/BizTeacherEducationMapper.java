package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.BizTeacherEducation;

/**
 * 教师历年学习经历与证书Mapper接口
 * 
 * @author ruoyi
 * @date 2026-03-27
 */
public interface BizTeacherEducationMapper 
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
     * 删除教师历年学习经历与证书
     * 
     * @param id 教师历年学习经历与证书主键
     * @return 结果
     */
    public int deleteBizTeacherEducationById(Long id);

    /**
     * 批量删除教师历年学习经历与证书
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBizTeacherEducationByIds(Long[] ids);
}
