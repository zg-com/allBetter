package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.BizTeacherChild;

/**
 * 教师子女与妇幼档案Mapper接口
 * 
 * @author ruoyi
 * @date 2026-04-17
 */
public interface BizTeacherChildMapper 
{
    /**
     * 查询教师子女与妇幼档案
     * 
     * @param id 教师子女与妇幼档案主键
     * @return 教师子女与妇幼档案
     */
    public BizTeacherChild selectBizTeacherChildById(Long id);

    /**
     * 查询教师子女与妇幼档案列表
     * 
     * @param bizTeacherChild 教师子女与妇幼档案
     * @return 教师子女与妇幼档案集合
     */
    public List<BizTeacherChild> selectBizTeacherChildList(BizTeacherChild bizTeacherChild);

    /**
     * 新增教师子女与妇幼档案
     * 
     * @param bizTeacherChild 教师子女与妇幼档案
     * @return 结果
     */
    public int insertBizTeacherChild(BizTeacherChild bizTeacherChild);

    /**
     * 修改教师子女与妇幼档案
     * 
     * @param bizTeacherChild 教师子女与妇幼档案
     * @return 结果
     */
    public int updateBizTeacherChild(BizTeacherChild bizTeacherChild);

    /**
     * 删除教师子女与妇幼档案
     * 
     * @param id 教师子女与妇幼档案主键
     * @return 结果
     */
    public int deleteBizTeacherChildById(Long id);

    /**
     * 批量删除教师子女与妇幼档案
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBizTeacherChildByIds(Long[] ids);
}
