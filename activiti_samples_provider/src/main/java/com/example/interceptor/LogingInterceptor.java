package com.example.interceptor;

import com.example.SpringUtils;
import com.example.constant.Constants;
import com.example.model.ssm.UserInf;
import com.example.util.RedisUtil;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author ywyw2424@foxmail.com
 * @date 2018/9/21 10:41
 * @desc
 */
@Component
public class LogingInterceptor implements HandlerInterceptor {

    private RedisUtil redisUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        redisUtil = SpringUtils.getBean("redisUtil", RedisUtil.class);
        HttpSession session = request.getSession();
        Map<String,Object> sessionIdKey = (Map<String, Object>) session.getAttribute(Constants.SESSION_ID_KEY);
        if(sessionIdKey != null){
            Object sessionId = sessionIdKey.get(Constants.SESSION_ID);
            UserInf userInf = (UserInf) sessionIdKey.get(Constants.USER);
            //与redis中校验是否一致
            Map<String,Object> redisSessionKey = (Map<String, Object>) this.redisUtil.get(new StringBuffer(Constants.SESSION_ID_KEY).append("_").append(userInf.getId()).toString());
            if(redisSessionKey!=null && redisSessionKey.get(Constants.SESSION_ID).equals(sessionId)){
                return true;
            }
            session.removeAttribute(Constants.SESSION_ID_KEY);
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
