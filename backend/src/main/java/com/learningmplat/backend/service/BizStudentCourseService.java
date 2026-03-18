package com.learningmplat.backend.service;

import com.learningmplat.backend.domain.BizStudentCourse;
import com.baomidou.mybatisplus.extension.service.IService;
import com.learningmplat.backend.domain.vo.CourseScoreVO;
import com.learningmplat.backend.domain.vo.MajorRankVO;

import java.util.List;

/**
* @author 13027
* @description 针对表【biz_student_course(学生选课与成绩关联表)】的数据库操作Service
* @createDate 2026-03-16 13:41:11
*/
public interface BizStudentCourseService extends IService<BizStudentCourse> {
    // 学生选课核心业务
    void selectCourse(Long courseId, Long studentId);
    //获取学分
    Integer getCredit(Long studentId);
    //获取课程成绩
    List<CourseScoreVO> getScore(Long studentId);
    //获取专业排名
    MajorRankVO getRanking(Long studentId);
}
