package com.java4all;

import org.bytesoft.bytetcc.supports.springcloud.config.SpringCloudSecondaryConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Import;
/**
 * 按请求粒度负载均衡(使用MongoDB存储事务日志):需引入SpringCloudConfiguration;
 * 按事务粒度负载均衡(使用文件系统存储事务日志):需引入SpringCloudSecondaryConfiguration;
 */
@EnableEurekaClient
@SpringBootApplication(scanBasePackages = "com.java4all")
@MapperScan("com.java4all.dao")
@Import(SpringCloudSecondaryConfiguration.class)
@EnableAutoConfiguration(exclude = {MongoAutoConfiguration.class})
//使用文件存储时，不需要配置mongodb
public class UserServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServerApplication.class, args);
	}

}

