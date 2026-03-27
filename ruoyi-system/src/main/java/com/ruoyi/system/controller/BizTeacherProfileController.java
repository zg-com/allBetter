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
import com.ruoyi.system.domain.BizTeacherProfile;
import com.ruoyi.system.service.IBizTeacherProfileService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 教师人事基础档案Controller
 * 
 * @author ruoyi
 * @date 2026-03-27
 */
@RestController
@RequestMapping("/system/profile")
public class BizTeacherProfileController extends BaseController
{
    @Autowired
    private IBizTeacherProfileService bizTeacherProfileService;

    /**
     * 查询教师人事基础档案列表
     */
    @PreAuthorize("@ss.hasPermi('system:profile:list')")
    @GetMapping("/list")
    public TableDataInfo list(BizTeacherProfile bizTeacherProfile)
    {
        startPage();
        List<BizTeacherProfile> list = bizTeacherProfileService.selectBizTeacherProfileList(bizTeacherProfile);
        return getDataTable(list);
    }

    /**
     * 导出教师人事基础档案列表
     */
    @PreAuthorize("@ss.hasPermi('system:profile:export')")
    @Log(title = "教师人事基础档案", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BizTeacherProfile bizTeacherProfile)
    {
        List<BizTeacherProfile> list = bizTeacherProfileService.selectBizTeacherProfileList(bizTeacherProfile);
        ExcelUtil<BizTeacherProfile> util = new ExcelUtil<BizTeacherProfile>(BizTeacherProfile.class);
        util.exportExcel(response, list, "教师人事基础档案数据");
    }

    /**
     * 获取教师人事基础档案详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:profile:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(bizTeacherProfileService.selectBizTeacherProfileById(id));
    }

    /**
     * 新增教师人事基础档案
     */
    @PreAuthorize("@ss.hasPermi('system:profile:add')")
    @Log(title = "教师人事基础档案", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BizTeacherProfile bizTeacherProfile)
    {
        return toAjax(bizTeacherProfileService.insertBizTeacherProfile(bizTeacherProfile));
    }

    /**
     * 修改教师人事基础档案
     */
    @PreAuthorize("@ss.hasPermi('system:profile:edit')")
    @Log(title = "教师人事基础档案", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BizTeacherProfile bizTeacherProfile)
    {
        return toAjax(bizTeacherProfileService.updateBizTeacherProfile(bizTeacherProfile));
    }

    /**
     * 删除教师人事基础档案
     */
    @PreAuthorize("@ss.hasPermi('system:profile:remove')")
    @Log(title = "教师人事基础档案", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(bizTeacherProfileService.deleteBizTeacherProfileByIds(ids));
    }
}
