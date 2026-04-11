package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.BizStudentProfile;

/**
 * 学生基础学籍档案Service接口
 * 
 * @author ruoyi
 * @date 2026-04-10
 */
public interface IBizStudentProfileService 
{
    /**
     * 查询学生基础学籍档案
     * 
     * @param id 学生基础学籍档案主键
     * @return 学生基础学籍档案
     */
    public BizStudentProfile selectBizStudentProfileById(Long id);

    /**
     * 查询学生基础学籍档案列表
     * 
     * @param bizStudentProfile 学生基础学籍档案
     * @return 学生基础学籍档案集合
     */
    public List<BizStudentProfile> selectBizStudentProfileList(BizStudentProfile bizStudentProfile);

    /**
     * 新增学生基础学籍档案
     * 
     * @param bizStudentProfile 学生基础学籍档案
     * @return 结果
     */
    public int insertBizStudentProfile(BizStudentProfile bizStudentProfile);

    /**
     * 修改学生基础学籍档案
     * 
     * @param bizStudentProfile 学生基础学籍档案
     * @return 结果
     */
    public int updateBizStudentProfile(BizStudentProfile bizStudentProfile);

    /**
     * 批量删除学生基础学籍档案
     * 
     * @param ids 需要删除的学生基础学籍档案主键集合
     * @return 结果
     */
    public int deleteBizStudentProfileByIds(Long[] ids);

    /**
     * 删除学生基础学籍档案信息
     * 
     * @param id 学生基础学籍档案主键
     * @return 结果
     */
    public int deleteBizStudentProfileById(Long id);
}
