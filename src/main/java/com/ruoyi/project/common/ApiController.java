package com.ruoyi.project.common;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.course.domain.TeachingCourse;
import com.ruoyi.project.system.course.service.ITeachingCourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Api 请求处理
 */
@Api("教程信息")
@Controller
@RequestMapping("/api")
public class ApiController extends BaseController {
    @Autowired
    private ITeachingCourseService teachingCourseService;

    @ApiOperation("课程列表")
    @PostMapping("/CourseList")
    @ResponseBody
    public TableDataInfo CourseList(TeachingCourse teachingCourse)
    {
        startPage();
        List<TeachingCourse> list = teachingCourseService.selectTeachingCourseList(teachingCourse);
        return getDataTable(list);
    }
}
