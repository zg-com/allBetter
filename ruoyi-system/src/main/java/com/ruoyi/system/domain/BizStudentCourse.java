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
 * @date 2026-04-10
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

    /** 选课状态：0：未选中，1：已选中 */
    @Excel(name = "选课状态：0：未选中，1：已选中")
    private Long chooseStatus;

    /** 修读状态：0：未修读，1：正在修读，2：已修读 */
    @Excel(name = "修读状态：0：未修读，1：正在修读，2：已修读")
    private Long learnStatus;


    /** 学生用户ID */
    @Excel(name = "学生用户ID")
    private Long userId;

    // ================= 连表查询的课程附加字段 =================

    /** 课程代码 */
    private String courseCode;

    /** 课程名称 */
    private String courseName;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public BigDecimal getCredits() {
        return credits;
    }

    public void setCredits(BigDecimal credits) {
        this.credits = credits;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    /** 任课教师 */
    private String teacherName;

    /** 学分 (注意：对应数据库 decimal，必须用 BigDecimal) */
    private BigDecimal credits;

    /** 开课学期 */
    private String semester;


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

    public void setChooseStatus(Long chooseStatus) 
    {
        this.chooseStatus = chooseStatus;
    }

    public Long getChooseStatus() 
    {
        return chooseStatus;
    }

    public void setLearnStatus(Long learnStatus) 
    {
        this.learnStatus = learnStatus;
    }

    public Long getLearnStatus() 
    {
        return learnStatus;
    }

    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
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
            .append("chooseStatus", getChooseStatus())
            .append("learnStatus", getLearnStatus())
            .append("userId", getUserId())
            .toString();
    }
}
