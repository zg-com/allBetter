package com.learningmplat.backend.mapper;

import com.learningmplat.backend.domain.BizStudentCourse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.learningmplat.backend.domain.vo.CourseScoreVO;
import com.learningmplat.backend.domain.vo.MajorRankVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author 13027
* @description 针对表【biz_student_course(学生选课与成绩关联表)】的数据库操作Mapper
* @createDate 2026-03-16 13:41:11
* @Entity com.learningmplat.backend.domain.BizStudentCourse
*/
public interface BizStudentCourseMapper extends BaseMapper<BizStudentCourse> {
    //获取总学分
    Integer sumCreditByStudentId(@Param("studentId") Long studentId);
    //获取该学生所有课程成绩
    List<CourseScoreVO> getAllCourseScore(@Param("studentId") Long studentId);
    //获取该学生专业课排名
    MajorRankVO getRanking(@Param("studentId") Long studentId);
}




