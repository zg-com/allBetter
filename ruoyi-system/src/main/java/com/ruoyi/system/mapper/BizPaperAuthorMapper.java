package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.BizPaperAuthor;

/**
 * 论文作者关联Mapper接口
 * 
 * @author ruoyi
 * @date 2026-04-10
 */
public interface BizPaperAuthorMapper 
{
    /**
     * 查询论文作者关联
     * 
     * @param id 论文作者关联主键
     * @return 论文作者关联
     */
    public BizPaperAuthor selectBizPaperAuthorById(Long id);

    /**
     * 查询论文作者关联列表
     * 
     * @param bizPaperAuthor 论文作者关联
     * @return 论文作者关联集合
     */
    public List<BizPaperAuthor> selectBizPaperAuthorList(BizPaperAuthor bizPaperAuthor);

    /**
     * 新增论文作者关联
     * 
     * @param bizPaperAuthor 论文作者关联
     * @return 结果
     */
    public int insertBizPaperAuthor(BizPaperAuthor bizPaperAuthor);

    /**
     * 修改论文作者关联
     * 
     * @param bizPaperAuthor 论文作者关联
     * @return 结果
     */
    public int updateBizPaperAuthor(BizPaperAuthor bizPaperAuthor);

    /**
     * 删除论文作者关联
     * 
     * @param id 论文作者关联主键
     * @return 结果
     */
    public int deleteBizPaperAuthorById(Long id);

    /**
     * 批量删除论文作者关联
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBizPaperAuthorByIds(Long[] ids);
}
