package com.ruoyi.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.mapper.SysDashboardMapper;

@RestController
@RequestMapping("/system/dashboard")
public class SysDashboardController {

    @Autowired
    private SysDashboardMapper dashboardMapper;

    @GetMapping("/panelData")
    public AjaxResult getPanelData() {
        Map<String, Object> data = new HashMap<>();
        // 依次执行四条 SQL，装入 Map
        data.put("studentCount", dashboardMapper.getStudentCount());
        data.put("courseCount", dashboardMapper.getCourseCount());
        data.put("researchFund", dashboardMapper.getResearchFund());
        data.put("paperCount", dashboardMapper.getPaperCount());

        return AjaxResult.success(data);
    }
    @PreAuthorize("@ss.hasPermi('system:dashboard:research')")
    @GetMapping("/researchChart")
    public AjaxResult getResearchChart() {
        List<Map<String, Object>> list = dashboardMapper.getResearchFundChart();
        return AjaxResult.success(list);
    }

    @GetMapping("/paperChart")
    public AjaxResult getPaperChart() {
        return AjaxResult.success(dashboardMapper.getPaperLevelStat());
    }

    @GetMapping("/studentChart")
    public AjaxResult getStudentChart() {
        return AjaxResult.success(dashboardMapper.getStudentCollegeStat());
    }
    @GetMapping("/courseStatusChart")
    public AjaxResult getCourseStatusChart() {
        return AjaxResult.success(dashboardMapper.getCourseStatusStat());
    }
    @PreAuthorize("@ss.hasPermi('system:dashboard:teaching')")
    @GetMapping("/saturationChart")
    public AjaxResult getSaturationChart() {
        return AjaxResult.success(dashboardMapper.getCourseSaturationStat());
    }
    @GetMapping("/learnStatusChart")
    public AjaxResult getLearnStatusChart() {
        return AjaxResult.success(dashboardMapper.getStudentLearnStatusStat());
    }
}