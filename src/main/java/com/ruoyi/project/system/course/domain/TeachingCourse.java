package com.ruoyi.project.system.course.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 课程对象 teaching_course
 * 
 * @author zhangkaifu
 * @date 2020-09-30
 */
public class TeachingCourse extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    @Excel(name = "id")
    private Long id;

    /** 年级 */
    @Excel(name = "年级")
    private String grade;

    /** 课程名称 */
    @Excel(name = "课程名称")
    private String courses;

    /** 章节名称 */
    @Excel(name = "章节名称")
    private String chapter;

    /** 小节名称 */
    @Excel(name = "小节名称")
    private String section;

    /** 授课老师 */
    @Excel(name = "授课老师")
    private String teacher;

    /** 课程简介 */
    @Excel(name = "课程简介")
    private String synopsis;

    /** 视频url */
    @Excel(name = "视频url")
    private String videosUrl;

    /** 二维码url */
    @Excel(name = "二维码url")
    private String erUrl;

    /** 封面url */
    @Excel(name = "封面url")
    private String imgUrl;

    /** 课程类别 */
    @Excel(name = "课程类别")
    private String label;

    /** 上传者 */
    @Excel(name = "上传者")
    private String craeateUser;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setGrade(String grade)
    {
        this.grade = grade;
    }

    public String getGrade()
    {
        return grade;
    }
    public void setCourses(String courses)
    {
        this.courses = courses;
    }

    public String getCourses()
    {
        return courses;
    }
    public void setChapter(String chapter)
    {
        this.chapter = chapter;
    }

    public String getChapter()
    {
        return chapter;
    }
    public void setSection(String section)
    {
        this.section = section;
    }

    public String getSection()
    {
        return section;
    }
    public void setTeacher(String teacher)
    {
        this.teacher = teacher;
    }

    public String getTeacher()
    {
        return teacher;
    }
    public void setSynopsis(String synopsis)
    {
        this.synopsis = synopsis;
    }

    public String getSynopsis()
    {
        return synopsis;
    }
    public void setVideosUrl(String videosUrl)
    {
        this.videosUrl = videosUrl;
    }

    public String getVideosUrl()
    {
        return videosUrl;
    }
    public void setErUrl(String erUrl)
    {
        this.erUrl = erUrl;
    }

    public String getErUrl()
    {
        return erUrl;
    }
    public void setImgUrl(String imgUrl)
    {
        this.imgUrl = imgUrl;
    }

    public String getImgUrl()
    {
        return imgUrl;
    }
    public void setLabel(String label)
    {
        this.label = label;
    }

    public String getLabel()
    {
        return label;
    }
    public void setCraeateUser(String craeateUser)
    {
        this.craeateUser = craeateUser;
    }

    public String getCraeateUser()
    {
        return craeateUser;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("grade", getGrade())
            .append("courses", getCourses())
            .append("chapter", getChapter())
            .append("section", getSection())
            .append("teacher", getTeacher())
            .append("synopsis", getSynopsis())
            .append("videosUrl", getVideosUrl())
            .append("erUrl", getErUrl())
            .append("imgUrl", getImgUrl())
            .append("label", getLabel())
            .append("craeateUser", getCraeateUser())
            .append("createTime", getCreateTime())
            .toString();
    }
}
