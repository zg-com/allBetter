package com.learningmplat.backend.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learningmplat.backend.common.Result;
import com.learningmplat.backend.domain.BizProject;
import com.learningmplat.backend.domain.dto.ProjectAuditDTO;
import com.learningmplat.backend.domain.dto.ProjectQueryDTO;
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

    /**
     * 分页查询：老师查看自己申报的项目列表
     * 这里用 POST 请求传搜索参数更规范
     */
    @PostMapping("/myList")
    public Result<Page<BizProject>> getMyProjectList(@RequestBody ProjectQueryDTO dto, HttpServletRequest request) {

        // 1. 验明正身：从手环里拆出当前登录老师的 ID
        String token = request.getHeader("token");
        Long userId = JwtUtils.parseToken(token).get("userId", Long.class);

        // 2. 创建分页对象 (告诉 MyBatis-Plus 查第几页，每页几条)
        Page<BizProject> page = new Page<>(dto.getPageNum(), dto.getPageSize());

        // 3. 构造极其强大的查询条件 (Wrapper)
        LambdaQueryWrapper<BizProject> wrapper = new LambdaQueryWrapper<>();

        // 条件A：只能查当前老师自己创建的项目！(数据隔离的核心)
        wrapper.eq(BizProject::getCreateId, userId);

        // 条件B：如果前端传了关键字，就按项目名字模糊查询 (LIKE '%关键字%')
        if (dto.getKeyword() != null && !dto.getKeyword().isEmpty()) {
            wrapper.like(BizProject::getProjectName, dto.getKeyword());
        }

        // 条件C：按创建时间或者ID倒序排列，让新申报的排在最前面
        wrapper.orderByDesc(BizProject::getId);

        // 4. 执行查询！这一行代码会自动帮你查总数 (COUNT) 和 分页数据 (LIMIT)
        Page<BizProject> resultPage = projectService.page(page, wrapper);

        // 5. 优雅地把包裹扔给前端
        return Result.success(resultPage);
    }
}