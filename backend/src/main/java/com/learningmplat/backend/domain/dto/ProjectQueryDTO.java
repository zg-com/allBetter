package com.learningmplat.backend.domain.dto;

import lombok.Data;

@Data
public class ProjectQueryDTO {
    private Integer pageNum = 1;  // 默认查第1页
    private Integer pageSize = 10; // 默认每页10条
    private String keyword;       // 搜索关键字（项目名称）
}