package com.magic.www.permissions.mapper;

import com.magic.www.permissions.domain.Plate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PlateMapper {
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
    int insert(Plate record);

    /**
     * 插入数据
     * @param record
     * @return
     */
    int insertSelective(Plate record);

    /**
     * 获取数据
     * @param id
     * @return
     */
    Plate selectByPrimaryKey(Integer id);

    /**
     * 修改数据
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Plate record);

    /**
     * 修改数据
     * 全字段
     * @param record
     * @return
     */
    int updateByPrimaryKey(Plate record);

    /**
     * 获取板块涨幅榜数据
     * @param type 类型
     * @param date 日期
     * @param num 数量
     * @return
     */
    List<Plate> queryPerformerTop(@Param("type")String type, @Param("date")String date,@Param("num")int num);

    /**
     * 获取板块跌幅榜数据
     * @param type
     * @param date
     * @param num
     * @return
     */
    List<Plate> queryDropTop(@Param("type")String type, @Param("date")String date,@Param("num")int num);
}