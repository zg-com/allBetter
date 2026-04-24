package com.ruoyi.system.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.system.domain.BizCourse;
import com.ruoyi.system.domain.BizStudentCourse;
import com.ruoyi.system.service.IBizCourseService;
import com.ruoyi.system.service.IBizStudentCourseService;
import com.ruoyi.common.utils.SecurityUtils;

/**
 * 教师教学与成绩管理 Controller
 */
@RestController
@RequestMapping("/system/teacherGrade")
public class BizTeacherGradeController extends BaseController {

    @Autowired
    private IBizCourseService bizCourseService;

    @Autowired
    private IBizStudentCourseService bizStudentCourseService;

    /**
     * 1. 查询【当前登录教师】自己的课程列表
     */
    @PreAuthorize("@ss.hasPermi('system:teacherGrade:list')")
    @GetMapping("/courseList")
    public TableDataInfo listTeacherCourse(BizCourse bizCourse) {
        startPage();
        // 🎯 核心隔离：强制设置查询条件为当前登录人的 ID

        bizCourse.setTeacherNo(SecurityUtils.getUserId());
        List<BizCourse> list = bizCourseService.selectBizCourseList(bizCourse);
        return getDataTable(list);
    }

    /**
     * 2. 查询某门课下的学生名单
     */
    @PreAuthorize("@ss.hasPermi('system:teacherGrade:list')")
    @GetMapping("/studentList")
    public TableDataInfo listCourseStudent(BizStudentCourse bizStudentCourse) {
        startPage();
        // 这里前端会传 courseId 过来
        List<BizStudentCourse> list = bizStudentCourseService.selectBizStudentCourseList(bizStudentCourse);
        return getDataTable(list);
    }

    /**
     * 3. 一键开启教学（从旧的 Controller 搬过来的）
     */
    @PreAuthorize("@ss.hasPermi('system:teacherGrade:edit')")
    @Log(title = "一键开课", businessType = BusinessType.UPDATE)
    @PutMapping("/start/{courseId}")
    public AjaxResult startCourse(@PathVariable Long courseId) {
        return toAjax(bizStudentCourseService.startCourse(courseId));
    }

    /**
     * 4. 录入成绩并结课（从旧的 Controller 搬过来的）
     */
    @PreAuthorize("@ss.hasPermi('system:teacherGrade:edit')")
    @Log(title = "录入成绩", businessType = BusinessType.UPDATE)
    @PutMapping("/grade")
    public AjaxResult gradeStudent(@RequestBody BizStudentCourse sc) {
        // 设置状态为 2 (已结课)
        sc.setLearnStatus(2L);
        return toAjax(bizStudentCourseService.updateStudentCourse(sc));
    }
}