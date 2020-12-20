package com.magic.www.permissions.mapper;

import com.magic.www.permissions.domain.CollectPlateRanking;

import java.util.List;

public interface CollectPlateRankingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CollectPlateRanking record);

    int insertSelective(CollectPlateRanking record);

    CollectPlateRanking selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CollectPlateRanking record);

    int updateByPrimaryKey(CollectPlateRanking record);

    /**
     * 查询板块排行数据
     * @param collectPlateRanking
     * @return
     */
    List<CollectPlateRanking> querySelective(CollectPlateRanking collectPlateRanking);

    /**
     * 获取最后一条数据
     * @return
     */
    CollectPlateRanking queryLastData();
}