package com.ruoyi.system.controller;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson2.JSONObject;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.BusPowerData;
import com.ruoyi.system.service.IBusPowerDataService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 火电厂核心传感器工况Controller
 * 
 * @author ruoyi
 * @date 2026-06-10
 */
@RestController
@RequestMapping("/system/data")
public class BusPowerDataController extends BaseController
{
    @Autowired
    private IBusPowerDataService busPowerDataService;



    /**
     * 接口一：纯粹获取当前的真实工况数据（高频调用）
     * 前端可以每秒调用一次，模拟火电厂实时的 SCADA 传感器推流
     */
    @GetMapping("/current/{dataId}")
    public AjaxResult getCurrentData(@PathVariable("dataId") Long dataId) {
        // 直接从 Service 查出 MySQL 里的原始行数据
        BusPowerData data = busPowerDataService.selectBusPowerDataByDataId(dataId);
        if (data == null) {
            return AjaxResult.error("已到达数据流末尾或未找到指定工况");
        }
        return AjaxResult.success("获取实时工况成功", data);
    }

    /**
     * 接口二：触发 AI 引擎预测未来趋势（低频调用）
     * 前端可以计数，比如每流过 5 条或 10 条数据，才调用一次本接口去唤醒 Python
     */
    @Log(title = "触发AI全频段趋势推演", businessType = BusinessType.OTHER)
    @PostMapping("/predict/{dataId}")
    public AjaxResult predict(@PathVariable("dataId") Long dataId, @RequestBody(required = false) Map<String, Integer> params) {
        try {
            Integer targetHorizon = 0;
            if (params != null && params.containsKey("target_horizon")) {
                targetHorizon = params.get("target_horizon");
            }

            // 这里的 Service 内部逻辑保持不变，它会把这条 dataId 的数据打包发给 Python
            JSONObject result = busPowerDataService.predictPowerLoad(dataId, targetHorizon);
            return AjaxResult.success("AI趋势推演完成", result);
        } catch (Exception e) {
            return AjaxResult.error(e.getMessage());
        }
    }

    /**
     * 查询火电厂核心传感器工况列表
     */


    @PreAuthorize("@ss.hasPermi('system:data:list')")
    @GetMapping("/list")
    public TableDataInfo list(BusPowerData busPowerData)
    {
        startPage();
        List<BusPowerData> list = busPowerDataService.selectBusPowerDataList(busPowerData);
        return getDataTable(list);
    }

    /**
     * 导出火电厂核心传感器工况列表
     */
    @PreAuthorize("@ss.hasPermi('system:data:export')")
    @Log(title = "火电厂核心传感器工况", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BusPowerData busPowerData)
    {
        List<BusPowerData> list = busPowerDataService.selectBusPowerDataList(busPowerData);
        ExcelUtil<BusPowerData> util = new ExcelUtil<BusPowerData>(BusPowerData.class);
        util.exportExcel(response, list, "火电厂核心传感器工况数据");
    }

    /**
     * 获取火电厂核心传感器工况详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:data:query')")
    @GetMapping(value = "/{dataId}")
    public AjaxResult getInfo(@PathVariable("dataId") Long dataId)
    {
        return success(busPowerDataService.selectBusPowerDataByDataId(dataId));
    }

    /**
     * 新增火电厂核心传感器工况
     */
    @PreAuthorize("@ss.hasPermi('system:data:add')")
    @Log(title = "火电厂核心传感器工况", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BusPowerData busPowerData)
    {
        return toAjax(busPowerDataService.insertBusPowerData(busPowerData));
    }

    /**
     * 修改火电厂核心传感器工况
     */
    @PreAuthorize("@ss.hasPermi('system:data:edit')")
    @Log(title = "火电厂核心传感器工况", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BusPowerData busPowerData)
    {
        return toAjax(busPowerDataService.updateBusPowerData(busPowerData));
    }

    /**
     * 删除火电厂核心传感器工况
     */
    @PreAuthorize("@ss.hasPermi('system:data:remove')")
    @Log(title = "火电厂核心传感器工况", businessType = BusinessType.DELETE)
	@DeleteMapping("/{dataIds}")
    public AjaxResult remove(@PathVariable Long[] dataIds)
    {
        return toAjax(busPowerDataService.deleteBusPowerDataByDataIds(dataIds));
    }


}
