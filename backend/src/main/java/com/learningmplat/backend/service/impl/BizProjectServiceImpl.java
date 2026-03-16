package com.learningmplat.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learningmplat.backend.domain.BizProject;
import com.learningmplat.backend.domain.dto.ProjectAuditDTO;
import com.learningmplat.backend.domain.dto.ProjectSubmitDTO;
import com.learningmplat.backend.mapper.BizProjectMapper;
import com.learningmplat.backend.service.BizProjectService;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
public class BizProjectServiceImpl extends ServiceImpl<BizProjectMapper, BizProject> implements BizProjectService {

    @Override
    public void submitNewProject(ProjectSubmitDTO dto, Long userId) {
        // 1. 创建一个全新的项目实体对象
        BizProject project = new BizProject();

        // 2. 把前端传来的名字和级别塞进去
        project.setProjectName(dto.getProjectName());
        project.setProjectLevel(dto.getProjectLevel());

        // 3. 【核心业务规则】：刚申报的项目，初始经费是 0，状态是 1（待审核）
        project.setTotalFund(BigDecimal.ZERO);
        project.setAuditStatus(1);

        // 4. 【最牛逼的一步】：打上创建人的思想钢印！
        project.setCreateId(userId);

        // 5. 调用 MyBatis-Plus 自带的保存方法，一条 INSERT 语句自动发往数据库！
        this.save(project);
    }
    @Override
    public void auditProject(ProjectAuditDTO dto) {
        // 1. 先根据 ID 把这个项目从数据库里查出来（这就是为啥要传 projectId）
        BizProject project = this.getById(dto.getProjectId());

        // 2. 【严谨的异常校验1】：防止前端乱传一个不存在的 ID
        if (project == null) {
            throw new RuntimeException("该科研项目不存在，请刷新后重试！");
        }

        // 3. 【严谨的异常校验2（核心状态机）】：只有 "1(待审核)" 状态的项目才能被审批！
        if (project.getAuditStatus() != 1) {
            throw new RuntimeException("该项目当前不是待审核状态，无法进行审批操作！");
        }

        // 4. 开始修改状态
        project.setAuditStatus(dto.getAuditStatus());

        // 5. 如果系主任大笔一挥同意了（状态2），并且输入了金额，那就把钱发下去！
        if (dto.getAuditStatus() == 2 && dto.getApprovedFund() != null) {
            project.setTotalFund(dto.getApprovedFund());
        }

        // 6. 【MyBatis-Plus 核心大招】：只更新发生变化的数据！
        // 底层会自动生成一条类似 UPDATE biz_project SET audit_status = 2, total_fund = 50000 WHERE id = 1 的 SQL
        this.updateById(project);
    }
}