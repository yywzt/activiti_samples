package com.example.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yw
 * @create 2018-06-22 16:05
 * @description: 自定义的ErrorAttributes 自定义返回的json串
 */
@Slf4j
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {

    /*@Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        //获取系统已有的提示信息 timestamp status 等...
        Map<String, Object> map = super.getErrorAttributes(webRequest, includeStackTrace);
        //从request中获取自定义的数据
        map.remove("errors");
        map.remove("trace");
        map.remove("message");
        ResponseData info = (ResponseData) webRequest.getAttribute("info",0);
        map.put("info",info);
        return map;
    }*/
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        //获取系统已有的提示信息 timestamp status 等...
        Map<String, Object> map = super.getErrorAttributes(webRequest, includeStackTrace);
        //从request中获取自定义的数据
        log.error(new StringBuilder(map.get("status").toString()).append("-").append(map.get("message")).toString());
        String message = (String) webRequest.getAttribute("info", 0);
        Map<String, Object> objectMap = new HashMap<>(5);
        objectMap.put("path",map.get("path"));
        objectMap.put("status",map.get("status"));
        objectMap.put("error",map.get("error"));
        objectMap.put("success",false);
        objectMap.put("message",message);
        objectMap.put("timestamp",map.get("timestamp"));
        return objectMap;
    }
}
