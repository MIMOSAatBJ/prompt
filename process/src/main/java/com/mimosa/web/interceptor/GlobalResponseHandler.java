package com.mimosa.web.interceptor;

import com.mimosa.common.base.BaseResponse;
import com.mimosa.common.base.Dict;
import com.mimosa.common.exception.GlobalException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class GlobalResponseHandler {
    private static final Logger LOGGER = LogManager.getLogger(GlobalResponseHandler.class);

    @Around("execution(* com.mimosa.web.controller.*.*(..)) ")
    protected Object wrapper(ProceedingJoinPoint joinPoint) {
        BaseResponse br;
        try {
            Object data = joinPoint.proceed();
            br = new BaseResponse(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), data);
        } catch (Throwable e) {
            LOGGER.error("exception when wrapper data:{}", e.getMessage());
            throw new GlobalException(Dict.Module.web, Dict.Factor.unknown, e);
        }
        return br;
    }
}
