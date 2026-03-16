package com.learningmplat.backend.common;

import lombok.Data;

/**
 * 全局统一返回结果类
 */
@Data // 用 Lombok 自动生成 Get/Set 方法，代码极其清爽
public class Result<T> {

    private Integer code; // 状态码：200代表成功，500代表后台报错
    private String message; // 提示信息
    private T data; // 真正要返回的数据

    private Result() {}

    // 成功时的快捷方法
    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setMessage("操作成功");
        result.setData(data);
        return result;
    }

    public static <T> Result<T> success() {
        return success(null);
    }

    // 失败时的快捷方法
    public static <T> Result<T> error(String message) {
        Result<T> result = new Result<>();
        result.setCode(500);
        result.setMessage(message);
        return result;
    }
}