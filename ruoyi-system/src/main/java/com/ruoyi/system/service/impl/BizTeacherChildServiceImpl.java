package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.BizTeacherChildMapper;
import com.ruoyi.system.domain.BizTeacherChild;
import com.ruoyi.system.service.IBizTeacherChildService;

/**
 * 教师子女与妇幼档案Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-04-17
 */
@Service
public class BizTeacherChildServiceImpl implements IBizTeacherChildService 
{
    @Autowired
    private BizTeacherChildMapper bizTeacherChildMapper;

    /**
     * 查询教师子女与妇幼档案
     * 
     * @param id 教师子女与妇幼档案主键
     * @return 教师子女与妇幼档案
     */
    @Override
    public BizTeacherChild selectBizTeacherChildById(Long id)
    {
        return bizTeacherChildMapper.selectBizTeacherChildById(id);
    }

    /**
     * 查询教师子女与妇幼档案列表
     * 
     * @param bizTeacherChild 教师子女与妇幼档案
     * @return 教师子女与妇幼档案
     */
    @Override
    public List<BizTeacherChild> selectBizTeacherChildList(BizTeacherChild bizTeacherChild)
    {
        return bizTeacherChildMapper.selectBizTeacherChildList(bizTeacherChild);
    }

    /**
     * 新增教师子女与妇幼档案
     * 
     * @param bizTeacherChild 教师子女与妇幼档案
     * @return 结果
     */
    @Override
    public int insertBizTeacherChild(BizTeacherChild bizTeacherChild)
    {
        bizTeacherChild.setCreateTime(DateUtils.getNowDate());
        return bizTeacherChildMapper.insertBizTeacherChild(bizTeacherChild);
    }

    /**
     * 修改教师子女与妇幼档案
     * 
     * @param bizTeacherChild 教师子女与妇幼档案
     * @return 结果
     */
    @Override
    public int updateBizTeacherChild(BizTeacherChild bizTeacherChild)
    {
        return bizTeacherChildMapper.updateBizTeacherChild(bizTeacherChild);
    }

    /**
     * 批量删除教师子女与妇幼档案
     * 
     * @param ids 需要删除的教师子女与妇幼档案主键
     * @return 结果
     */
    @Override
    public int deleteBizTeacherChildByIds(Long[] ids)
    {
        return bizTeacherChildMapper.deleteBizTeacherChildByIds(ids);
    }

    /**
     * 删除教师子女与妇幼档案信息
     * 
     * @param id 教师子女与妇幼档案主键
     * @return 结果
     */
    @Override
    public int deleteBizTeacherChildById(Long id)
    {
        return bizTeacherChildMapper.deleteBizTeacherChildById(id);
    }
}
