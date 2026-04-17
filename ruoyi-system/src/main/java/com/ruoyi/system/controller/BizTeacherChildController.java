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
import com.ruoyi.system.domain.BizTeacherChild;
import com.ruoyi.system.service.IBizTeacherChildService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 教师子女与妇幼档案Controller
 * 
 * @author ruoyi
 * @date 2026-04-17
 */
@RestController
@RequestMapping("/system/child")
public class BizTeacherChildController extends BaseController
{
    @Autowired
    private IBizTeacherChildService bizTeacherChildService;

    //自定义接口部分

     /*
     * 教师提交子女信息申请
      */
    @Log(title = "教师子女信息申请", businessType = BusinessType.INSERT)
    @PostMapping("/apply")
    public AjaxResult apply(@RequestBody BizTeacherChild bizTeacherChild){
        bizTeacherChild.setUserId(SecurityUtils.getUserId());
        bizTeacherChild.setStatus(0L);
        return toAjax(bizTeacherChildService.insertBizTeacherChild(bizTeacherChild));
    }

    /*
      * 同意子女信息申请
     */
    @Log(title = "教师子女信息申请同意", businessType = BusinessType.UPDATE)
    @PutMapping("/approve")
    public AjaxResult approve(@RequestBody BizTeacherChild bizTeacherChild){
        bizTeacherChild.setStatus(1L);
        bizTeacherChild.setCause("");
        return toAjax(bizTeacherChildService.updateBizTeacherChild(bizTeacherChild));
    }

    /*
      * 拒绝子女信息申请
     */
    @Log(title = "教师子女信息申请拒绝", businessType = BusinessType.UPDATE)
    @PutMapping("/reject")
    public AjaxResult reject(@RequestBody BizTeacherChild bizTeacherChild){
        bizTeacherChild.setStatus(2L);
        bizTeacherChild.setCause(bizTeacherChild.getCause());
        return toAjax(bizTeacherChildService.updateBizTeacherChild(bizTeacherChild));
    }

    /**
     * 查询教师子女与妇幼档案列表
     */
    @PreAuthorize("@ss.hasPermi('system:child:list')")
    @GetMapping("/list")
    public TableDataInfo list(BizTeacherChild bizTeacherChild)
    {
        startPage();
        List<BizTeacherChild> list = bizTeacherChildService.selectBizTeacherChildList(bizTeacherChild);
        return getDataTable(list);
    }

    /**
     * 导出教师子女与妇幼档案列表
     */
    @PreAuthorize("@ss.hasPermi('system:child:export')")
    @Log(title = "教师子女与妇幼档案", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BizTeacherChild bizTeacherChild)
    {
        List<BizTeacherChild> list = bizTeacherChildService.selectBizTeacherChildList(bizTeacherChild);
        ExcelUtil<BizTeacherChild> util = new ExcelUtil<BizTeacherChild>(BizTeacherChild.class);
        util.exportExcel(response, list, "教师子女与妇幼档案数据");
    }

    /**
     * 获取教师子女与妇幼档案详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:child:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(bizTeacherChildService.selectBizTeacherChildById(id));
    }

    /**
     * 新增教师子女与妇幼档案
     */
    @PreAuthorize("@ss.hasPermi('system:child:add')")
    @Log(title = "教师子女与妇幼档案", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BizTeacherChild bizTeacherChild)
    {
        bizTeacherChild.setUserId(SecurityUtils.getUserId());
        return toAjax(bizTeacherChildService.insertBizTeacherChild(bizTeacherChild));
    }

    /**
     * 修改教师子女与妇幼档案
     */
    @PreAuthorize("@ss.hasPermi('system:child:edit')")
    @Log(title = "教师子女与妇幼档案", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BizTeacherChild bizTeacherChild)
    {
        return toAjax(bizTeacherChildService.updateBizTeacherChild(bizTeacherChild));
    }

    /**
     * 删除教师子女与妇幼档案
     */
    @PreAuthorize("@ss.hasPermi('system:child:remove')")
    @Log(title = "教师子女与妇幼档案", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(bizTeacherChildService.deleteBizTeacherChildByIds(ids));
    }
}
