package com.learningmplat.backend.controller;

import com.learningmplat.backend.common.Result;
import com.learningmplat.backend.domain.dto.CourseSelectDTO;
import com.learningmplat.backend.service.BizStudentCourseService;
import com.learningmplat.backend.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student-course")
public class StudentCourseController {

    @Autowired
    private BizStudentCourseService studentCourseService;

    @PostMapping("/select")
    public Result<String> selectCourse(@RequestBody CourseSelectDTO dto, HttpServletRequest request) {

        // 1. 验明正身：拿到当前登录学生的 ID (绝对不能让前端传，防作弊！)
        String token = request.getHeader("token");
        Long studentId = JwtUtils.parseToken(token).get("userId", Long.class);

        // 2. 交给大厨去处理选课逻辑
        studentCourseService.selectCourse(dto.getCourseId(), studentId);

        return Result.success("选课成功！");
    }
}