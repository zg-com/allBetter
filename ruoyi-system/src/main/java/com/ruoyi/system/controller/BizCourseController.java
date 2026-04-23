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
import com.ruoyi.system.domain.BizCourse;
import com.ruoyi.system.service.IBizCourseService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 课程信息Controller
 * 
 * @author ruoyi
 * @date 2026-04-10
 */
@RestController
@RequestMapping("/system/course")
public class BizCourseController extends BaseController
{
    @Autowired
    private IBizCourseService bizCourseService;

    //自定义接口部分

    /**
     * 开课申请
     */
    @Log(title = "开课申请", businessType = BusinessType.INSERT)
    @PostMapping("/apply")
    public AjaxResult apply(@RequestBody BizCourse bizCourse)
    {
        if (bizCourse.getTeacherNo() == null){
            bizCourse.setTeacherNo(getUserId());
        }
        bizCourse.setStatus(0L);
        return toAjax(bizCourseService.insertBizCourse(bizCourse));
    }

    /**
     * 课程审核
     */
    @Log(title = "课程审核通过", businessType = BusinessType.UPDATE)
    @PutMapping("/approve")
    public AjaxResult approve(@RequestBody BizCourse bizCourse)
    {
        bizCourse.setStatus(1L);
        bizCourse.setCause("");
        return toAjax(bizCourseService.updateBizCourse(bizCourse));
    }

    /**
     * 课程审核不通过
     */
    @Log(title = "课程审核不通过", businessType = BusinessType.UPDATE)
    @PutMapping("/reject")
    public AjaxResult reject(@RequestBody BizCourse bizCourse)
    {
        bizCourse.setStatus(2L);
        return toAjax(bizCourseService.updateBizCourse(bizCourse));
    }

    /**
     * 查询课程信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:course:list')")
    @GetMapping("/list")
    public TableDataInfo list(BizCourse bizCourse)
    {
        startPage();
        List<BizCourse> list = bizCourseService.selectBizCourseList(bizCourse);
        return getDataTable(list);
    }

    /**
     * 导出课程信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:course:export')")
    @Log(title = "课程信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BizCourse bizCourse)
    {
        List<BizCourse> list = bizCourseService.selectBizCourseList(bizCourse);
        ExcelUtil<BizCourse> util = new ExcelUtil<BizCourse>(BizCourse.class);
        util.exportExcel(response, list, "课程信息数据");
    }

    /**
     * 获取课程信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:course:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(bizCourseService.selectBizCourseById(id));
    }

    /**
     * 新增课程信息
     */
    @PreAuthorize("@ss.hasPermi('system:course:add')")
    @Log(title = "课程信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BizCourse bizCourse)
    {
        return toAjax(bizCourseService.insertBizCourse(bizCourse));
    }

    /**
     * 修改课程信息
     */
    @PreAuthorize("@ss.hasPermi('system:course:edit')")
    @Log(title = "课程信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BizCourse bizCourse)
    {
        return toAjax(bizCourseService.updateBizCourse(bizCourse));
    }

    /**
     * 删除课程信息
     */
    @PreAuthorize("@ss.hasPermi('system:course:remove')")
    @Log(title = "课程信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(bizCourseService.deleteBizCourseByIds(ids));
    }
}
