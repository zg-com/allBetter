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
import com.ruoyi.system.domain.BizResearchProject;
import com.ruoyi.system.service.IBizResearchProjectService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 科研项目经费与周期管理Controller
 * 
 * @author ruoyi
 * @date 2026-03-27
 */
@RestController
@RequestMapping("/system/research_project")
public class BizResearchProjectController extends BaseController
{
    @Autowired
    private IBizResearchProjectService bizResearchProjectService;

    /**
     * 查询科研项目经费与周期管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:research_project:list')")
    @GetMapping("/list")
    public TableDataInfo list(BizResearchProject bizResearchProject)
    {
        startPage();
        List<BizResearchProject> list = bizResearchProjectService.selectBizResearchProjectList(bizResearchProject);
        return getDataTable(list);
    }

    /**
     * 导出科研项目经费与周期管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:research_project:export')")
    @Log(title = "科研项目经费与周期管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BizResearchProject bizResearchProject)
    {
        List<BizResearchProject> list = bizResearchProjectService.selectBizResearchProjectList(bizResearchProject);
        ExcelUtil<BizResearchProject> util = new ExcelUtil<BizResearchProject>(BizResearchProject.class);
        util.exportExcel(response, list, "科研项目经费与周期管理数据");
    }

    /**
     * 获取科研项目经费与周期管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:research_project:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(bizResearchProjectService.selectBizResearchProjectById(id));
    }

    /**
     * 新增科研项目经费与周期管理
     */
    @PreAuthorize("@ss.hasPermi('system:research_project:add')")
    @Log(title = "科研项目经费与周期管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BizResearchProject bizResearchProject)
    {
        return toAjax(bizResearchProjectService.insertBizResearchProject(bizResearchProject));
    }

    /**
     * 修改科研项目经费与周期管理
     */
    @PreAuthorize("@ss.hasPermi('system:research_project:edit')")
    @Log(title = "科研项目经费与周期管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BizResearchProject bizResearchProject)
    {
        return toAjax(bizResearchProjectService.updateBizResearchProject(bizResearchProject));
    }

    /**
     * 删除科研项目经费与周期管理
     */
    @PreAuthorize("@ss.hasPermi('system:research_project:remove')")
    @Log(title = "科研项目经费与周期管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(bizResearchProjectService.deleteBizResearchProjectByIds(ids));
    }
}
