package com.learningmplat.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learningmplat.backend.domain.SysLog;
import com.learningmplat.backend.service.SysLogService;
import com.learningmplat.backend.mapper.SysLogMapper;
import org.springframework.stereotype.Service;

/**
* @author 13027
* @description 针对表【sys_log(系统操作日志与审计表)】的数据库操作Service实现
* @createDate 2026-03-16 13:41:11
*/
@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLog>
    implements SysLogService{

}




