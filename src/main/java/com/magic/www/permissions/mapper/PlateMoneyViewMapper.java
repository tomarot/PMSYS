package com.magic.www.permissions.mapper;

import com.magic.www.permissions.domain.PlateMoneyView;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface PlateMoneyViewMapper {

    /**
     * 获取板块资金流入榜数据
     * @param type 类型
     * @param date  日期
     * @param num 数量
     * @return
     */
    public List<PlateMoneyView> queryPlateMoneyInflowsTop(@Param("type")String type, @Param("date")String date, @Param("num")int num);


    /**
     * 获取板块资金流出榜数据
     * @param type 类型
     * @param date 日期
     * @param num 数量
     * @return
     */
    public List<PlateMoneyView> queryPlateMoneyOutOfTop(@Param("type")String type,@Param("date")String date,@Param("num")int num);
}