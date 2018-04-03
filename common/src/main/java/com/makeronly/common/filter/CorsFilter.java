package com.makeronly.common.filter;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

/**
 * 跨域过滤器
 * @author Walter Wong
 */
@Provider
public class CorsFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        // 允许跨域的请求头
        final String Access_Control_Allow_Headers = "origin, content-type, accept, authorization, X-Token";
        // 允许跨域
        responseContext.getHeaders().add("Access-Control-Allow-Origin", "*");
        // 允许的Header值，不支持通配符
        responseContext.getHeaders().add("Access-Control-Allow-Headers", Access_Control_Allow_Headers);
        responseContext.getHeaders().add("Access-Control-Allow-Credentials", "true");
        // 即使只用其中几种，header和options是不能删除的，因为浏览器通过options请求来获取服务的跨域策略
        responseContext.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
        // CORS策略的缓存时间
        responseContext.getHeaders().add("Access-Control-Max-Age", "1209600");
    }
}
