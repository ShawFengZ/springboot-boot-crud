package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author zxf
 * @date 2018/8/1 20:00
 */
@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("hello")
    public String hello(){
        return "Hello";
    }

    @RequestMapping("/success")
    public String success(Map<String, Object> map){
        map.put("hello","你好");
        return "success";
    }
}
