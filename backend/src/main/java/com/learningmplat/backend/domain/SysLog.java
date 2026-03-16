package com.learningmplat.backend.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

/**
 * 系统操作日志与审计表
 * @TableName sys_log
 */
@TableName(value ="sys_log")
@Data
public class SysLog {
    /**
     * 日志主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 操作的模块(如：科研项目)
     */
    private String title;

    /**
     * 具体动作(如：驳回了李老师的项目申报)
     */
    private String action;

    /**
     * 操作人姓名(冗余字段，极大提高查询速度！)
     */
    private String operName;

    /**
     * 操作主机IP地址
     */
    private String operIp;

    /**
     * 操作状态：0-失败异常, 1-正常成功
     */
    private Integer status;

    /**
     * 操作发生时间
     */
    private Date createTime;
}