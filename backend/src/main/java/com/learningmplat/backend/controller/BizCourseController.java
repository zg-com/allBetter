package com.learningmplat.backend.controller;

import com.learningmplat.backend.common.Result;
import com.learningmplat.backend.domain.BizCourse;
import com.learningmplat.backend.service.BizCourseService;
import com.learningmplat.backend.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/course")
public class BizCourseController {

    @Autowired
    private BizCourseService courseService;

    @GetMapping("/my-selected")
    public Result<List<BizCourse>> getMySelectedCourses(HttpServletRequest request) {
        // 1. 验明正身：拿到当前登录学生的 ID
        String token = request.getHeader("token");
        Long studentId = JwtUtils.parseToken(token).get("userId", Long.class);

        // 2. 调用大厨去查连表 SQL
        List<BizCourse> courses = courseService.getMySelectedCourses(studentId);

        return Result.success(courses);
    }
}