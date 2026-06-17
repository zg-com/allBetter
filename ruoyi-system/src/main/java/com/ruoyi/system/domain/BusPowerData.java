package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 火电厂核心传感器工况对象 bus_power_data
 * 
 * @author ruoyi
 * @date 2026-06-10
 */
public class BusPowerData extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 数据主键 */
    private Long dataId;

    /** 记录时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "记录时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date recordTime;

    /** 目标特征: 实际负荷(MW) */
    @Excel(name = "目标特征: 实际负荷(MW)")
    private BigDecimal actualLoad;

    /** A磨总一次风量149 */
    @Excel(name = "A磨总一次风量149")
    private BigDecimal millAPriWind149;

    /** B磨总一次风量164 */
    @Excel(name = "B磨总一次风量164")
    private BigDecimal millBPriWind164;

    /** C磨总一次风量175 */
    @Excel(name = "C磨总一次风量175")
    private BigDecimal millCPriWind175;

    /** 磨煤机A一次风总风量183 */
    @Excel(name = "磨煤机A一次风总风量183")
    private BigDecimal millAPriTotal183;

    /** 磨煤机B一次风总风量184 */
    @Excel(name = "磨煤机B一次风总风量184")
    private BigDecimal millBPriTotal184;

    /** 一次粉管A11风速30 */
    @Excel(name = "一次粉管A11风速30")
    private BigDecimal pipeA11WindSpd30;

    /** 一次粉管A12煤粉浓度73 */
    @Excel(name = "一次粉管A12煤粉浓度73")
    private BigDecimal pipeA12CoalCon73;

    /** 一次粉管A12风速31 */
    @Excel(name = "一次粉管A12风速31")
    private BigDecimal pipeA12WindSpd31;

    /** 一次粉管A13风速32 */
    @Excel(name = "一次粉管A13风速32")
    private BigDecimal pipeA13WindSpd32;

    /** 一次粉管A14风速33 */
    @Excel(name = "一次粉管A14风速33")
    private BigDecimal pipeA14WindSpd33;

    /** 一次粉管A21风速34 */
    @Excel(name = "一次粉管A21风速34")
    private BigDecimal pipeA21WindSpd34;

    /** 一次粉管A22风速35 */
    @Excel(name = "一次粉管A22风速35")
    private BigDecimal pipeA22WindSpd35;

    /** 一次粉管A23风速36 */
    @Excel(name = "一次粉管A23风速36")
    private BigDecimal pipeA23WindSpd36;

    /** 一次粉管A24风速37 */
    @Excel(name = "一次粉管A24风速37")
    private BigDecimal pipeA24WindSpd37;

    /** 一次粉管B11风速38 */
    @Excel(name = "一次粉管B11风速38")
    private BigDecimal pipeB11WindSpd38;

    /** 一次粉管B14风速41 */
    @Excel(name = "一次粉管B14风速41")
    private BigDecimal pipeB14WindSpd41;

    /** 一次粉管B21煤粉浓度95 */
    @Excel(name = "一次粉管B21煤粉浓度95")
    private BigDecimal pipeB21CoalCon95;

    /** 一次粉管B22煤粉浓度2_96 */
    @Excel(name = "一次粉管B22煤粉浓度2_96")
    private BigDecimal pipeB22CoalCon296;

    /** 一次粉管B22煤粉浓度97 */
    @Excel(name = "一次粉管B22煤粉浓度97")
    private BigDecimal pipeB22CoalCon97;

    /** 一次粉管B23煤粉浓度99 */
    @Excel(name = "一次粉管B23煤粉浓度99")
    private BigDecimal pipeB23CoalCon99;

    /** 一次粉管B24煤粉浓度101 */
    @Excel(name = "一次粉管B24煤粉浓度101")
    private BigDecimal pipeB24CoalCon101;

    /** 一次粉管C11煤粉浓度103 */
    @Excel(name = "一次粉管C11煤粉浓度103")
    private BigDecimal pipeC11CoalCon103;

    /** 一次粉管C12煤粉浓度105 */
    @Excel(name = "一次粉管C12煤粉浓度105")
    private BigDecimal pipeC12CoalCon105;

    /** 一次粉管C13煤粉浓度107 */
    @Excel(name = "一次粉管C13煤粉浓度107")
    private BigDecimal pipeC13CoalCon107;

    /** 一次粉管C14煤粉浓度109 */
    @Excel(name = "一次粉管C14煤粉浓度109")
    private BigDecimal pipeC14CoalCon109;

    /** 屏式再热器横向第23片屏排＃1管管壁温度338 */
    @Excel(name = "屏式再热器横向第23片屏排＃1管管壁温度338")
    private BigDecimal reheaterScrTubeTemp338;

    /** 末级再热器入口烟气温度A 358 */
    @Excel(name = "末级再热器入口烟气温度A 358")
    private BigDecimal reheaterInletGasTempA358;

    /** 末级再热器入口烟气温度B 359 */
    @Excel(name = "末级再热器入口烟气温度B 359")
    private BigDecimal reheaterInletGasTempB359;

    /** 末级再热器横向第2排的＃1管管壁温度344 */
    @Excel(name = "末级再热器横向第2排的＃1管管壁温度344")
    private BigDecimal reheaterEndTubeTempRow2344;

    /** 末级再热器横向第67排的＃1管管壁温度357 */
    @Excel(name = "末级再热器横向第67排的＃1管管壁温度357")
    private BigDecimal reheaterEndTubeTempRow67357;

    /** 汽包压力均值234 */
    @Excel(name = "汽包压力均值234")
    private BigDecimal drumPressureAvg234;

    /** 汽包水位1239 */
    @Excel(name = "汽包水位1239")
    private BigDecimal drumWaterLevel1239;

    /** 总一次风量199 */
    @Excel(name = "总一次风量199")
    private BigDecimal totalPriWind199;

    /** 总二次风量200 */
    @Excel(name = "总二次风量200")
    private BigDecimal totalSecWind200;

    /** 总风量198 */
    @Excel(name = "总风量198")
    private BigDecimal totalWind198;

    /** 摆角平均位置280 */
    @Excel(name = "摆角平均位置280")
    private BigDecimal swingAngleAvg280;

    /** 摆角调节上限284 */
    @Excel(name = "摆角调节上限284")
    private BigDecimal swingAngleUpper284;

    /** 摆角调节下限283 */
    @Excel(name = "摆角调节下限283")
    private BigDecimal swingAngleLower283;

    /** 给煤机B1给煤量信号120 */
    @Excel(name = "给煤机B1给煤量信号120")
    private BigDecimal coalFeederB1120;

    /** 给煤机B1给煤量信号121 */
    @Excel(name = "给煤机B1给煤量信号121")
    private BigDecimal coalFeederB1121;

    /** 给煤机B2给煤量信号126 */
    @Excel(name = "给煤机B2给煤量信号126")
    private BigDecimal coalFeederB2126;

    /** 给煤机B2给煤量信号127 */
    @Excel(name = "给煤机B2给煤量信号127")
    private BigDecimal coalFeederB2127;

    /** 给煤机C1给煤量信号122 */
    @Excel(name = "给煤机C1给煤量信号122")
    private BigDecimal coalFeederC1122;

    /** 给煤机C1给煤量信号123 */
    @Excel(name = "给煤机C1给煤量信号123")
    private BigDecimal coalFeederC1123;

    /** 送风机A出口风量1 177 */
    @Excel(name = "送风机A出口风量1 177")
    private BigDecimal blowerAOut1177;

    /** 送风机A出口风量2 179 */
    @Excel(name = "送风机A出口风量2 179")
    private BigDecimal blowerAOut2179;

    /** 送风机A出口风量3 181 */
    @Excel(name = "送风机A出口风量3 181")
    private BigDecimal blowerAOut3181;

    /** 送风机B出口风量1 178 */
    @Excel(name = "送风机B出口风量1 178")
    private BigDecimal blowerBOut1178;

    /** 送风机B出口风量2 180 */
    @Excel(name = "送风机B出口风量2 180")
    private BigDecimal blowerBOut2180;

    /** 送风机B出口风量3 182 */
    @Excel(name = "送风机B出口风量3 182")
    private BigDecimal blowerBOut3182;

    /** 非核心传感器全量快照(兜底扩展) */
    @Excel(name = "非核心传感器全量快照(兜底扩展)")
    private String otherSensors;

    public void setDataId(Long dataId) 
    {
        this.dataId = dataId;
    }

    public Long getDataId() 
    {
        return dataId;
    }

    public void setRecordTime(Date recordTime) 
    {
        this.recordTime = recordTime;
    }

    public Date getRecordTime() 
    {
        return recordTime;
    }

    public void setActualLoad(BigDecimal actualLoad) 
    {
        this.actualLoad = actualLoad;
    }

    public BigDecimal getActualLoad() 
    {
        return actualLoad;
    }

    public void setMillAPriWind149(BigDecimal millAPriWind149) 
    {
        this.millAPriWind149 = millAPriWind149;
    }

    public BigDecimal getMillAPriWind149() 
    {
        return millAPriWind149;
    }

    public void setMillBPriWind164(BigDecimal millBPriWind164) 
    {
        this.millBPriWind164 = millBPriWind164;
    }

    public BigDecimal getMillBPriWind164() 
    {
        return millBPriWind164;
    }

    public void setMillCPriWind175(BigDecimal millCPriWind175) 
    {
        this.millCPriWind175 = millCPriWind175;
    }

    public BigDecimal getMillCPriWind175() 
    {
        return millCPriWind175;
    }

    public void setMillAPriTotal183(BigDecimal millAPriTotal183) 
    {
        this.millAPriTotal183 = millAPriTotal183;
    }

    public BigDecimal getMillAPriTotal183() 
    {
        return millAPriTotal183;
    }

    public void setMillBPriTotal184(BigDecimal millBPriTotal184) 
    {
        this.millBPriTotal184 = millBPriTotal184;
    }

    public BigDecimal getMillBPriTotal184() 
    {
        return millBPriTotal184;
    }

    public void setPipeA11WindSpd30(BigDecimal pipeA11WindSpd30) 
    {
        this.pipeA11WindSpd30 = pipeA11WindSpd30;
    }

    public BigDecimal getPipeA11WindSpd30() 
    {
        return pipeA11WindSpd30;
    }

    public void setPipeA12CoalCon73(BigDecimal pipeA12CoalCon73) 
    {
        this.pipeA12CoalCon73 = pipeA12CoalCon73;
    }

    public BigDecimal getPipeA12CoalCon73() 
    {
        return pipeA12CoalCon73;
    }

    public void setPipeA12WindSpd31(BigDecimal pipeA12WindSpd31) 
    {
        this.pipeA12WindSpd31 = pipeA12WindSpd31;
    }

    public BigDecimal getPipeA12WindSpd31() 
    {
        return pipeA12WindSpd31;
    }

    public void setPipeA13WindSpd32(BigDecimal pipeA13WindSpd32) 
    {
        this.pipeA13WindSpd32 = pipeA13WindSpd32;
    }

    public BigDecimal getPipeA13WindSpd32() 
    {
        return pipeA13WindSpd32;
    }

    public void setPipeA14WindSpd33(BigDecimal pipeA14WindSpd33) 
    {
        this.pipeA14WindSpd33 = pipeA14WindSpd33;
    }

    public BigDecimal getPipeA14WindSpd33() 
    {
        return pipeA14WindSpd33;
    }

    public void setPipeA21WindSpd34(BigDecimal pipeA21WindSpd34) 
    {
        this.pipeA21WindSpd34 = pipeA21WindSpd34;
    }

    public BigDecimal getPipeA21WindSpd34() 
    {
        return pipeA21WindSpd34;
    }

    public void setPipeA22WindSpd35(BigDecimal pipeA22WindSpd35) 
    {
        this.pipeA22WindSpd35 = pipeA22WindSpd35;
    }

    public BigDecimal getPipeA22WindSpd35() 
    {
        return pipeA22WindSpd35;
    }

    public void setPipeA23WindSpd36(BigDecimal pipeA23WindSpd36) 
    {
        this.pipeA23WindSpd36 = pipeA23WindSpd36;
    }

    public BigDecimal getPipeA23WindSpd36() 
    {
        return pipeA23WindSpd36;
    }

    public void setPipeA24WindSpd37(BigDecimal pipeA24WindSpd37) 
    {
        this.pipeA24WindSpd37 = pipeA24WindSpd37;
    }

    public BigDecimal getPipeA24WindSpd37() 
    {
        return pipeA24WindSpd37;
    }

    public void setPipeB11WindSpd38(BigDecimal pipeB11WindSpd38) 
    {
        this.pipeB11WindSpd38 = pipeB11WindSpd38;
    }

    public BigDecimal getPipeB11WindSpd38() 
    {
        return pipeB11WindSpd38;
    }

    public void setPipeB14WindSpd41(BigDecimal pipeB14WindSpd41) 
    {
        this.pipeB14WindSpd41 = pipeB14WindSpd41;
    }

    public BigDecimal getPipeB14WindSpd41() 
    {
        return pipeB14WindSpd41;
    }

    public void setPipeB21CoalCon95(BigDecimal pipeB21CoalCon95) 
    {
        this.pipeB21CoalCon95 = pipeB21CoalCon95;
    }

    public BigDecimal getPipeB21CoalCon95() 
    {
        return pipeB21CoalCon95;
    }

    public void setPipeB22CoalCon296(BigDecimal pipeB22CoalCon296) 
    {
        this.pipeB22CoalCon296 = pipeB22CoalCon296;
    }

    public BigDecimal getPipeB22CoalCon296() 
    {
        return pipeB22CoalCon296;
    }

    public void setPipeB22CoalCon97(BigDecimal pipeB22CoalCon97) 
    {
        this.pipeB22CoalCon97 = pipeB22CoalCon97;
    }

    public BigDecimal getPipeB22CoalCon97() 
    {
        return pipeB22CoalCon97;
    }

    public void setPipeB23CoalCon99(BigDecimal pipeB23CoalCon99) 
    {
        this.pipeB23CoalCon99 = pipeB23CoalCon99;
    }

    public BigDecimal getPipeB23CoalCon99() 
    {
        return pipeB23CoalCon99;
    }

    public void setPipeB24CoalCon101(BigDecimal pipeB24CoalCon101) 
    {
        this.pipeB24CoalCon101 = pipeB24CoalCon101;
    }

    public BigDecimal getPipeB24CoalCon101() 
    {
        return pipeB24CoalCon101;
    }

    public void setPipeC11CoalCon103(BigDecimal pipeC11CoalCon103) 
    {
        this.pipeC11CoalCon103 = pipeC11CoalCon103;
    }

    public BigDecimal getPipeC11CoalCon103() 
    {
        return pipeC11CoalCon103;
    }

    public void setPipeC12CoalCon105(BigDecimal pipeC12CoalCon105) 
    {
        this.pipeC12CoalCon105 = pipeC12CoalCon105;
    }

    public BigDecimal getPipeC12CoalCon105() 
    {
        return pipeC12CoalCon105;
    }

    public void setPipeC13CoalCon107(BigDecimal pipeC13CoalCon107) 
    {
        this.pipeC13CoalCon107 = pipeC13CoalCon107;
    }

    public BigDecimal getPipeC13CoalCon107() 
    {
        return pipeC13CoalCon107;
    }

    public void setPipeC14CoalCon109(BigDecimal pipeC14CoalCon109) 
    {
        this.pipeC14CoalCon109 = pipeC14CoalCon109;
    }

    public BigDecimal getPipeC14CoalCon109() 
    {
        return pipeC14CoalCon109;
    }

    public void setReheaterScrTubeTemp338(BigDecimal reheaterScrTubeTemp338) 
    {
        this.reheaterScrTubeTemp338 = reheaterScrTubeTemp338;
    }

    public BigDecimal getReheaterScrTubeTemp338() 
    {
        return reheaterScrTubeTemp338;
    }

    public void setReheaterInletGasTempA358(BigDecimal reheaterInletGasTempA358) 
    {
        this.reheaterInletGasTempA358 = reheaterInletGasTempA358;
    }

    public BigDecimal getReheaterInletGasTempA358() 
    {
        return reheaterInletGasTempA358;
    }

    public void setReheaterInletGasTempB359(BigDecimal reheaterInletGasTempB359) 
    {
        this.reheaterInletGasTempB359 = reheaterInletGasTempB359;
    }

    public BigDecimal getReheaterInletGasTempB359() 
    {
        return reheaterInletGasTempB359;
    }

    public void setReheaterEndTubeTempRow2344(BigDecimal reheaterEndTubeTempRow2344) 
    {
        this.reheaterEndTubeTempRow2344 = reheaterEndTubeTempRow2344;
    }

    public BigDecimal getReheaterEndTubeTempRow2344() 
    {
        return reheaterEndTubeTempRow2344;
    }

    public void setReheaterEndTubeTempRow67357(BigDecimal reheaterEndTubeTempRow67357) 
    {
        this.reheaterEndTubeTempRow67357 = reheaterEndTubeTempRow67357;
    }

    public BigDecimal getReheaterEndTubeTempRow67357() 
    {
        return reheaterEndTubeTempRow67357;
    }

    public void setDrumPressureAvg234(BigDecimal drumPressureAvg234) 
    {
        this.drumPressureAvg234 = drumPressureAvg234;
    }

    public BigDecimal getDrumPressureAvg234() 
    {
        return drumPressureAvg234;
    }

    public void setDrumWaterLevel1239(BigDecimal drumWaterLevel1239) 
    {
        this.drumWaterLevel1239 = drumWaterLevel1239;
    }

    public BigDecimal getDrumWaterLevel1239() 
    {
        return drumWaterLevel1239;
    }

    public void setTotalPriWind199(BigDecimal totalPriWind199) 
    {
        this.totalPriWind199 = totalPriWind199;
    }

    public BigDecimal getTotalPriWind199() 
    {
        return totalPriWind199;
    }

    public void setTotalSecWind200(BigDecimal totalSecWind200) 
    {
        this.totalSecWind200 = totalSecWind200;
    }

    public BigDecimal getTotalSecWind200() 
    {
        return totalSecWind200;
    }

    public void setTotalWind198(BigDecimal totalWind198) 
    {
        this.totalWind198 = totalWind198;
    }

    public BigDecimal getTotalWind198() 
    {
        return totalWind198;
    }

    public void setSwingAngleAvg280(BigDecimal swingAngleAvg280) 
    {
        this.swingAngleAvg280 = swingAngleAvg280;
    }

    public BigDecimal getSwingAngleAvg280() 
    {
        return swingAngleAvg280;
    }

    public void setSwingAngleUpper284(BigDecimal swingAngleUpper284) 
    {
        this.swingAngleUpper284 = swingAngleUpper284;
    }

    public BigDecimal getSwingAngleUpper284() 
    {
        return swingAngleUpper284;
    }

    public void setSwingAngleLower283(BigDecimal swingAngleLower283) 
    {
        this.swingAngleLower283 = swingAngleLower283;
    }

    public BigDecimal getSwingAngleLower283() 
    {
        return swingAngleLower283;
    }

    public void setCoalFeederB1120(BigDecimal coalFeederB1120) 
    {
        this.coalFeederB1120 = coalFeederB1120;
    }

    public BigDecimal getCoalFeederB1120() 
    {
        return coalFeederB1120;
    }

    public void setCoalFeederB1121(BigDecimal coalFeederB1121) 
    {
        this.coalFeederB1121 = coalFeederB1121;
    }

    public BigDecimal getCoalFeederB1121() 
    {
        return coalFeederB1121;
    }

    public void setCoalFeederB2126(BigDecimal coalFeederB2126) 
    {
        this.coalFeederB2126 = coalFeederB2126;
    }

    public BigDecimal getCoalFeederB2126() 
    {
        return coalFeederB2126;
    }

    public void setCoalFeederB2127(BigDecimal coalFeederB2127) 
    {
        this.coalFeederB2127 = coalFeederB2127;
    }

    public BigDecimal getCoalFeederB2127() 
    {
        return coalFeederB2127;
    }

    public void setCoalFeederC1122(BigDecimal coalFeederC1122) 
    {
        this.coalFeederC1122 = coalFeederC1122;
    }

    public BigDecimal getCoalFeederC1122() 
    {
        return coalFeederC1122;
    }

    public void setCoalFeederC1123(BigDecimal coalFeederC1123) 
    {
        this.coalFeederC1123 = coalFeederC1123;
    }

    public BigDecimal getCoalFeederC1123() 
    {
        return coalFeederC1123;
    }

    public void setBlowerAOut1177(BigDecimal blowerAOut1177) 
    {
        this.blowerAOut1177 = blowerAOut1177;
    }

    public BigDecimal getBlowerAOut1177() 
    {
        return blowerAOut1177;
    }

    public void setBlowerAOut2179(BigDecimal blowerAOut2179) 
    {
        this.blowerAOut2179 = blowerAOut2179;
    }

    public BigDecimal getBlowerAOut2179() 
    {
        return blowerAOut2179;
    }

    public void setBlowerAOut3181(BigDecimal blowerAOut3181) 
    {
        this.blowerAOut3181 = blowerAOut3181;
    }

    public BigDecimal getBlowerAOut3181() 
    {
        return blowerAOut3181;
    }

    public void setBlowerBOut1178(BigDecimal blowerBOut1178) 
    {
        this.blowerBOut1178 = blowerBOut1178;
    }

    public BigDecimal getBlowerBOut1178() 
    {
        return blowerBOut1178;
    }

    public void setBlowerBOut2180(BigDecimal blowerBOut2180) 
    {
        this.blowerBOut2180 = blowerBOut2180;
    }

    public BigDecimal getBlowerBOut2180() 
    {
        return blowerBOut2180;
    }

    public void setBlowerBOut3182(BigDecimal blowerBOut3182) 
    {
        this.blowerBOut3182 = blowerBOut3182;
    }

    public BigDecimal getBlowerBOut3182() 
    {
        return blowerBOut3182;
    }

    public void setOtherSensors(String otherSensors) 
    {
        this.otherSensors = otherSensors;
    }

    public String getOtherSensors() 
    {
        return otherSensors;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("dataId", getDataId())
            .append("recordTime", getRecordTime())
            .append("actualLoad", getActualLoad())
            .append("millAPriWind149", getMillAPriWind149())
            .append("millBPriWind164", getMillBPriWind164())
            .append("millCPriWind175", getMillCPriWind175())
            .append("millAPriTotal183", getMillAPriTotal183())
            .append("millBPriTotal184", getMillBPriTotal184())
            .append("pipeA11WindSpd30", getPipeA11WindSpd30())
            .append("pipeA12CoalCon73", getPipeA12CoalCon73())
            .append("pipeA12WindSpd31", getPipeA12WindSpd31())
            .append("pipeA13WindSpd32", getPipeA13WindSpd32())
            .append("pipeA14WindSpd33", getPipeA14WindSpd33())
            .append("pipeA21WindSpd34", getPipeA21WindSpd34())
            .append("pipeA22WindSpd35", getPipeA22WindSpd35())
            .append("pipeA23WindSpd36", getPipeA23WindSpd36())
            .append("pipeA24WindSpd37", getPipeA24WindSpd37())
            .append("pipeB11WindSpd38", getPipeB11WindSpd38())
            .append("pipeB14WindSpd41", getPipeB14WindSpd41())
            .append("pipeB21CoalCon95", getPipeB21CoalCon95())
            .append("pipeB22CoalCon296", getPipeB22CoalCon296())
            .append("pipeB22CoalCon97", getPipeB22CoalCon97())
            .append("pipeB23CoalCon99", getPipeB23CoalCon99())
            .append("pipeB24CoalCon101", getPipeB24CoalCon101())
            .append("pipeC11CoalCon103", getPipeC11CoalCon103())
            .append("pipeC12CoalCon105", getPipeC12CoalCon105())
            .append("pipeC13CoalCon107", getPipeC13CoalCon107())
            .append("pipeC14CoalCon109", getPipeC14CoalCon109())
            .append("reheaterScrTubeTemp338", getReheaterScrTubeTemp338())
            .append("reheaterInletGasTempA358", getReheaterInletGasTempA358())
            .append("reheaterInletGasTempB359", getReheaterInletGasTempB359())
            .append("reheaterEndTubeTempRow2344", getReheaterEndTubeTempRow2344())
            .append("reheaterEndTubeTempRow67357", getReheaterEndTubeTempRow67357())
            .append("drumPressureAvg234", getDrumPressureAvg234())
            .append("drumWaterLevel1239", getDrumWaterLevel1239())
            .append("totalPriWind199", getTotalPriWind199())
            .append("totalSecWind200", getTotalSecWind200())
            .append("totalWind198", getTotalWind198())
            .append("swingAngleAvg280", getSwingAngleAvg280())
            .append("swingAngleUpper284", getSwingAngleUpper284())
            .append("swingAngleLower283", getSwingAngleLower283())
            .append("coalFeederB1120", getCoalFeederB1120())
            .append("coalFeederB1121", getCoalFeederB1121())
            .append("coalFeederB2126", getCoalFeederB2126())
            .append("coalFeederB2127", getCoalFeederB2127())
            .append("coalFeederC1122", getCoalFeederC1122())
            .append("coalFeederC1123", getCoalFeederC1123())
            .append("blowerAOut1177", getBlowerAOut1177())
            .append("blowerAOut2179", getBlowerAOut2179())
            .append("blowerAOut3181", getBlowerAOut3181())
            .append("blowerBOut1178", getBlowerBOut1178())
            .append("blowerBOut2180", getBlowerBOut2180())
            .append("blowerBOut3182", getBlowerBOut3182())
            .append("otherSensors", getOtherSensors())
            .append("createTime", getCreateTime())
            .toString();
    }
}
