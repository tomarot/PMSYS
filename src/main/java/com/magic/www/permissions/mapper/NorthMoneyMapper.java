package com.magic.www.permissions.mapper;

import com.magic.www.permissions.domain.NorthMoneyMeta;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface NorthMoneyMapper {
    /**
     * 删除数据
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入数据
     * 全字段
     * @param record
     * @return
     */
    int insert(NorthMoneyMeta record);

    /**
     * 插入数据
     * @param record
     * @return
     */
    int insertSelective(NorthMoneyMeta record);

    /**
     * 获取数据
     * 根据主键
     * @param id
     * @return
     */
    NorthMoneyMeta selectByPrimaryKey(Integer id);

    /**
     * 修改数据
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(NorthMoneyMeta record);

    /**
     * 修改数据
     * 全字段
     * @param record
     * @return
     */
    int updateByPrimaryKey(NorthMoneyMeta record);

    /**
     * 查询数据
     * @param record
     * @return
     */
    List<NorthMoneyMeta> querySelective(NorthMoneyMeta record);

    /**
     * 获取北向资金流入top榜
     * @param dateType
     * @param periodType
     * @param date
     * @param topNum
     * @return
     */
    List<NorthMoneyMeta> queryInflowsTop(@Param("type")String dateType,@Param("DateType")String periodType, @Param("date")String date,@Param("topNum")int topNum);

    /**
     * 获取北向资金流出top榜
     * @param dateType
     * @param periodType
     * @param date
     * @param topNum
     * @return
     */
    List<NorthMoneyMeta> queryOutOfTop(@Param("type")String dateType,@Param("DateType")String periodType, @Param("date")String date,@Param("topNum")int topNum);

}