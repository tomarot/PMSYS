package com.magic.www.permissions.controller;

import com.magic.www.permissions.Service.ClearUpService;
import com.magic.www.permissions.Service.PlateService;
import com.magic.www.permissions.base.ResultVo;
import com.magic.www.permissions.collect.CollectService;
import com.magic.www.permissions.schedule.OrderUnionTaskDevice;
import com.magic.www.permissions.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 2020/9/20
 * Time: 19:52
 * To change this template use File | Settings | File Templates.
 * 数据任务控制器
 */
@Controller
@RequestMapping("dataTask")
public class DataTaskController {

    private static final Logger log = LoggerFactory.getLogger(DataTaskController.class);

    @Autowired
    private ClearUpService clearUpService;
    @Autowired
    private CollectService collectService;
    @Autowired
    private PlateService plateService;

    /**
     * 跳转数据任务页面
     * @return
     */
    @RequestMapping("/toDataTaskPage")
    public String toDataTaskPage(){
        return "dataTask/dataTask";
    }
    /**
     * 统计个股连续涨停数据整理
     * @return
     */
    @RequestMapping("/statisticalContinuousHarden")
    @ResponseBody
    public ResultVo statisticalContinuousHarden(){
        ResultVo resultVo = clearUpService.clearUpStockHarderData(DateUtils.getDayStartTime(new Date()));
        return resultVo;
    }

    /**
     * 采集实时成交额数据
     * @return
     */
    @RequestMapping("/collectCurrentStockGainsData")
    @ResponseBody
    public ResultVo collectCurrentStockGainsData(){
        ResultVo resultVo = collectService.collectCurrentStockGainsData();
        return resultVo;
    }

    /**
     * #联合任务#更新个股数据及板块数据
     */
    @RequestMapping("/collectStockPlateInfoData")
    @ResponseBody
    public ResultVo collectStockPlateInfoData() {
        log.info("#联合任务#更新个股数据及板块数据。开始执行：时间["+ DateUtils.date2String(new Date())+"].");
        ResultVo resultVo = new ResultVo();
        try {
            //采集个股
            collectService.collectStockData();
            //采集板块
            collectService.collectPlateInfoData();
            //采集个股与板块关系数据并建立关联关系
            collectService.collectStockPlateInfoData();
            //更新板块与板块的关联关系
            plateService.CorrelationPlatePlateRelationData();
            log.info("#联合任务#更新个股数据及板块数据.完成：时间["+ DateUtils.date2String(new Date())+"].");
        } catch (Exception e) {
            log.error("#联合任务#更新个股数据及板块数据异常.");
            resultVo.setResult_code(ResultVo.CODE_FAILED);
            resultVo.setResult_msg(ResultVo.MSG_FAILED);
        }
        return resultVo;
    }

    /**
     * 采集板块排行数据
     */
    @RequestMapping("/collectPlateRankingData")
    @ResponseBody
    public ResultVo collectPlateRankingData() {
        log.info("采集板块排行数据。开始执行：时间["+ DateUtils.date2String(new Date())+"].");
        ResultVo resultVo = null;
        try {
            resultVo = collectService.collectPlateRankingData();
            log.info("采集板块排行数据.完成：时间["+ DateUtils.date2String(new Date())+"].");
        } catch (Exception e) {
            log.error("采集板块排行数据异常.");
            resultVo.setResult_code(ResultVo.CODE_FAILED);
            resultVo.setResult_msg(ResultVo.MSG_FAILED);
        }
        return resultVo;
    }

    /**
     * 采集板块排行数据
     */
    @RequestMapping("/collectPlateMoneyRankingData")
    @ResponseBody
    public ResultVo collectPlateMoneyRankingData() {
        log.info("采集板块资金排行数据。开始执行：时间["+ DateUtils.date2String(new Date())+"].");
        ResultVo resultVo = null;
        try {
            resultVo = collectService.collectPlateMoneyRankingData();
            log.info("采集板块资金排行数据.完成：时间["+ DateUtils.date2String(new Date())+"].");
        } catch (Exception e) {
            log.error("采集板块资金排行数据异常.");
            resultVo.setResult_code(ResultVo.CODE_FAILED);
            resultVo.setResult_msg(ResultVo.MSG_FAILED);
        }
        return resultVo;
    }

    /**
     * 采集个股排行数据
     */
    @RequestMapping("/collectStockRankingData")
    @ResponseBody
    public ResultVo collectStockRankingData() {
        log.info("采集个股排行数据。开始执行：时间["+ DateUtils.date2String(new Date())+"].");
        ResultVo resultVo = null;
        try {
            resultVo = collectService.collectStockRankingData();
            log.info("采集个股排行数据.完成：时间["+ DateUtils.date2String(new Date())+"].");
        } catch (Exception e) {
            log.error("采集个股排行数据异常.");
            resultVo.setResult_code(ResultVo.CODE_FAILED);
            resultVo.setResult_msg(ResultVo.MSG_FAILED);
        }
        return resultVo;
    }

    /**
     * 采集个股资金排行数据
     */
    @RequestMapping("/collectStockMoneyRankingData")
    @ResponseBody
    public ResultVo collectStockMoneyRankingData() {
        log.info("采集个股资金排行数据。开始执行：时间["+ DateUtils.date2String(new Date())+"].");
        ResultVo resultVo = null;
        try {
            resultVo = collectService.collectStockMoneyRankingData();
            log.info("采集个股资金排行数据.完成：时间["+ DateUtils.date2String(new Date())+"].");
        } catch (Exception e) {
            log.error("采集个股资金排行数据异常.");
            resultVo.setResult_code(ResultVo.CODE_FAILED);
            resultVo.setResult_msg(ResultVo.MSG_FAILED);
        }
        return resultVo;
    }





}
