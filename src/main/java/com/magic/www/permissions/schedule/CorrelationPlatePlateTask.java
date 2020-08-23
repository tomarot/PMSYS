package com.magic.www.permissions.schedule;

import com.magic.www.permissions.Service.PlateService;
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
 * 关联板块与板块关系任务
 */
@Service
public class CorrelationPlatePlateTask {

    private static final Logger log = LoggerFactory.getLogger(CorrelationPlatePlateTask.class);

    @Autowired
    private PlateService plateService;

    /**
     * 关联板块与板块关系任务
     */
//    @Scheduled(cron="0 0 0/3 * * ?")
    public void CorrelationPlatePlateRelationData() {
        log.info("关联板块与板块关系任务开始执行：时间["+ DateUtils.date2String(new Date())+"].");
        ResultVo resultVo = null;
        try {
            resultVo = plateService.CorrelationPlatePlateRelationData();
            if(resultVo.getResult_code()==ResultVo.CODE_SUCCESS){
                log.info("关联板块与板块关系任务完成：时间["+ DateUtils.date2String(new Date())+"].");
            }else{
                log.info("关联板块与板块关系任务异常.");
            }
        } catch (Exception e) {
            log.error("关联板块与板块关系任务异常.",e);
        }
    }
}
