package club.yunzhi.cloud.service.impl;

import club.yunzhi.cloud.CourseInfo;
import club.yunzhi.cloud.entity.Course;
import club.yunzhi.cloud.repository.CourseRepository;
import club.yunzhi.cloud.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.persistence.EntityNotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public CourseInfo getCourseInfo(Long id) {
        Course course = courseRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return course.buildCourseInfo();
    }

    @Override
    public List<CourseInfo> getCourseInfo(List<Long> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return Collections.emptyList();
        }

        return courseRepository
                .findAllById(ids)
                .stream()
                .map(Course::buildCourseInfo)
                .collect(Collectors.toList());
    }
}
