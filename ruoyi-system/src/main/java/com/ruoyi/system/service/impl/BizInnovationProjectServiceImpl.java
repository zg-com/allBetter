package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.BizInnovationProjectMapper;
import com.ruoyi.system.domain.BizInnovationProject;
import com.ruoyi.system.service.IBizInnovationProjectService;

/**
 * 大创项目管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-04-17
 */
@Service
public class BizInnovationProjectServiceImpl implements IBizInnovationProjectService 
{
    @Autowired
    private BizInnovationProjectMapper bizInnovationProjectMapper;

    /**
     * 查询大创项目管理
     * 
     * @param id 大创项目管理主键
     * @return 大创项目管理
     */
    @Override
    public BizInnovationProject selectBizInnovationProjectById(Long id)
    {
        return bizInnovationProjectMapper.selectBizInnovationProjectById(id);
    }

    /**
     * 查询大创项目管理列表
     * 
     * @param bizInnovationProject 大创项目管理
     * @return 大创项目管理
     */
    @Override
    public List<BizInnovationProject> selectBizInnovationProjectList(BizInnovationProject bizInnovationProject)
    {
        return bizInnovationProjectMapper.selectBizInnovationProjectList(bizInnovationProject);
    }

    /**
     * 新增大创项目管理
     * 
     * @param bizInnovationProject 大创项目管理
     * @return 结果
     */
    @Override
    public int insertBizInnovationProject(BizInnovationProject bizInnovationProject)
    {
        bizInnovationProject.setCreateTime(DateUtils.getNowDate());
        return bizInnovationProjectMapper.insertBizInnovationProject(bizInnovationProject);
    }

    /**
     * 修改大创项目管理
     * 
     * @param bizInnovationProject 大创项目管理
     * @return 结果
     */
    @Override
    public int updateBizInnovationProject(BizInnovationProject bizInnovationProject)
    {
        bizInnovationProject.setUpdateTime(DateUtils.getNowDate());
        return bizInnovationProjectMapper.updateBizInnovationProject(bizInnovationProject);
    }

    /**
     * 批量删除大创项目管理
     * 
     * @param ids 需要删除的大创项目管理主键
     * @return 结果
     */
    @Override
    public int deleteBizInnovationProjectByIds(Long[] ids)
    {
        return bizInnovationProjectMapper.deleteBizInnovationProjectByIds(ids);
    }

    /**
     * 删除大创项目管理信息
     * 
     * @param id 大创项目管理主键
     * @return 结果
     */
    @Override
    public int deleteBizInnovationProjectById(Long id)
    {
        return bizInnovationProjectMapper.deleteBizInnovationProjectById(id);
    }
}
