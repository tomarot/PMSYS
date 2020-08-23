package com.magic.www.permissions.utils;

import com.magic.www.permissions.collect.impl.CollectServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 2020/8/20
 * Time: 17:35
 * To change this template use File | Settings | File Templates.
 */
public class StockUtils {

    /**
     * 获取的上市地简称
     * @param code
     * @return
     */
    public static String getMark(String code){

        final Logger log = LoggerFactory.getLogger(CollectServiceImpl.class);

        //沪市A股
        //沪市A股的代码是以600、601、603或605打头
        //科创板
        //科创板的代码是688打头

        //深市A股
        //深市A股的代码是以000打头
        //中小板
        //中小板的代码是002打头
        //创业板
        //创业板的代码是300打头的股票代码
        String resultStr = "";
        if(code.startsWith("6")){
            resultStr = "SH";
        }else if(code.startsWith("0")||code.startsWith("3")){
            resultStr = "SZ";
        }else{
            try {
                throw new Exception("未定义的代码");
            } catch (Exception e) {
                log.error("未定义的代码");
                e.printStackTrace();
            }
        }
        return resultStr;
    }
}
