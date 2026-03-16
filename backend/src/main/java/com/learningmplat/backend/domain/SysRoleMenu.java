package com.learningmplat.backend.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 角色与菜单权限关联表
 * @TableName sys_role_menu
 */
@TableName(value ="sys_role_menu")
@Data
public class SysRoleMenu {
    /**
     * 角色ID(关联sys_role)
     */

    private Long roleId;

    /**
     * 菜单/权限ID(关联sys_menu)
     */

    private Long menuId;
}