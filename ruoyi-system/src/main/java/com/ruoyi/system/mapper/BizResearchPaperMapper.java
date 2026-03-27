package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.BizResearchPaper;

/**
 * 科研论文全纪录Mapper接口
 * 
 * @author ruoyi
 * @date 2026-03-27
 */
public interface BizResearchPaperMapper 
{
    /**
     * 查询科研论文全纪录
     * 
     * @param id 科研论文全纪录主键
     * @return 科研论文全纪录
     */
    public BizResearchPaper selectBizResearchPaperById(Long id);

    /**
     * 查询科研论文全纪录列表
     * 
     * @param bizResearchPaper 科研论文全纪录
     * @return 科研论文全纪录集合
     */
    public List<BizResearchPaper> selectBizResearchPaperList(BizResearchPaper bizResearchPaper);

    /**
     * 新增科研论文全纪录
     * 
     * @param bizResearchPaper 科研论文全纪录
     * @return 结果
     */
    public int insertBizResearchPaper(BizResearchPaper bizResearchPaper);

    /**
     * 修改科研论文全纪录
     * 
     * @param bizResearchPaper 科研论文全纪录
     * @return 结果
     */
    public int updateBizResearchPaper(BizResearchPaper bizResearchPaper);

    /**
     * 删除科研论文全纪录
     * 
     * @param id 科研论文全纪录主键
     * @return 结果
     */
    public int deleteBizResearchPaperById(Long id);

    /**
     * 批量删除科研论文全纪录
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBizResearchPaperByIds(Long[] ids);
}
