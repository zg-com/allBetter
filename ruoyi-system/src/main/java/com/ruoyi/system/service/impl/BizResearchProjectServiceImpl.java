package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.BizResearchProjectMapper;
import com.ruoyi.system.domain.BizResearchProject;
import com.ruoyi.system.service.IBizResearchProjectService;

/**
 * 科研项目经费与周期管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-03-27
 */
@Service
public class BizResearchProjectServiceImpl implements IBizResearchProjectService 
{
    @Autowired
    private BizResearchProjectMapper bizResearchProjectMapper;

    /**
     * 查询科研项目经费与周期管理
     * 
     * @param id 科研项目经费与周期管理主键
     * @return 科研项目经费与周期管理
     */
    @Override
    public BizResearchProject selectBizResearchProjectById(Long id)
    {
        return bizResearchProjectMapper.selectBizResearchProjectById(id);
    }

    /**
     * 查询科研项目经费与周期管理列表
     * 
     * @param bizResearchProject 科研项目经费与周期管理
     * @return 科研项目经费与周期管理
     */
    @Override
    public List<BizResearchProject> selectBizResearchProjectList(BizResearchProject bizResearchProject)
    {
        return bizResearchProjectMapper.selectBizResearchProjectList(bizResearchProject);
    }

    /**
     * 新增科研项目经费与周期管理
     * 
     * @param bizResearchProject 科研项目经费与周期管理
     * @return 结果
     */
    @Override
    public int insertBizResearchProject(BizResearchProject bizResearchProject)
    {
        bizResearchProject.setCreateTime(DateUtils.getNowDate());
        return bizResearchProjectMapper.insertBizResearchProject(bizResearchProject);
    }

    /**
     * 修改科研项目经费与周期管理
     * 
     * @param bizResearchProject 科研项目经费与周期管理
     * @return 结果
     */
    @Override
    public int updateBizResearchProject(BizResearchProject bizResearchProject)
    {
        bizResearchProject.setUpdateTime(DateUtils.getNowDate());
        return bizResearchProjectMapper.updateBizResearchProject(bizResearchProject);
    }

    /**
     * 批量删除科研项目经费与周期管理
     * 
     * @param ids 需要删除的科研项目经费与周期管理主键
     * @return 结果
     */
    @Override
    public int deleteBizResearchProjectByIds(Long[] ids)
    {
        return bizResearchProjectMapper.deleteBizResearchProjectByIds(ids);
    }

    /**
     * 删除科研项目经费与周期管理信息
     * 
     * @param id 科研项目经费与周期管理主键
     * @return 结果
     */
    @Override
    public int deleteBizResearchProjectById(Long id)
    {
        return bizResearchProjectMapper.deleteBizResearchProjectById(id);
    }
}
