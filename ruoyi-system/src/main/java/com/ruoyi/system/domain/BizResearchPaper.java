package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 科研论文全纪录对象 biz_research_paper
 * 
 * @author ruoyi
 * @date 2026-03-27
 */
public class BizResearchPaper extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;

    /** 关联教师的主键(归属人) */
    @Excel(name = "关联教师的主键(归属人)")
    private Long userId;

    /** 论文类型(1:SCI论文 2:卓越期刊论文 3:CCF会议论文) */
    @Excel(name = "论文类型(1:SCI论文 2:卓越期刊论文 3:CCF会议论文)")
    private String paperType;

    /** 论文题目 */
    @Excel(name = "论文题目")
    private String paperTitle;

    /** 发表期刊/会议名称 */
    @Excel(name = "发表期刊/会议名称")
    private String journalOrConf;

    /** 作者信息/一作 */
    @Excel(name = "作者信息/一作")
    private String authorInfo;

    /** 通讯作者信息 */
    @Excel(name = "通讯作者信息")
    private String corrAuthorInfo;

    /** 青大是否第一单位(0否 1是) */
    @Excel(name = "青大是否第一单位(0否 1是)")
    private String isFirstUnit;

    /** 论文归属 */
    @Excel(name = "论文归属")
    private String attribution;

    /** 积分 */
    @Excel(name = "积分")
    private BigDecimal points;

    /** SCI分区 */
    @Excel(name = "SCI分区")
    private String sciZone;

    /** 是否推荐期刊(0否 1是) */
    @Excel(name = "是否推荐期刊(0否 1是)")
    private String isRecommended;

    /** CCF分区/会议类型(CCF A等) */
    @Excel(name = "CCF分区/会议类型(CCF A等)")
    private String ccfZone;

    /** 是否卓越领军期刊(0否 1是) */
    @Excel(name = "是否卓越领军期刊(0否 1是)")
    private String isExcellentLeading;

    /** 是否高被引(0否 1是) */
    @Excel(name = "是否高被引(0否 1是)")
    private String isHighlyCited;

    /** 是否ESI论文(0否 1是) */
    @Excel(name = "是否ESI论文(0否 1是)")
    private String isEsi;

    /** 奖励级别 */
    @Excel(name = "奖励级别")
    private String awardLevel;

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

    public void setPaperType(String paperType) 
    {
        this.paperType = paperType;
    }

    public String getPaperType() 
    {
        return paperType;
    }

    public void setPaperTitle(String paperTitle) 
    {
        this.paperTitle = paperTitle;
    }

    public String getPaperTitle() 
    {
        return paperTitle;
    }

    public void setJournalOrConf(String journalOrConf) 
    {
        this.journalOrConf = journalOrConf;
    }

    public String getJournalOrConf() 
    {
        return journalOrConf;
    }

    public void setAuthorInfo(String authorInfo) 
    {
        this.authorInfo = authorInfo;
    }

    public String getAuthorInfo() 
    {
        return authorInfo;
    }

    public void setCorrAuthorInfo(String corrAuthorInfo) 
    {
        this.corrAuthorInfo = corrAuthorInfo;
    }

    public String getCorrAuthorInfo() 
    {
        return corrAuthorInfo;
    }

    public void setIsFirstUnit(String isFirstUnit) 
    {
        this.isFirstUnit = isFirstUnit;
    }

    public String getIsFirstUnit() 
    {
        return isFirstUnit;
    }

    public void setAttribution(String attribution) 
    {
        this.attribution = attribution;
    }

    public String getAttribution() 
    {
        return attribution;
    }

    public void setPoints(BigDecimal points) 
    {
        this.points = points;
    }

    public BigDecimal getPoints() 
    {
        return points;
    }

    public void setSciZone(String sciZone) 
    {
        this.sciZone = sciZone;
    }

    public String getSciZone() 
    {
        return sciZone;
    }

    public void setIsRecommended(String isRecommended) 
    {
        this.isRecommended = isRecommended;
    }

    public String getIsRecommended() 
    {
        return isRecommended;
    }

    public void setCcfZone(String ccfZone) 
    {
        this.ccfZone = ccfZone;
    }

    public String getCcfZone() 
    {
        return ccfZone;
    }

    public void setIsExcellentLeading(String isExcellentLeading) 
    {
        this.isExcellentLeading = isExcellentLeading;
    }

    public String getIsExcellentLeading() 
    {
        return isExcellentLeading;
    }

    public void setIsHighlyCited(String isHighlyCited) 
    {
        this.isHighlyCited = isHighlyCited;
    }

    public String getIsHighlyCited() 
    {
        return isHighlyCited;
    }

    public void setIsEsi(String isEsi) 
    {
        this.isEsi = isEsi;
    }

    public String getIsEsi() 
    {
        return isEsi;
    }

    public void setAwardLevel(String awardLevel) 
    {
        this.awardLevel = awardLevel;
    }

    public String getAwardLevel() 
    {
        return awardLevel;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("paperType", getPaperType())
            .append("paperTitle", getPaperTitle())
            .append("journalOrConf", getJournalOrConf())
            .append("authorInfo", getAuthorInfo())
            .append("corrAuthorInfo", getCorrAuthorInfo())
            .append("isFirstUnit", getIsFirstUnit())
            .append("attribution", getAttribution())
            .append("points", getPoints())
            .append("sciZone", getSciZone())
            .append("isRecommended", getIsRecommended())
            .append("ccfZone", getCcfZone())
            .append("isExcellentLeading", getIsExcellentLeading())
            .append("isHighlyCited", getIsHighlyCited())
            .append("isEsi", getIsEsi())
            .append("awardLevel", getAwardLevel())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
