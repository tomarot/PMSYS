package com.magic.www.permissions.controller;

import com.magic.www.permissions.Service.PlateService;
import com.magic.www.permissions.base.ResultVo;
import com.magic.www.permissions.collect.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private CollectService collectService;

    @Autowired
    private PlateService plateService;
    /**
     * 跳转首页页面
     * @return
     */
    @RequestMapping("/toIndex")
    public String toIndexPage(){

        return "index/index";
    }

    /**
     * 测试接口专用
     * @return
     */
    @RequestMapping("/getTestData")
    @ResponseBody
    public ResultVo getTestData(String type){
        ResultVo resultVo= null;
        if("0".equals(type)){
            resultVo = collectService.collectStockData();
        }
        else if("1".equals(type)){
            resultVo = collectService.collectPlateInfoData();
        }
        else if("2".equals(type)){
            resultVo = collectService.collectStockPlateInfoData();
        }
        else if("3".equals(type)){
            resultVo = plateService.CorrelationPlatePlateRelationData();
        }
        return resultVo;
    }

}
