package com.taobao.console.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@Controller
public class SystemController {

    @RequestMapping(value = {"/index", "/"},
            method = RequestMethod.GET)
    public String home() {
        return "schedule/index";  //返回到login.jsp登录页，而不是Controller的方法。
    }

    @RequestMapping("/schedule/{tag}")
    public String common(@PathVariable("tag") String tag) {
        return "schedule/" + tag;  //返回到login.jsp登录页，而不是Controller的方法。
    }
}