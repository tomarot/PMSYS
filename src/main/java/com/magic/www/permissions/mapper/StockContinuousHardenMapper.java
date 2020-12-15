package com.magic.www.permissions.mapper;

import com.magic.www.permissions.domain.StockContinuousHarden;

import java.util.List;

public interface StockContinuousHardenMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StockContinuousHarden record);

    int insertSelective(StockContinuousHarden record);

    StockContinuousHarden selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StockContinuousHarden record);

    int updateByPrimaryKey(StockContinuousHarden record);

    /**
     * 查询股票连续涨停数据
     * @param record
     * @return
     */
    List<StockContinuousHarden> querySelective(StockContinuousHarden record);
}