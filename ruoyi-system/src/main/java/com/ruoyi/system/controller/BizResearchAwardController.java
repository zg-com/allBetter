package com.ruoyi.system.controller;

import java.util.List;
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
import com.ruoyi.system.domain.BizResearchAward;
import com.ruoyi.system.service.IBizResearchAwardService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 科研奖励管理Controller
 * 
 * @author ruoyi
 * @date 2026-03-27
 */
@RestController
@RequestMapping("/system/research_award")
public class BizResearchAwardController extends BaseController
{
    @Autowired
    private IBizResearchAwardService bizResearchAwardService;

    /**
     * 查询科研奖励管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:research_award:list')")
    @GetMapping("/list")
    public TableDataInfo list(BizResearchAward bizResearchAward)
    {
        startPage();
        List<BizResearchAward> list = bizResearchAwardService.selectBizResearchAwardList(bizResearchAward);
        return getDataTable(list);
    }

    /**
     * 导出科研奖励管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:research_award:export')")
    @Log(title = "科研奖励管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BizResearchAward bizResearchAward)
    {
        List<BizResearchAward> list = bizResearchAwardService.selectBizResearchAwardList(bizResearchAward);
        ExcelUtil<BizResearchAward> util = new ExcelUtil<BizResearchAward>(BizResearchAward.class);
        util.exportExcel(response, list, "科研奖励管理数据");
    }

    /**
     * 获取科研奖励管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:research_award:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(bizResearchAwardService.selectBizResearchAwardById(id));
    }

    /**
     * 新增科研奖励管理
     */
    @PreAuthorize("@ss.hasPermi('system:research_award:add')")
    @Log(title = "科研奖励管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BizResearchAward bizResearchAward)
    {
        return toAjax(bizResearchAwardService.insertBizResearchAward(bizResearchAward));
    }

    /**
     * 修改科研奖励管理
     */
    @PreAuthorize("@ss.hasPermi('system:research_award:edit')")
    @Log(title = "科研奖励管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BizResearchAward bizResearchAward)
    {
        return toAjax(bizResearchAwardService.updateBizResearchAward(bizResearchAward));
    }

    /**
     * 删除科研奖励管理
     */
    @PreAuthorize("@ss.hasPermi('system:research_award:remove')")
    @Log(title = "科研奖励管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(bizResearchAwardService.deleteBizResearchAwardByIds(ids));
    }
}
