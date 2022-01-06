package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        // 윈도우용 설정
        // registry.addResourceHandler("/upload/**").addResourceLocations("file:///C:/upload/");

        // 리눅스용 설정
        registry.addResourceHandler("/upload/**").addResourceLocations("file:///upload/");
    }

//    @Bean
//    public AuthorizationInterceptor authorizationIInterceptor() {
//        return new AuthorizationInterceptor();
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(authorizationIInterceptor());
//    }

}
