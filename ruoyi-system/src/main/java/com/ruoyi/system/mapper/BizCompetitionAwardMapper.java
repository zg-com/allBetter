package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.BizCompetitionAward;

/**
 * 学生竞赛获奖全纪录Mapper接口
 * 
 * @author ruoyi
 * @date 2026-04-23
 */
public interface BizCompetitionAwardMapper 
{
    /**
     * 查询学生竞赛获奖全纪录
     * 
     * @param id 学生竞赛获奖全纪录主键
     * @return 学生竞赛获奖全纪录
     */
    public BizCompetitionAward selectBizCompetitionAwardById(Long id);

    /**
     * 查询学生竞赛获奖全纪录列表
     * 
     * @param bizCompetitionAward 学生竞赛获奖全纪录
     * @return 学生竞赛获奖全纪录集合
     */
    public List<BizCompetitionAward> selectBizCompetitionAwardList(BizCompetitionAward bizCompetitionAward);

    /**
     * 新增学生竞赛获奖全纪录
     * 
     * @param bizCompetitionAward 学生竞赛获奖全纪录
     * @return 结果
     */
    public int insertBizCompetitionAward(BizCompetitionAward bizCompetitionAward);

    /**
     * 修改学生竞赛获奖全纪录
     * 
     * @param bizCompetitionAward 学生竞赛获奖全纪录
     * @return 结果
     */
    public int updateBizCompetitionAward(BizCompetitionAward bizCompetitionAward);

    /**
     * 删除学生竞赛获奖全纪录
     * 
     * @param id 学生竞赛获奖全纪录主键
     * @return 结果
     */
    public int deleteBizCompetitionAwardById(Long id);

    /**
     * 批量删除学生竞赛获奖全纪录
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBizCompetitionAwardByIds(Long[] ids);
}
