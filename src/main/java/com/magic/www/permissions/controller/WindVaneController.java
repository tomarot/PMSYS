package com.magic.www.permissions.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 2020/7/1
 * Time: 11:10
 * To change this template use File | Settings | File Templates.
 * 风向标控制器
 */
@Controller
@RequestMapping("/windVane")
public class WindVaneController {

    private static final Logger log = LoggerFactory.getLogger(WindVaneController.class);
    /**
     * 跳转风向标展示页
     * @return
     */
    @RequestMapping("/toWindVaneShowPage")
    public String toWindVaneShowPage(){
        return "/windVane/windVaneShowPage";
    }
}
