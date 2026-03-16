package com.learningmplat.backend.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import lombok.Data;

/**
 * 论文多作者排名关联表
 * @TableName biz_paper_author
 */
@TableName(value ="biz_paper_author")
@Data
public class BizPaperAuthor {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 关联论文ID
     */
    private Long paperId;

    /**
     * 作者系统ID(可以是老师，也可以是学生)
     */
    private Long userId;

    /**
     * 作者排名：1-第一作者, 2-第二作者, 0-通讯作者
     */
    private Integer authorRank;

    /**
     * 贡献度百分比(如：50.00，用于年底算分)
     */
    private BigDecimal contributionRate;
}