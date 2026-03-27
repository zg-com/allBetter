package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 科研项目经费与周期管理对象 biz_research_project
 * 
 * @author ruoyi
 * @date 2026-03-27
 */
public class BizResearchProject extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;

    /** 关联教师的主键(负责人) */
    @Excel(name = "关联教师的主键(负责人)")
    private Long userId;

    /** 项目编号 */
    @Excel(name = "项目编号")
    private String projectNo;

    /** 项目名称 */
    @Excel(name = "项目名称")
    private String projectName;

    /** 项目来源 */
    @Excel(name = "项目来源")
    private String projectSource;

    /** 负责人 */
    @Excel(name = "负责人")
    private String leaderName;

    /** 项目签署所属年度 */
    @Excel(name = "项目签署所属年度")
    private String signYear;

    /** 合同签订日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "合同签订日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date contractStartDate;

    /** 合同截止日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "合同截止日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date contractEndDate;

    /** 合同金额(万元) */
    @Excel(name = "合同金额(万元)")
    private BigDecimal contractAmount;

    /** 到账金额(万元) */
    @Excel(name = "到账金额(万元)")
    private BigDecimal arrivedAmount;

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

    public void setProjectNo(String projectNo) 
    {
        this.projectNo = projectNo;
    }

    public String getProjectNo() 
    {
        return projectNo;
    }

    public void setProjectName(String projectName) 
    {
        this.projectName = projectName;
    }

    public String getProjectName() 
    {
        return projectName;
    }

    public void setProjectSource(String projectSource) 
    {
        this.projectSource = projectSource;
    }

    public String getProjectSource() 
    {
        return projectSource;
    }

    public void setLeaderName(String leaderName) 
    {
        this.leaderName = leaderName;
    }

    public String getLeaderName() 
    {
        return leaderName;
    }

    public void setSignYear(String signYear) 
    {
        this.signYear = signYear;
    }

    public String getSignYear() 
    {
        return signYear;
    }

    public void setContractStartDate(Date contractStartDate) 
    {
        this.contractStartDate = contractStartDate;
    }

    public Date getContractStartDate() 
    {
        return contractStartDate;
    }

    public void setContractEndDate(Date contractEndDate) 
    {
        this.contractEndDate = contractEndDate;
    }

    public Date getContractEndDate() 
    {
        return contractEndDate;
    }

    public void setContractAmount(BigDecimal contractAmount) 
    {
        this.contractAmount = contractAmount;
    }

    public BigDecimal getContractAmount() 
    {
        return contractAmount;
    }

    public void setArrivedAmount(BigDecimal arrivedAmount) 
    {
        this.arrivedAmount = arrivedAmount;
    }

    public BigDecimal getArrivedAmount() 
    {
        return arrivedAmount;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("projectNo", getProjectNo())
            .append("projectName", getProjectName())
            .append("projectSource", getProjectSource())
            .append("leaderName", getLeaderName())
            .append("signYear", getSignYear())
            .append("contractStartDate", getContractStartDate())
            .append("contractEndDate", getContractEndDate())
            .append("contractAmount", getContractAmount())
            .append("arrivedAmount", getArrivedAmount())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
