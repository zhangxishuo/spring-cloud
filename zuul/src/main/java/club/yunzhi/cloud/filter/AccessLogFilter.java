package club.yunzhi.cloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 自定义过滤器，打印请求响应时间
 */
@Slf4j
@Component
public class AccessLogFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.SEND_RESPONSE_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        // RequestContext 用于在过滤器之间传递消息
        RequestContext context = RequestContext.getCurrentContext();
        Long startTime = (Long) context.get("startTime");

        HttpServletRequest request = context.getRequest();
        String uri = request.getRequestURI();

        long duration = System.currentTimeMillis() - startTime;

        log.info("uri: {}, duration: {}ms", uri, duration / 100);

        return null;
    }
}
