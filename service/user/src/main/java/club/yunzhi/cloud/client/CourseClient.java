package club.yunzhi.cloud.client;

import club.yunzhi.cloud.CourseInfo;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * fallback 兜底策略
 */
@FeignClient(value = "course",
        fallback = CourseClientHystrix.class)
public interface CourseClient {

    @GetMapping(value = "{id}")
    CourseInfo getCourseInfo(@PathVariable Long id);

    @GetMapping(value = "batch")
    List<CourseInfo> getCourseInfo(@RequestParam List<Long> ids);
}
