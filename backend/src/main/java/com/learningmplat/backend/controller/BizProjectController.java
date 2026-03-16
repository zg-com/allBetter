package com.learningmplat.backend.controller;

import com.learningmplat.backend.common.Result;
import com.learningmplat.backend.domain.dto.ProjectAuditDTO;
import com.learningmplat.backend.domain.dto.ProjectSubmitDTO;
import com.learningmplat.backend.service.BizProjectService;
import com.learningmplat.backend.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/project")
public class BizProjectController {

    @Autowired
    private BizProjectService projectService;

    @PostMapping("/submit")
    public Result<String> submitProject(@RequestBody ProjectSubmitDTO dto, HttpServletRequest request) {

        // 1. 从请求头里拿到 VIP 手环
        String token = request.getHeader("token");

        // 2. 拆开手环（因为拦截器已经验过真伪了，这里绝对安全），拿到里面的 userId
        Claims claims = JwtUtils.parseToken(token);
        // 【注意这里的强转技巧】：从 claims 里把 userId 取出来变成 Long 类型
        Long userId = claims.get("userId", Long.class);

        // 3. 传给大厨（Service）去干活
        projectService.submitNewProject(dto, userId);

        return Result.success("科研项目申报成功！已进入待审批状态。");
    }

    @PostMapping("/audit")
    public Result<String> auditProject(@RequestBody ProjectAuditDTO dto, HttpServletRequest request) {
        // 真实企业开发中，这里还会解析 Token，去校验当前登录人到底有没有“系主任”的权限。
        // 因为咱们的重点是让你先跑通状态机，权限校验咱们先略过，直接放行给 Service。

        projectService.auditProject(dto);

        return Result.success("审批操作完成！");
    }
}