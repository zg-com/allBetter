package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学生竞赛获奖全纪录对象 biz_competition_award
 * 
 * @author ruoyi
 * @date 2026-03-27
 */
public class BizCompetitionAward extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;

    /** 学号 */
    @Excel(name = "学号")
    private String studentNo;

    /** 姓名 */
    @Excel(name = "姓名")
    private String studentName;

    /** 专业 */
    @Excel(name = "专业")
    private String major;

    /** 年级/参赛年份 */
    @Excel(name = "年级/参赛年份")
    private String compYear;

    /** 赛事名称(含获批项目名称) */
    @Excel(name = "赛事名称(含获批项目名称)")
    private String compName;

    /** 主办单位 */
    @Excel(name = "主办单位")
    private String organizer;

    /** 证书编号 */
    @Excel(name = "证书编号")
    private String certNumber;

    /** 获奖时间(以主办方公布时间为准) */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "获奖时间(以主办方公布时间为准)", width = 30, dateFormat = "yyyy-MM-dd")
    private Date awardDate;

    /** 获奖批文或官网公示网址 */
    @Excel(name = "获奖批文或官网公示网址")
    private String certUrl;

    /** 获奖级别(如:国创/省创等) */
    @Excel(name = "获奖级别(如:国创/省创等)")
    private String compLevel;

    /** 获奖等次(如:一等奖/特等奖) */
    @Excel(name = "获奖等次(如:一等奖/特等奖)")
    private String awardGrade;

    /** 赛届(如:第十三届) */
    @Excel(name = "赛届(如:第十三届)")
    private String compEdition;

    /** 赛类(如:软件类/电子类) */
    @Excel(name = "赛类(如:软件类/电子类)")
    private String compCategory;

    /** 比赛科目(如:C/C++程序设计) */
    @Excel(name = "比赛科目(如:C/C++程序设计)")
    private String compSubject;

    /** 比赛组别(如:研究生组/大学A组) */
    @Excel(name = "比赛组别(如:研究生组/大学A组)")
    private String compGroup;

    /** 参赛类型(0个人 1团队) */
    @Excel(name = "参赛类型(0个人 1团队)")
    private String isTeam;

    /** 团队人数 */
    @Excel(name = "团队人数")
    private Long teamSize;

    /** 个人位次 */
    @Excel(name = "个人位次")
    private Long myRank;

    /** 团队成员姓名(顿号分隔) */
    @Excel(name = "团队成员姓名(顿号分隔)")
    private String teamMembers;

    /** 指导教师1姓名 */
    @Excel(name = "指导教师1姓名")
    private String instructor1Name;

    /** 指导教师1所在学院 */
    @Excel(name = "指导教师1所在学院")
    private String instructor1College;

    /** 指导教师2姓名 */
    @Excel(name = "指导教师2姓名")
    private String instructor2Name;

    /** 指导教师2所在学院 */
    @Excel(name = "指导教师2所在学院")
    private String instructor2College;

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

    public void setStudentName(String studentName) 
    {
        this.studentName = studentName;
    }

    public String getStudentName() 
    {
        return studentName;
    }

    public void setMajor(String major) 
    {
        this.major = major;
    }

    public String getMajor() 
    {
        return major;
    }

    public void setCompYear(String compYear) 
    {
        this.compYear = compYear;
    }

    public String getCompYear() 
    {
        return compYear;
    }

    public void setCompName(String compName) 
    {
        this.compName = compName;
    }

    public String getCompName() 
    {
        return compName;
    }

    public void setOrganizer(String organizer) 
    {
        this.organizer = organizer;
    }

    public String getOrganizer() 
    {
        return organizer;
    }

    public void setCertNumber(String certNumber) 
    {
        this.certNumber = certNumber;
    }

    public String getCertNumber() 
    {
        return certNumber;
    }

    public void setAwardDate(Date awardDate) 
    {
        this.awardDate = awardDate;
    }

    public Date getAwardDate() 
    {
        return awardDate;
    }

    public void setCertUrl(String certUrl) 
    {
        this.certUrl = certUrl;
    }

    public String getCertUrl() 
    {
        return certUrl;
    }

    public void setCompLevel(String compLevel) 
    {
        this.compLevel = compLevel;
    }

    public String getCompLevel() 
    {
        return compLevel;
    }

    public void setAwardGrade(String awardGrade) 
    {
        this.awardGrade = awardGrade;
    }

    public String getAwardGrade() 
    {
        return awardGrade;
    }

    public void setCompEdition(String compEdition) 
    {
        this.compEdition = compEdition;
    }

    public String getCompEdition() 
    {
        return compEdition;
    }

    public void setCompCategory(String compCategory) 
    {
        this.compCategory = compCategory;
    }

    public String getCompCategory() 
    {
        return compCategory;
    }

    public void setCompSubject(String compSubject) 
    {
        this.compSubject = compSubject;
    }

    public String getCompSubject() 
    {
        return compSubject;
    }

    public void setCompGroup(String compGroup) 
    {
        this.compGroup = compGroup;
    }

    public String getCompGroup() 
    {
        return compGroup;
    }

    public void setIsTeam(String isTeam) 
    {
        this.isTeam = isTeam;
    }

    public String getIsTeam() 
    {
        return isTeam;
    }

    public void setTeamSize(Long teamSize) 
    {
        this.teamSize = teamSize;
    }

    public Long getTeamSize() 
    {
        return teamSize;
    }

    public void setMyRank(Long myRank) 
    {
        this.myRank = myRank;
    }

    public Long getMyRank() 
    {
        return myRank;
    }

    public void setTeamMembers(String teamMembers) 
    {
        this.teamMembers = teamMembers;
    }

    public String getTeamMembers() 
    {
        return teamMembers;
    }

    public void setInstructor1Name(String instructor1Name) 
    {
        this.instructor1Name = instructor1Name;
    }

    public String getInstructor1Name() 
    {
        return instructor1Name;
    }

    public void setInstructor1College(String instructor1College) 
    {
        this.instructor1College = instructor1College;
    }

    public String getInstructor1College() 
    {
        return instructor1College;
    }

    public void setInstructor2Name(String instructor2Name) 
    {
        this.instructor2Name = instructor2Name;
    }

    public String getInstructor2Name() 
    {
        return instructor2Name;
    }

    public void setInstructor2College(String instructor2College) 
    {
        this.instructor2College = instructor2College;
    }

    public String getInstructor2College() 
    {
        return instructor2College;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("studentNo", getStudentNo())
            .append("studentName", getStudentName())
            .append("major", getMajor())
            .append("compYear", getCompYear())
            .append("compName", getCompName())
            .append("organizer", getOrganizer())
            .append("certNumber", getCertNumber())
            .append("awardDate", getAwardDate())
            .append("certUrl", getCertUrl())
            .append("compLevel", getCompLevel())
            .append("awardGrade", getAwardGrade())
            .append("compEdition", getCompEdition())
            .append("compCategory", getCompCategory())
            .append("compSubject", getCompSubject())
            .append("compGroup", getCompGroup())
            .append("isTeam", getIsTeam())
            .append("teamSize", getTeamSize())
            .append("myRank", getMyRank())
            .append("teamMembers", getTeamMembers())
            .append("instructor1Name", getInstructor1Name())
            .append("instructor1College", getInstructor1College())
            .append("instructor2Name", getInstructor2Name())
            .append("instructor2College", getInstructor2College())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
