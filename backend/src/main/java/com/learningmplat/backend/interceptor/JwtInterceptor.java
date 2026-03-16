package com.learningmplat.backend.interceptor;

import com.learningmplat.backend.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * JWT 拦截器（系统的安保大队长）
 */
public class JwtInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 1. 从前端发来的请求头（Header）里，找一个叫 "token" 的东西
        String token = request.getHeader("token");

        // 2. 如果他根本没带手环（没传 token）
        if (token == null || token.trim().isEmpty()) {
            // 直接抛出异常！咱们的 GlobalExceptionHandler 会完美接住它，并优雅地返回给前端
            throw new RuntimeException("无访问权限，请先登录！");
        }

        // 3. 如果带了手环，我们就用 JwtUtils 验明真伪
        try {
            JwtUtils.parseToken(token);
            // 验明正身！放行，允许他去访问真实的接口（比如 /user/list）
            return true;
        } catch (Exception e) {
            // 如果手环是伪造的，或者时间太长过期了，直接拦截！
            throw new RuntimeException("Token无效或已过期，请重新登录！");
        }
    }
}