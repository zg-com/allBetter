package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.BizTeachingAward;

/**
 * 教研奖励Mapper接口
 * 
 * @author ruoyi
 * @date 2026-04-10
 */
public interface BizTeachingAwardMapper 
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
     * 删除教研奖励
     * 
     * @param id 教研奖励主键
     * @return 结果
     */
    public int deleteBizTeachingAwardById(Long id);

    /**
     * 批量删除教研奖励
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBizTeachingAwardByIds(Long[] ids);
}
