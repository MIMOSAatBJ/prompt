package com.cicc.web.interceptor;

import com.cicc.common.base.Dict;
import com.cicc.common.exception.GlobalException;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthInterceptor implements HandlerInterceptor {
    private static final Logger LOGGER = LogManager.getLogger(HandlerInterceptor.class);

    /**
     * 项目环境
     */
    @Value("${project.env}")
    private String env;
    /**
     * 跳过验证
     */
    @Value("${skip.enable}")
    private String skip;


    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        if (Dict.Environment.dev.name().equalsIgnoreCase(env) && Boolean.TRUE.toString().equalsIgnoreCase(skip)) {
            LOGGER.warn("current environment is {} and auth.skip is {}", env, skip);
            return true;
        } else {
            String token = httpServletRequest.getHeader(Dict.Header.token.getKey());
            if (StringUtils.isEmpty(token)) {
                throw new GlobalException(Dict.Module.web, Dict.Factor.unlogin);
            }
            LOGGER.debug("current environment: {}", env);
            return true;
        }

    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

}
