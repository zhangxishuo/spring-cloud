package club.yunzhi.cloud.controller;

import club.yunzhi.cloud.CourseInfo;
import club.yunzhi.cloud.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 课程对外服务接口
 */
@Slf4j
@RestController
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("{id}")
    public CourseInfo getCourseInfo(@PathVariable Long id) {
        log.info("course: get course -> {}", id);
        return courseService.getCourseInfo(id);
    }

    @GetMapping("batch/{ids}")
    public List<CourseInfo> getCourseInfo(@PathVariable List<Long> ids){
        return courseService.getCourseInfo(ids);
    }
}
