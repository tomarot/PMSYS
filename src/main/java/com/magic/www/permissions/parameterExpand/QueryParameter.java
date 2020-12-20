package com.magic.www.permissions.parameterExpand;

import com.magic.www.permissions.base.PageBase;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 2020/8/2
 * Time: 16:55
 * To change this template use File | Settings | File Templates.
 */
public class QueryParameter extends PageBase{

    //排序功能状态 禁用
    public static int ORDER_STATE_DISABLE = 0;
    //排序功能状态 启用
    public static int ORDER_STATE_ENABLE = 1;

    //排序类型 升序
    public static String ORDER_ASC = "ASC";
    //排序类型 降序
    public static String ORDER_DESC = "DESC";


    //开始时间
    public Date startDate;
    //结束时间
    public Date endDate;

    //日期
    public String createTimeStr;

    //最大涨幅
    public String maxGains;
    //最小涨幅
    public String minGains;

    //排序状态
    public int orderState;
    //排序字段
    public String orderStr;
    //排序类型
    public String orderType;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getMaxGains() {
        return maxGains;
    }

    public void setMaxGains(String maxGains) {
        this.maxGains = maxGains;
    }

    public String getMinGains() {
        return minGains;
    }

    public void setMinGains(String minGains) {
        this.minGains = minGains;
    }

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
    }

    public int getOrderState() {
        return orderState;
    }

    public void setOrderState(int orderState) {
        this.orderState = orderState;
    }

    public String getOrderStr() {
        return orderStr;
    }

    public void setOrderStr(String orderStr) {
        this.orderStr = orderStr;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }
}
