package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zxf
 * @date 2018/8/1 20:00
 */
@Controller
@RequestMapping("hcontroller")
public class HelloController {

    @ResponseBody
    @RequestMapping("hello")
    public String hello(){
        return "Hello";
    }
}
