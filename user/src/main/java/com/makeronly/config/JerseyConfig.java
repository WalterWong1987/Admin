package com.makeronly.config;

import com.alibaba.fastjson.support.jaxrs.FastJsonFeature;
import com.makeronly.common.filter.CorsFilter;
import com.makeronly.user.resource.AccountResource;
import com.makeronly.user.resource.UserResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;
import org.springframework.stereotype.Component;

/**
 * Jersey配置类
 * @author Walter Wong
 */
@Component
public class JerseyConfig extends ResourceConfig {
    /**
     * 注册服务，使其识别JAX-RS注解
     */
    public JerseyConfig() {
        register(RequestContextFilter.class);
        //注册跨域过滤器
        register(CorsFilter.class);
        //使用fastJson作为Json序列化工具，不需要可以去掉，使用官方提供的jackson工具
        register(FastJsonFeature.class);

        register(UserResource.class);
        register(AccountResource.class);
    }
}
