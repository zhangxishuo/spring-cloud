package club.yunzhi.cloud.client;

import club.yunzhi.cloud.CourseInfo;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * 熔断降级策略
 */
@Component
public class CourseClientHystrix implements CourseClient {

    @Override
    public CourseInfo getCourseInfo(Long id) {
        return new CourseInfo();
    }

    @Override
    public List<CourseInfo> getCourseInfo(List<Long> ids) {
        return Collections.emptyList();
    }
}
