package com.magic.www.permissions.mapper;

import com.magic.www.permissions.domain.CollectPlateMoneyRanking;

import java.util.List;

public interface CollectPlateMoneyRankingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CollectPlateMoneyRanking record);

    int insertSelective(CollectPlateMoneyRanking record);

    CollectPlateMoneyRanking selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CollectPlateMoneyRanking record);

    int updateByPrimaryKey(CollectPlateMoneyRanking record);

    /**
     * 查询板块资金排行数据记录
     * @param collectPlateMoneyRanking
     * @return
     */
    List<CollectPlateMoneyRanking> querySelective(CollectPlateMoneyRanking collectPlateMoneyRanking);
}