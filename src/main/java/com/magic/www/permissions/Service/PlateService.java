package com.magic.www.permissions.Service;

import com.magic.www.permissions.base.ResultVo;
import com.magic.www.permissions.domain.PlateBaseInfo;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 2020/7/22
 * Time: 13:05
 * 板块相关服务类
 */
public interface PlateService {

    /**
     * 获取板块信息列表
     * @param queryPlate
     * @return
     */
    public List<PlateBaseInfo> querySelective(PlateBaseInfo queryPlate);

    /**
     * 获取板块关联关系数据
     * @return
     */
    public ResultVo getPlateRelationData();

    /**
     * 设置板块关联关系
     * @param hyCode
     * @param gnCode
     * @return
     */
    public ResultVo setPlateRelation(String hyCode,String gnCode);

    /**
     * 关联板块与板块关系
     * 根据个股所关联的板块数据,建立板块与板块的关联关系
     * @return
     */
    public ResultVo CorrelationPlatePlateRelationData();


}
