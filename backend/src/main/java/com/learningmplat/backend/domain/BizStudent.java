package com.learningmplat.backend.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import lombok.Data;

/**
 * 学生业务信息表
 * @TableName biz_student
 */
@TableName(value ="biz_student")
@Data
public class BizStudent {
    /**
     * 用户ID（主键，逻辑关联sys_user）
     */
    @TableId
    private Long userId;

    /**
     * 学号
     */
    private String studentNo;

    /**
     * 入学年份
     */
    private Integer enrollmentYear;

    /**
     * 专业
     */
    private String major;

    /**
     * 已修总学分
     */
    private BigDecimal totalCredits;
}