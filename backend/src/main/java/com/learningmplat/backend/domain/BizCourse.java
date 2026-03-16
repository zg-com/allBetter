package com.learningmplat.backend.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 课程实体表
 * @TableName biz_course
 */
@TableName(value ="biz_course")
@Data
public class BizCourse {
    /**
     * 课程id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 课程名称
     */
    private String courseName;

    /**
     * 包含学分
     */
    private BigDecimal credit;

    /**
     * 课程状态： 0-未开课，1-选课中，2-已结课
     */
    private Integer status;

    /**
     * 开课时间
     */
    private Date createTime;
}