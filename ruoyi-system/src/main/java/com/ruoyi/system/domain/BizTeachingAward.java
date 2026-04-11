package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 教研奖励对象 biz_teaching_award
 * 
 * @author ruoyi
 * @date 2026-04-10
 */
public class BizTeachingAward extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;

    /** 关联教师的主键(申报人) */
    @Excel(name = "关联教师的主键(申报人)")
    private Long userId;

    /** 奖励名称 */
    @Excel(name = "奖励名称")
    private String awardName;

    /** 成果名称 */
    @Excel(name = "成果名称")
    private String achievementName;

    /** 获奖级别 */
    @Excel(name = "获奖级别")
    private String awardLevel;

    /** 获奖日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "获奖日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date awardDate;

    /** 所有完成人(逗号/顿号分隔) */
    @Excel(name = "所有完成人(逗号/顿号分隔)")
    private String allContributors;

    /** 发证机关 */
    @Excel(name = "发证机关")
    private String issuingAuthority;

    /** 获奖等级 */
    @Excel(name = "获奖等级")
    private String awardGrade;

    /** 证书号 */
    @Excel(name = "证书号")
    private String certNumber;

    /** 主要成果简述 */
    @Excel(name = "主要成果简述")
    private String mainAchievement;

    /** 教师名称 */
    @Excel(name = "教师名称")
    private String teacherName;

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

    public void setAwardName(String awardName) 
    {
        this.awardName = awardName;
    }

    public String getAwardName() 
    {
        return awardName;
    }

    public void setAchievementName(String achievementName) 
    {
        this.achievementName = achievementName;
    }

    public String getAchievementName() 
    {
        return achievementName;
    }

    public void setAwardLevel(String awardLevel) 
    {
        this.awardLevel = awardLevel;
    }

    public String getAwardLevel() 
    {
        return awardLevel;
    }

    public void setAwardDate(Date awardDate) 
    {
        this.awardDate = awardDate;
    }

    public Date getAwardDate() 
    {
        return awardDate;
    }

    public void setAllContributors(String allContributors) 
    {
        this.allContributors = allContributors;
    }

    public String getAllContributors() 
    {
        return allContributors;
    }

    public void setIssuingAuthority(String issuingAuthority) 
    {
        this.issuingAuthority = issuingAuthority;
    }

    public String getIssuingAuthority() 
    {
        return issuingAuthority;
    }

    public void setAwardGrade(String awardGrade) 
    {
        this.awardGrade = awardGrade;
    }

    public String getAwardGrade() 
    {
        return awardGrade;
    }

    public void setCertNumber(String certNumber) 
    {
        this.certNumber = certNumber;
    }

    public String getCertNumber() 
    {
        return certNumber;
    }

    public void setMainAchievement(String mainAchievement) 
    {
        this.mainAchievement = mainAchievement;
    }

    public String getMainAchievement() 
    {
        return mainAchievement;
    }

    public void setTeacherName(String teacherName) 
    {
        this.teacherName = teacherName;
    }

    public String getTeacherName() 
    {
        return teacherName;
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
            .append("awardName", getAwardName())
            .append("achievementName", getAchievementName())
            .append("awardLevel", getAwardLevel())
            .append("awardDate", getAwardDate())
            .append("allContributors", getAllContributors())
            .append("issuingAuthority", getIssuingAuthority())
            .append("awardGrade", getAwardGrade())
            .append("certNumber", getCertNumber())
            .append("mainAchievement", getMainAchievement())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("teacherName", getTeacherName())
            .append("status", getStatus())
            .append("cause", getCause())
            .toString();
    }
}
