package com.xiangyang.application;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories(basePackages = {"com.xiangyang.model","com.xiangyang.service"})
//@ComponentScan(basePackages = {"com.xiangyang.model","com.xiangyang.service"})
@EntityScan(basePackages = {"com.xiangyang.model"})
@EnableJpaRepositories(basePackages = {"com.xiangyang.service"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
