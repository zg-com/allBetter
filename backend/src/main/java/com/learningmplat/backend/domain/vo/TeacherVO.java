package com.learningmplat.backend.domain.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TeacherVO {
    public Long userId;//用户ID
    public String teacher_no;//工号
    public String title;//职称
    public BigDecimal workHours;//工时
}
