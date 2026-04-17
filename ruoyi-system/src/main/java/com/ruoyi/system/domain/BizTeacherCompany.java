package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 教师个人创业情况对象 biz_teacher_company
 * 
 * @author ruoyi
 * @date 2026-04-17
 */
public class BizTeacherCompany extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 教师的user_id */
    @Excel(name = "教师的user_id")
    private Long userId;

    /** 兼职创办公司名称 */
    @Excel(name = "兼职创办公司名称")
    private String companyName;

    /** 法人代表 */
    @Excel(name = "法人代表")
    private String legalPerson;

    /** 成立日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "成立日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date establishDate;

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

    public void setCompanyName(String companyName) 
    {
        this.companyName = companyName;
    }

    public String getCompanyName() 
    {
        return companyName;
    }

    public void setLegalPerson(String legalPerson) 
    {
        this.legalPerson = legalPerson;
    }

    public String getLegalPerson() 
    {
        return legalPerson;
    }

    public void setEstablishDate(Date establishDate) 
    {
        this.establishDate = establishDate;
    }

    public Date getEstablishDate() 
    {
        return establishDate;
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
            .append("companyName", getCompanyName())
            .append("legalPerson", getLegalPerson())
            .append("establishDate", getEstablishDate())
            .append("createTime", getCreateTime())
            .append("status", getStatus())
            .append("cause", getCause())
            .toString();
    }
}
