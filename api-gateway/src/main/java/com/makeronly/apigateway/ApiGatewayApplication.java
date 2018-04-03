package com.makeronly.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.context.annotation.Bean;

/**
 * API网关入口类
 * @author Walter Wong
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ApiGatewayApplication {

    /**
     * 读取路由配置。指定从注册中心读取路由信息
     * <p>
     * RouteDefinitionLocator 负责读取路由配置( {@link org.springframework.cloud.gateway.route.RouteDefinition} )。
     * RouteDefinitionLocator 接口有四种实现：
     * <ul>
     *  <li>PropertiesRouteDefinitionLocator，从配置文件(例如，yaml和properties等)读取</li>
     *  <li>RouteDefinitionRepository ，从存储器( 例如，内存 / Redis / MySQL 等 )读取</li>
     *  <li>DiscoveryClientRouteDefinitionLocator ，从注册中心( 例如，Eureka / Consul / Zookeeper / Etcd 等 )读取</li>
     *  <li>CompositeRouteDefinitionLocator ，组合多种 RouteDefinitionLocator 的实现，为 RouteDefinitionRouteLocator 提供统一入口</li>
     * </ul>
     * </p>
     *
     * @param client DiscoveryClient
     * @return RouteDefinitionLocator
     */
    @Bean
    public RouteDefinitionLocator discoveryClientRouteDefinitionLocator(DiscoveryClient client) {
        return new DiscoveryClientRouteDefinitionLocator(client);
    }

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }
}
