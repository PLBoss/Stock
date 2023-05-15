package com.raw.stock.config;

import com.raw.stock.controller.intercepter.LoginIntercepter;

import com.raw.stock.controller.intercepter.LoginRequireIntercepter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class webConfig implements WebMvcConfigurer {

    @Autowired
    private LoginIntercepter loginIntercepter;

    @Autowired
    private LoginRequireIntercepter loginRequireIntercepter;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginIntercepter);

        registry.addInterceptor(loginRequireIntercepter);

    }
}
