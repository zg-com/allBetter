package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.BizInnovationProject;

/**
 * 大创项目管理Service接口
 * 
 * @author ruoyi
 * @date 2026-04-17
 */
public interface IBizInnovationProjectService 
{
    /**
     * 查询大创项目管理
     * 
     * @param id 大创项目管理主键
     * @return 大创项目管理
     */
    public BizInnovationProject selectBizInnovationProjectById(Long id);

    /**
     * 查询大创项目管理列表
     * 
     * @param bizInnovationProject 大创项目管理
     * @return 大创项目管理集合
     */
    public List<BizInnovationProject> selectBizInnovationProjectList(BizInnovationProject bizInnovationProject);

    /**
     * 新增大创项目管理
     * 
     * @param bizInnovationProject 大创项目管理
     * @return 结果
     */
    public int insertBizInnovationProject(BizInnovationProject bizInnovationProject);

    /**
     * 修改大创项目管理
     * 
     * @param bizInnovationProject 大创项目管理
     * @return 结果
     */
    public int updateBizInnovationProject(BizInnovationProject bizInnovationProject);

    /**
     * 批量删除大创项目管理
     * 
     * @param ids 需要删除的大创项目管理主键集合
     * @return 结果
     */
    public int deleteBizInnovationProjectByIds(Long[] ids);

    /**
     * 删除大创项目管理信息
     * 
     * @param id 大创项目管理主键
     * @return 结果
     */
    public int deleteBizInnovationProjectById(Long id);
}
