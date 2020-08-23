package com.magic.www.permissions.Service;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 2020/8/10
 * Time: 14:19
 * To change this template use File | Settings | File Templates.
 */
public interface NorthMoneyService {

    /**
     * 获取数据最新时间
     * @param dataType null表示全部数据
     * @param periodType null表示全部数据
     * @return
     */
    public Date queryLatestDate(String dataType,String periodType);
}
