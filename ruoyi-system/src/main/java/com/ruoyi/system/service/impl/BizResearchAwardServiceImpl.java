package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.BizResearchAwardMapper;
import com.ruoyi.system.domain.BizResearchAward;
import com.ruoyi.system.service.IBizResearchAwardService;

/**
 * 科研奖励管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-03-27
 */
@Service
public class BizResearchAwardServiceImpl implements IBizResearchAwardService 
{
    @Autowired
    private BizResearchAwardMapper bizResearchAwardMapper;

    /**
     * 查询科研奖励管理
     * 
     * @param id 科研奖励管理主键
     * @return 科研奖励管理
     */
    @Override
    public BizResearchAward selectBizResearchAwardById(Long id)
    {
        return bizResearchAwardMapper.selectBizResearchAwardById(id);
    }

    /**
     * 查询科研奖励管理列表
     * 
     * @param bizResearchAward 科研奖励管理
     * @return 科研奖励管理
     */
    @Override
    public List<BizResearchAward> selectBizResearchAwardList(BizResearchAward bizResearchAward)
    {
        return bizResearchAwardMapper.selectBizResearchAwardList(bizResearchAward);
    }

    /**
     * 新增科研奖励管理
     * 
     * @param bizResearchAward 科研奖励管理
     * @return 结果
     */
    @Override
    public int insertBizResearchAward(BizResearchAward bizResearchAward)
    {
        bizResearchAward.setCreateTime(DateUtils.getNowDate());
        return bizResearchAwardMapper.insertBizResearchAward(bizResearchAward);
    }

    /**
     * 修改科研奖励管理
     * 
     * @param bizResearchAward 科研奖励管理
     * @return 结果
     */
    @Override
    public int updateBizResearchAward(BizResearchAward bizResearchAward)
    {
        bizResearchAward.setUpdateTime(DateUtils.getNowDate());
        return bizResearchAwardMapper.updateBizResearchAward(bizResearchAward);
    }

    /**
     * 批量删除科研奖励管理
     * 
     * @param ids 需要删除的科研奖励管理主键
     * @return 结果
     */
    @Override
    public int deleteBizResearchAwardByIds(Long[] ids)
    {
        return bizResearchAwardMapper.deleteBizResearchAwardByIds(ids);
    }

    /**
     * 删除科研奖励管理信息
     * 
     * @param id 科研奖励管理主键
     * @return 结果
     */
    @Override
    public int deleteBizResearchAwardById(Long id)
    {
        return bizResearchAwardMapper.deleteBizResearchAwardById(id);
    }
}
