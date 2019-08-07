package club.yunzhi.cloud.client;

import club.yunzhi.cloud.CourseInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * fallback 兜底策略
 */
@FeignClient(value = "course",
        fallback = CourseClientHystrix.class)
public interface CourseClient {

    @GetMapping(value = "/course/{id}")
    CourseInfo getCourseInfo(@PathVariable Long id);

    @GetMapping(value = "/course/batch/{ids}")
    List<CourseInfo> getCourseInfo(@PathVariable List<Long> ids);
}
