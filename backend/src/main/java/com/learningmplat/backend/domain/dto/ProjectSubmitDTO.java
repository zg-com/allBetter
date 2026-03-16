package com.learningmplat.backend.domain.dto;

import lombok.Data;

/**
 * 接收老师申报科研项目参数的 DTO
 */
@Data
public class ProjectSubmitDTO {
    private String projectName;   // 项目名称
    private String projectLevel;  // 项目级别 (国家级, 省部级等)
}