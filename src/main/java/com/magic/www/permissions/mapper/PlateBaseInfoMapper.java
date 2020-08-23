package com.magic.www.permissions.mapper;

import com.magic.www.permissions.domain.PlateBaseInfo;

import java.util.List;

public interface PlateBaseInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PlateBaseInfo record);

    int insertSelective(PlateBaseInfo record);

    PlateBaseInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PlateBaseInfo record);

    int updateByPrimaryKey(PlateBaseInfo record);

    /**
     * 查询列表
     * @param plateBaseInfo
     * @return
     */
    List<PlateBaseInfo> querySelective(PlateBaseInfo plateBaseInfo);
}