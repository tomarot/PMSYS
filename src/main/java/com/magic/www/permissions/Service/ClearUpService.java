package com.magic.www.permissions.Service;

import com.magic.www.permissions.base.ResultVo;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 2020/9/19
 * Time: 19:49
 * To change this template use File | Settings | File Templates.
 * 整理/格式化/清洗数据服务类
 */
public interface ClearUpService {

    /**
     * 整理个股连续涨停板数据
     * @param date 整理的日期
     * @return
     */
    public ResultVo clearUpStockHarderData(Date date);
}
