package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学生基础学籍档案对象 biz_student_profile
 * 
 * @author ruoyi
 * @date 2026-04-14
 */
public class BizStudentProfile extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;

    /** 关联sys_user的ID */
    @Excel(name = "关联sys_user的ID")
    private Long userId;

    /** 学号(登录账号) */
    @Excel(name = "学号(登录账号)")
    private String studentNo;

    /** 姓名 */
    @Excel(name = "姓名")
    private String realName;

    /** 性别(0男 1女) */
    @Excel(name = "性别(0男 1女)")
    private String gender;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String idCard;

    /** 所属学院 */
    @Excel(name = "所属学院")
    private String college;

    /** 所属专业 */
    @Excel(name = "所属专业")
    private String major;

    /** 所属班级 */
    @Excel(name = "所属班级")
    private String className;

    /** 入学年份(如:2023级) */
    @Excel(name = "入学年份(如:2023级)")
    private String enrollmentYear;

    /** 学籍状态(在读/毕业/休学) */
    @Excel(name = "学籍状态(在读/毕业/休学)")
    private String status;

    /** 当前状态（0：申请中、1：审核已通过、2：申请已驳回） */
    @Excel(name = "当前状态", readConverterExp = "0=：申请中、1：审核已通过、2：申请已驳回")
    private Long statusProfile;

    /** 驳回原因 */
    @Excel(name = "驳回原因")
    private String cause;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }

    public void setStudentNo(String studentNo) 
    {
        this.studentNo = studentNo;
    }

    public String getStudentNo() 
    {
        return studentNo;
    }

    public void setRealName(String realName) 
    {
        this.realName = realName;
    }

    public String getRealName() 
    {
        return realName;
    }

    public void setGender(String gender) 
    {
        this.gender = gender;
    }

    public String getGender() 
    {
        return gender;
    }

    public void setIdCard(String idCard) 
    {
        this.idCard = idCard;
    }

    public String getIdCard() 
    {
        return idCard;
    }

    public void setCollege(String college) 
    {
        this.college = college;
    }

    public String getCollege() 
    {
        return college;
    }

    public void setMajor(String major) 
    {
        this.major = major;
    }

    public String getMajor() 
    {
        return major;
    }

    public void setClassName(String className) 
    {
        this.className = className;
    }

    public String getClassName() 
    {
        return className;
    }

    public void setEnrollmentYear(String enrollmentYear) 
    {
        this.enrollmentYear = enrollmentYear;
    }

    public String getEnrollmentYear() 
    {
        return enrollmentYear;
    }

    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    public void setStatusProfile(Long statusProfile) 
    {
        this.statusProfile = statusProfile;
    }

    public Long getStatusProfile() 
    {
        return statusProfile;
    }

    public void setCause(String cause) 
    {
        this.cause = cause;
    }

    public String getCause() 
    {
        return cause;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("studentNo", getStudentNo())
            .append("realName", getRealName())
            .append("gender", getGender())
            .append("idCard", getIdCard())
            .append("college", getCollege())
            .append("major", getMajor())
            .append("className", getClassName())
            .append("enrollmentYear", getEnrollmentYear())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("statusProfile", getStatusProfile())
            .append("cause", getCause())
            .toString();
    }
}
