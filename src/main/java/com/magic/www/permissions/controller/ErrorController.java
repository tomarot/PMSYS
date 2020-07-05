package com.magic.www.permissions.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 2019/12/5
 * Time: 17:12
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/error")
public class ErrorController {

    /**
     * 跳转404页面
     * @return
     */
    @GetMapping("/404")
    public String error_404(){
        return "404";
    }
    /**
     * 跳转500页面
     * @return
     */
    @GetMapping("/500")
    public String error_500(){
        return "500";
    }
}
