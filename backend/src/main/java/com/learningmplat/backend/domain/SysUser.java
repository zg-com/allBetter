package com.learningmplat.backend.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

/**
 * 系统用户表
 * @TableName sys_user
 */
@TableName(value ="sys_user")
@Data
public class SysUser {
    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 登陆账号
     */
    private String username;

    /**
     * 登录密码（加密后）
     */
    private String password;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 账号状态：0-停用，1-正常
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date createTime;
}