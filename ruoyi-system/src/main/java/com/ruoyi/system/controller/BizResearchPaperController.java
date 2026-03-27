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
import com.ruoyi.system.domain.BizResearchPaper;
import com.ruoyi.system.service.IBizResearchPaperService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 科研论文全纪录Controller
 * 
 * @author ruoyi
 * @date 2026-03-27
 */
@RestController
@RequestMapping("/system/paper")
public class BizResearchPaperController extends BaseController
{
    @Autowired
    private IBizResearchPaperService bizResearchPaperService;

    /**
     * 查询科研论文全纪录列表
     */
    @PreAuthorize("@ss.hasPermi('system:paper:list')")
    @GetMapping("/list")
    public TableDataInfo list(BizResearchPaper bizResearchPaper)
    {
        startPage();
        List<BizResearchPaper> list = bizResearchPaperService.selectBizResearchPaperList(bizResearchPaper);
        return getDataTable(list);
    }

    /**
     * 导出科研论文全纪录列表
     */
    @PreAuthorize("@ss.hasPermi('system:paper:export')")
    @Log(title = "科研论文全纪录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BizResearchPaper bizResearchPaper)
    {
        List<BizResearchPaper> list = bizResearchPaperService.selectBizResearchPaperList(bizResearchPaper);
        ExcelUtil<BizResearchPaper> util = new ExcelUtil<BizResearchPaper>(BizResearchPaper.class);
        util.exportExcel(response, list, "科研论文全纪录数据");
    }

    /**
     * 获取科研论文全纪录详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:paper:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(bizResearchPaperService.selectBizResearchPaperById(id));
    }

    /**
     * 新增科研论文全纪录
     */
    @PreAuthorize("@ss.hasPermi('system:paper:add')")
    @Log(title = "科研论文全纪录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BizResearchPaper bizResearchPaper)
    {
        return toAjax(bizResearchPaperService.insertBizResearchPaper(bizResearchPaper));
    }

    /**
     * 修改科研论文全纪录
     */
    @PreAuthorize("@ss.hasPermi('system:paper:edit')")
    @Log(title = "科研论文全纪录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BizResearchPaper bizResearchPaper)
    {
        return toAjax(bizResearchPaperService.updateBizResearchPaper(bizResearchPaper));
    }

    /**
     * 删除科研论文全纪录
     */
    @PreAuthorize("@ss.hasPermi('system:paper:remove')")
    @Log(title = "科研论文全纪录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(bizResearchPaperService.deleteBizResearchPaperByIds(ids));
    }
}
