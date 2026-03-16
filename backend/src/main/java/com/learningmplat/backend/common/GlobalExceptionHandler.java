package com.learningmplat.backend.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器（系统的防弹衣）
 */
@Slf4j // Lombok 提供的日志注解，方便我们在后台打印详细报错
@RestControllerAdvice // 这个注解是核心：告诉 Spring，只要系统里抛出异常，全归这里管！
public class GlobalExceptionHandler {

    /**
     * 捕获所有未知的 Exception 异常
     */
    @ExceptionHandler(Exception.class)
    public Result<String> handleException(Exception e) {
        // 1. 在后台控制台打印出红色的详细错误日志，方便咱们自己修 Bug
        log.error("系统出现异常：", e);

        // 2. 给前端返回一个极其优雅的统一格式包装盒
        return Result.error("服务器开小差了，请稍后再试或联系管理员！");
    }

    /**
     * 这里其实还可以写很多专属异常的拦截
     * 比如：专门拦截“参数校验失败异常”、专门拦截“未登录异常”等
     * 咱们先用一个兜底的 Exception.class 把所有错误全网打尽
     */
}