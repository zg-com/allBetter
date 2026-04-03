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
import com.ruoyi.system.domain.BizStudentProfile;
import com.ruoyi.system.service.IBizStudentProfileService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学生基础学籍档案Controller
 * 
 * @author ruoyi
 * @date 2026-04-03
 */
@RestController
@RequestMapping("/system/student_profile")
public class BizStudentProfileController extends BaseController
{
    @Autowired
    private IBizStudentProfileService bizStudentProfileService;

    /**
     * 查询学生基础学籍档案列表
     */
    @PreAuthorize("@ss.hasPermi('system:student_profile:list')")
    @GetMapping("/list")
    public TableDataInfo list(BizStudentProfile bizStudentProfile)
    {
        startPage();
        List<BizStudentProfile> list = bizStudentProfileService.selectBizStudentProfileList(bizStudentProfile);
        return getDataTable(list);
    }

    /**
     * 导出学生基础学籍档案列表
     */
    @PreAuthorize("@ss.hasPermi('system:student_profile:export')")
    @Log(title = "学生基础学籍档案", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BizStudentProfile bizStudentProfile)
    {
        List<BizStudentProfile> list = bizStudentProfileService.selectBizStudentProfileList(bizStudentProfile);
        ExcelUtil<BizStudentProfile> util = new ExcelUtil<BizStudentProfile>(BizStudentProfile.class);
        util.exportExcel(response, list, "学生基础学籍档案数据");
    }

    /**
     * 获取学生基础学籍档案详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:student_profile:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(bizStudentProfileService.selectBizStudentProfileById(id));
    }

    /**
     * 新增学生基础学籍档案
     */
    @PreAuthorize("@ss.hasPermi('system:student_profile:add')")
    @Log(title = "学生基础学籍档案", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BizStudentProfile bizStudentProfile)
    {
        return toAjax(bizStudentProfileService.insertBizStudentProfile(bizStudentProfile));
    }

    /**
     * 修改学生基础学籍档案
     */
    @PreAuthorize("@ss.hasPermi('system:student_profile:edit')")
    @Log(title = "学生基础学籍档案", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BizStudentProfile bizStudentProfile)
    {
        return toAjax(bizStudentProfileService.updateBizStudentProfile(bizStudentProfile));
    }

    /**
     * 删除学生基础学籍档案
     */
    @PreAuthorize("@ss.hasPermi('system:student_profile:remove')")
    @Log(title = "学生基础学籍档案", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(bizStudentProfileService.deleteBizStudentProfileByIds(ids));
    }
}
