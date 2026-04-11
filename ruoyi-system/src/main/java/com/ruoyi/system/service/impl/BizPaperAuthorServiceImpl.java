package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.BizPaperAuthorMapper;
import com.ruoyi.system.domain.BizPaperAuthor;
import com.ruoyi.system.service.IBizPaperAuthorService;

/**
 * 论文作者关联Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-04-10
 */
@Service
public class BizPaperAuthorServiceImpl implements IBizPaperAuthorService 
{
    @Autowired
    private BizPaperAuthorMapper bizPaperAuthorMapper;

    /**
     * 查询论文作者关联
     * 
     * @param id 论文作者关联主键
     * @return 论文作者关联
     */
    @Override
    public BizPaperAuthor selectBizPaperAuthorById(Long id)
    {
        return bizPaperAuthorMapper.selectBizPaperAuthorById(id);
    }

    /**
     * 查询论文作者关联列表
     * 
     * @param bizPaperAuthor 论文作者关联
     * @return 论文作者关联
     */
    @Override
    public List<BizPaperAuthor> selectBizPaperAuthorList(BizPaperAuthor bizPaperAuthor)
    {
        return bizPaperAuthorMapper.selectBizPaperAuthorList(bizPaperAuthor);
    }

    /**
     * 新增论文作者关联
     * 
     * @param bizPaperAuthor 论文作者关联
     * @return 结果
     */
    @Override
    public int insertBizPaperAuthor(BizPaperAuthor bizPaperAuthor)
    {
        return bizPaperAuthorMapper.insertBizPaperAuthor(bizPaperAuthor);
    }

    /**
     * 修改论文作者关联
     * 
     * @param bizPaperAuthor 论文作者关联
     * @return 结果
     */
    @Override
    public int updateBizPaperAuthor(BizPaperAuthor bizPaperAuthor)
    {
        return bizPaperAuthorMapper.updateBizPaperAuthor(bizPaperAuthor);
    }

    /**
     * 批量删除论文作者关联
     * 
     * @param ids 需要删除的论文作者关联主键
     * @return 结果
     */
    @Override
    public int deleteBizPaperAuthorByIds(Long[] ids)
    {
        return bizPaperAuthorMapper.deleteBizPaperAuthorByIds(ids);
    }

    /**
     * 删除论文作者关联信息
     * 
     * @param id 论文作者关联主键
     * @return 结果
     */
    @Override
    public int deleteBizPaperAuthorById(Long id)
    {
        return bizPaperAuthorMapper.deleteBizPaperAuthorById(id);
    }
}
