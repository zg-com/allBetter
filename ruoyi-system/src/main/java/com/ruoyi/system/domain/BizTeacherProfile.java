package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 教师人事基础档案对象 biz_teacher_profile
 * 
 * @author ruoyi
 * @date 2026-03-27
 */
public class BizTeacherProfile extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;

    /** 关联sys_user表的user_id */
    @Excel(name = "关联sys_user表的user_id")
    private Long userId;

    /** 教职工号 */
    @Excel(name = "教职工号")
    private String teacherNo;

    /** 教职工姓名 */
    @Excel(name = "教职工姓名")
    private String realName;

    /** 性别(0女 1男) */
    @Excel(name = "性别(0女 1男)")
    private String gender;

    /** 民族 */
    @Excel(name = "民族")
    private String nation;

    /** 出生年月 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出生年月", width = 30, dateFormat = "yyyy-MM-dd")
    private Date birthDate;

    /** 年龄 */
    @Excel(name = "年龄")
    private Long age;

    /** 来校时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "来校时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date comingTime;

    /** 拟退休年 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "拟退休年", width = 30, dateFormat = "yyyy-MM-dd")
    private Date retireAge;

    /** 所在部门 */
    @Excel(name = "所在部门")
    private String department;

    /** 籍贯 */
    @Excel(name = "籍贯")
    private String nativePlace;

    /** 婚否(0未婚 1已婚) */
    @Excel(name = "婚否(0未婚 1已婚)")
    private String maritalStatus;

    /** 宗教信仰 */
    @Excel(name = "宗教信仰")
    private String religion;

    /** 紧急联系人 */
    @Excel(name = "紧急联系人")
    private String emergencyContact;

    /** 紧急联系人手机号 */
    @Excel(name = "紧急联系人手机号")
    private String emergencyPhone;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String email;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String idCard;

    /** 手机号 */
    @Excel(name = "手机号")
    private String phoneNumber;

    /** 住址 */
    @Excel(name = "住址")
    private String homeAddress;

    /** 最高学位 */
    @Excel(name = "最高学位")
    private String highestDegree;

    /** 最高学历 */
    @Excel(name = "最高学历")
    private String highestEducation;

    /** 最高毕业院校 */
    @Excel(name = "最高毕业院校")
    private String highestGradSchool;

    /** 所学专业 */
    @Excel(name = "所学专业")
    private String major;

    /** 所属门类 */
    @Excel(name = "所属门类")
    private String belongCategory;

    /** 最高学历开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "最高学历开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date highestEducationBeginTime;

    /** 最高学历毕业时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "最高学历毕业时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date highestEducationEndTime;

    /** 第一学位 */
    @Excel(name = "第一学位")
    private String firstDegree;

    /** 第一学历 */
    @Excel(name = "第一学历")
    private String firstEducation;

    /** 党派 */
    @Excel(name = "党派")
    private String politicalParty;

    /** 专业技术职务(职称) */
    @Excel(name = "专业技术职务(职称)")
    private String professionalTitle;

    /** 人才称号 */
    @Excel(name = "人才称号")
    private String talentTitle;

    /** 是否双肩挑(0否 1是) */
    @Excel(name = "是否双肩挑(0否 1是)")
    private String isDualShoulder;

    /** 辅导员类别 */
    @Excel(name = "辅导员类别")
    private String counselorType;

    /** 入党时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "入党时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date joinPartyDate;

    /** 转正时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "转正时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date partyRegularDate;

    /** 党政职务 */
    @Excel(name = "党政职务")
    private String adminPost;

    /** 任职时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "任职时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date postAppointDate;

    /** 评聘时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "评聘时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date titleEvalDate;

    /** 分类 */
    @Excel(name = "分类")
    private String staffCategory;

    /** 岗位 */
    @Excel(name = "岗位")
    private String postName;

    /** 现岗位聘用时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "现岗位聘用时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date currentPostDate;

    /** 人才评聘时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "人才评聘时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date talentEvalDate;

    /** 首聘期日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "首聘期日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date firstHireDate;

    /** 转正日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "转正日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date regularDate;

    /** 引进层次 */
    @Excel(name = "引进层次")
    private String introLevel;

    /** 特聘层次 */
    @Excel(name = "特聘层次")
    private String specialLevel;

    /** 特聘合同日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "特聘合同日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date contractDate;

    /** 特聘合同附件地址 */
    @Excel(name = "特聘合同附件地址")
    private String contractFileUrl;

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

    public void setTeacherNo(String teacherNo) 
    {
        this.teacherNo = teacherNo;
    }

    public String getTeacherNo() 
    {
        return teacherNo;
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

    public void setNation(String nation) 
    {
        this.nation = nation;
    }

    public String getNation() 
    {
        return nation;
    }

    public void setBirthDate(Date birthDate) 
    {
        this.birthDate = birthDate;
    }

    public Date getBirthDate() 
    {
        return birthDate;
    }

    public void setAge(Long age) 
    {
        this.age = age;
    }

    public Long getAge() 
    {
        return age;
    }

    public void setComingTime(Date comingTime) 
    {
        this.comingTime = comingTime;
    }

    public Date getComingTime() 
    {
        return comingTime;
    }

    public void setRetireAge(Date retireAge) 
    {
        this.retireAge = retireAge;
    }

    public Date getRetireAge() 
    {
        return retireAge;
    }

    public void setDepartment(String department) 
    {
        this.department = department;
    }

    public String getDepartment() 
    {
        return department;
    }

    public void setNativePlace(String nativePlace) 
    {
        this.nativePlace = nativePlace;
    }

    public String getNativePlace() 
    {
        return nativePlace;
    }

    public void setMaritalStatus(String maritalStatus) 
    {
        this.maritalStatus = maritalStatus;
    }

    public String getMaritalStatus() 
    {
        return maritalStatus;
    }

    public void setReligion(String religion) 
    {
        this.religion = religion;
    }

    public String getReligion() 
    {
        return religion;
    }

    public void setEmergencyContact(String emergencyContact) 
    {
        this.emergencyContact = emergencyContact;
    }

    public String getEmergencyContact() 
    {
        return emergencyContact;
    }

    public void setEmergencyPhone(String emergencyPhone) 
    {
        this.emergencyPhone = emergencyPhone;
    }

    public String getEmergencyPhone() 
    {
        return emergencyPhone;
    }

    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }

    public void setIdCard(String idCard) 
    {
        this.idCard = idCard;
    }

    public String getIdCard() 
    {
        return idCard;
    }

    public void setPhoneNumber(String phoneNumber) 
    {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() 
    {
        return phoneNumber;
    }

    public void setHomeAddress(String homeAddress) 
    {
        this.homeAddress = homeAddress;
    }

    public String getHomeAddress() 
    {
        return homeAddress;
    }

    public void setHighestDegree(String highestDegree) 
    {
        this.highestDegree = highestDegree;
    }

    public String getHighestDegree() 
    {
        return highestDegree;
    }

    public void setHighestEducation(String highestEducation) 
    {
        this.highestEducation = highestEducation;
    }

    public String getHighestEducation() 
    {
        return highestEducation;
    }

    public void setHighestGradSchool(String highestGradSchool) 
    {
        this.highestGradSchool = highestGradSchool;
    }

    public String getHighestGradSchool() 
    {
        return highestGradSchool;
    }

    public void setMajor(String major) 
    {
        this.major = major;
    }

    public String getMajor() 
    {
        return major;
    }

    public void setBelongCategory(String belongCategory) 
    {
        this.belongCategory = belongCategory;
    }

    public String getBelongCategory() 
    {
        return belongCategory;
    }

    public void setHighestEducationBeginTime(Date highestEducationBeginTime) 
    {
        this.highestEducationBeginTime = highestEducationBeginTime;
    }

    public Date getHighestEducationBeginTime() 
    {
        return highestEducationBeginTime;
    }

    public void setHighestEducationEndTime(Date highestEducationEndTime) 
    {
        this.highestEducationEndTime = highestEducationEndTime;
    }

    public Date getHighestEducationEndTime() 
    {
        return highestEducationEndTime;
    }

    public void setFirstDegree(String firstDegree) 
    {
        this.firstDegree = firstDegree;
    }

    public String getFirstDegree() 
    {
        return firstDegree;
    }

    public void setFirstEducation(String firstEducation) 
    {
        this.firstEducation = firstEducation;
    }

    public String getFirstEducation() 
    {
        return firstEducation;
    }

    public void setPoliticalParty(String politicalParty) 
    {
        this.politicalParty = politicalParty;
    }

    public String getPoliticalParty() 
    {
        return politicalParty;
    }

    public void setProfessionalTitle(String professionalTitle) 
    {
        this.professionalTitle = professionalTitle;
    }

    public String getProfessionalTitle() 
    {
        return professionalTitle;
    }

    public void setTalentTitle(String talentTitle) 
    {
        this.talentTitle = talentTitle;
    }

    public String getTalentTitle() 
    {
        return talentTitle;
    }

    public void setIsDualShoulder(String isDualShoulder) 
    {
        this.isDualShoulder = isDualShoulder;
    }

    public String getIsDualShoulder() 
    {
        return isDualShoulder;
    }

    public void setCounselorType(String counselorType) 
    {
        this.counselorType = counselorType;
    }

    public String getCounselorType() 
    {
        return counselorType;
    }

    public void setJoinPartyDate(Date joinPartyDate) 
    {
        this.joinPartyDate = joinPartyDate;
    }

    public Date getJoinPartyDate() 
    {
        return joinPartyDate;
    }

    public void setPartyRegularDate(Date partyRegularDate) 
    {
        this.partyRegularDate = partyRegularDate;
    }

    public Date getPartyRegularDate() 
    {
        return partyRegularDate;
    }

    public void setAdminPost(String adminPost) 
    {
        this.adminPost = adminPost;
    }

    public String getAdminPost() 
    {
        return adminPost;
    }

    public void setPostAppointDate(Date postAppointDate) 
    {
        this.postAppointDate = postAppointDate;
    }

    public Date getPostAppointDate() 
    {
        return postAppointDate;
    }

    public void setTitleEvalDate(Date titleEvalDate) 
    {
        this.titleEvalDate = titleEvalDate;
    }

    public Date getTitleEvalDate() 
    {
        return titleEvalDate;
    }

    public void setStaffCategory(String staffCategory) 
    {
        this.staffCategory = staffCategory;
    }

    public String getStaffCategory() 
    {
        return staffCategory;
    }

    public void setPostName(String postName) 
    {
        this.postName = postName;
    }

    public String getPostName() 
    {
        return postName;
    }

    public void setCurrentPostDate(Date currentPostDate) 
    {
        this.currentPostDate = currentPostDate;
    }

    public Date getCurrentPostDate() 
    {
        return currentPostDate;
    }

    public void setTalentEvalDate(Date talentEvalDate) 
    {
        this.talentEvalDate = talentEvalDate;
    }

    public Date getTalentEvalDate() 
    {
        return talentEvalDate;
    }

    public void setFirstHireDate(Date firstHireDate) 
    {
        this.firstHireDate = firstHireDate;
    }

    public Date getFirstHireDate() 
    {
        return firstHireDate;
    }

    public void setRegularDate(Date regularDate) 
    {
        this.regularDate = regularDate;
    }

    public Date getRegularDate() 
    {
        return regularDate;
    }

    public void setIntroLevel(String introLevel) 
    {
        this.introLevel = introLevel;
    }

    public String getIntroLevel() 
    {
        return introLevel;
    }

    public void setSpecialLevel(String specialLevel) 
    {
        this.specialLevel = specialLevel;
    }

    public String getSpecialLevel() 
    {
        return specialLevel;
    }

    public void setContractDate(Date contractDate) 
    {
        this.contractDate = contractDate;
    }

    public Date getContractDate() 
    {
        return contractDate;
    }

    public void setContractFileUrl(String contractFileUrl) 
    {
        this.contractFileUrl = contractFileUrl;
    }

    public String getContractFileUrl() 
    {
        return contractFileUrl;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("teacherNo", getTeacherNo())
            .append("realName", getRealName())
            .append("gender", getGender())
            .append("nation", getNation())
            .append("birthDate", getBirthDate())
            .append("age", getAge())
            .append("comingTime", getComingTime())
            .append("retireAge", getRetireAge())
            .append("department", getDepartment())
            .append("nativePlace", getNativePlace())
            .append("maritalStatus", getMaritalStatus())
            .append("religion", getReligion())
            .append("emergencyContact", getEmergencyContact())
            .append("emergencyPhone", getEmergencyPhone())
            .append("email", getEmail())
            .append("idCard", getIdCard())
            .append("phoneNumber", getPhoneNumber())
            .append("homeAddress", getHomeAddress())
            .append("highestDegree", getHighestDegree())
            .append("highestEducation", getHighestEducation())
            .append("highestGradSchool", getHighestGradSchool())
            .append("major", getMajor())
            .append("belongCategory", getBelongCategory())
            .append("highestEducationBeginTime", getHighestEducationBeginTime())
            .append("highestEducationEndTime", getHighestEducationEndTime())
            .append("firstDegree", getFirstDegree())
            .append("firstEducation", getFirstEducation())
            .append("politicalParty", getPoliticalParty())
            .append("professionalTitle", getProfessionalTitle())
            .append("talentTitle", getTalentTitle())
            .append("isDualShoulder", getIsDualShoulder())
            .append("counselorType", getCounselorType())
            .append("joinPartyDate", getJoinPartyDate())
            .append("partyRegularDate", getPartyRegularDate())
            .append("adminPost", getAdminPost())
            .append("postAppointDate", getPostAppointDate())
            .append("titleEvalDate", getTitleEvalDate())
            .append("staffCategory", getStaffCategory())
            .append("postName", getPostName())
            .append("currentPostDate", getCurrentPostDate())
            .append("talentEvalDate", getTalentEvalDate())
            .append("firstHireDate", getFirstHireDate())
            .append("regularDate", getRegularDate())
            .append("introLevel", getIntroLevel())
            .append("specialLevel", getSpecialLevel())
            .append("contractDate", getContractDate())
            .append("contractFileUrl", getContractFileUrl())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
