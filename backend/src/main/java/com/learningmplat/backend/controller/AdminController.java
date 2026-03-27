package com.learningmplat.backend.controller;

import com.learningmplat.backend.common.Result;
import com.learningmplat.backend.domain.dto.StudentAddDTO;
import com.learningmplat.backend.domain.dto.TeacherAddDTO;
import com.learningmplat.backend.service.SysUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@Tag(name = "管理员接口", description = "提供管理员相关的接口")
public class AdminController {
    @Autowired
    private SysUserService sysUserService;

    @PostMapping("/student/add")
    @Operation(summary = "添加学生接口", description = "添加学生")
    public Result<String> addStudent(@RequestBody StudentAddDTO dto){
        sysUserService.addStudent(dto);
        return Result.success("添加成功！");
    }

    @PostMapping("/teacher/add")
    @Operation(summary = "添加教师接口", description = "添加教师")
    public Result<String> addTeacher(@RequestBody TeacherAddDTO dto){
        sysUserService.addTeacher(dto);
        return Result.success("添加成功！");
    }

}
