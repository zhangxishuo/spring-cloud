package club.yunzhi.cloud.service.impl;

import club.yunzhi.cloud.CourseInfo;
import club.yunzhi.cloud.repository.CourseRepository;
import club.yunzhi.cloud.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public CourseInfo getCourseInfo(Long id) {
        return null;
    }

    @Override
    public List<CourseInfo> getCourseInfo(List<Long> ids) {
        return null;
    }
}
