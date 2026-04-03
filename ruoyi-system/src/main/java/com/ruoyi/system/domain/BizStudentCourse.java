package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学生选课与成绩对象 biz_student_course
 * 
 * @author ruoyi
 * @date 2026-04-03
 */
public class BizStudentCourse extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;

    /** 学号 */
    @Excel(name = "学号")
    private String studentNo;

    /** 关联的课程ID */
    @Excel(name = "关联的课程ID")
    private Long courseId;

    /** 最终成绩 */
    @Excel(name = "最终成绩")
    private BigDecimal score;

    /** 已获学分(及格后才给) */
    @Excel(name = "已获学分(及格后才给)")
    private BigDecimal earnedCredits;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setStudentNo(String studentNo) 
    {
        this.studentNo = studentNo;
    }

    public String getStudentNo() 
    {
        return studentNo;
    }

    public void setCourseId(Long courseId) 
    {
        this.courseId = courseId;
    }

    public Long getCourseId() 
    {
        return courseId;
    }

    public void setScore(BigDecimal score) 
    {
        this.score = score;
    }

    public BigDecimal getScore() 
    {
        return score;
    }

    public void setEarnedCredits(BigDecimal earnedCredits) 
    {
        this.earnedCredits = earnedCredits;
    }

    public BigDecimal getEarnedCredits() 
    {
        return earnedCredits;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("studentNo", getStudentNo())
            .append("courseId", getCourseId())
            .append("score", getScore())
            .append("earnedCredits", getEarnedCredits())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
