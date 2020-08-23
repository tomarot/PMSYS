package com.magic.www.permissions.Service;

import com.magic.www.permissions.base.ResultVo;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 2020/8/9
 * Time: 13:20
 * To change this template use File | Settings | File Templates.
 */
public interface HomeService {

    /**
     * 获取最新涨停跌停对比数据
     * @return
     */
    public ResultVo getLatestHardenDropProportionData();

    /**
     * 获取最新赚钱效应数据
     * @return
     */
    public ResultVo getLatestMakeMoneyEffectData();

    /**
     * 获取风向标数量数据
     * @return
     */
    public ResultVo getWindVaneCountData();

    /**
     * 获取北向资金行业图数据
     * @param periodType
     * @return
     */
    public ResultVo getNorthMoneyHyCountData(String periodType);

    /**
     * 获取北向资金概念图数据
     * @param periodType
     * @return
     */
    public ResultVo getNorthMoneyGnCountData(String periodType);

    /**
     * 获取涨幅分布情图数据
     * @return
     */
    public ResultVo getGainsCountData();
}
