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
import com.ruoyi.system.domain.BizResearchAwardPeople;
import com.ruoyi.system.service.IBizResearchAwardPeopleService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 科研奖励关联Controller
 * 
 * @author ruoyi
 * @date 2026-04-23
 */
@RestController
@RequestMapping("/system/award_people")
public class BizResearchAwardPeopleController extends BaseController
{
    @Autowired
    private IBizResearchAwardPeopleService bizResearchAwardPeopleService;

    /**
     * 查询科研奖励关联列表
     */
    @PreAuthorize("@ss.hasPermi('system:award_people:list')")
    @GetMapping("/list")
    public TableDataInfo list(BizResearchAwardPeople bizResearchAwardPeople)
    {
        startPage();
        List<BizResearchAwardPeople> list = bizResearchAwardPeopleService.selectBizResearchAwardPeopleList(bizResearchAwardPeople);
        return getDataTable(list);
    }

    /**
     * 导出科研奖励关联列表
     */
    @PreAuthorize("@ss.hasPermi('system:award_people:export')")
    @Log(title = "科研奖励关联", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BizResearchAwardPeople bizResearchAwardPeople)
    {
        List<BizResearchAwardPeople> list = bizResearchAwardPeopleService.selectBizResearchAwardPeopleList(bizResearchAwardPeople);
        ExcelUtil<BizResearchAwardPeople> util = new ExcelUtil<BizResearchAwardPeople>(BizResearchAwardPeople.class);
        util.exportExcel(response, list, "科研奖励关联数据");
    }

    /**
     * 获取科研奖励关联详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:award_people:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(bizResearchAwardPeopleService.selectBizResearchAwardPeopleById(id));
    }

    /**
     * 新增科研奖励关联
     */
    @PreAuthorize("@ss.hasPermi('system:award_people:add')")
    @Log(title = "科研奖励关联", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BizResearchAwardPeople bizResearchAwardPeople)
    {
        return toAjax(bizResearchAwardPeopleService.insertBizResearchAwardPeople(bizResearchAwardPeople));
    }

    /**
     * 修改科研奖励关联
     */
    @PreAuthorize("@ss.hasPermi('system:award_people:edit')")
    @Log(title = "科研奖励关联", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BizResearchAwardPeople bizResearchAwardPeople)
    {
        return toAjax(bizResearchAwardPeopleService.updateBizResearchAwardPeople(bizResearchAwardPeople));
    }

    /**
     * 删除科研奖励关联
     */
    @PreAuthorize("@ss.hasPermi('system:award_people:remove')")
    @Log(title = "科研奖励关联", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(bizResearchAwardPeopleService.deleteBizResearchAwardPeopleByIds(ids));
    }
}
