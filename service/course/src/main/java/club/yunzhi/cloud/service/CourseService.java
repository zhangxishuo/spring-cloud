package club.yunzhi.cloud.service;

import club.yunzhi.cloud.CourseInfo;

import java.util.List;

public interface CourseService {

    /**
     * 通过 id 获取课程信息
     */
    CourseInfo getCourseInfo(Long id);

    /**
     * 通过 ids 获取课程列表
     */
    List<CourseInfo> getCourseInfo(List<Long> ids);
}
