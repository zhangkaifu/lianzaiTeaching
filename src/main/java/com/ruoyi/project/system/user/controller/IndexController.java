package com.ruoyi.project.system.user.controller;

import com.github.pagehelper.PageHelper;
import com.ruoyi.common.utils.CookieUtils;
import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.config.RuoYiConfig;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.project.system.config.service.IConfigService;
import com.ruoyi.project.system.course.domain.TeachingCourse;
import com.ruoyi.project.system.course.service.ITeachingCourseService;
import com.ruoyi.project.system.liangzaiinfo.domain.Liangzaiinfo;
import com.ruoyi.project.system.liangzaiinfo.service.ILiangzaiinfoService;
import com.ruoyi.project.system.menu.domain.Menu;
import com.ruoyi.project.system.menu.service.IMenuService;
import com.ruoyi.project.system.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 首页 业务处理
 * 
 * @author ruoyi
 */
@Controller
public class IndexController extends BaseController
{
    @Autowired
    private IMenuService menuService;

    @Autowired
    private IConfigService configService;

    @Autowired
    private RuoYiConfig ruoYiConfig;

    @Autowired
    private ITeachingCourseService teachingCourseService;
    @Autowired
    private ILiangzaiinfoService liangzaiinfoService;

    // 系统后台首页
    @GetMapping({"/admin","/index"})
    public String adminIndex(ModelMap mmap)
    {
        // 取身份信息
        User user = getSysUser();
        // 根据用户id取出菜单
        List<Menu> menus = menuService.selectMenusByUser(user);
        mmap.put("menus", menus);
        mmap.put("user", user);
        mmap.put("sideTheme", configService.selectConfigByKey("sys.index.sideTheme"));
        mmap.put("skinName", configService.selectConfigByKey("sys.index.skinName"));
        mmap.put("ignoreFooter", configService.selectConfigByKey("sys.index.ignoreFooter"));
        mmap.put("copyrightYear", ruoYiConfig.getCopyrightYear());
        mmap.put("demoEnabled", ruoYiConfig.isDemoEnabled());
        Liangzaiinfo liangzaiinfo = liangzaiinfoService.selectLiangzaiinfoById(1l);
        mmap.put("liangzaiinfo", liangzaiinfo);
        // 菜单导航显示风格
        String menuStyle = configService.selectConfigByKey("sys.index.menuStyle");
        // 移动端，默认使左侧导航菜单，否则取默认配置
        String indexStyle = ServletUtils.checkAgentIsMobile(ServletUtils.getRequest().getHeader("User-Agent")) ? "index" : menuStyle;
        
        // 优先Cookie配置导航菜单
        Cookie[] cookies = ServletUtils.getRequest().getCookies();
        for (Cookie cookie : cookies)
        {
            if (StringUtils.isNotEmpty(cookie.getName()) && "nav-style".equalsIgnoreCase(cookie.getName()))
            {
                indexStyle = cookie.getValue();
                break;
            }
        }
        String webIndex = "topnav".equalsIgnoreCase(indexStyle) ? "index-topnav" : "index";
        return webIndex;
    }

    // 切换主题
    @GetMapping("/system/switchSkin")
    public String switchSkin()
    {
        return "skin";
    }

    // 切换菜单
    @GetMapping("/system/menuStyle/{style}")
    public void menuStyle(@PathVariable String style, HttpServletResponse response)
    {
        CookieUtils.setCookie(response, "nav-style", style);
    }

    // 系统介绍
    @GetMapping("/system/main")
    public String main(ModelMap mmap)
    {
        mmap.put("version", ruoYiConfig.getVersion());
        Liangzaiinfo liangzaiinfo = liangzaiinfoService.selectLiangzaiinfoById(1L);
        mmap.put("liangzaiinfo", liangzaiinfo);
        TeachingCourse teachingCourse = new TeachingCourse();
        PageHelper.startPage(1, 10);
        List<TeachingCourse> list = teachingCourseService.selectTeachingCourseList(teachingCourse);
        mmap.put("Construct",1);
        mmap.put("sizes",10);
        mmap.put("course",list);
        return "home";
    }
}
