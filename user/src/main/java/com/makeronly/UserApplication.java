package com.makeronly;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author Walter Wong
 */
@EnableDiscoveryClient
@EnableTransactionManagement
@MapperScan("com.makeronly.user.repo")
@SpringBootApplication
public class UserApplication {
	@Bean(name = "default")
	public PlatformTransactionManager defaultTxManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}
}
