package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.BizTeacherCompany;

/**
 * 教师个人创业情况Service接口
 * 
 * @author ruoyi
 * @date 2026-03-27
 */
public interface IBizTeacherCompanyService 
{
    /**
     * 查询教师个人创业情况
     * 
     * @param id 教师个人创业情况主键
     * @return 教师个人创业情况
     */
    public BizTeacherCompany selectBizTeacherCompanyById(Long id);

    /**
     * 查询教师个人创业情况列表
     * 
     * @param bizTeacherCompany 教师个人创业情况
     * @return 教师个人创业情况集合
     */
    public List<BizTeacherCompany> selectBizTeacherCompanyList(BizTeacherCompany bizTeacherCompany);

    /**
     * 新增教师个人创业情况
     * 
     * @param bizTeacherCompany 教师个人创业情况
     * @return 结果
     */
    public int insertBizTeacherCompany(BizTeacherCompany bizTeacherCompany);

    /**
     * 修改教师个人创业情况
     * 
     * @param bizTeacherCompany 教师个人创业情况
     * @return 结果
     */
    public int updateBizTeacherCompany(BizTeacherCompany bizTeacherCompany);

    /**
     * 批量删除教师个人创业情况
     * 
     * @param ids 需要删除的教师个人创业情况主键集合
     * @return 结果
     */
    public int deleteBizTeacherCompanyByIds(Long[] ids);

    /**
     * 删除教师个人创业情况信息
     * 
     * @param id 教师个人创业情况主键
     * @return 结果
     */
    public int deleteBizTeacherCompanyById(Long id);
}
