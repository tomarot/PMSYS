package com.magic.www.permissions.mapper;

import com.magic.www.permissions.domain.Stock;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface StockMapper {
    /**
     * 删除数据
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存数据
     * 全字段
     * @param record
     * @return
     */
    int insert(Stock record);

    /**
     * 保存数据
     * @param record
     * @return
     */
    int insertSelective(Stock record);

    /**
     * 获取数据
     * @param id 主键
     * @return
     */
    Stock selectByPrimaryKey(Integer id);

    /**
     * 修改数据
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Stock record);

    /**
     * 修改数据
     * 根据主键
     * @param record
     * @return
     */
    int updateByPrimaryKey(Stock record);

    /**
     * 获取股票数据
     * @param record
     * @return
     */
    List<Stock> querySelective(Stock record);

    /**
     * 获取涨停股票
     * @param date
     * @return
     */
    List<Stock> queryHardenStock(Date date);

    /**
     * 获取跌停股票
     * @param date
     * @return
     */
    List<Stock> queryDropStock(Date date);

    /**
     *涨停股票的板块名称列表
     * @param date
     * @return
     */
    List<Map> queryPlateListForHardenStock(@Param("date")String date);

    /**
     * 获取涨幅大于3%的股票
     * @param date
     * @return
     */
    List<Stock> queryStockByGreater3(@Param("date")String date);

    /**
     * 获取涨幅分布情况统计
     * @param startDate
     * @param endDate
     * @return
     */
    List<Map<String,Object>> queryGainsCount(@Param("startDate")String startDate,@Param("endDate")String endDate,@Param("pageState")String pageState,@Param("offset")int offset,@Param("pageSize")int pageSize);
}