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
}
