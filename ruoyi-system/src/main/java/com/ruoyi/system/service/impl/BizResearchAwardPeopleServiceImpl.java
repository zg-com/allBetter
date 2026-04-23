package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.BizResearchAwardPeopleMapper;
import com.ruoyi.system.domain.BizResearchAwardPeople;
import com.ruoyi.system.service.IBizResearchAwardPeopleService;

/**
 * 科研奖励关联Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-04-23
 */
@Service
public class BizResearchAwardPeopleServiceImpl implements IBizResearchAwardPeopleService 
{
    @Autowired
    private BizResearchAwardPeopleMapper bizResearchAwardPeopleMapper;

    /**
     * 查询科研奖励关联
     * 
     * @param id 科研奖励关联主键
     * @return 科研奖励关联
     */
    @Override
    public BizResearchAwardPeople selectBizResearchAwardPeopleById(Long id)
    {
        return bizResearchAwardPeopleMapper.selectBizResearchAwardPeopleById(id);
    }

    /**
     * 查询科研奖励关联列表
     * 
     * @param bizResearchAwardPeople 科研奖励关联
     * @return 科研奖励关联
     */
    @Override
    public List<BizResearchAwardPeople> selectBizResearchAwardPeopleList(BizResearchAwardPeople bizResearchAwardPeople)
    {
        return bizResearchAwardPeopleMapper.selectBizResearchAwardPeopleList(bizResearchAwardPeople);
    }

    /**
     * 新增科研奖励关联
     * 
     * @param bizResearchAwardPeople 科研奖励关联
     * @return 结果
     */
    @Override
    public int insertBizResearchAwardPeople(BizResearchAwardPeople bizResearchAwardPeople)
    {
        return bizResearchAwardPeopleMapper.insertBizResearchAwardPeople(bizResearchAwardPeople);
    }

    /**
     * 修改科研奖励关联
     * 
     * @param bizResearchAwardPeople 科研奖励关联
     * @return 结果
     */
    @Override
    public int updateBizResearchAwardPeople(BizResearchAwardPeople bizResearchAwardPeople)
    {
        return bizResearchAwardPeopleMapper.updateBizResearchAwardPeople(bizResearchAwardPeople);
    }

    /**
     * 批量删除科研奖励关联
     * 
     * @param ids 需要删除的科研奖励关联主键
     * @return 结果
     */
    @Override
    public int deleteBizResearchAwardPeopleByIds(Long[] ids)
    {
        return bizResearchAwardPeopleMapper.deleteBizResearchAwardPeopleByIds(ids);
    }

    /**
     * 删除科研奖励关联信息
     * 
     * @param id 科研奖励关联主键
     * @return 结果
     */
    @Override
    public int deleteBizResearchAwardPeopleById(Long id)
    {
        return bizResearchAwardPeopleMapper.deleteBizResearchAwardPeopleById(id);
    }
}
