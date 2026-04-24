package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.BizStudentCourse;

import java.util.List;

public interface BizTeacherGradeMapper {
    /** 教师视角的学生名单查询（涉及多表 Join） */
    public List<BizStudentCourse> selectCourseStudentList(BizStudentCourse studentCourse);

    /** 批量更新开课状态 */
    public int updateBatchLearnStatus(Long courseId);
}
