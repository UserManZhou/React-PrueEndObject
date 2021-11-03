package com.gec.amolpsw.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class AuthFilter extends ZuulFilter {
    /*
     * Zuul有一下四种过滤器
     * "pre":是在请求路由到具体的服务之前执行,这种类型的过滤器可以做安全校验,例如身份校验,参数校验等
     * "routing":它用于将请求路由到具体的微服务实例,在默认情况下,它使用Http Client进行网络请求
     * "post":它是在请求已被路由到微服务后执行,一般情况下,用作收集统计信息,指标,以及将响应传输到客户
     * "error":它是在其他过滤器发生错误时执行
     */
    @Override
    public String filterType() {
        return "pre";
    }
    /**
     * 过滤顺序,值越小,越早执行该过滤器
     * @return
     */
    @Override
    public int filterOrder() {
        // 过滤的顺序
        return 0;
    }
    /**	开关
     * 表示该过滤器是否过滤逻辑,如果是ture,则执行run()方法;如果是false,则不执行run()方法.
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }
    /***
     **网关真正的逻辑部分
     */
    @Override
    public Object run() throws ZuulException {
        //获得请求的上下文
        RequestContext requestContext = RequestContext.getCurrentContext();
        //从请求中获取request域
        HttpServletRequest request = requestContext.getRequest();
        //从request域里面获得Authorization字段下的值（我就是放Bearer + token信息）
        String header = request.getHeader("Authorization");
        if(null != header && !"".equals(header)){
            //把信息头转发到下一个微服务
            //requestContext.addZuulRequestHeader("Authorization",header);
            requestContext.addZuulRequestHeader("header",header);
        }
        return null;
    }
}
