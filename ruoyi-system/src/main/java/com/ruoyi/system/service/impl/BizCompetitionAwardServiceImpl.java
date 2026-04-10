package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.BizCompetitionAwardMapper;
import com.ruoyi.system.domain.BizCompetitionAward;
import com.ruoyi.system.service.IBizCompetitionAwardService;

/**
 * 学生竞赛获奖全纪录Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-03-27
 */
@Service
public class BizCompetitionAwardServiceImpl implements IBizCompetitionAwardService 
{
    @Autowired
    private BizCompetitionAwardMapper bizCompetitionAwardMapper;

    /**
     * 查询学生竞赛获奖全纪录
     * 
     * @param id 学生竞赛获奖全纪录主键
     * @return 学生竞赛获奖全纪录
     */
    @Override
    public BizCompetitionAward selectBizCompetitionAwardById(Long id)
    {
        return bizCompetitionAwardMapper.selectBizCompetitionAwardById(id);
    }

    /**
     * 查询学生竞赛获奖全纪录列表
     * 
     * @param bizCompetitionAward 学生竞赛获奖全纪录
     * @return 学生竞赛获奖全纪录
     */
    @Override
    public List<BizCompetitionAward> selectBizCompetitionAwardList(BizCompetitionAward bizCompetitionAward)
    {
        return bizCompetitionAwardMapper.selectBizCompetitionAwardList(bizCompetitionAward);
    }

    /**
     * 新增学生竞赛获奖全纪录
     * 
     * @param bizCompetitionAward 学生竞赛获奖全纪录
     * @return 结果
     */
    @Override
    public int insertBizCompetitionAward(BizCompetitionAward bizCompetitionAward)
    {
        bizCompetitionAward.setCreateTime(DateUtils.getNowDate());
        //Long currentUserId = com.ruoyi.common.utils.SecurityUtils.getUserId();
        //bizCompetitionAward.setStudentNo(currentUserId.toString());
        return bizCompetitionAwardMapper.insertBizCompetitionAward(bizCompetitionAward);
    }

    /**
     * 修改学生竞赛获奖全纪录
     * 
     * @param bizCompetitionAward 学生竞赛获奖全纪录
     * @return 结果
     */
    @Override
    public int updateBizCompetitionAward(BizCompetitionAward bizCompetitionAward)
    {
        bizCompetitionAward.setUpdateTime(DateUtils.getNowDate());
        return bizCompetitionAwardMapper.updateBizCompetitionAward(bizCompetitionAward);
    }

    /**
     * 批量删除学生竞赛获奖全纪录
     * 
     * @param ids 需要删除的学生竞赛获奖全纪录主键
     * @return 结果
     */
    @Override
    public int deleteBizCompetitionAwardByIds(Long[] ids)
    {
        return bizCompetitionAwardMapper.deleteBizCompetitionAwardByIds(ids);
    }

    /**
     * 删除学生竞赛获奖全纪录信息
     * 
     * @param id 学生竞赛获奖全纪录主键
     * @return 结果
     */
    @Override
    public int deleteBizCompetitionAwardById(Long id)
    {
        return bizCompetitionAwardMapper.deleteBizCompetitionAwardById(id);
    }
}
