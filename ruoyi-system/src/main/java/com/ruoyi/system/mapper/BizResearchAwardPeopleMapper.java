package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.BizResearchAwardPeople;

/**
 * 科研奖励关联Mapper接口
 * 
 * @author ruoyi
 * @date 2026-04-23
 */
public interface BizResearchAwardPeopleMapper 
{
    /**
     * 查询科研奖励关联
     * 
     * @param id 科研奖励关联主键
     * @return 科研奖励关联
     */
    public BizResearchAwardPeople selectBizResearchAwardPeopleById(Long id);

    /**
     * 查询科研奖励关联列表
     * 
     * @param bizResearchAwardPeople 科研奖励关联
     * @return 科研奖励关联集合
     */
    public List<BizResearchAwardPeople> selectBizResearchAwardPeopleList(BizResearchAwardPeople bizResearchAwardPeople);

    /**
     * 新增科研奖励关联
     * 
     * @param bizResearchAwardPeople 科研奖励关联
     * @return 结果
     */
    public int insertBizResearchAwardPeople(BizResearchAwardPeople bizResearchAwardPeople);

    /**
     * 修改科研奖励关联
     * 
     * @param bizResearchAwardPeople 科研奖励关联
     * @return 结果
     */
    public int updateBizResearchAwardPeople(BizResearchAwardPeople bizResearchAwardPeople);

    /**
     * 删除科研奖励关联
     * 
     * @param id 科研奖励关联主键
     * @return 结果
     */
    public int deleteBizResearchAwardPeopleById(Long id);

    /**
     * 批量删除科研奖励关联
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBizResearchAwardPeopleByIds(Long[] ids);
}
