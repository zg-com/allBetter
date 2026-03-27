package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.BizTeachingAwardMapper;
import com.ruoyi.system.domain.BizTeachingAward;
import com.ruoyi.system.service.IBizTeachingAwardService;

/**
 * 教研奖励Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-03-27
 */
@Service
public class BizTeachingAwardServiceImpl implements IBizTeachingAwardService 
{
    @Autowired
    private BizTeachingAwardMapper bizTeachingAwardMapper;

    /**
     * 查询教研奖励
     * 
     * @param id 教研奖励主键
     * @return 教研奖励
     */
    @Override
    public BizTeachingAward selectBizTeachingAwardById(Long id)
    {
        return bizTeachingAwardMapper.selectBizTeachingAwardById(id);
    }

    /**
     * 查询教研奖励列表
     * 
     * @param bizTeachingAward 教研奖励
     * @return 教研奖励
     */
    @Override
    public List<BizTeachingAward> selectBizTeachingAwardList(BizTeachingAward bizTeachingAward)
    {
        return bizTeachingAwardMapper.selectBizTeachingAwardList(bizTeachingAward);
    }

    /**
     * 新增教研奖励
     * 
     * @param bizTeachingAward 教研奖励
     * @return 结果
     */
    @Override
    public int insertBizTeachingAward(BizTeachingAward bizTeachingAward)
    {
        bizTeachingAward.setCreateTime(DateUtils.getNowDate());
        return bizTeachingAwardMapper.insertBizTeachingAward(bizTeachingAward);
    }

    /**
     * 修改教研奖励
     * 
     * @param bizTeachingAward 教研奖励
     * @return 结果
     */
    @Override
    public int updateBizTeachingAward(BizTeachingAward bizTeachingAward)
    {
        bizTeachingAward.setUpdateTime(DateUtils.getNowDate());
        return bizTeachingAwardMapper.updateBizTeachingAward(bizTeachingAward);
    }

    /**
     * 批量删除教研奖励
     * 
     * @param ids 需要删除的教研奖励主键
     * @return 结果
     */
    @Override
    public int deleteBizTeachingAwardByIds(Long[] ids)
    {
        return bizTeachingAwardMapper.deleteBizTeachingAwardByIds(ids);
    }

    /**
     * 删除教研奖励信息
     * 
     * @param id 教研奖励主键
     * @return 结果
     */
    @Override
    public int deleteBizTeachingAwardById(Long id)
    {
        return bizTeachingAwardMapper.deleteBizTeachingAwardById(id);
    }
}
