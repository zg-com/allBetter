package com.learningmplat.backend.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

/**
 * 系统站内信与通知表
 * @TableName sys_message
 */
@TableName(value ="sys_message")
@Data
public class SysMessage {
    /**
     * 消息主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 接收人ID(逻辑关联sys_user)
     */
    private Long receiverId;

    /**
     * 消息标题
     */
    private String title;

    /**
     * 消息正文(如：驳回理由详情)
     */
    private String content;

    /**
     * 读取状态：0-未读, 1-已读
     */
    private Integer isRead;

    /**
     * 系统发送时间
     */
    private Date createTime;
}