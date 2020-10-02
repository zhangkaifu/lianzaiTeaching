package com.ruoyi.project.system.liangzaiinfo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.liangzaiinfo.mapper.LiangzaiinfoMapper;
import com.ruoyi.project.system.liangzaiinfo.domain.Liangzaiinfo;
import com.ruoyi.project.system.liangzaiinfo.service.ILiangzaiinfoService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 网站信息Service业务层处理
 * 
 * @author zhangkaifu
 * @date 2020-09-30
 */
@Service
public class LiangzaiinfoServiceImpl implements ILiangzaiinfoService 
{
    @Autowired
    private LiangzaiinfoMapper liangzaiinfoMapper;

    /**
     * 查询网站信息
     * 
     * @param id 网站信息ID
     * @return 网站信息
     */
    @Override
    public Liangzaiinfo selectLiangzaiinfoById(Long id)
    {
        return liangzaiinfoMapper.selectLiangzaiinfoById(id);
    }

    /**
     * 查询网站信息列表
     * 
     * @param liangzaiinfo 网站信息
     * @return 网站信息
     */
    @Override
    public List<Liangzaiinfo> selectLiangzaiinfoList(Liangzaiinfo liangzaiinfo)
    {
        return liangzaiinfoMapper.selectLiangzaiinfoList(liangzaiinfo);
    }

    /**
     * 新增网站信息
     * 
     * @param liangzaiinfo 网站信息
     * @return 结果
     */
    @Override
    public int insertLiangzaiinfo(Liangzaiinfo liangzaiinfo)
    {
        return liangzaiinfoMapper.insertLiangzaiinfo(liangzaiinfo);
    }

    /**
     * 修改网站信息
     * 
     * @param liangzaiinfo 网站信息
     * @return 结果
     */
    @Override
    public int updateLiangzaiinfo(Liangzaiinfo liangzaiinfo)
    {
        return liangzaiinfoMapper.updateLiangzaiinfo(liangzaiinfo);
    }

    /**
     * 删除网站信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLiangzaiinfoByIds(String ids)
    {
        return liangzaiinfoMapper.deleteLiangzaiinfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除网站信息信息
     * 
     * @param id 网站信息ID
     * @return 结果
     */
    @Override
    public int deleteLiangzaiinfoById(Long id)
    {
        return liangzaiinfoMapper.deleteLiangzaiinfoById(id);
    }
}
