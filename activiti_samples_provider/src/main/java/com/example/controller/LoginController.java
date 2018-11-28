package com.example.controller;

import com.example.config.ResponseData;
import com.example.constant.Constants;
import com.example.model.ssm.UserInf;
import com.example.service.ssm.UserInfService;
import com.example.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author ywyw2424@foxmail.com
 * @date 2018/9/21 10:37
 * @desc 登录用户将之前用户挤出
 */
@RestController
public class LoginController {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private UserInfService userInfService;

    @RequestMapping(value = "/doLoging",method = RequestMethod.POST)
    public ResponseData doLoging(HttpServletRequest request, @RequestParam("username") String username, @RequestParam("password") String password){
        HttpSession session = request.getSession();
        Map<String,Object> sessionIdKey = (Map<String, Object>) session.getAttribute(Constants.SESSION_ID_KEY);
        if(sessionIdKey != null){
            //已登录
            return ResponseData.failure("已登录，请勿重复登录...");
        }
        UserInf userInf = userInfService.findUserInfByUname(username);
        if(userInf != null){
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            if(bCryptPasswordEncoder.matches(password,userInf.getPassword())){
                //校验通过  存入session以及redis ，过期时间30分钟
                String sessionId = session.getId();
                session.setMaxInactiveInterval(Constants.SESSION_EXPIRES_MIN*60);
                Map<String,Object> map = new HashMap<>();
                map.put(Constants.SESSION_ID,sessionId);
                map.put(Constants.USER,userInf);
                session.setAttribute(Constants.SESSION_ID_KEY,map);
                redisUtil.set(new StringBuffer(Constants.SESSION_ID_KEY).append("_").append(userInf.getId()).toString() ,map,Constants.SESSION_EXPIRES_MIN, TimeUnit.MINUTES);
//                redisUtil.set(Constants.SESSION_ID_KEY,sessionId,Constants.SESSION_EXPIRES_MIN, TimeUnit.MINUTES);
                return ResponseData.success();
            }else{
                return ResponseData.failure("用户名或密码错误");
            }
        }
        return ResponseData.failure("当前用户为注册啊...");
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public ResponseData register(@RequestBody @Validated UserInf userInf, BindingResult result){
        if(result.hasErrors()){
            List<ObjectError> allErrors = result.getAllErrors();
            StringBuffer msg = new StringBuffer();
            allErrors.forEach(objectError -> {
                msg.append(objectError.getDefaultMessage());
            });
            return ResponseData.failure(msg.toString());
        }
        //注册
        return ResponseData.success();
    }
}
