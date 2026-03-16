package com.learningmplat.backend.service;

import com.learningmplat.backend.domain.BizCourse;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 13027
* @description 针对表【biz_course(课程实体表)】的数据库操作Service
* @createDate 2026-03-16 13:41:11
*/
public interface BizCourseService extends IService<BizCourse> {
    List<BizCourse> getMySelectedCourses(Long studentId);
}
