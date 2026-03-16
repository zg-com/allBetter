package com.learningmplat.backend.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 教师业务信息表
 * @TableName biz_teacher
 */
@TableName(value ="biz_teacher")
@Data
public class BizTeacher {
    /**
     * 用户ID（主键，逻辑关联sys_user）
     */
    @TableId
    private Long userId;

    /**
     * 工号
     */
    private String teacherNo;

    /**
     * 职称
     */
    private String title;

    /**
     * 本学年总课时
     */
    private Integer workHours;
}