package com.magic.www.permissions.controller;

import com.magic.www.permissions.Service.WindVaneService;
import com.magic.www.permissions.base.ResultVo;
import com.magic.www.permissions.collect.CollectService;
import com.magic.www.permissions.parameterExpand.WindVaneParameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private WindVaneService windVaneService;


    private static final Logger log = LoggerFactory.getLogger(WindVaneController.class);
    /**
     * 跳转风向标展示页
     * @return
     */
    @RequestMapping("/toWindVaneShowPage")
    public String toWindVaneShowPage(){
        return "windVane/windVaneShowPage";
    }

    /**
     * 获取风向标数据
     * @param windVaneParameter
     * @return
     */
    @RequestMapping("/getWindVaneData")
    @ResponseBody
    public ResultVo getWindVaneData(WindVaneParameter windVaneParameter){
        ResultVo resultVo = windVaneService.getWindVaneShowInfo(windVaneParameter);
        return resultVo;
    }

    /**
     * 跳转新增风向标页
     * @return
     */
    @RequestMapping("/toAddWindVanePage")
    public String toAddWindVanePage(){
        return "windVane/addWindVanePage";
    }

    /**
     * 获取风向标重点关注项
     * @param date
     * @return
     */
    @RequestMapping("/getTodayImportant")
    @ResponseBody
    public ResultVo getTodayImportant(String date){
        ResultVo resultVo = new ResultVo();
        Map resultMap = windVaneService.getTodayImportant(date);
        resultVo.setResultData(resultMap);
        return resultVo;
    }

    /**
     * 新增风向标数据
     * @param windVaneStr
     * @param response
     * @param request
     * @return
     */
    @RequestMapping("/saveWindVane")
    @ResponseBody
    public ResultVo saveWindVane(String windVaneStr, HttpServletResponse response, HttpServletRequest request){
        ResultVo resultVo = new ResultVo();
        Map map = windVaneService.saveWindVane(windVaneStr);
        return resultVo;
    }

}
