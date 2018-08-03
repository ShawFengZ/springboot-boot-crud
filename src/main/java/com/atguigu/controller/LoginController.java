package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author zxf
 * @date 2018/8/2 14:57
 */
@Controller
public class LoginController {

    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String, Object> map, HttpSession session){
        if (!StringUtils.isEmpty(username) && "123456".equals(password)){
            //只要登录了，用户就会在session中存在，方便我们做前端校验的
            session.setAttribute("loginUser", username);
            //登录成功，防止表单重复提交，使用重定向
            return "redirect:/main.html";
        }else {
            //传回一个消息
            map.put("msg", "用户名或密码错误！");
            //失败还是返回首页
            return "index";
        }
    }
}
