package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.BizResearchAward;

/**
 * 科研奖励管理Mapper接口
 * 
 * @author ruoyi
 * @date 2026-03-27
 */
public interface BizResearchAwardMapper 
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
     * 删除科研奖励管理
     * 
     * @param id 科研奖励管理主键
     * @return 结果
     */
    public int deleteBizResearchAwardById(Long id);

    /**
     * 批量删除科研奖励管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBizResearchAwardByIds(Long[] ids);
}
