package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.BizResearchProject;

/**
 * 科研项目经费与周期管理Mapper接口
 * 
 * @author ruoyi
 * @date 2026-03-27
 */
public interface BizResearchProjectMapper 
{
    /**
     * 查询科研项目经费与周期管理
     * 
     * @param id 科研项目经费与周期管理主键
     * @return 科研项目经费与周期管理
     */
    public BizResearchProject selectBizResearchProjectById(Long id);

    /**
     * 查询科研项目经费与周期管理列表
     * 
     * @param bizResearchProject 科研项目经费与周期管理
     * @return 科研项目经费与周期管理集合
     */
    public List<BizResearchProject> selectBizResearchProjectList(BizResearchProject bizResearchProject);

    /**
     * 新增科研项目经费与周期管理
     * 
     * @param bizResearchProject 科研项目经费与周期管理
     * @return 结果
     */
    public int insertBizResearchProject(BizResearchProject bizResearchProject);

    /**
     * 修改科研项目经费与周期管理
     * 
     * @param bizResearchProject 科研项目经费与周期管理
     * @return 结果
     */
    public int updateBizResearchProject(BizResearchProject bizResearchProject);

    /**
     * 删除科研项目经费与周期管理
     * 
     * @param id 科研项目经费与周期管理主键
     * @return 结果
     */
    public int deleteBizResearchProjectById(Long id);

    /**
     * 批量删除科研项目经费与周期管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBizResearchProjectByIds(Long[] ids);
}
