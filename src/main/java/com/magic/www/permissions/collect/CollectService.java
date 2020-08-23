package com.magic.www.permissions.collect;

import com.magic.www.permissions.base.ResultVo;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 2020/7/27
 * Time: 8:53
 * To change this template use File | Settings | File Templates.
 */
public interface CollectService {

    /**
     * 验证数据是否已经采集
     * @param date
     * @return
     */
    public boolean valid(Date date);

    /**
     * 采集北向资金数据
     */
    public ResultVo collectNorthMoneyData() throws Exception;

    /**
     * 采集股票数据
     * @return
     */
    public ResultVo collectStockData();

    /**
     * 采集股票所属的板块
     * @return
     */
    public ResultVo collectStockPlateInfoData();

    /**
     * 采集板块数据
     * @return
     */
    public ResultVo collectPlateInfoData();
}
