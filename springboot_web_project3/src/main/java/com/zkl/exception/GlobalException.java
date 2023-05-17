package com.zkl.exception;

import com.zkl.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author zkl
 * @date 2023/4/30
 * @time 12:00
 **/
@RestControllerAdvice
//全局异常处理器
public class GlobalException {
    @ExceptionHandler(Exception.class)
    public Result ex(Exception exception){
        exception.printStackTrace();
        return Result.error("404");
    }
}
