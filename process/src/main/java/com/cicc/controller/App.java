package com.cicc.controller;

import com.cicc.common.base.BaseController;
import com.cicc.common.mapper.ext.DrugExtMapper;
import com.cicc.common.service.DrugService;
import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/test")
public class App extends BaseController {
    private static final Logger LOGGER = LogManager.getLogger(App.class);

    @Autowired
    private DrugService drugService;
    @Autowired
    private DrugExtMapper extMapper;

    @RequestMapping("/hi")
    public String hello(HttpServletRequest request, HttpServletResponse response, @RequestParam(name = "id") Integer id) {
        Gson g = new Gson();
        LOGGER.info("test");
        return new Gson().toJson(extMapper.extSelect(id));
    }
}
