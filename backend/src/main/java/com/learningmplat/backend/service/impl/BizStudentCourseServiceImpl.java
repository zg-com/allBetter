package com.learningmplat.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learningmplat.backend.domain.BizStudentCourse;
import com.learningmplat.backend.service.BizStudentCourseService;
import com.learningmplat.backend.mapper.BizStudentCourseMapper;
import org.springframework.stereotype.Service;

/**
* @author 13027
* @description 针对表【biz_student_course(学生选课与成绩关联表)】的数据库操作Service实现
* @createDate 2026-03-16 13:41:11
*/
@Service
public class BizStudentCourseServiceImpl extends ServiceImpl<BizStudentCourseMapper, BizStudentCourse>
    implements BizStudentCourseService{

}




