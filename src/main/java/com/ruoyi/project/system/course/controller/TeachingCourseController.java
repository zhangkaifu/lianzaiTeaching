package com.ruoyi.project.system.course.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.course.domain.TeachingCourse;
import com.ruoyi.project.system.course.service.ITeachingCourseService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 课程Controller
 * 
 * @author zhangkaifu
 * @date 2020-09-30
 */
@Controller
@RequestMapping("/system/course")
public class TeachingCourseController extends BaseController
{
    private String prefix = "system/course";

    @Autowired
    private ITeachingCourseService teachingCourseService;

    @RequiresPermissions("system:course:view")
    @GetMapping()
    public String course()
    {
        return prefix + "/course";
    }

    /**
     * 查询课程列表
     */
    @RequiresPermissions("system:course:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TeachingCourse teachingCourse)
    {
        startPage();
        List<TeachingCourse> list = teachingCourseService.selectTeachingCourseList(teachingCourse);
        return getDataTable(list);
    }

    /**
     * 导出课程列表
     */
    @RequiresPermissions("system:course:export")
    @Log(title = "课程", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TeachingCourse teachingCourse)
    {
        List<TeachingCourse> list = teachingCourseService.selectTeachingCourseList(teachingCourse);
        ExcelUtil<TeachingCourse> util = new ExcelUtil<TeachingCourse>(TeachingCourse.class);
        return util.exportExcel(list, "course");
    }

    /**
     * 新增课程
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存课程
     */
    @RequiresPermissions("system:course:add")
    @Log(title = "课程", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TeachingCourse teachingCourse)
    {
        teachingCourse.setCraeateUser(ShiroUtils.getSysUser().getUserName());
        return toAjax(teachingCourseService.insertTeachingCourse(teachingCourse));
    }

    /**
     * 修改课程
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TeachingCourse teachingCourse = teachingCourseService.selectTeachingCourseById(id);
        mmap.put("teachingCourse", teachingCourse);
        return prefix + "/edit";
    }

    /**
     * 修改保存课程
     */
    @RequiresPermissions("system:course:edit")
    @Log(title = "课程", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TeachingCourse teachingCourse)
    {
        return toAjax(teachingCourseService.updateTeachingCourse(teachingCourse));
    }

    /**
     * 删除课程
     */
    @RequiresPermissions("system:course:remove")
    @Log(title = "课程", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(teachingCourseService.deleteTeachingCourseByIds(ids));
    }
}
