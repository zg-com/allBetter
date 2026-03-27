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
import com.ruoyi.system.domain.BizTeacherCompany;
import com.ruoyi.system.service.IBizTeacherCompanyService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 教师个人创业情况Controller
 * 
 * @author ruoyi
 * @date 2026-03-27
 */
@RestController
@RequestMapping("/system/company")
public class BizTeacherCompanyController extends BaseController
{
    @Autowired
    private IBizTeacherCompanyService bizTeacherCompanyService;

    /**
     * 查询教师个人创业情况列表
     */
    @PreAuthorize("@ss.hasPermi('system:company:list')")
    @GetMapping("/list")
    public TableDataInfo list(BizTeacherCompany bizTeacherCompany)
    {
        startPage();
        List<BizTeacherCompany> list = bizTeacherCompanyService.selectBizTeacherCompanyList(bizTeacherCompany);
        return getDataTable(list);
    }

    /**
     * 导出教师个人创业情况列表
     */
    @PreAuthorize("@ss.hasPermi('system:company:export')")
    @Log(title = "教师个人创业情况", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BizTeacherCompany bizTeacherCompany)
    {
        List<BizTeacherCompany> list = bizTeacherCompanyService.selectBizTeacherCompanyList(bizTeacherCompany);
        ExcelUtil<BizTeacherCompany> util = new ExcelUtil<BizTeacherCompany>(BizTeacherCompany.class);
        util.exportExcel(response, list, "教师个人创业情况数据");
    }

    /**
     * 获取教师个人创业情况详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:company:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(bizTeacherCompanyService.selectBizTeacherCompanyById(id));
    }

    /**
     * 新增教师个人创业情况
     */
    @PreAuthorize("@ss.hasPermi('system:company:add')")
    @Log(title = "教师个人创业情况", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BizTeacherCompany bizTeacherCompany)
    {
        return toAjax(bizTeacherCompanyService.insertBizTeacherCompany(bizTeacherCompany));
    }

    /**
     * 修改教师个人创业情况
     */
    @PreAuthorize("@ss.hasPermi('system:company:edit')")
    @Log(title = "教师个人创业情况", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BizTeacherCompany bizTeacherCompany)
    {
        return toAjax(bizTeacherCompanyService.updateBizTeacherCompany(bizTeacherCompany));
    }

    /**
     * 删除教师个人创业情况
     */
    @PreAuthorize("@ss.hasPermi('system:company:remove')")
    @Log(title = "教师个人创业情况", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(bizTeacherCompanyService.deleteBizTeacherCompanyByIds(ids));
    }
}
