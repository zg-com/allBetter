package com.learningmplat.backend.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 教学班排课表，讲老师与课程绑定的中间表
 * @TableName biz_teaching_class
 */
@TableName(value ="biz_teaching_class")
@Data
public class BizTeachingClass {
    /**
     * 教学班主键ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 关联课程表
     */
    private Long courseId;

    /**
     * 关联教师id
     */
    private Long teacherId;

    /**
     * 开课学期
     */
    private String semester;

    /**
     * 选课课程容量
     */
    private Integer maxCapacity;
}