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
import com.ruoyi.system.domain.BizPaperAuthor;
import com.ruoyi.system.service.IBizPaperAuthorService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 论文作者关联Controller
 * 
 * @author ruoyi
 * @date 2026-04-10
 */
@RestController
@RequestMapping("/system/paper_author")
public class BizPaperAuthorController extends BaseController
{
    @Autowired
    private IBizPaperAuthorService bizPaperAuthorService;

    /**
     * 查询论文作者关联列表
     */
    @PreAuthorize("@ss.hasPermi('system:paper_author:list')")
    @GetMapping("/list")
    public TableDataInfo list(BizPaperAuthor bizPaperAuthor)
    {
        startPage();
        List<BizPaperAuthor> list = bizPaperAuthorService.selectBizPaperAuthorList(bizPaperAuthor);
        return getDataTable(list);
    }

    /**
     * 导出论文作者关联列表
     */
    @PreAuthorize("@ss.hasPermi('system:paper_author:export')")
    @Log(title = "论文作者关联", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BizPaperAuthor bizPaperAuthor)
    {
        List<BizPaperAuthor> list = bizPaperAuthorService.selectBizPaperAuthorList(bizPaperAuthor);
        ExcelUtil<BizPaperAuthor> util = new ExcelUtil<BizPaperAuthor>(BizPaperAuthor.class);
        util.exportExcel(response, list, "论文作者关联数据");
    }

    /**
     * 获取论文作者关联详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:paper_author:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(bizPaperAuthorService.selectBizPaperAuthorById(id));
    }

    /**
     * 新增论文作者关联
     */
    @PreAuthorize("@ss.hasPermi('system:paper_author:add')")
    @Log(title = "论文作者关联", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BizPaperAuthor bizPaperAuthor)
    {
        return toAjax(bizPaperAuthorService.insertBizPaperAuthor(bizPaperAuthor));
    }

    /**
     * 修改论文作者关联
     */
    @PreAuthorize("@ss.hasPermi('system:paper_author:edit')")
    @Log(title = "论文作者关联", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BizPaperAuthor bizPaperAuthor)
    {
        return toAjax(bizPaperAuthorService.updateBizPaperAuthor(bizPaperAuthor));
    }

    /**
     * 删除论文作者关联
     */
    @PreAuthorize("@ss.hasPermi('system:paper_author:remove')")
    @Log(title = "论文作者关联", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(bizPaperAuthorService.deleteBizPaperAuthorByIds(ids));
    }
}
