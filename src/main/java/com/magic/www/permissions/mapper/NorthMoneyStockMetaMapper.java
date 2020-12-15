package com.magic.www.permissions.mapper;

import com.magic.www.permissions.domain.NorthMoneyStockMeta;

import java.util.List;

public interface NorthMoneyStockMetaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(NorthMoneyStockMeta record);

    int insertSelective(NorthMoneyStockMeta record);

    NorthMoneyStockMeta selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(NorthMoneyStockMeta record);

    int updateByPrimaryKey(NorthMoneyStockMeta record);

    /**
     * 查询北向资金个股数据
     * @param NorthMoneyStockMeta
     * @return
     */
    List<NorthMoneyStockMeta> querySelective(NorthMoneyStockMeta NorthMoneyStockMeta);
}