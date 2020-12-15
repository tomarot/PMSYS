package com.magic.www.permissions.mapper;

import com.magic.www.permissions.domain.StockDataMeta;

public interface StockDataMetaMapper {
    int deleteByPrimaryKey(Integer id);

    /**
     * 清空数据
     * @return
     */
    int delete();

    int insert(StockDataMeta record);

    int insertSelective(StockDataMeta record);

    StockDataMeta selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StockDataMeta record);

    int updateByPrimaryKey(StockDataMeta record);
}