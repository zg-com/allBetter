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
import com.ruoyi.system.domain.BizTeacherEducation;
import com.ruoyi.system.service.IBizTeacherEducationService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 教师历年学习经历与证书Controller
 * 
 * @author ruoyi
 * @date 2026-04-10
 */
@RestController
@RequestMapping("/system/education")
public class BizTeacherEducationController extends BaseController
{
    @Autowired
    private IBizTeacherEducationService bizTeacherEducationService;

    //自定义接口部分

    /*
     * 教师提交历年学习经历与证书申请
     */
    @Log(title = "教师历年学习经历与证书", businessType = BusinessType.INSERT)
    @PostMapping("/apply")
    public AjaxResult apply(@RequestBody BizTeacherEducation bizTeacherEducation) {
        //自动设置用户id
        bizTeacherEducation.setUserId(SecurityUtils.getUserId());
        bizTeacherEducation.setStatus(0L);
        return toAjax(bizTeacherEducationService.insertBizTeacherEducation(bizTeacherEducation));
    }

    /*
     * 教师历年学习经历与证书审批同意
     */
    @Log(title = "教师历年学习经历与证书", businessType = BusinessType.UPDATE)
    @PutMapping("/approve")
    public AjaxResult approve(@RequestBody BizTeacherEducation bizTeacherEducation) {
        bizTeacherEducation.setStatus(1L);
        bizTeacherEducation.setCause("");
        return toAjax(bizTeacherEducationService.updateBizTeacherEducation(bizTeacherEducation));
    }

    /*
     * 教师历年学习经历与证书审批驳回
     */
    @Log(title = "教师历年学习经历与证书", businessType = BusinessType.UPDATE)
    @PutMapping("/reject")
    public AjaxResult reject(@RequestBody BizTeacherEducation bizTeacherEducation) {
        bizTeacherEducation.setStatus(2L);
        bizTeacherEducation.setCause(bizTeacherEducation.getCause());
        return toAjax(bizTeacherEducationService.updateBizTeacherEducation(bizTeacherEducation));
    }



    /**
     * 查询教师历年学习经历与证书列表
     */
    @PreAuthorize("@ss.hasPermi('system:education:list')")
    @GetMapping("/list")
    public TableDataInfo list(BizTeacherEducation bizTeacherEducation)
    {
        startPage();
        List<BizTeacherEducation> list = bizTeacherEducationService.selectBizTeacherEducationList(bizTeacherEducation);
        return getDataTable(list);
    }

    /**
     * 导出教师历年学习经历与证书列表
     */
    @PreAuthorize("@ss.hasPermi('system:education:export')")
    @Log(title = "教师历年学习经历与证书", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BizTeacherEducation bizTeacherEducation)
    {
        List<BizTeacherEducation> list = bizTeacherEducationService.selectBizTeacherEducationList(bizTeacherEducation);
        ExcelUtil<BizTeacherEducation> util = new ExcelUtil<BizTeacherEducation>(BizTeacherEducation.class);
        util.exportExcel(response, list, "教师历年学习经历与证书数据");
    }

    /**
     * 获取教师历年学习经历与证书详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:education:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(bizTeacherEducationService.selectBizTeacherEducationById(id));
    }

    /**
     * 新增教师历年学习经历与证书
     */
    @PreAuthorize("@ss.hasPermi('system:education:add')")
    @Log(title = "教师历年学习经历与证书", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BizTeacherEducation bizTeacherEducation)
    {
        bizTeacherEducation.setUserId(SecurityUtils.getUserId());
        return toAjax(bizTeacherEducationService.insertBizTeacherEducation(bizTeacherEducation));
    }

    /**
     * 修改教师历年学习经历与证书
     */
    @PreAuthorize("@ss.hasPermi('system:education:edit')")
    @Log(title = "教师历年学习经历与证书", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BizTeacherEducation bizTeacherEducation)
    {
        return toAjax(bizTeacherEducationService.updateBizTeacherEducation(bizTeacherEducation));
    }

    /**
     * 删除教师历年学习经历与证书
     */
    @PreAuthorize("@ss.hasPermi('system:education:remove')")
    @Log(title = "教师历年学习经历与证书", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(bizTeacherEducationService.deleteBizTeacherEducationByIds(ids));
    }
}
