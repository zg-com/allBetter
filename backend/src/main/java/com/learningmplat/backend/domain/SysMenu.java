package com.learningmplat.backend.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

/**
 * 菜单与权限控制表
 * @TableName sys_menu
 */
@TableName(value ="sys_menu")
@Data
public class SysMenu {
    /**
     * 菜单/权限主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 菜单名称(如：科研项目, 审批管理)
     */
    private String menuName;

    /**
     * 父菜单ID(0代表最顶级的目录)
     */
    private Long parentId;

    /**
     * 显示顺序(决定前端菜单排在第几个)
     */
    private Integer orderNum;

    /**
     * 前端路由地址(如：/research/project)
     */
    private String path;

    /**
     * Vue组件路径(如：research/project/index)
     */
    private String component;

    /**
     * 类型：M-目录, C-菜单页面, F-按钮权限
     */
    private String menuType;

    /**
     * 后端权限标识(如：project:audit:reject)
     */
    private String perms;

    /**
     * 创建时间
     */
    private Date createTime;
}