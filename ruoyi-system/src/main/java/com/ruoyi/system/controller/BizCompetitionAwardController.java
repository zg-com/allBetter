package com.ruoyi.system.controller;

import java.util.List;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.BizCompetitionAward;
import com.ruoyi.system.service.IBizCompetitionAwardService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学生竞赛获奖全纪录Controller
 * 
 * @author ruoyi
 * @date 2026-03-27
 */
@RestController
@RequestMapping("/system/comp_award")
public class BizCompetitionAwardController extends BaseController
{
    @Autowired
    private IBizCompetitionAwardService bizCompetitionAwardService;

    /**
     * 查询学生竞赛获奖全纪录列表
     */
    @PreAuthorize("@ss.hasPermi('system:comp_award:list')")
    @GetMapping("/list")
    public TableDataInfo list(BizCompetitionAward bizCompetitionAward)
    {
        startPage();
        List<BizCompetitionAward> list = bizCompetitionAwardService.selectBizCompetitionAwardList(bizCompetitionAward);
        return getDataTable(list);
    }

    /**
     * 导出学生竞赛获奖全纪录列表
     */
    @PreAuthorize("@ss.hasPermi('system:comp_award:export')")
    @Log(title = "学生竞赛获奖全纪录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BizCompetitionAward bizCompetitionAward)
    {
        List<BizCompetitionAward> list = bizCompetitionAwardService.selectBizCompetitionAwardList(bizCompetitionAward);
        ExcelUtil<BizCompetitionAward> util = new ExcelUtil<BizCompetitionAward>(BizCompetitionAward.class);
        util.exportExcel(response, list, "学生竞赛获奖全纪录数据");
    }

    /**
     * 获取学生竞赛获奖全纪录详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:comp_award:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(bizCompetitionAwardService.selectBizCompetitionAwardById(id));
    }

    /**
     * 新增学生竞赛获奖全纪录
     */
    @PreAuthorize("@ss.hasPermi('system:comp_award:add')")
    @Log(title = "学生竞赛获奖全纪录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BizCompetitionAward bizCompetitionAward)
    {
        return toAjax(bizCompetitionAwardService.insertBizCompetitionAward(bizCompetitionAward));
    }

    /**
     * 修改学生竞赛获奖全纪录
     */
    @PreAuthorize("@ss.hasPermi('system:comp_award:edit')")
    @Log(title = "学生竞赛获奖全纪录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BizCompetitionAward bizCompetitionAward)
    {
        return toAjax(bizCompetitionAwardService.updateBizCompetitionAward(bizCompetitionAward));
    }

    /**
     * 删除学生竞赛获奖全纪录
     */
    @PreAuthorize("@ss.hasPermi('system:comp_award:remove')")
    @Log(title = "学生竞赛获奖全纪录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(bizCompetitionAwardService.deleteBizCompetitionAwardByIds(ids));
    }
}
