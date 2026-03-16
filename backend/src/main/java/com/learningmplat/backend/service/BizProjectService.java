package com.learningmplat.backend.service;

import com.learningmplat.backend.domain.BizProject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.learningmplat.backend.domain.dto.ProjectAuditDTO;
import com.learningmplat.backend.domain.dto.ProjectSubmitDTO;

/**
* @author 13027
* @description 针对表【biz_project(科研项目实体表)】的数据库操作Service
* @createDate 2026-03-16 13:41:11
*/
public interface BizProjectService extends IService<BizProject> {
    void submitNewProject(ProjectSubmitDTO dto, Long userId);
    // 审批科研项目
    void auditProject(ProjectAuditDTO dto);
}
