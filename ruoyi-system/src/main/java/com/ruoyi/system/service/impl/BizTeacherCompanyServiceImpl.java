package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.BizTeacherCompanyMapper;
import com.ruoyi.system.domain.BizTeacherCompany;
import com.ruoyi.system.service.IBizTeacherCompanyService;

/**
 * 教师个人创业情况Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-04-17
 */
@Service
public class BizTeacherCompanyServiceImpl implements IBizTeacherCompanyService 
{
    @Autowired
    private BizTeacherCompanyMapper bizTeacherCompanyMapper;

    /**
     * 查询教师个人创业情况
     * 
     * @param id 教师个人创业情况主键
     * @return 教师个人创业情况
     */
    @Override
    public BizTeacherCompany selectBizTeacherCompanyById(Long id)
    {
        return bizTeacherCompanyMapper.selectBizTeacherCompanyById(id);
    }

    /**
     * 查询教师个人创业情况列表
     * 
     * @param bizTeacherCompany 教师个人创业情况
     * @return 教师个人创业情况
     */
    @Override
    public List<BizTeacherCompany> selectBizTeacherCompanyList(BizTeacherCompany bizTeacherCompany)
    {
        return bizTeacherCompanyMapper.selectBizTeacherCompanyList(bizTeacherCompany);
    }

    /**
     * 新增教师个人创业情况
     * 
     * @param bizTeacherCompany 教师个人创业情况
     * @return 结果
     */
    @Override
    public int insertBizTeacherCompany(BizTeacherCompany bizTeacherCompany)
    {
        bizTeacherCompany.setCreateTime(DateUtils.getNowDate());
        return bizTeacherCompanyMapper.insertBizTeacherCompany(bizTeacherCompany);
    }

    /**
     * 修改教师个人创业情况
     * 
     * @param bizTeacherCompany 教师个人创业情况
     * @return 结果
     */
    @Override
    public int updateBizTeacherCompany(BizTeacherCompany bizTeacherCompany)
    {
        return bizTeacherCompanyMapper.updateBizTeacherCompany(bizTeacherCompany);
    }

    /**
     * 批量删除教师个人创业情况
     * 
     * @param ids 需要删除的教师个人创业情况主键
     * @return 结果
     */
    @Override
    public int deleteBizTeacherCompanyByIds(Long[] ids)
    {
        return bizTeacherCompanyMapper.deleteBizTeacherCompanyByIds(ids);
    }

    /**
     * 删除教师个人创业情况信息
     * 
     * @param id 教师个人创业情况主键
     * @return 结果
     */
    @Override
    public int deleteBizTeacherCompanyById(Long id)
    {
        return bizTeacherCompanyMapper.deleteBizTeacherCompanyById(id);
    }
}
