package com.learningmplat.backend.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 科研经费收支流水表
 * @TableName biz_fund_record
 */
@TableName(value ="biz_fund_record")
@Data
public class BizFundRecord {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 所属项目ID
     */
    private Long projectId;

    /**
     * 变动金额(正数代表下拨入账，负数代表报销支出)
     */
    private BigDecimal amount;

    /**
     * 经费类别(如：初始下拨, 设备费, 差旅费, 劳务费)
     */
    private String fundType;

    /**
     * 报销人/操作人ID
     */
    private Long operatorId;

    /**
     * 发票/报销凭证的图片云盘链接
     */
    private String proofUrl;

    /**
     * 发生时间
     */
    private Date createTime;
}