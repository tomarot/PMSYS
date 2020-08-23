package com.magic.www.permissions.controller;

import com.magic.www.permissions.base.ResultVo;
import com.magic.www.permissions.collect.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 2020/7/29
 * Time: 13:43
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("northMoney")
public class NorthMoneyController {

    @Autowired
    private CollectService collectService;

    /**
     * 跳转采集北向资金页面
     * @return
     */
    @RequestMapping("/toCollectNorthMoneyPage")
    public String toCollectNorthMoneyPage(){
        return "northMoney/collectNorthMoneyPage";
    }

    /**
     * 采集北向资金数据
     * @return
     */
    @RequestMapping("/collectNorthMoney")
    @ResponseBody
    public ResultVo collectNorthMoney() throws Exception {
        ResultVo resultVo = collectService.collectNorthMoneyData();
        return resultVo;
    }


}
