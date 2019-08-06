package club.yunzhi.cloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

/**
 * 在过滤器中存储客户端发起请求的时间戳
 */
@Component
public class PreRequestFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /**
     * 过滤器顺序，数字越小，优先级越高
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否启用当前过滤器
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        // RequestContext 用于在过滤器之间传递消息
        RequestContext context = RequestContext.getCurrentContext();
        context.set("startTime", System.currentTimeMillis());

        return null;
    }
}
