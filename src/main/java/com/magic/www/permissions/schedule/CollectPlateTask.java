package com.magic.www.permissions.schedule;

import com.magic.www.permissions.base.ResultVo;
import com.magic.www.permissions.collect.CollectService;
import com.magic.www.permissions.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 2020/7/21
 * Time: 17:07
 * 个股数据采集任务
 */
@Service
public class CollectPlateTask {

    private static final Logger log = LoggerFactory.getLogger(CollectPlateTask.class);

    @Autowired
    private CollectService collectService;

    /**
     * 采集板块数据
     */
//    @Scheduled(cron="0 0 0/3 * * ?")
    public void collectPlateData() {
        log.info("板块数据采集任务开始执行：时间["+ DateUtils.date2String(new Date())+"].");
        ResultVo resultVo = null;
        try {
            resultVo = collectService.collectPlateInfoData();
            if(resultVo.getResult_code()==ResultVo.CODE_SUCCESS){
                log.info("板块数据信息采集任务完成：时间["+ DateUtils.date2String(new Date())+"].");
            }else{
                log.info("板块数据信息采集任务异常.");
            }
        } catch (Exception e) {
            log.error("板块数据信息采集任务异常.");
        }
    }
}
