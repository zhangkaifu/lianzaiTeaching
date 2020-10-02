package com.ruoyi.project.system.liangzaiinfo.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 网站信息对象 liangzaiinfo
 * 
 * @author zhangkaifu
 * @date 2020-09-30
 */
public class Liangzaiinfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 网名 */
    @Excel(name = "网名")
    private String title;

    /** logo */
    @Excel(name = "logo")
    private String logourl;

    /** 背景图 */
    @Excel(name = "背景图")
    private String bkgurl;

    /** 个人简历图 */
    @Excel(name = "个人简历图")
    private String personurl;

    /** 个人简历文件 */
    @Excel(name = "个人简历文件")
    private String personfile;

    /** 备注 */
    @Excel(name = "备注")
    private String makers;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getTitle()
    {
        return title;
    }
    public void setLogourl(String logourl)
    {
        this.logourl = logourl;
    }

    public String getLogourl()
    {
        return logourl;
    }
    public void setBkgurl(String bkgurl)
    {
        this.bkgurl = bkgurl;
    }

    public String getBkgurl()
    {
        return bkgurl;
    }
    public void setPersonurl(String personurl)
    {
        this.personurl = personurl;
    }

    public String getPersonurl()
    {
        return personurl;
    }
    public void setPersonfile(String personfile)
    {
        this.personfile = personfile;
    }

    public String getPersonfile()
    {
        return personfile;
    }
    public void setMakers(String makers)
    {
        this.makers = makers;
    }

    public String getMakers()
    {
        return makers;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("title", getTitle())
            .append("logourl", getLogourl())
            .append("bkgurl", getBkgurl())
            .append("personurl", getPersonurl())
            .append("personfile", getPersonfile())
            .append("makers", getMakers())
            .toString();
    }
}
