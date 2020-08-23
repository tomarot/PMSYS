package com.magic.www.permissions.mapper;

import com.magic.www.permissions.domain.StockBaseInfo;

import java.util.List;

public interface StockBaseInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StockBaseInfo record);

    int insertSelective(StockBaseInfo record);

    StockBaseInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StockBaseInfo record);

    int updateByPrimaryKey(StockBaseInfo record);

    /**
     * 查询股票基础数据
     * @param record
     * @return
     */
    List<StockBaseInfo> querySelective(StockBaseInfo record);
}