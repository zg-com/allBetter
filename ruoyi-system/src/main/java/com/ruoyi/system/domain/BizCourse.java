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
 * @date 2026-04-10
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

    /** 任课教师id */
    @Excel(name = "任课教师id")
    private Long teacherNo;

    /** 课程当前状态（0：申请开课中、1：审核已通过、2：申请已驳回） */
    @Excel(name = "课程当前状态", readConverterExp = "0=：申请开课中、1：审核已通过、2：申请已驳回")
    private Long status;

    /** 课程驳回原因 */
    @Excel(name = "课程驳回原因")
    private String cause;

    /** 课程容量 */
    @Excel(name = "课程容量")
    private Long volume;

    /** 当前选课人数 */
    @Excel(name = "当前选课人数")
    private Long currentNumofpeople;

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

    public void setTeacherNo(Long teacherNo) 
    {
        this.teacherNo = teacherNo;
    }

    public Long getTeacherNo() 
    {
        return teacherNo;
    }

    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }

    public void setCause(String cause) 
    {
        this.cause = cause;
    }

    public String getCause() 
    {
        return cause;
    }

    public void setVolume(Long volume) 
    {
        this.volume = volume;
    }

    public Long getVolume() 
    {
        return volume;
    }

    public void setCurrentNumofpeople(Long currentNumofpeople) 
    {
        this.currentNumofpeople = currentNumofpeople;
    }

    public Long getCurrentNumofpeople() 
    {
        return currentNumofpeople;
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
            .append("teacherNo", getTeacherNo())
            .append("status", getStatus())
            .append("cause", getCause())
            .append("volume", getVolume())
            .append("currentNumofpeople", getCurrentNumofpeople())
            .toString();
    }
}
