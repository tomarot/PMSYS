package com.magic.www.permissions.schedule;

import com.magic.www.permissions.Service.PlateService;
import com.magic.www.permissions.base.ResultVo;
import com.magic.www.permissions.collect.CollectService;
import com.magic.www.permissions.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 2020/9/5
 * Time: 15:26
 * To change this template use File | Settings | File Templates.
 * 串联执行多个任务
 */
@Service
public class OrderUnionTaskDevice {

    private static final Logger log = LoggerFactory.getLogger(OrderUnionTaskDevice.class);

    @Autowired
    private PlateService plateService;
    @Autowired
    private CollectService collectService;

    /**
     * #联合任务#更新个股数据及板块数据
     */
    @Scheduled(cron="0 0 1 * * ?")
    public void collectStockPlateInfoData() {
        log.info("#联合任务#更新个股数据及板块数据。开始执行：时间["+ DateUtils.date2String(new Date())+"].");
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
        }
    }

    /**
     * #联合任务#采集个股及板块排行数据
     */
    @Scheduled(cron="0 0 2 * * ?")
    public void collectRankData() {
        log.info("#联合任务#采集个股及板块排行数据。开始执行：时间["+ DateUtils.date2String(new Date())+"].");
        try {
            //采集板块排行数据
            collectService.collectPlateRankingData();
            //采集板块资金排行数据
            collectService.collectPlateMoneyRankingData();
            //采集个股排行数据
            collectService.collectStockRankingData();
            //采集个股资金排行数据
            collectService.collectStockMoneyRankingData();
            log.info("##联合任务#采集个股及板块排行数据.完成：时间["+ DateUtils.date2String(new Date())+"].");
        } catch (Exception e) {
            log.error("##联合任务#采集个股及板块排行数据.");
        }
    }
}
