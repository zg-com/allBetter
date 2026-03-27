package com.learningmplat.backend.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 科研项目实体表
 * @TableName biz_project
 */
@TableName(value ="biz_project")
@Data
public class BizProject {
    /**
     * 项目主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 项目级别
     */
    private String projectLevel;

    /**
     * 获批总经费
     */
    private BigDecimal totalFund;

    /**
     * 审批状态： 0-草稿，1-待审核，2-已通过，3-已驳回
     */
    private Integer auditStatus;

    /**
     * 申报时间
     */
    private Date createTime;

    /**
     * 申报人ID (关联sys_user)
     */
    private Long createId;

    private String creatorName; //创建者姓名
}