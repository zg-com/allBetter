package com.learningmplat.backend.controller;

import com.learningmplat.backend.common.Result;
import com.learningmplat.backend.domain.dto.CourseSelectDTO;
import com.learningmplat.backend.domain.dto.StudentCourseDataDTO;
import com.learningmplat.backend.domain.vo.CourseScoreVO;
import com.learningmplat.backend.domain.vo.MajorRankVO;
import com.learningmplat.backend.service.BizStudentCourseService;
import com.learningmplat.backend.utils.JwtUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student-course")
@Tag(name = "学生课程管理接口", description = "提供学生与其选课程相关信息")
public class StudentCourseController {

    @Autowired
    private BizStudentCourseService studentCourseService;


    @PostMapping("/select")
    @Operation(summary = "学生选课接口", description = "前端只需传入要选的课程的id")
    public Result<String> selectCourse(@RequestBody CourseSelectDTO dto, HttpServletRequest request) {

        // 1. 验明正身：拿到当前登录学生的 ID (绝对不能让前端传，防作弊！)
        String token = request.getHeader("token");
        Long studentId = JwtUtils.parseToken(token).get("userId", Long.class);

        // 2. 交给大厨去处理选课逻辑
        studentCourseService.selectCourse(dto.getCourseId(), studentId);

        return Result.success("选课成功！");
    }


    @GetMapping("/credit")
    @Operation(summary = "学分获取接口",description = "前端直接获取即可，在请求中后端会自动解析token中的id")
    public Result<Integer> getCredit(HttpServletRequest request){
        String token = request.getHeader("token");
        Long studentId = JwtUtils.parseToken(token).get("userId", Long.class);
        Integer totalCredit = studentCourseService.getCredit(studentId);
        return Result.success(totalCredit);
    }

    @GetMapping("/score")
    @Operation(summary = "获取学生各科成绩接口",description = "前端直接获取即可")
    public Result<List<CourseScoreVO>> getScore(HttpServletRequest request){
        String token = request.getHeader("token");
        Long studentId = JwtUtils.parseToken(token).get("userId", Long.class);

        List<CourseScoreVO> allCourseScore = studentCourseService.getScore(studentId);
        return Result.success(allCourseScore);
    }

    @GetMapping("/ranking")
    @Operation(summary = "获取学生专业排名",description = "直接查")
    public Result<MajorRankVO> getRanking(HttpServletRequest request){
        String token = request.getHeader("token");
        Long studentId = JwtUtils.parseToken(token).get("userId", Long.class);

        MajorRankVO rankingData = studentCourseService.getRanking(studentId);
        return Result.success(rankingData);
    }
}