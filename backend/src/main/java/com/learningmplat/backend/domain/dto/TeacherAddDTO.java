package com.learningmplat.backend.domain.dto;

import lombok.Data;

@Data
public class TeacherAddDTO {
    private String username; //用户名
    private String password;//密码
    private String realName;//真实姓名
    private String title;//职称
}
