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
     * 验证北向资金个股数据是否已经采集
     * @param date
     * @return
     */
    public boolean valid_northMoneyStock(Date date);

    /**
     *验证板块排行数据是否已经采集
     * @param date
     * @return
     */
    public boolean valid_plateRanking(Date date);

    /**
     * 验证个股排行数据是否已经采集
     * @param date
     * @return
     */
    public boolean valid_stockRanking(Date date);

    /**
     * 验证个股资金排行数据是否已经采集
     * @param date
     * @return
     */
    public boolean valid_stockMoneyRanking(Date date);

    /**
     *验证板块资金排行数据是否已经采集
     * @param date
     * @return
     */
    public boolean valid_plateMoneyRanking(Date date);

    /**
     * 采集北向资金板块数据
     */
    public ResultVo collectNorthMoneyData() throws Exception;

    /**
     * 采集北向资金个股数据
     * @return
     * @throws Exception
     */
    public ResultVo collectNorthMoneyStockData() throws Exception;

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

    /**
     * 采集当前个股涨跌数据任务开始
     * @return
     */
    public ResultVo collectCurrentStockGainsData();

    /**
     * 采集板块排行数据
     * @return
     */
    public ResultVo collectPlateRankingData();

    /**
     * 采集板块资金排名数据
     * @return
     */
    public ResultVo collectPlateMoneyRankingData();

    /**
     * 采集个股排名数据
     * @return
     */
    public ResultVo collectStockRankingData();

    /**
     * 采集个股资金排名数据
     * @return
     */
    public ResultVo collectStockMoneyRankingData();


}
