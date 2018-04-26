package com.youzou;

import com.youzou.interceptor.loginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by 葉蔵 on 2018/4/21.
 */
@Configuration
public class HumanConfiguration implements WebMvcConfigurer {
    @Bean
    public loginInterceptor loginInterceptor(){
        return new loginInterceptor();
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor()).addPathPatterns("/interview/**").
        excludePathPatterns("/login","/login.do","/toLogin");
    }
}
