package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 论文作者关联对象 biz_paper_author
 * 
 * @author ruoyi
 * @date 2026-04-10
 */
public class BizPaperAuthor extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 关联表主键ID */
    private Long id;

    /** 关联论文id */
    @Excel(name = "关联论文id")
    private Long paperId;

    /** 用户id (灵魂) */
    @Excel(name = "用户id (灵魂)")
    private Long userId;

    /** 位次 (1代表一作，2代表二作) */
    @Excel(name = "位次 (1代表一作，2代表二作)")
    private Long authorOrder;

    /** 是否为通讯作者（0 否，1 是） */
    @Excel(name = "是否为通讯作者", readConverterExp = "0=,否=，1,是=")
    private Long isCorresponding;

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

    public void setPaperId(Long paperId) 
    {
        this.paperId = paperId;
    }

    public Long getPaperId() 
    {
        return paperId;
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

    public void setIsCorresponding(Long isCorresponding) 
    {
        this.isCorresponding = isCorresponding;
    }

    public Long getIsCorresponding() 
    {
        return isCorresponding;
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
            .append("paperId", getPaperId())
            .append("userId", getUserId())
            .append("authorOrder", getAuthorOrder())
            .append("isCorresponding", getIsCorresponding())
            .append("contribution", getContribution())
            .toString();
    }
}
