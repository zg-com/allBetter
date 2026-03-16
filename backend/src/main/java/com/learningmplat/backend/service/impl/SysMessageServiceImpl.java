package com.learningmplat.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learningmplat.backend.domain.SysMessage;
import com.learningmplat.backend.service.SysMessageService;
import com.learningmplat.backend.mapper.SysMessageMapper;
import org.springframework.stereotype.Service;

/**
* @author 13027
* @description 针对表【sys_message(系统站内信与通知表)】的数据库操作Service实现
* @createDate 2026-03-16 13:41:11
*/
@Service
public class SysMessageServiceImpl extends ServiceImpl<SysMessageMapper, SysMessage>
    implements SysMessageService{

}




