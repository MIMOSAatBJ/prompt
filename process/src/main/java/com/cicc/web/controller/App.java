package com.cicc.web.controller;

import com.cicc.common.base.BaseController;
import com.cicc.common.service.DrugService;
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


    @RequestMapping("/hi")
    public Object hello(HttpServletRequest request, HttpServletResponse response, @RequestParam(name = "id") Integer id) {
        return  drugService.findById(id);
    }
}
