package com.magic.www.permissions.config;

import com.magic.www.permissions.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 2019/12/13
 * Time: 14:29
 * To change this template use File | Settings | File Templates.
 */
@Configuration
public class WebConfigurer implements WebMvcConfigurer {

//    @Autowired
//    private LoginInterceptor loginInterceptor;

    // 这个方法用来注册拦截器，我们自己写好的拦截器需要通过这里添加注册才能生效
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns("/**") 表示拦截所有的请求，
        // excludePathPatterns("/login", "/register") 表示除了登陆与注册之外，因为登陆注册不需要登陆也可以访问
//        registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns("/login/toLogin", "/login/doLogin","/register/**",
//                "/**/*.css", "/**/*.js", "/**/*.png", "/**/*.jpg","/**/*.jpeg", "/**/*.gif", "/**/fonts/*", "/**/*.svg");
    }
    // 这个方法是用来配置静态资源的，比如html，js，css，等等
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/**/*.css", "/**/*.js", "/**/*.png", "/**/*.jpg","/**/*.jpeg", "/**/*.gif", "/**/fonts/*", "/**/*.svg")
//                .addResourceLocations("classpath:/static/");
    }
}
