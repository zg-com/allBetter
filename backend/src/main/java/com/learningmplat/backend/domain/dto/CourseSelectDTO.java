package com.learningmplat.backend.domain.dto;

import lombok.Data;

@Data
public class CourseSelectDTO {
    // 前端只传课程 ID 过来
    private Long courseId;
}