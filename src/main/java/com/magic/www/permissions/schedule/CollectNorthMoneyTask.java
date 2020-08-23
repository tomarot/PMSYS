package com.magic.www.permissions.schedule;

import com.magic.www.permissions.base.ResultVo;
import com.magic.www.permissions.collect.CollectService;
import com.magic.www.permissions.collect.impl.CollectServiceImpl;
import com.magic.www.permissions.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 2020/7/21
 * Time: 17:07
 * 北向资金采集任务
 */
@Service
public class CollectNorthMoneyTask {

    private static final Logger log = LoggerFactory.getLogger(CollectNorthMoneyTask.class);

    @Autowired
    private CollectService collectService;

    /**
     * 采集北向资金数据
     */
    @Scheduled(cron="0 0 0/3 * * ?")
    public void collectNorthMoneyData() {
        log.info("北向资金采集任务开始执行：时间["+ DateUtils.date2String(new Date())+"].");
        ResultVo resultVo = null;
        try {
            resultVo = collectService.collectNorthMoneyData();
            if(resultVo.getResult_code()==ResultVo.CODE_SUCCESS){
                log.info("北向资金采集任务完成：时间["+ DateUtils.date2String(new Date())+"].");
            }else{
                log.info("北向资金采集任务异常.");
            }
        } catch (Exception e) {
            log.error("北向资金采集任务异常.");
        }
    }
}
