package com.magic.www.permissions.controller;

import com.magic.www.permissions.Service.impl.HomeServiceImpl;
import com.magic.www.permissions.base.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 2020/8/6
 * Time: 13:10
 * 主页控制器
 */
@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private HomeServiceImpl homeService;

    /**
     * 跳转主页
     * @return
     */
    @RequestMapping("/toHomePage")
    public String toIndexPage(){
        return "home/homePage";
    }

    /**
     * 获取涨停跌停数量对比数据
     * @return
     */
    @RequestMapping("/getLatestHardenDropProportionData")
    @ResponseBody
    public ResultVo getLatestHardenDropProportionData(){
        ResultVo resultVo = homeService.getLatestHardenDropProportionData();
        return resultVo;
    }

    /**
     * 获取赚钱效应数据
     * @return
     */
    @RequestMapping("/getMakeMoneyEffectData")
    @ResponseBody
    public ResultVo getMakeMoneyEffectData(){
        ResultVo resultVo =  homeService.getLatestMakeMoneyEffectData();
        return resultVo;
    }

    /**
     * 获取风向标数量数据
     * @return
     */
    @RequestMapping("/getWindVaneCountData")
    @ResponseBody
    public ResultVo getWindVaneCountData(){
        ResultVo resultVo =  homeService.getWindVaneCountData();
        return resultVo;
    }

    /**
     * 获取北向资金行业图数据
     * @param periodType
     * @return
     */
    @RequestMapping("/getNorthMoneyHyCountData")
    @ResponseBody
    public ResultVo getNorthMoneyHyCountData(String periodType){
        ResultVo resultVo =  homeService.getNorthMoneyHyCountData(periodType);
        return resultVo;
    }

    /**
     * 获取北向资金行业图数据
     * @param periodType
     * @return
     */
    @RequestMapping("/getNorthMoneyGnCountData")
    @ResponseBody
    public ResultVo getNorthMoneyGnCountData(String periodType){
        ResultVo resultVo =  homeService.getNorthMoneyGnCountData(periodType);
        return resultVo;
    }

    /**
     * 获取涨幅分布情图数据
     * @return
     */
    @RequestMapping("/getGainsCountData")
    @ResponseBody
    public ResultVo getGainsCountData(){
        ResultVo resultVo =  homeService.getGainsCountData();
        return resultVo;
    }

}
