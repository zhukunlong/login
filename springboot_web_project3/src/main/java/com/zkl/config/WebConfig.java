package com.zkl.config;

import com.zkl.filter.LoginCheckInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author zkl
 * @date 2023/4/29
 * @time 16:27
 **/
//@Configuration//当前类为配置类
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private LoginCheckInterceptor loginCheckInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       registry.addInterceptor(loginCheckInterceptor).addPathPatterns("/**").excludePathPatterns("/login2");
    }
}
