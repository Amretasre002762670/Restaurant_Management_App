package com.webtools.ResManageApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@ComponentScan({"com.webtools.ResManageApp.controller", "com.webtools.ResManageApp.pojo, com.webtools.ResManageApp.DAO", "com.webtools.ResManageApp.utils", "com.webtools.ResManageApp.validator"})
public class ResManageAppApplication extends SpringBootServletInitializer implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(ResManageAppApplication.class, args);
	}
	
	// add welcome file
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("welcome");
	}
	

}
