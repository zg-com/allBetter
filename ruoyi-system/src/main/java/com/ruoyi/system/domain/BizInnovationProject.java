package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 大创项目管理对象 biz_innovation_project
 * 
 * @author ruoyi
 * @date 2026-03-27
 */
public class BizInnovationProject extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;

    /** 项目编号 */
    @Excel(name = "项目编号")
    private String projectNo;

    /** 项目名称 */
    @Excel(name = "项目名称")
    private String projectName;

    /** 项目级别(国家级/省级/校级) */
    @Excel(name = "项目级别(国家级/省级/校级)")
    private String projectLevel;

    /** 项目类型(创新/创业等) */
    @Excel(name = "项目类型(创新/创业等)")
    private String projectType;

    /** 负责人学号 */
    @Excel(name = "负责人学号")
    private String leaderNo;

    /** 负责人姓名 */
    @Excel(name = "负责人姓名")
    private String leaderName;

    /** 团队其他成员 */
    @Excel(name = "团队其他成员")
    private String teamMembers;

    /** 指导教师 */
    @Excel(name = "指导教师")
    private String instructorName;

    /** 立项年份 */
    @Excel(name = "立项年份")
    private String approvalYear;

    /** 项目状态(0进行中 1已结题) */
    @Excel(name = "项目状态(0进行中 1已结题)")
    private String status;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
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

    public void setProjectLevel(String projectLevel) 
    {
        this.projectLevel = projectLevel;
    }

    public String getProjectLevel() 
    {
        return projectLevel;
    }

    public void setProjectType(String projectType) 
    {
        this.projectType = projectType;
    }

    public String getProjectType() 
    {
        return projectType;
    }

    public void setLeaderNo(String leaderNo) 
    {
        this.leaderNo = leaderNo;
    }

    public String getLeaderNo() 
    {
        return leaderNo;
    }

    public void setLeaderName(String leaderName) 
    {
        this.leaderName = leaderName;
    }

    public String getLeaderName() 
    {
        return leaderName;
    }

    public void setTeamMembers(String teamMembers) 
    {
        this.teamMembers = teamMembers;
    }

    public String getTeamMembers() 
    {
        return teamMembers;
    }

    public void setInstructorName(String instructorName) 
    {
        this.instructorName = instructorName;
    }

    public String getInstructorName() 
    {
        return instructorName;
    }

    public void setApprovalYear(String approvalYear) 
    {
        this.approvalYear = approvalYear;
    }

    public String getApprovalYear() 
    {
        return approvalYear;
    }

    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("projectNo", getProjectNo())
            .append("projectName", getProjectName())
            .append("projectLevel", getProjectLevel())
            .append("projectType", getProjectType())
            .append("leaderNo", getLeaderNo())
            .append("leaderName", getLeaderName())
            .append("teamMembers", getTeamMembers())
            .append("instructorName", getInstructorName())
            .append("approvalYear", getApprovalYear())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
