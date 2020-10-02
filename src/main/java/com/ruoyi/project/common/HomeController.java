package com.ruoyi.project.common;

import com.github.pagehelper.PageHelper;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.project.system.course.domain.TeachingCourse;
import com.ruoyi.project.system.course.service.ITeachingCourseService;
import com.ruoyi.project.system.liangzaiinfo.domain.Liangzaiinfo;
import com.ruoyi.project.system.liangzaiinfo.service.ILiangzaiinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

/**
 * 前端请求处理
 */
@Controller
public class HomeController extends BaseController {

    @Autowired
    private ITeachingCourseService teachingCourseService;
    @Autowired
    private ILiangzaiinfoService liangzaiinfoService;

    //前端首页
    @GetMapping("/home/{pages}/{sizes}")
    public String index(@PathVariable("pages")Integer pages,@PathVariable("sizes")Integer sizes,ModelMap mmap){
        Liangzaiinfo liangzaiinfo = liangzaiinfoService.selectLiangzaiinfoById(1L);
        mmap.put("liangzaiinfo", liangzaiinfo);
        TeachingCourse teachingCourse = new TeachingCourse();
        Integer pageNum = pages== null ? 1: pages;
        Integer pageSize = sizes== null ? 10: sizes;
        PageHelper.startPage(pageNum, pageSize);
        List<TeachingCourse> list = teachingCourseService.selectTeachingCourseList(teachingCourse);
        mmap.put("course",list);
        mmap.put("Construct",pageNum);
        mmap.put("sizes",sizes);
        return   "home" ;
    }
    //前端首页
    @GetMapping("/")
    public String home(ModelMap mmap){
        Liangzaiinfo liangzaiinfo = liangzaiinfoService.selectLiangzaiinfoById(1L);
        mmap.put("liangzaiinfo", liangzaiinfo);
        TeachingCourse teachingCourse = new TeachingCourse();
        PageHelper.startPage(1, 10);
        List<TeachingCourse> list = teachingCourseService.selectTeachingCourseList(teachingCourse);
        mmap.put("course",list);
        mmap.put("Construct",1);
        mmap.put("sizes",10);
        return   "home" ;
    }
    @GetMapping("/qianduan/info/{Id}")
    public String infos(@PathVariable("Id") Long Id, ModelMap mmap){
        TeachingCourse list = teachingCourseService.selectTeachingCourseById(Id);
        Liangzaiinfo liangzaiinfo = liangzaiinfoService.selectLiangzaiinfoById(1L);
        mmap.put("liangzaiinfo", liangzaiinfo);
        mmap.put("info",list);
        return  "playVideos" ;
    }

}
