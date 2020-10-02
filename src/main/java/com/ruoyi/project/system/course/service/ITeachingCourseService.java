package com.ruoyi.project.system.course.service;

import java.util.List;
import com.ruoyi.project.system.course.domain.TeachingCourse;

/**
 * 课程Service接口
 * 
 * @author zhangkaifu
 * @date 2020-09-30
 */
public interface ITeachingCourseService 
{
    /**
     * 查询课程
     * 
     * @param id 课程ID
     * @return 课程
     */
    public TeachingCourse selectTeachingCourseById(Long id);

    /**
     * 查询课程列表
     * 
     * @param teachingCourse 课程
     * @return 课程集合
     */
    public List<TeachingCourse> selectTeachingCourseList(TeachingCourse teachingCourse);

    /**
     * 新增课程
     * 
     * @param teachingCourse 课程
     * @return 结果
     */
    public int insertTeachingCourse(TeachingCourse teachingCourse);

    /**
     * 修改课程
     * 
     * @param teachingCourse 课程
     * @return 结果
     */
    public int updateTeachingCourse(TeachingCourse teachingCourse);

    /**
     * 批量删除课程
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTeachingCourseByIds(String ids);

    /**
     * 删除课程信息
     * 
     * @param id 课程ID
     * @return 结果
     */
    public int deleteTeachingCourseById(Long id);
}
