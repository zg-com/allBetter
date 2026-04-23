package com.ruoyi.system.mapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

public interface SysDashboardMapper {
    /** 统计在校生总数 */
    public int getStudentCount();

    /** 统计当前审核通过的在开课程总数 */
    public int getCourseCount();

    /** 统计审核通过的科研到账总金额 (万元) */
    public BigDecimal getResearchFund();

    /** 统计审核通过的高水平论文数 */
    public int getPaperCount();

    /** 统计历年科研经费对比 (合同额 vs 到账额) */
    public List<Map<String, Object>> getResearchFundChart();

    /** 统计科研论文级别分布 */
    public List<Map<String, Object>> getPaperLevelStat();

    /** 统计各学院在校生人数分布 */
    public List<Map<String, Object>> getStudentCollegeStat();
    /** 统计不同状态的课程数量分布 */
    public List<Map<String, Object>> getCourseStatusStat();
    /** 统计课程饱和度排行 */
    public List<Map<String, Object>> getCourseSaturationStat();
    /** 统计学生修读状态分布 */
    public List<Map<String, Object>> getStudentLearnStatusStat();
}
