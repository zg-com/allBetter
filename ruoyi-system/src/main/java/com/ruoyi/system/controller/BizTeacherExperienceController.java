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
import com.ruoyi.system.domain.BizTeacherExperience;
import com.ruoyi.system.service.IBizTeacherExperienceService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 教师兼职与访学经历Controller
 * 
 * @author ruoyi
 * @date 2026-04-10
 */
@RestController
@RequestMapping("/system/experience")
public class BizTeacherExperienceController extends BaseController
{
    @Autowired
    private IBizTeacherExperienceService bizTeacherExperienceService;

    /**
     * 查询教师兼职与访学经历列表
     */
    @PreAuthorize("@ss.hasPermi('system:experience:list')")
    @GetMapping("/list")
    public TableDataInfo list(BizTeacherExperience bizTeacherExperience)
    {
        startPage();
        List<BizTeacherExperience> list = bizTeacherExperienceService.selectBizTeacherExperienceList(bizTeacherExperience);
        return getDataTable(list);
    }

    /**
     * 导出教师兼职与访学经历列表
     */
    @PreAuthorize("@ss.hasPermi('system:experience:export')")
    @Log(title = "教师兼职与访学经历", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BizTeacherExperience bizTeacherExperience)
    {
        List<BizTeacherExperience> list = bizTeacherExperienceService.selectBizTeacherExperienceList(bizTeacherExperience);
        ExcelUtil<BizTeacherExperience> util = new ExcelUtil<BizTeacherExperience>(BizTeacherExperience.class);
        util.exportExcel(response, list, "教师兼职与访学经历数据");
    }

    /**
     * 获取教师兼职与访学经历详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:experience:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(bizTeacherExperienceService.selectBizTeacherExperienceById(id));
    }

    /**
     * 新增教师兼职与访学经历
     */
    @PreAuthorize("@ss.hasPermi('system:experience:add')")
    @Log(title = "教师兼职与访学经历", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BizTeacherExperience bizTeacherExperience)
    {
        return toAjax(bizTeacherExperienceService.insertBizTeacherExperience(bizTeacherExperience));
    }

    /**
     * 修改教师兼职与访学经历
     */
    @PreAuthorize("@ss.hasPermi('system:experience:edit')")
    @Log(title = "教师兼职与访学经历", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BizTeacherExperience bizTeacherExperience)
    {
        return toAjax(bizTeacherExperienceService.updateBizTeacherExperience(bizTeacherExperience));
    }

    /**
     * 删除教师兼职与访学经历
     */
    @PreAuthorize("@ss.hasPermi('system:experience:remove')")
    @Log(title = "教师兼职与访学经历", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(bizTeacherExperienceService.deleteBizTeacherExperienceByIds(ids));
    }
}
