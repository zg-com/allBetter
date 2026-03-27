package com.learningmplat.backend.domain.dto;

import java.math.BigDecimal;
import java.util.List;


public class ProjectAddDTO {
    public class ProjectMemberDTO {
        private Long userId;
        private String memberName;//项目成员名称
        private String memberRole;//项目成员角色(1-负责人，2-核心骨干，3-参与人)
    }//关于传入的成员信息
    private String projectName;
    private String projectLevel;
    private BigDecimal totalFund;//总申请预算
    private Long createId;
    private String creatorName;//创建人名称
    private List<ProjectMemberDTO> memberList;//项目成员列表
}
