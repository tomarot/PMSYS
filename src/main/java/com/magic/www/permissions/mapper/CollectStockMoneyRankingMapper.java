package com.magic.www.permissions.mapper;

import com.magic.www.permissions.domain.CollectStockMoneyRanking;

import java.util.List;

public interface CollectStockMoneyRankingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CollectStockMoneyRanking record);

    int insertSelective(CollectStockMoneyRanking record);

    CollectStockMoneyRanking selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CollectStockMoneyRanking record);

    int updateByPrimaryKey(CollectStockMoneyRanking record);

    /**
     * 查询个股资金排行数据
     * @param collectStockMoneyRanking
     * @return
     */
    List<CollectStockMoneyRanking> querySelective(CollectStockMoneyRanking collectStockMoneyRanking);

    CollectStockMoneyRanking queryLastData();
}