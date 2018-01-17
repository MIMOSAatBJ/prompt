package com.mimosa.common.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class BaseController {
    private static final Logger logger = LogManager.getLogger(BaseController.class);
    /**
     * @param request
     * @return
     * @DESC 从request对象中获取参数，返回参数一定不会为null
     * @author zhangH
     * @date 2016年10月25日
     * @version
     */
    protected Map<String, String> getparmMap(HttpServletRequest request) {
        Enumeration<String> names = request.getParameterNames();
        Map<String, String> parms = new HashMap<>();
        while (names.hasMoreElements()) {
            String key = names.nextElement();
            String value = request.getParameter(key);
            parms.put(key, value);
        }
        logger.debug("received parms:" + parms);
        return parms;
    }


    /**
     * @param response
     * @DESC 通过response的writer写出内容
     * @author zH
     * @date 2017年10月25日
     * @version
     */
    protected void write(HttpServletResponse response, String str) {
        try {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter pw = response.getWriter();
            pw.write(str);
            pw.close();
        } catch (IOException e) {
            logger.error("write Exception:" + e.getClass().getSimpleName());
        }

    }

    /**
     * @param request
     * @param key     cookie的key
     * @return
     * @DESC 从客户端对象中拿到想要的cookie
     * @author zH
     * @date 2017年11月1日
     * @version
     */
    protected Cookie getCookie(HttpServletRequest request, String key) {
        Cookie[] cookies = request.getCookies();
        Cookie cookie = null;
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (key.equalsIgnoreCase(c.getName())) {
                    cookie = c;
                    break;
                }
            }
        }
        return cookie;
    }

    /**
     * @param key
     * @param value  存储的值
     * @param maxage 生命周期，时间是秒
     * @return
     * @DESC 创建一个cookie
     * @author zhangH
     * @date 2016年11月1日
     * @version
     */
    protected Cookie createCookie(String key, String value, Integer maxage) {
        Cookie cookie = new Cookie(key, value);
        cookie.setMaxAge(maxage);
        cookie.setPath("/");
        return cookie;
    }
}
