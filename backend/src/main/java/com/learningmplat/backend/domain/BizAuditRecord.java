package com.learningmplat.backend.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

/**
 * 通用业务审批流水表
 * @TableName biz_audit_record
 */
@TableName(value ="biz_audit_record")
@Data
public class BizAuditRecord {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 目标业务ID(比如科研项目的ID)
     */
    private Long targetId;

    /**
     * 业务类型(如：PROJECT代表项目审批)
     */
    private String targetType;

    /**
     * 审批人/操作人ID(逻辑关联sys_user)
     */
    private Long approverId;

    /**
     * 动作：1-同意, 2-驳回, 3-发起申诉
     */
    private Integer auditAction;

    /**
     * 审批/申诉意见(如：经费预算过高)
     */
    private String auditComment;

    /**
     * 操作时间
     */
    private Date createTime;
}