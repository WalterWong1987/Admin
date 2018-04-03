package com.makeronly.registrycenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Eureka注册中心
 * @author Walter Wong
 */
@EnableEurekaServer
@SpringBootApplication
public class RegistryCenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistryCenterApplication.class, args);
	}
}
