package com.ljtao.RESTfulspringboot.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

//异常处理的注解
@ControllerAdvice
public class MyControllerAdvice {
    /*
    全局捕获异常类，只要作用在@RequestMapping方法上，所有的异常信息都能捕获到
     */
    @ResponseBody
    @ExceptionHandler(value = BussinesException.class)
    public Map<String,Object> errorHandler(BussinesException ex){
        Map<String,Object> map=new HashMap<>();
        map.put("code",ex.getCode());
        map.put("msg",ex.getMsg());
        return map;


    }
    public static void main(String[] args) {

    }
}
