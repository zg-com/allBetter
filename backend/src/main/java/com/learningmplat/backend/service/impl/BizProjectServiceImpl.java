package com.learningmplat.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learningmplat.backend.domain.BizProject;
import com.learningmplat.backend.service.BizProjectService;
import com.learningmplat.backend.mapper.BizProjectMapper;
import org.springframework.stereotype.Service;

/**
* @author 13027
* @description 针对表【biz_project(科研项目实体表)】的数据库操作Service实现
* @createDate 2026-03-16 13:41:11
*/
@Service
public class BizProjectServiceImpl extends ServiceImpl<BizProjectMapper, BizProject>
    implements BizProjectService{

}




