package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 教师历年学习经历与证书对象 biz_teacher_education
 * 
 * @author ruoyi
 * @date 2026-03-27
 */
public class BizTeacherEducation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 教师的user_id */
    @Excel(name = "教师的user_id")
    private Long userId;

    /** 学习阶段(大专/本科/硕士/博士) */
    @Excel(name = "学习阶段(大专/本科/硕士/博士)")
    private String eduStage;

    /** 就读院校名称 */
    @Excel(name = "就读院校名称")
    private String schoolName;

    /** 所学专业 */
    @Excel(name = "所学专业")
    private String major;

    /** 开始日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startDate;

    /** 毕业日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "毕业日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endDate;

    /** 学位证书扫描件地址 */
    @Excel(name = "学位证书扫描件地址")
    private String degreeCertUrl;

    /** 毕业证书扫描件地址 */
    @Excel(name = "毕业证书扫描件地址")
    private String gradCertUrl;

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

    public void setEduStage(String eduStage) 
    {
        this.eduStage = eduStage;
    }

    public String getEduStage() 
    {
        return eduStage;
    }

    public void setSchoolName(String schoolName) 
    {
        this.schoolName = schoolName;
    }

    public String getSchoolName() 
    {
        return schoolName;
    }

    public void setMajor(String major) 
    {
        this.major = major;
    }

    public String getMajor() 
    {
        return major;
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

    public void setDegreeCertUrl(String degreeCertUrl) 
    {
        this.degreeCertUrl = degreeCertUrl;
    }

    public String getDegreeCertUrl() 
    {
        return degreeCertUrl;
    }

    public void setGradCertUrl(String gradCertUrl) 
    {
        this.gradCertUrl = gradCertUrl;
    }

    public String getGradCertUrl() 
    {
        return gradCertUrl;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("eduStage", getEduStage())
            .append("schoolName", getSchoolName())
            .append("major", getMajor())
            .append("startDate", getStartDate())
            .append("endDate", getEndDate())
            .append("degreeCertUrl", getDegreeCertUrl())
            .append("gradCertUrl", getGradCertUrl())
            .append("createTime", getCreateTime())
            .toString();
    }
}
