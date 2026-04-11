package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.BizTeacherProfile;

/**
 * 教师人事基础档案Mapper接口
 * 
 * @author ruoyi
 * @date 2026-04-10
 */
public interface BizTeacherProfileMapper 
{
    /**
     * 查询教师人事基础档案
     * 
     * @param id 教师人事基础档案主键
     * @return 教师人事基础档案
     */
    public BizTeacherProfile selectBizTeacherProfileById(Long id);

    /**
     * 查询教师人事基础档案列表
     * 
     * @param bizTeacherProfile 教师人事基础档案
     * @return 教师人事基础档案集合
     */
    public List<BizTeacherProfile> selectBizTeacherProfileList(BizTeacherProfile bizTeacherProfile);

    /**
     * 新增教师人事基础档案
     * 
     * @param bizTeacherProfile 教师人事基础档案
     * @return 结果
     */
    public int insertBizTeacherProfile(BizTeacherProfile bizTeacherProfile);

    /**
     * 修改教师人事基础档案
     * 
     * @param bizTeacherProfile 教师人事基础档案
     * @return 结果
     */
    public int updateBizTeacherProfile(BizTeacherProfile bizTeacherProfile);

    /**
     * 删除教师人事基础档案
     * 
     * @param id 教师人事基础档案主键
     * @return 结果
     */
    public int deleteBizTeacherProfileById(Long id);

    /**
     * 批量删除教师人事基础档案
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBizTeacherProfileByIds(Long[] ids);
}
