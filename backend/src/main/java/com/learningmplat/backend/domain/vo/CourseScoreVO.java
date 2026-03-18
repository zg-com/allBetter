package com.learningmplat.backend.domain.vo;

import lombok.Data;

@Data
public class CourseScoreVO {
    public String courseName;//课程名称
    public String score;//期末分数
    public String credit;//获得学分
}
