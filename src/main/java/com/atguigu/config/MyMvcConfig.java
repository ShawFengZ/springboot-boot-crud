package com.atguigu.config;

import com.atguigu.component.LoginHandlerInterceptor;
import com.atguigu.component.MyLocaleResolver;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
/*
 * @author zxf
 * @date 2018/8/1 21:38
 */
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {

    /*@Override
    protected void addViewControllers(ViewControllerRegistry registry) {
        //super.addViewControllers(registry);
        //浏览器发送/atguigu 请求会来到success
        registry.addViewController("/atguigu").setViewName("success");
        registry.addViewController("/").setViewName("login");
    }*/

    //所有的WebMvcConfigurerAdapter组件都会一起起作用
    @Bean//将组件注册在容器中
    public WebMvcConfigurerAdapter MyMvcConfig() {
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("index");
                registry.addViewController("/index.html").setViewName("index");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            //注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //静态资源：*.css, *.js
                //SpringBoot已经做好了静态资源映射，因此不用排除静态资源的使用1.10
                //springboot2.0以后要重新指定静态资源的位置啊
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns("/index.html", "/", "/user/login", "/asserts/css/signin.css",
                                "/webjars/bootstrap/4.0.0/css/bootstrap.css", "/asserts/img/bootstrap-solid.svg");
            }

        };
        return adapter;
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }
}
