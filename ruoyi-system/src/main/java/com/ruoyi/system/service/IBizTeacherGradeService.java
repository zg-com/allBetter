package com.ruoyi.system.service;

import com.ruoyi.system.domain.BizCourse;
import com.ruoyi.system.domain.BizStudentCourse;

import java.util.List;

public interface IBizTeacherGradeService {
    /** 查询老师负责的课程列表 */
    public List<BizCourse> selectTeacherCourseList(BizCourse course);

    /** 查询某门课下的学生名单（含成绩、档案信息） */
    public List<BizStudentCourse> selectCourseStudentList(BizStudentCourse studentCourse);

    /** 开启课程教学 */
    public int startCourse(Long courseId);

    /** 录入学生成绩 */
    public int updateGrade(BizStudentCourse studentCourse);
}
