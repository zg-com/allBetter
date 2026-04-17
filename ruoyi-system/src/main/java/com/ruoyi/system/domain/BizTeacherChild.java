package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 教师子女与妇幼档案对象 biz_teacher_child
 * 
 * @author ruoyi
 * @date 2026-04-17
 */
public class BizTeacherChild extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 教师的user_id */
    @Excel(name = "教师的user_id")
    private Long userId;

    /** 子女姓名 */
    @Excel(name = "子女姓名")
    private String childName;

    /** 子女出生日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "子女出生日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date birthDate;

    /** 性别(0男 1女) */
    @Excel(name = "性别(0男 1女)")
    private String gender;

    /** 就学状况/所在学校 */
    @Excel(name = "就学状况/所在学校")
    private String schoolingStatus;

    /** 幼儿费用及上学问题详细备注 */
    @Excel(name = "幼儿费用及上学问题详细备注")
    private String nurseryFeeInfo;

    /** 当前状态（0：申请中、1：审核已通过、2：申请已驳回） */
    @Excel(name = "当前状态", readConverterExp = "0=：申请中、1：审核已通过、2：申请已驳回")
    private Long status;

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

    public void setChildName(String childName) 
    {
        this.childName = childName;
    }

    public String getChildName() 
    {
        return childName;
    }

    public void setBirthDate(Date birthDate) 
    {
        this.birthDate = birthDate;
    }

    public Date getBirthDate() 
    {
        return birthDate;
    }

    public void setGender(String gender) 
    {
        this.gender = gender;
    }

    public String getGender() 
    {
        return gender;
    }

    public void setSchoolingStatus(String schoolingStatus) 
    {
        this.schoolingStatus = schoolingStatus;
    }

    public String getSchoolingStatus() 
    {
        return schoolingStatus;
    }

    public void setNurseryFeeInfo(String nurseryFeeInfo) 
    {
        this.nurseryFeeInfo = nurseryFeeInfo;
    }

    public String getNurseryFeeInfo() 
    {
        return nurseryFeeInfo;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("childName", getChildName())
            .append("birthDate", getBirthDate())
            .append("gender", getGender())
            .append("schoolingStatus", getSchoolingStatus())
            .append("nurseryFeeInfo", getNurseryFeeInfo())
            .append("createTime", getCreateTime())
            .append("status", getStatus())
            .append("cause", getCause())
            .toString();
    }
}
