/*
package com.atguigu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

*/
/**
 * @author zxf
 * @date 2018/8/1 21:38
 *//*

@Configuration
public class MyMvcConfig extends WebMvcConfigurationSupport {

    @Override
    protected void addViewControllers(ViewControllerRegistry registry) {
        //super.addViewControllers(registry);
        //浏览器发送/atguigu 请求会来到success
        registry.addViewController("/atguigu").setViewName("success");
        registry.addViewController("/").setViewName("login");
    }

    //所有的WebMvcConfigurerAdapter组件都会一起起作用
    @Bean//将组件注册在容器中
    public WebMvcConfigurationSupport MyMvcConfig() {
        WebMvcConfigurationSupport support = new WebMvcConfigurationSupport(){
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
            }
        };
        return support;
    }
}
*/
