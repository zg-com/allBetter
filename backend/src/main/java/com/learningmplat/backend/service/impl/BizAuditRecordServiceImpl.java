package com.learningmplat.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learningmplat.backend.domain.BizAuditRecord;
import com.learningmplat.backend.service.BizAuditRecordService;
import com.learningmplat.backend.mapper.BizAuditRecordMapper;
import org.springframework.stereotype.Service;

/**
* @author 13027
* @description 针对表【biz_audit_record(通用业务审批流水表)】的数据库操作Service实现
* @createDate 2026-03-16 13:41:11
*/
@Service
public class BizAuditRecordServiceImpl extends ServiceImpl<BizAuditRecordMapper, BizAuditRecord>
    implements BizAuditRecordService{

}




