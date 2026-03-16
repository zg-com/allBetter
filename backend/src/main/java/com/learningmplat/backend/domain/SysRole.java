package com.learningmplat.backend.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 系统角色表
 * @TableName sys_role
 */
@TableName(value ="sys_role")
@Data
public class SysRole {
    /**
     * 角色主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 角色中文名称
     */
    private String roleName;

    /**
     * 角色代码
     */
    private String roleCode;
}