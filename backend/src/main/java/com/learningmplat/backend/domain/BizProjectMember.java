package com.learningmplat.backend.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

/**
 * 科研项目成员关联表
 * @TableName biz_project_member
 */
@TableName(value ="biz_project_member")
@Data
public class BizProjectMember {
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
     * 成员ID(逻辑关联sys_user，可是老师或学生)
     */
    private Long userId;

    /**
     * 项目内角色：1-负责人, 2-核心骨干, 3-参与人
     */
    private Integer memberRole;

    /**
     * 加入时间
     */
    private Date joinTime;

    private String memberName;//项目成员名称
}