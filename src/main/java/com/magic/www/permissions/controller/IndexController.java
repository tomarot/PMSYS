package com.magic.www.permissions.controller;

import com.magic.www.permissions.Service.ClearUpService;
import com.magic.www.permissions.Service.PlateService;
import com.magic.www.permissions.base.ResultVo;
import com.magic.www.permissions.collect.CollectService;
import com.magic.www.permissions.utils.DateUtils;
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
    @Autowired
    private ClearUpService clearUpService;
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
        if("0".equals(type)){//采集股票数据
            resultVo = collectService.collectStockData();
        }
        else if("1".equals(type)){//采集板块数据
            resultVo = collectService.collectPlateInfoData();
        }
        else if("2".equals(type)){//采集股票所属的板块
            resultVo = collectService.collectStockPlateInfoData();
        }
        else if("3".equals(type)){//关联板块与板块关系
            resultVo = plateService.CorrelationPlatePlateRelationData();
        }else if("4".equals(type)){//采集当前个股涨跌数据任务开始
            resultVo = collectService.collectCurrentStockGainsData();
        }else if("5".equals(type)){//整理个股连续涨停板数据
            clearUpService.clearUpStockHarderData(DateUtils.stringToDate("2020-09-18"));
        }else if("6".equals(type)){//北向资金个股
            try {
                collectService.collectNorthMoneyStockData();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if("7".equals(type)){
            //板块排行
//            collectService.collectPlateRankingData();
            //采集板块资金排行数据
//            collectService.collectPlateMoneyRankingData();
            //采集个股排行数据
//            collectService.collectStockRankingData();
            //采集个股资金排行数据
            collectService.collectStockMoneyRankingData();
        }
        return resultVo;
    }

}
