package com.learningmplat.backend.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

/**
 * 学术论文实体表
 * @TableName biz_paper
 */
@TableName(value ="biz_paper")
@Data
public class BizPaper {
    /**
     * 论文主键id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 期刊/会议名称
     */
    private String journalName;

    /**
     * 期刊等级
     */
    private String paperLevel;

    /**
     * 论文题目
     */
    private String title;

    /**
     * 发表日期
     */
    private Date publishDate;

    /**
     * 论文状态：0-待提交，1-院系审核中，2-审核通过，3-已驳回
     */
    private Integer publishStatus;

    /**
     * 系统录入时间
     */
    private Date createTime;

    /**
     * 论文归档附件地址
     */
    private String fileUrl;

    /**
     * 上传人ID
     */
    private Long uploaderId;
}