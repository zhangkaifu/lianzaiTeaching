package com.ruoyi.project.system.liangzaiinfo.service;

import java.util.List;
import com.ruoyi.project.system.liangzaiinfo.domain.Liangzaiinfo;

/**
 * 网站信息Service接口
 * 
 * @author zhangkaifu
 * @date 2020-09-30
 */
public interface ILiangzaiinfoService 
{
    /**
     * 查询网站信息
     * 
     * @param id 网站信息ID
     * @return 网站信息
     */
    public Liangzaiinfo selectLiangzaiinfoById(Long id);

    /**
     * 查询网站信息列表
     * 
     * @param liangzaiinfo 网站信息
     * @return 网站信息集合
     */
    public List<Liangzaiinfo> selectLiangzaiinfoList(Liangzaiinfo liangzaiinfo);

    /**
     * 新增网站信息
     * 
     * @param liangzaiinfo 网站信息
     * @return 结果
     */
    public int insertLiangzaiinfo(Liangzaiinfo liangzaiinfo);

    /**
     * 修改网站信息
     * 
     * @param liangzaiinfo 网站信息
     * @return 结果
     */
    public int updateLiangzaiinfo(Liangzaiinfo liangzaiinfo);

    /**
     * 批量删除网站信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteLiangzaiinfoByIds(String ids);

    /**
     * 删除网站信息信息
     * 
     * @param id 网站信息ID
     * @return 结果
     */
    public int deleteLiangzaiinfoById(Long id);
}
