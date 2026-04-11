package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 科研奖励关联对象 biz_research_award_people
 * 
 * @author ruoyi
 * @date 2026-04-10
 */
public class BizResearchAwardPeople extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 关联表主键ID */
    private Long id;

    /** 关联奖励id */
    @Excel(name = "关联奖励id")
    private Long awardId;

    /** 用户id (灵魂) */
    @Excel(name = "用户id (灵魂)")
    private Long userId;

    /** 位次 */
    @Excel(name = "位次")
    private Long authorOrder;

    /** 贡献百分比 */
    @Excel(name = "贡献百分比")
    private BigDecimal contribution;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setAwardId(Long awardId) 
    {
        this.awardId = awardId;
    }

    public Long getAwardId() 
    {
        return awardId;
    }

    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }

    public void setAuthorOrder(Long authorOrder) 
    {
        this.authorOrder = authorOrder;
    }

    public Long getAuthorOrder() 
    {
        return authorOrder;
    }

    public void setContribution(BigDecimal contribution) 
    {
        this.contribution = contribution;
    }

    public BigDecimal getContribution() 
    {
        return contribution;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("awardId", getAwardId())
            .append("userId", getUserId())
            .append("authorOrder", getAuthorOrder())
            .append("contribution", getContribution())
            .toString();
    }
}
