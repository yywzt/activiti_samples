package com.example.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author ywyw2424@foxmail.com
 * @date 2018/11/28 9:30
 * @desc controller日志切面
 */
@Component
@Aspect
@Slf4j
public class LogAspect {

    @Pointcut("execution(public * com.example..*.*Controller.*(..))")
    public void log(){

    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        log.info("-------------------用户发起请求-----------------");
        // 记录下请求内容
        log.info("URL : " + request.getRequestURL().toString());
        log.info("HTTP_METHOD : " + request.getMethod());
        // 如果是表单，参数值是普通键值对。如果是application/json，则request.getParameter是取不到的。
        log.info("HTTP_HEAD Type : " + request.getHeader("Content-Type"));
        log.info("IP : " + request.getRemoteAddr());
        log.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        if ("application/json".equals(request.getHeader("Content-Type"))) {
        // 记录application/json时的传参，SpringMVC中使用@RequestBody接收的值
//            log.info(getRequestPayload(request));
        } else {
            //记录请求的键值对
            for (String key : request.getParameterMap().keySet()) {
                log.info(key + "----" + request.getParameter(key));
            }
        }

        System.out.println("前置通知");
    }

    @AfterReturning(returning = "ret",pointcut = "log()")
    public void doReturn(Object ret){
        log.info("方法返回值是：" + ret);
        System.out.println("返回通知");
    }

    @AfterThrowing(throwing = "ex",pointcut = "log()")
    public void afterThrowing(JoinPoint joinPoint, Exception ex){
        System.out.println("异常通知");
    }

    @After("log()")
    public void doAfter(JoinPoint joinPoint){
        System.out.println("后置通知");
    }

    private String getRequestPayload(HttpServletRequest req) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader reader = req.getReader();
            char[] buff = new char[1024];
            int len;
            while ((len = reader.read(buff)) != -1) {
                sb.append(buff,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return e.getMessage();
        }

        return sb.toString();
    }

}
