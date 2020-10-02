package com.ruoyi.project.system.liangzaiinfo.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.system.liangzaiinfo.domain.Liangzaiinfo;
import com.ruoyi.project.system.liangzaiinfo.service.ILiangzaiinfoService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 网站信息Controller
 * 
 * @author zhangkaifu
 * @date 2020-09-30
 */
@Controller
@RequestMapping("/system/liangzaiinfo")
public class LiangzaiinfoController extends BaseController
{
    private String prefix = "system/liangzaiinfo";

    @Autowired
    private ILiangzaiinfoService liangzaiinfoService;

    @RequiresPermissions("system:liangzaiinfo:view")
    @GetMapping()
    public String liangzaiinfo()
    {
        return prefix + "/liangzaiinfo";
    }

    /**
     * 查询网站信息列表
     */
    @RequiresPermissions("system:liangzaiinfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Liangzaiinfo liangzaiinfo)
    {
        startPage();
        List<Liangzaiinfo> list = liangzaiinfoService.selectLiangzaiinfoList(liangzaiinfo);
        return getDataTable(list);
    }

    /**
     * 导出网站信息列表
     */
    @RequiresPermissions("system:liangzaiinfo:export")
    @Log(title = "网站信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Liangzaiinfo liangzaiinfo)
    {
        List<Liangzaiinfo> list = liangzaiinfoService.selectLiangzaiinfoList(liangzaiinfo);
        ExcelUtil<Liangzaiinfo> util = new ExcelUtil<Liangzaiinfo>(Liangzaiinfo.class);
        return util.exportExcel(list, "liangzaiinfo");
    }

    /**
     * 新增网站信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存网站信息
     */
    @RequiresPermissions("system:liangzaiinfo:add")
    @Log(title = "网站信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Liangzaiinfo liangzaiinfo)
    {
        return toAjax(liangzaiinfoService.insertLiangzaiinfo(liangzaiinfo));
    }

    /**
     * 修改网站信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Liangzaiinfo liangzaiinfo = liangzaiinfoService.selectLiangzaiinfoById(id);
        mmap.put("liangzaiinfo", liangzaiinfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存网站信息
     */
    @RequiresPermissions("system:liangzaiinfo:edit")
    @Log(title = "网站信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Liangzaiinfo liangzaiinfo)
    {
        return toAjax(liangzaiinfoService.updateLiangzaiinfo(liangzaiinfo));
    }

    /**
     * 删除网站信息
     */
    @RequiresPermissions("system:liangzaiinfo:remove")
    @Log(title = "网站信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(liangzaiinfoService.deleteLiangzaiinfoByIds(ids));
    }
}
