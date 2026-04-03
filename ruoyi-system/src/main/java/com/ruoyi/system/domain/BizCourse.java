package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 课程信息对象 biz_course
 * 
 * @author ruoyi
 * @date 2026-04-03
 */
public class BizCourse extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 课程ID */
    private Long id;

    /** 课程代码 */
    @Excel(name = "课程代码")
    private String courseCode;

    /** 课程名称 */
    @Excel(name = "课程名称")
    private String courseName;

    /** 课程学分(如:2.5) */
    @Excel(name = "课程学分(如:2.5)")
    private BigDecimal credits;

    /** 任课教师 */
    @Excel(name = "任课教师")
    private String teacherName;

    /** 开课学期(如:2025-2026-1) */
    @Excel(name = "开课学期(如:2025-2026-1)")
    private String semester;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setCourseCode(String courseCode) 
    {
        this.courseCode = courseCode;
    }

    public String getCourseCode() 
    {
        return courseCode;
    }

    public void setCourseName(String courseName) 
    {
        this.courseName = courseName;
    }

    public String getCourseName() 
    {
        return courseName;
    }

    public void setCredits(BigDecimal credits) 
    {
        this.credits = credits;
    }

    public BigDecimal getCredits() 
    {
        return credits;
    }

    public void setTeacherName(String teacherName) 
    {
        this.teacherName = teacherName;
    }

    public String getTeacherName() 
    {
        return teacherName;
    }

    public void setSemester(String semester) 
    {
        this.semester = semester;
    }

    public String getSemester() 
    {
        return semester;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("courseCode", getCourseCode())
            .append("courseName", getCourseName())
            .append("credits", getCredits())
            .append("teacherName", getTeacherName())
            .append("semester", getSemester())
            .append("createTime", getCreateTime())
            .append("remark", getRemark())
            .toString();
    }
}
