package com.example.spring.interceptor.handlerinterceptor.config;

import com.example.spring.interceptor.handlerinterceptor.interceptors.MyHandlerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer
{

    // ============================== [Fields] ==============================

    // -------------------- [Private Fields] --------------------

    @Autowired
    private MyHandlerInterceptor myHandlerInterceptor;

    // ============================== [Construction / Destruction] ==============================

    // -------------------- [Public Construction / Destruction] --------------------

    // ============================== [Getter/Setter] ==============================

    // -------------------- [Private Getter/Setter] --------------------

    // -------------------- [Public Getter/Setter] --------------------

    // ============================== [Methods] ==============================

    // -------------------- [Private Methods] --------------------

    // -------------------- [Public Methods] --------------------

    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {
        registry.addInterceptor(this.myHandlerInterceptor);
    }
}
