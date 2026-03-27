package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.BizResearchPaperMapper;
import com.ruoyi.system.domain.BizResearchPaper;
import com.ruoyi.system.service.IBizResearchPaperService;

/**
 * 科研论文全纪录Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-03-27
 */
@Service
public class BizResearchPaperServiceImpl implements IBizResearchPaperService 
{
    @Autowired
    private BizResearchPaperMapper bizResearchPaperMapper;

    /**
     * 查询科研论文全纪录
     * 
     * @param id 科研论文全纪录主键
     * @return 科研论文全纪录
     */
    @Override
    public BizResearchPaper selectBizResearchPaperById(Long id)
    {
        return bizResearchPaperMapper.selectBizResearchPaperById(id);
    }

    /**
     * 查询科研论文全纪录列表
     * 
     * @param bizResearchPaper 科研论文全纪录
     * @return 科研论文全纪录
     */
    @Override
    public List<BizResearchPaper> selectBizResearchPaperList(BizResearchPaper bizResearchPaper)
    {
        return bizResearchPaperMapper.selectBizResearchPaperList(bizResearchPaper);
    }

    /**
     * 新增科研论文全纪录
     * 
     * @param bizResearchPaper 科研论文全纪录
     * @return 结果
     */
    @Override
    public int insertBizResearchPaper(BizResearchPaper bizResearchPaper)
    {
        bizResearchPaper.setCreateTime(DateUtils.getNowDate());
        return bizResearchPaperMapper.insertBizResearchPaper(bizResearchPaper);
    }

    /**
     * 修改科研论文全纪录
     * 
     * @param bizResearchPaper 科研论文全纪录
     * @return 结果
     */
    @Override
    public int updateBizResearchPaper(BizResearchPaper bizResearchPaper)
    {
        bizResearchPaper.setUpdateTime(DateUtils.getNowDate());
        return bizResearchPaperMapper.updateBizResearchPaper(bizResearchPaper);
    }

    /**
     * 批量删除科研论文全纪录
     * 
     * @param ids 需要删除的科研论文全纪录主键
     * @return 结果
     */
    @Override
    public int deleteBizResearchPaperByIds(Long[] ids)
    {
        return bizResearchPaperMapper.deleteBizResearchPaperByIds(ids);
    }

    /**
     * 删除科研论文全纪录信息
     * 
     * @param id 科研论文全纪录主键
     * @return 结果
     */
    @Override
    public int deleteBizResearchPaperById(Long id)
    {
        return bizResearchPaperMapper.deleteBizResearchPaperById(id);
    }
}
