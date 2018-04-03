package com.makeronly.config;

import com.alibaba.fastjson.support.jaxrs.FastJsonFeature;
import com.makeronly.common.filter.CorsFilter;
import com.makeronly.nav.resource.NavigationResource;
import com.makeronly.rbac.resource.RoleResource;
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
        register(CorsFilter.class);
        //使用fastJson作为Json序列化工具，不需要可以去掉，使用官方提供的jackson工具
        register(FastJsonFeature.class);
        register(NavigationResource.class);
        register(RoleResource.class);
    }

}
