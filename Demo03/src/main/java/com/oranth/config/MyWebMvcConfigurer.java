package com.oranth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {
    
	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
		// 开启路径后缀匹配
		configurer.setUseSuffixPatternMatch(true);
	}

	/**
	 * 配置图片的虚拟路径
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/products/wu/**").addResourceLocations("file:D:/products/wu/");
	}
}
