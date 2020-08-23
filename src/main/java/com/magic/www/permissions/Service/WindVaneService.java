package com.magic.www.permissions.Service;

import com.magic.www.permissions.base.ResultVo;
import com.magic.www.permissions.parameterExpand.WindVaneParameter;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 2020/7/1
 * Time: 11:19
 * To change this template use File | Settings | File Templates.
 * 风向标服务
 */
public interface WindVaneService {


    /**
     * 获取风向标展示信息
     * @param windVaneParameter
     * @return
     */
    public ResultVo getWindVaneShowInfo(WindVaneParameter windVaneParameter);

    /**
     * 获取重要关注点
     * 包括行业概念板块涨幅前十、行业概念资金流入前十、是否有涨停个股
     * @param date
     * @return
     */
    public Map getTodayImportant(String date);

    /**
     * 保存风向标数据
     * @param windVaneStr
     * @return
     */
    public Map saveWindVane(String windVaneStr);
}
