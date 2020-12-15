package com.magic.www.permissions.Service;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 2020/7/22
 * Time: 13:06
 * 个股相关服务类
 */
public interface StockService {

    /**
     * 获取数据最新时间
     * @return
     */
    public Date queryLatestDate();

    /**
     * 获取数据时间列表
     * @return
     */
    public List<Date> queryDateList();
}
