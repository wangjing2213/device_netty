package com.dearho.result;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.dearho.exception.BusinessException;

/**
 * 统一错误码异常处理
 *
 * Created by bysocket on 14/03/2017.
 */
@RestControllerAdvice
public class GlobalErrorInfoHandler {

    @ExceptionHandler(value = BusinessException.class)
    public JSONResult errorHandlerOverJson(HttpServletRequest request,
    		BusinessException exception) {

    	JSONResult result = JSONResult.AppFailJSONResult(exception.getMessage());
        return result;
    }
    
    @ExceptionHandler(value = Exception.class)
    public JSONResult errorHandlerOverJson(HttpServletRequest request,
    		Exception exception) {
    	JSONResult result =null;
    	if (exception instanceof org.springframework.web.servlet.NoHandlerFoundException) {
    		result = JSONResult.AppFailJSONResult("404");
        }else{
        	exception.printStackTrace();
        	result = JSONResult.AppFailJSONResult(exception.getMessage());
        }
        return result;
    }
}
