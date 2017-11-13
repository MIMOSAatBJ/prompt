package com.cicc.controller;

import com.cicc.common.BaseController;
import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/test")
public class App extends BaseController {
    private static final Logger LOGGER= LogManager.getLogger(App.class);

    @RequestMapping("/hi")
    public String hello(HttpServletRequest request, HttpServletResponse response) {
        Gson g = new Gson();
        LOGGER.info("test");
        return "hello";
    }
}
