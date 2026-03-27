package com.learningmplat.backend.controller;

import com.learningmplat.backend.common.Result;
import com.learningmplat.backend.domain.BizProject;
import com.learningmplat.backend.domain.BizProjectMember;
import com.learningmplat.backend.domain.dto.ProjectAddDTO;
import com.learningmplat.backend.service.BizPaperAuthorService;
import com.learningmplat.backend.service.BizPaperService;
import com.learningmplat.backend.service.BizProjectMemberService;
import com.learningmplat.backend.service.BizProjectService;
import com.learningmplat.backend.service.impl.BizPaperServiceImpl;
import com.learningmplat.backend.service.impl.BizProjectMemberServiceImpl;
import com.learningmplat.backend.service.impl.BizProjectServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/projectAndPaper")
@Tag(name = "项目与论文接口", description = "项目与论文相关的接口")
public class ProjectAndPaperController {
    @Autowired
    private BizProjectService bizProjectService;
    @Autowired
    private BizPaperService bizPaperService;
    @Autowired
    private BizProjectMemberService bizProjectMemberService;
    @Autowired
    private BizPaperAuthorService bizPaperAuthorService;

    @PostMapping("/addproject")
    @Operation(summary = "添加项目接口", description = "前端传入项目信息即可")
    public Result<String> addProject(ProjectAddDTO dto, HttpServletRequest request) {

        //处理项目信息
        bizProjectService.updateProjectData(dto);
        return Result.success("选课成功！");
    }


}
