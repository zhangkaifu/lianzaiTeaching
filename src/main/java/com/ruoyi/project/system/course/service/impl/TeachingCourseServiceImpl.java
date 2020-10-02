package com.ruoyi.project.system.course.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.course.mapper.TeachingCourseMapper;
import com.ruoyi.project.system.course.domain.TeachingCourse;
import com.ruoyi.project.system.course.service.ITeachingCourseService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 课程Service业务层处理
 * 
 * @author zhangkaifu
 * @date 2020-09-30
 */
@Service
public class TeachingCourseServiceImpl implements ITeachingCourseService 
{
    @Autowired
    private TeachingCourseMapper teachingCourseMapper;

    /**
     * 查询课程
     * 
     * @param id 课程ID
     * @return 课程
     */
    @Override
    public TeachingCourse selectTeachingCourseById(Long id)
    {
        return teachingCourseMapper.selectTeachingCourseById(id);
    }

    /**
     * 查询课程列表
     * 
     * @param teachingCourse 课程
     * @return 课程
     */
    @Override
    public List<TeachingCourse> selectTeachingCourseList(TeachingCourse teachingCourse)
    {
        return teachingCourseMapper.selectTeachingCourseList(teachingCourse);
    }

    /**
     * 新增课程
     * 
     * @param teachingCourse 课程
     * @return 结果
     */
    @Override
    public int insertTeachingCourse(TeachingCourse teachingCourse)
    {
        teachingCourse.setCreateTime(DateUtils.getNowDate());
        return teachingCourseMapper.insertTeachingCourse(teachingCourse);
    }

    /**
     * 修改课程
     * 
     * @param teachingCourse 课程
     * @return 结果
     */
    @Override
    public int updateTeachingCourse(TeachingCourse teachingCourse)
    {
        return teachingCourseMapper.updateTeachingCourse(teachingCourse);
    }

    /**
     * 删除课程对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTeachingCourseByIds(String ids)
    {
        return teachingCourseMapper.deleteTeachingCourseByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除课程信息
     * 
     * @param id 课程ID
     * @return 结果
     */
    @Override
    public int deleteTeachingCourseById(Long id)
    {
        return teachingCourseMapper.deleteTeachingCourseById(id);
    }
}
