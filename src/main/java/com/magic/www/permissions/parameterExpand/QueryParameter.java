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
}
