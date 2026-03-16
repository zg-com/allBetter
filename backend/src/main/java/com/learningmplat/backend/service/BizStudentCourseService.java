package com.learningmplat.backend.service;

import com.learningmplat.backend.domain.BizStudentCourse;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 13027
* @description 针对表【biz_student_course(学生选课与成绩关联表)】的数据库操作Service
* @createDate 2026-03-16 13:41:11
*/
public interface BizStudentCourseService extends IService<BizStudentCourse> {
    // 学生选课核心业务
    void selectCourse(Long courseId, Long studentId);
}
