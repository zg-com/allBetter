package com.learningmplat.backend.domain.dto;

import lombok.Data;

/**
 * 专门用于接收前端登录参数的 DTO
 */
@Data
public class LoginDTO {
    private String username;
    private String password;
}