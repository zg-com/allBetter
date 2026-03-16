package com.learningmplat.backend.domain.dto;

import lombok.Data;
import java.math.BigDecimal;

/**
 * 接收系主任审批参数的 DTO
 */
@Data
public class ProjectAuditDTO {
    // 1. 要审批的项目 ID
    private Long projectId;

    // 2. 审批结果：2 代表通过，3 代表驳回
    private Integer auditStatus;

    // 3. 如果通过了，批准多少经费？（如果是驳回，前端不传或者传 0 就行）
    private BigDecimal approvedFund;
}