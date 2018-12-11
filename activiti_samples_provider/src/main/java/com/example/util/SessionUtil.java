package com.example.util;

import com.example.constant.Constants;
import com.example.exception.NoLoginException;
import com.example.model.ssm.UserInf;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author yanzt
 * @date 2018/12/3 20:50
 * @describe
 */
@Slf4j
public class SessionUtil {

    public static void setAttribute(HttpSession session, String key, Object data){
        session.setAttribute(key,data);
    }

    public static void setAttribute(HttpSession session, String key, Object data, int interval){
        session.setMaxInactiveInterval(interval);
        session.setAttribute(key,data);
    }

    public Object getAttribute(HttpSession session,String key){
        if (session != null && session.getAttribute(key) != null) {
            return session.getAttribute(key);
        }
        return null;
    }

    public static String getUserId(HttpSession session){
        if (session != null) {
            try {
                Map<String,Object> sessionAttribute = (Map<String, Object>) session.getAttribute(Constants.SESSION_ID_KEY);
                UserInf userInf = (UserInf) sessionAttribute.get(Constants.USER);
                return String.valueOf(userInf.getId());
            } catch (Exception e) {
                e.printStackTrace();
                log.error("获取userId失败：{}",e.getMessage());
                throw new NoLoginException("获取userId失败");
            }
        }
        return null;
    }
    public static String getUserName(HttpSession session){
        if (session != null) {
            try {
                Map<String,Object> sessionAttribute = (Map<String, Object>) session.getAttribute(Constants.SESSION_ID_KEY);
                UserInf userInf = (UserInf) sessionAttribute.get(Constants.USER);
                return userInf.getUsername();
            } catch (Exception e) {
                e.printStackTrace();
                log.error("获取userName失败：{}",e.getMessage());
                throw new NoLoginException("获取userId失败");
            }
        }
        return null;
    }

    public static boolean removeAttribute(HttpSession session,String key){
        try {
            session.removeAttribute(key);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
