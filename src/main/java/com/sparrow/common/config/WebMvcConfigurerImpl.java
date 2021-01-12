package com.sparrow.common.config;

import com.sparrow.common.interceptor.AuthenticationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

/**
 * @Description
 * @Author RanGooooo
 * @date 2020.03.15 15:33
 */
@Configuration
public class WebMvcConfigurerImpl implements WebMvcConfigurer {

    @Autowired
    private AuthenticationInterceptor authenticationInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /*权限拦截器*/
        List<String> authenticationExcludePath = Arrays.asList(
                "/TSLoginController/login",
                "/TSLoginController/validate",
                "/static/**");
        //registry.addInterceptor(authenticationInterceptor).addPathPatterns("/**").excludePathPatterns(authenticationExcludePath);

        registry.addInterceptor(authenticationInterceptor)
                .excludePathPatterns(authenticationExcludePath)
                .addPathPatterns("/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
          registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }
}
