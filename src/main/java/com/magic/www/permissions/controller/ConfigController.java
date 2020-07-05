package com.magic.www.permissions.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 2020/2/10
 * Time: 9:20
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping("/config/")
public class ConfigController {

    /**
     * 获取全部字典项
     * 前端对全部字典项缓存处理
     * @return
     */
    @GetMapping("getDictionary")
    public Map<String,Object> getInitDictionary(){
        return null;
    }
}
