package com.magic.www.permissions.controller;

import com.magic.www.permissions.base.ResultVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 2019/12/12
 * Time: 15:16
 * To change this template use File | Settings | File Templates.
 * 系统主页控制器
 */
@Controller
@RequestMapping("/index")
public class IndexController {

    /**
     * 跳转首页页面
     * @return
     */
    @RequestMapping("/toIndex")
    public String toIndexPage(){
        return "/index/index";
    }

}
