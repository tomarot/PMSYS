package com.magic.www.permissions.mapper;

import com.magic.www.permissions.domain.WindVane;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface WindVaneMapper {
    /**
     * 删除数据
     * 根据id
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存数据
     * 全字段
     * @param record
     * @return
     */
    int insert(WindVane record);

    /**
     * 保存数据
     * @param record
     * @return
     */
    int insertSelective(WindVane record);

    /**
     * 获取数据
     * 根据主键
     * @param id
     * @return
     */
    WindVane selectByPrimaryKey(Integer id);

    /**
     * 修改数据
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(WindVane record);

    /**
     * 修改数据
     * 根据主键
     * @param record
     * @return
     */
    int updateByPrimaryKey(WindVane record);

    /**
     * 获取风向标日期列表
     * @param type
     * @return
     */
    List<Date> getWindVaneDateList(@Param("type")String type);

    /**
     * 查询风向标
     * @param record
     * @return
     */
    List<WindVane> querySelective(WindVane record);

    /**
     * 获取风向标最小数量
     * @param type
     * @param startDate null表示从最早数据开始
     * @param endDate null表示到最新数据
     * @return
     */
    int queryMinWindVaneNum(@Param("type")String type,@Param("startDate")String startDate,@Param("endDate")String endDate);

    /**
     * 获取风向标最大数量
     * @param type
     * @param startDate null表示从最早数据开始
     * @param endDate null表示到最新数据
     * @return
     */
    int queryMaxWindVaneNum(@Param("type")String type,@Param("startDate")String startDate,@Param("endDate")String endDate);

    /**
     * 获取风向标每周期数量
     * @param type
     * @param startDate null表示从最早数据开始
     * @param endDate null表示到最新数据
     * @return Map key:日期 value:数量
     */
    List<Map<String,Object>> queryWindVaneNum(@Param("type")String type,@Param("startDate")String startDate,@Param("endDate")String endDate);
}