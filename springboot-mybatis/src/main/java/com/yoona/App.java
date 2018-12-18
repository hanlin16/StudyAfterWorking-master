package com.yoona;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@ComponentScan(basePackages="com.yoona.*")
@SpringBootApplication
@MapperScan("com.yoona.dao")
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}



//	解决跨域问题
	@Bean
	public WebMvcConfigurer webMvcConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*");
			}
		};
	}



}
