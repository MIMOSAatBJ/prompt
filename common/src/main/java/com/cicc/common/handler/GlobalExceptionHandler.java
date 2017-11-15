package com.cicc.common.handler;

import com.cicc.common.base.BaseResponse;
import com.cicc.common.base.Dict;
import com.cicc.common.exception.GlobalException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LogManager.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public Object handle(HttpServletRequest request,
                         Exception exception) {
        LOGGER.error("exception {} url [{}]", exception.getClass(), request.getRequestURL());
        if (LOGGER.isDebugEnabled()) {
            request.getParameterMap().forEach((k, v) ->
                    LOGGER.debug("k->{},v->{}", k, v[0])
            );
        }
        GlobalException ge;
        if (!(exception instanceof GlobalException)) {
            LOGGER.error("exception {}:{}", exception.getMessage(), exception.getStackTrace());
            ge = new GlobalException(Dict.Module.unknown, Dict.Factor.unknown, exception);
        } else {
            ge = (GlobalException) exception;
        }
        return new BaseResponse(ge);
    }

}
