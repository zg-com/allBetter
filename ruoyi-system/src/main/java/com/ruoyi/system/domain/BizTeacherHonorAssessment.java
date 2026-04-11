package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 教师荣誉与历年考核记录对象 biz_teacher_honor_assessment
 * 
 * @author ruoyi
 * @date 2026-04-10
 */
public class BizTeacherHonorAssessment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 教师的user_id */
    @Excel(name = "教师的user_id")
    private Long userId;

    /** 记录类型(1荣誉称号 2年度考核) */
    @Excel(name = "记录类型(1荣誉称号 2年度考核)")
    private String recordType;

    /** 年份 */
    @Excel(name = "年份")
    private String recordYear;

    /** 荣誉名称或考核结果 */
    @Excel(name = "荣誉名称或考核结果")
    private String honorNameOrResult;

    /** 颁发单位 */
    @Excel(name = "颁发单位")
    private String awardUnit;

    /** 发文年号 */
    @Excel(name = "发文年号")
    private String docNumber;

    /** 发文日期/获奖日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "发文日期/获奖日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date awardDate;

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

    public void setRecordType(String recordType) 
    {
        this.recordType = recordType;
    }

    public String getRecordType() 
    {
        return recordType;
    }

    public void setRecordYear(String recordYear) 
    {
        this.recordYear = recordYear;
    }

    public String getRecordYear() 
    {
        return recordYear;
    }

    public void setHonorNameOrResult(String honorNameOrResult) 
    {
        this.honorNameOrResult = honorNameOrResult;
    }

    public String getHonorNameOrResult() 
    {
        return honorNameOrResult;
    }

    public void setAwardUnit(String awardUnit) 
    {
        this.awardUnit = awardUnit;
    }

    public String getAwardUnit() 
    {
        return awardUnit;
    }

    public void setDocNumber(String docNumber) 
    {
        this.docNumber = docNumber;
    }

    public String getDocNumber() 
    {
        return docNumber;
    }

    public void setAwardDate(Date awardDate) 
    {
        this.awardDate = awardDate;
    }

    public Date getAwardDate() 
    {
        return awardDate;
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
            .append("recordType", getRecordType())
            .append("recordYear", getRecordYear())
            .append("honorNameOrResult", getHonorNameOrResult())
            .append("awardUnit", getAwardUnit())
            .append("docNumber", getDocNumber())
            .append("awardDate", getAwardDate())
            .append("createTime", getCreateTime())
            .append("status", getStatus())
            .append("cause", getCause())
            .toString();
    }
}
