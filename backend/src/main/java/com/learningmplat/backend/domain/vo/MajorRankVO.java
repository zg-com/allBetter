package com.learningmplat.backend.domain.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class MajorRankVO {
    public Long studentId;//学生id
    public String studentName;//学生姓名
    public BigDecimal totalScore;//总成绩
    public Long studentCount; //学生总数
    public Integer ranking; //排名
}
