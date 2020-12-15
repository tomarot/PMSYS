package com.magic.www.permissions.mapper;

import com.magic.www.permissions.domain.CollectStockRanking;

import java.util.List;

public interface CollectStockRankingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CollectStockRanking record);

    int insertSelective(CollectStockRanking record);

    CollectStockRanking selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CollectStockRanking record);

    int updateByPrimaryKey(CollectStockRanking record);

    List<CollectStockRanking> querySelective(CollectStockRanking collectStockRanking);
}