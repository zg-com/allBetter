package com.learningmplat.backend.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 学生选课与成绩关联表
 * @TableName biz_student_course
 */
@TableName(value ="biz_student_course")
@Data
public class BizStudentCourse {
    /**
     * 选课记录主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 选课学生ID
     */
    private Long studentId;

    /**
     * 教学班ID
     */
    private Long teachingClassId;

    /**
     * 期末成绩（及格后触发学分结算）
     */
    private BigDecimal score;

    /**
     * 状态：0-学习中，1-已结课（成绩已出）
     */
    private Integer status;

    /**
     * 选课时间
     */
    private Date selectTime;

    private BigDecimal credit;
}