package com.learningmplat.backend.controller;

import com.learningmplat.backend.common.Result;
import com.learningmplat.backend.domain.vo.TeacherVO;
import com.learningmplat.backend.service.BizTeacherService;
import com.learningmplat.backend.utils.JwtUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher")
@Tag(name = "教师管理接口", description = "提供教师信息查询")
public class TeacherController {
    @Autowired
    private BizTeacherService teacherService;

    @GetMapping("/data")
    @Operation(summary = "获取教师所有信息", description = "直接查")
    public Result<TeacherVO> getTeacherData(HttpServletRequest request) {
        String token = request.getHeader("token");
        Long teacherId = JwtUtils.parseToken(token).get("userId", Long.class);
        TeacherVO teacherData = teacherService.getTeacherInfo(teacherId);
        return Result.success(teacherData);
    }
}
