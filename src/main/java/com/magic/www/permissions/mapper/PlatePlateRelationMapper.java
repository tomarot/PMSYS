package com.magic.www.permissions.mapper;

import com.magic.www.permissions.domain.PlatePlateRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PlatePlateRelationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PlatePlateRelation record);

    int insertSelective(PlatePlateRelation record);

    PlatePlateRelation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PlatePlateRelation record);

    int updateByPrimaryKey(PlatePlateRelation record);

    /**
     * 清空关联关系数据
     * @return
     */
    int deleteAll();

    /**
     * 清空关联关系
     * @param hyCode 行业代码
     * @return
     */
    int deleteByHyCode(@Param("hyCode") String hyCode);

    /**
     * 查询列表
     * @param record
     * @return
     */
    List<PlatePlateRelation> querySelective(PlatePlateRelation record);
}