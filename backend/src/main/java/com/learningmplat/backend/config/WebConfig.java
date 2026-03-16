package com.learningmplat.backend.config;

import com.learningmplat.backend.interceptor.JwtInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 系统的交通枢纽中心
 */
@Configuration // 告诉 Spring Boot 这是一个配置类，启动时必须加载
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 安排咱们刚才写的保安上岗
        registry.addInterceptor(new JwtInterceptor())
                // 1. 拦截所有的请求（/** 代表不管是 /user/list 还是 /course/add，全拦住）
                .addPathPatterns("/**")
                // 2. 极其重要：开通绿色通道！登录接口绝对不能拦，否则死循环了
                .excludePathPatterns(
                        "/user/login",          // 登录接口免检
                        "/swagger-ui/**",       // 网页 UI 免检
                        "/v3/api-docs/**",      // 接口数据免检
                        "/swagger-ui.html"      // 网页入口免检
                );
    }
}