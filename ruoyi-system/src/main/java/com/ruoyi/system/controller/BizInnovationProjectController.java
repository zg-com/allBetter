package com.ruoyi.system.controller;

import java.util.List;

import com.ruoyi.common.utils.SecurityUtils;
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
import com.ruoyi.system.domain.BizInnovationProject;
import com.ruoyi.system.service.IBizInnovationProjectService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 大创项目管理Controller
 * 
 * @author ruoyi
 * @date 2026-04-17
 */
@RestController
@RequestMapping("/system/innovation_project")
public class BizInnovationProjectController extends BaseController
{
    @Autowired
    private IBizInnovationProjectService bizInnovationProjectService;

    //自定义接口

    /*
     * 申请大创项目管理
     */
    @Log(title = "大创项目管理", businessType = BusinessType.INSERT)
    @PostMapping("/apply")
    public AjaxResult apply(@RequestBody BizInnovationProject bizInnovationProject)
    {
        if(bizInnovationProject.getLeaderNo()==null){
            bizInnovationProject.setLeaderNo(SecurityUtils.getUsername());
        }
        if(bizInnovationProject.getUserId()==null){
            bizInnovationProject.setUserId(SecurityUtils.getUserId());
        }
        bizInnovationProject.setStatus1(0L);
        return toAjax(bizInnovationProjectService.insertBizInnovationProject(bizInnovationProject));
    }

    /*
     * 同意大创项目管理
     */
    @Log(title = "同意大创项目管理", businessType = BusinessType.UPDATE)
    @PutMapping("/approve")
    public AjaxResult approve(@RequestBody BizInnovationProject bizInnovationProject)
    {
        bizInnovationProject.setStatus1(1L);
        bizInnovationProject.setCause("");
        return toAjax(bizInnovationProjectService.updateBizInnovationProject(bizInnovationProject));
    }

    /*
     * 拒绝大创项目管理
     */
    @Log(title = "拒绝大创项目管理", businessType = BusinessType.UPDATE)
    @PutMapping("/reject")
    public AjaxResult reject(@RequestBody BizInnovationProject bizInnovationProject)
    {
        bizInnovationProject.setStatus1(2L);
        bizInnovationProject.setCause(bizInnovationProject.getCause());
        return toAjax(bizInnovationProjectService.updateBizInnovationProject(bizInnovationProject));
    }

    /**
     * 查询大创项目管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:innovation_project:list')")
    @GetMapping("/list")
    public TableDataInfo list(BizInnovationProject bizInnovationProject)
    {
        startPage();
        List<BizInnovationProject> list = bizInnovationProjectService.selectBizInnovationProjectList(bizInnovationProject);
        return getDataTable(list);
    }

    /**
     * 导出大创项目管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:innovation_project:export')")
    @Log(title = "大创项目管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BizInnovationProject bizInnovationProject)
    {
        List<BizInnovationProject> list = bizInnovationProjectService.selectBizInnovationProjectList(bizInnovationProject);
        ExcelUtil<BizInnovationProject> util = new ExcelUtil<BizInnovationProject>(BizInnovationProject.class);
        util.exportExcel(response, list, "大创项目管理数据");
    }

    /**
     * 获取大创项目管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:innovation_project:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(bizInnovationProjectService.selectBizInnovationProjectById(id));
    }

    /**
     * 新增大创项目管理
     */
    @PreAuthorize("@ss.hasPermi('system:innovation_project:add')")
    @Log(title = "大创项目管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BizInnovationProject bizInnovationProject)
    {
        return toAjax(bizInnovationProjectService.insertBizInnovationProject(bizInnovationProject));
    }

    /**
     * 修改大创项目管理
     */
    @PreAuthorize("@ss.hasPermi('system:innovation_project:edit')")
    @Log(title = "大创项目管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BizInnovationProject bizInnovationProject)
    {
        return toAjax(bizInnovationProjectService.updateBizInnovationProject(bizInnovationProject));
    }

    /**
     * 删除大创项目管理
     */
    @PreAuthorize("@ss.hasPermi('system:innovation_project:remove')")
    @Log(title = "大创项目管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(bizInnovationProjectService.deleteBizInnovationProjectByIds(ids));
    }
}
