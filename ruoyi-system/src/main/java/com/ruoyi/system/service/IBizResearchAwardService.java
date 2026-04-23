package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.BizResearchAward;

/**
 * 科研奖励管理Service接口
 * 
 * @author ruoyi
 * @date 2026-04-23
 */
public interface IBizResearchAwardService 
{
    /**
     * 查询科研奖励管理
     * 
     * @param id 科研奖励管理主键
     * @return 科研奖励管理
     */
    public BizResearchAward selectBizResearchAwardById(Long id);

    /**
     * 查询科研奖励管理列表
     * 
     * @param bizResearchAward 科研奖励管理
     * @return 科研奖励管理集合
     */
    public List<BizResearchAward> selectBizResearchAwardList(BizResearchAward bizResearchAward);

    /**
     * 新增科研奖励管理
     * 
     * @param bizResearchAward 科研奖励管理
     * @return 结果
     */
    public int insertBizResearchAward(BizResearchAward bizResearchAward);

    /**
     * 修改科研奖励管理
     * 
     * @param bizResearchAward 科研奖励管理
     * @return 结果
     */
    public int updateBizResearchAward(BizResearchAward bizResearchAward);

    /**
     * 批量删除科研奖励管理
     * 
     * @param ids 需要删除的科研奖励管理主键集合
     * @return 结果
     */
    public int deleteBizResearchAwardByIds(Long[] ids);

    /**
     * 删除科研奖励管理信息
     * 
     * @param id 科研奖励管理主键
     * @return 结果
     */
    public int deleteBizResearchAwardById(Long id);
}
