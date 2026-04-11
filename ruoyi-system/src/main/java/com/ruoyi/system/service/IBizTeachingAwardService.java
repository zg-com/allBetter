package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.BizTeachingAward;

/**
 * 教研奖励Service接口
 * 
 * @author ruoyi
 * @date 2026-04-10
 */
public interface IBizTeachingAwardService 
{
    /**
     * 查询教研奖励
     * 
     * @param id 教研奖励主键
     * @return 教研奖励
     */
    public BizTeachingAward selectBizTeachingAwardById(Long id);

    /**
     * 查询教研奖励列表
     * 
     * @param bizTeachingAward 教研奖励
     * @return 教研奖励集合
     */
    public List<BizTeachingAward> selectBizTeachingAwardList(BizTeachingAward bizTeachingAward);

    /**
     * 新增教研奖励
     * 
     * @param bizTeachingAward 教研奖励
     * @return 结果
     */
    public int insertBizTeachingAward(BizTeachingAward bizTeachingAward);

    /**
     * 修改教研奖励
     * 
     * @param bizTeachingAward 教研奖励
     * @return 结果
     */
    public int updateBizTeachingAward(BizTeachingAward bizTeachingAward);

    /**
     * 批量删除教研奖励
     * 
     * @param ids 需要删除的教研奖励主键集合
     * @return 结果
     */
    public int deleteBizTeachingAwardByIds(Long[] ids);

    /**
     * 删除教研奖励信息
     * 
     * @param id 教研奖励主键
     * @return 结果
     */
    public int deleteBizTeachingAwardById(Long id);
}
