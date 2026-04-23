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
import com.ruoyi.system.domain.BizTeacherHonorAssessment;
import com.ruoyi.system.service.IBizTeacherHonorAssessmentService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 教师荣誉与历年考核记录Controller
 * 
 * @author ruoyi
 * @date 2026-04-10
 */
@RestController
@RequestMapping("/system/assessment")
public class BizTeacherHonorAssessmentController extends BaseController
{
    @Autowired
    private IBizTeacherHonorAssessmentService bizTeacherHonorAssessmentService;

    //自定义接口部分

    /**
     * 教师荣誉与历年考核申请
     */
    @Log(title = "教师荣誉与历年考核申请", businessType = BusinessType.INSERT)
    @PostMapping("/apply")
    public AjaxResult apply(@RequestBody BizTeacherHonorAssessment bizTeacherHonorAssessment)
    {
        if(bizTeacherHonorAssessment.getUserId()==null){
            bizTeacherHonorAssessment.setUserId(getUserId());
        }
        bizTeacherHonorAssessment.setStatus(0L);
        return toAjax(bizTeacherHonorAssessmentService.insertBizTeacherHonorAssessment(bizTeacherHonorAssessment));
    }

    /**
     * 教师荣誉与历年考核审批
     */
    @Log(title = "教师荣誉与历年考核审批通过", businessType = BusinessType.UPDATE)
    @PutMapping("/approve")
    public AjaxResult approve(@RequestBody BizTeacherHonorAssessment bizTeacherHonorAssessment)
    {
        bizTeacherHonorAssessment.setStatus(1L);
        bizTeacherHonorAssessment.setCause("");
        return toAjax(bizTeacherHonorAssessmentService.updateBizTeacherHonorAssessment(bizTeacherHonorAssessment));
    }

    /**
     * 教师荣誉与历年考核审批驳回
     */
    @Log(title = "教师荣誉与历年考核审批驳回", businessType = BusinessType.UPDATE)
    @PutMapping("/reject")
    public AjaxResult reject(@RequestBody BizTeacherHonorAssessment bizTeacherHonorAssessment)
    {
        bizTeacherHonorAssessment.setStatus(2L);
        return toAjax(bizTeacherHonorAssessmentService.updateBizTeacherHonorAssessment(bizTeacherHonorAssessment));
    }

    /**
     * 查询教师荣誉与历年考核记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:assessment:list')")
    @GetMapping("/list")
    public TableDataInfo list(BizTeacherHonorAssessment bizTeacherHonorAssessment)
    {
        startPage();
        List<BizTeacherHonorAssessment> list = bizTeacherHonorAssessmentService.selectBizTeacherHonorAssessmentList(bizTeacherHonorAssessment);
        return getDataTable(list);
    }

    /**
     * 导出教师荣誉与历年考核记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:assessment:export')")
    @Log(title = "教师荣誉与历年考核记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BizTeacherHonorAssessment bizTeacherHonorAssessment)
    {
        List<BizTeacherHonorAssessment> list = bizTeacherHonorAssessmentService.selectBizTeacherHonorAssessmentList(bizTeacherHonorAssessment);
        ExcelUtil<BizTeacherHonorAssessment> util = new ExcelUtil<BizTeacherHonorAssessment>(BizTeacherHonorAssessment.class);
        util.exportExcel(response, list, "教师荣誉与历年考核记录数据");
    }

    /**
     * 获取教师荣誉与历年考核记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:assessment:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(bizTeacherHonorAssessmentService.selectBizTeacherHonorAssessmentById(id));
    }

    /**
     * 新增教师荣誉与历年考核记录
     */
    @PreAuthorize("@ss.hasPermi('system:assessment:add')")
    @Log(title = "教师荣誉与历年考核记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BizTeacherHonorAssessment bizTeacherHonorAssessment)
    {
        return toAjax(bizTeacherHonorAssessmentService.insertBizTeacherHonorAssessment(bizTeacherHonorAssessment));
    }

    /**
     * 修改教师荣誉与历年考核记录
     */
    @PreAuthorize("@ss.hasPermi('system:assessment:edit')")
    @Log(title = "教师荣誉与历年考核记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BizTeacherHonorAssessment bizTeacherHonorAssessment)
    {
        return toAjax(bizTeacherHonorAssessmentService.updateBizTeacherHonorAssessment(bizTeacherHonorAssessment));
    }

    /**
     * 删除教师荣誉与历年考核记录
     */
    @PreAuthorize("@ss.hasPermi('system:assessment:remove')")
    @Log(title = "教师荣誉与历年考核记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(bizTeacherHonorAssessmentService.deleteBizTeacherHonorAssessmentByIds(ids));
    }
}
