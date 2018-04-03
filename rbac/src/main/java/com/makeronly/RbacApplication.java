package com.makeronly;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Walter Wong
 */
@EnableDiscoveryClient
@EnableTransactionManagement
@MapperScan({"com.makeronly.*.repo","com.makeronly.rbac.*.repo"})
@SpringBootApplication
public class RbacApplication {

	public static void main(String[] args) {
		SpringApplication.run(RbacApplication.class, args);
	}
}
