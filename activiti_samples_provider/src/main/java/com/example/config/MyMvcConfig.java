package com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ywyw2424@foxmail.com
 * @date 2018/11/8 11:00
 * @desc
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("modeler");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/editor-app/**").addResourceLocations("classpath:/static/editor-app/");
        registry.addResourceHandler("/resources/**").addResourceLocations("classpath:/static/view/resources/");
        registry.addResourceHandler("/html/**").addResourceLocations("classpath:/static/view/html/");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:8081","null","*")
                .allowedMethods("GET","POST","PUT","DELETE","OPTIONS")
                .allowCredentials(true)
                .allowedHeaders("Content-Type","X-Token")
                .maxAge(3600L);//预检请求的有效期，单位为秒。
    }
}
