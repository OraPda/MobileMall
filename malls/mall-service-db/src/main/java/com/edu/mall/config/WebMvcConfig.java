package com.edu.mall.config;

import com.edu.mall.interceptor.TokenInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /*registry.addInterceptor(new TokenInterceptor()).addPathPatterns("/api/cart/**","/api/user/**");*/
    }
}
