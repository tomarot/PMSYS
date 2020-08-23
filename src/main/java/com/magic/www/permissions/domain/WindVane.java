package com.magic.www.permissions.domain;

import com.magic.www.permissions.base.PageBase;
import com.magic.www.permissions.base.ResultVo;
import com.magic.www.permissions.parameterExpand.QueryParameter;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 2020/7/20
 * Time: 13:43
 * To change this template use File | Settings | File Templates.
 * 板块风向标实体
 */
public class WindVane extends QueryParameter {

    //主键
    private Integer id;
    //代码
    private String code;
    //名称
    private String name;
    //级别 1 日 2 周 3 月
    private String type;
    //是否涨幅榜前十 1 是 0 否
    private String increasesList;
    //是否跌幅榜前十 1 是 0 否
    private String dropList;
    //是否资金流入 1 是 0 否
    private String moneyInflows;
    //是否资金流出 1 是 0 否
    private String moneyOut;
    //是否拥有涨停 1 是 0 否
    private String haveHarden;
    //是否风向标 1 是 0 否
    private String windVane;
    //首字母
    private String firstLetter;
    //日期
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getIncreasesList() {
        return increasesList;
    }

    public void setIncreasesList(String increasesList) {
        this.increasesList = increasesList == null ? null : increasesList.trim();
    }

    public String getDropList() {
        return dropList;
    }

    public void setDropList(String dropList) {
        this.dropList = dropList == null ? null : dropList.trim();
    }

    public String getMoneyInflows() {
        return moneyInflows;
    }

    public void setMoneyInflows(String moneyInflows) {
        this.moneyInflows = moneyInflows == null ? null : moneyInflows.trim();
    }

    public String getMoneyOut() {
        return moneyOut;
    }

    public void setMoneyOut(String moneyOut) {
        this.moneyOut = moneyOut == null ? null : moneyOut.trim();
    }

    public String getHaveHarden() {
        return haveHarden;
    }

    public void setHaveHarden(String haveHarden) {
        this.haveHarden = haveHarden == null ? null : haveHarden.trim();
    }

    public String getWindVane() {
        return windVane;
    }

    public void setWindVane(String windVane) {
        this.windVane = windVane == null ? null : windVane.trim();
    }

    public String getFirstLetter() {
        return firstLetter;
    }

    public void setFirstLetter(String firstLetter) {
        this.firstLetter = firstLetter == null ? null : firstLetter.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
