package com.example.config;

import com.example.servlet.JsonpCallbackFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

import javax.servlet.Filter;

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

    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(new JsonpCallbackFilter());
        filterFilterRegistrationBean.addUrlPatterns("/*");
        filterFilterRegistrationBean.setName("jsonpCallbackFilter");
        filterFilterRegistrationBean.setOrder(1);
        return  filterFilterRegistrationBean;
    }
}
