package com.learningmplat.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learningmplat.backend.domain.BizPaperAuthor;
import com.learningmplat.backend.service.BizPaperAuthorService;
import com.learningmplat.backend.mapper.BizPaperAuthorMapper;
import org.springframework.stereotype.Service;

/**
* @author 13027
* @description 针对表【biz_paper_author(论文多作者排名关联表)】的数据库操作Service实现
* @createDate 2026-03-16 13:41:11
*/
@Service
public class BizPaperAuthorServiceImpl extends ServiceImpl<BizPaperAuthorMapper, BizPaperAuthor>
    implements BizPaperAuthorService{

}




