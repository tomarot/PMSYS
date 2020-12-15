package com.magic.www.permissions.mapper;

import com.magic.www.permissions.domain.StockPlateRelation;
import com.magic.www.permissions.vo.StockPlateRelationVo;

import java.util.List;

public interface StockPlateRelationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StockPlateRelation record);

    int insertSelective(StockPlateRelation record);

    StockPlateRelation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StockPlateRelation record);

    int updateByPrimaryKey(StockPlateRelation record);

    int deleteAll();

    /**
     * 查询股票与板块关联关系列表
     * @param record
     * @return
     */
    List<StockPlateRelation> querySelective(StockPlateRelation record);


    /**
     * 查询股票与板块关联关系列表
     * 通过left join关联查询的列表
     * @param record
     * @return
     */
    List<StockPlateRelationVo> queryStockPlateRelation(StockPlateRelationVo record);
}