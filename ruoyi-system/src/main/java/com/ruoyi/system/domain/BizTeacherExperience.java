package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 教师兼职与访学经历对象 biz_teacher_experience
 * 
 * @author ruoyi
 * @date 2026-04-10
 */
public class BizTeacherExperience extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 教师的user_id */
    @Excel(name = "教师的user_id")
    private Long userId;

    /** 记录类型(1社会兼职 2留学访学) */
    @Excel(name = "记录类型(1社会兼职 2留学访学)")
    private String expType;

    /** 兼职头衔或访学国家 */
    @Excel(name = "兼职头衔或访学国家")
    private String titleOrCountry;

    /** 研究领域 */
    @Excel(name = "研究领域")
    private String researchField;

    /** 获得的荣誉或成果 */
    @Excel(name = "获得的荣誉或成果")
    private String achievements;

    /** 起止时间-开始 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "起止时间-开始", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startDate;

    /** 起止时间-结束 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "起止时间-结束", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endDate;

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

    public void setExpType(String expType) 
    {
        this.expType = expType;
    }

    public String getExpType() 
    {
        return expType;
    }

    public void setTitleOrCountry(String titleOrCountry) 
    {
        this.titleOrCountry = titleOrCountry;
    }

    public String getTitleOrCountry() 
    {
        return titleOrCountry;
    }

    public void setResearchField(String researchField) 
    {
        this.researchField = researchField;
    }

    public String getResearchField() 
    {
        return researchField;
    }

    public void setAchievements(String achievements) 
    {
        this.achievements = achievements;
    }

    public String getAchievements() 
    {
        return achievements;
    }

    public void setStartDate(Date startDate) 
    {
        this.startDate = startDate;
    }

    public Date getStartDate() 
    {
        return startDate;
    }

    public void setEndDate(Date endDate) 
    {
        this.endDate = endDate;
    }

    public Date getEndDate() 
    {
        return endDate;
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
            .append("expType", getExpType())
            .append("titleOrCountry", getTitleOrCountry())
            .append("researchField", getResearchField())
            .append("achievements", getAchievements())
            .append("startDate", getStartDate())
            .append("endDate", getEndDate())
            .append("createTime", getCreateTime())
            .append("status", getStatus())
            .append("cause", getCause())
            .toString();
    }
}
