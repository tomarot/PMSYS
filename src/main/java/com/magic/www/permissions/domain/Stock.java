package com.magic.www.permissions.domain;

import com.magic.www.permissions.base.Order;
import com.magic.www.permissions.parameterExpand.QueryParameter;

import java.util.Date;
import java.util.List;

public class Stock extends QueryParameter{
    //主键
    private Integer id;
    //代码
    private String code;
    //名称
    private String name;
    //最新价格
    private String price;
    //涨幅
    private String gains;
    //涨跌值
    private String gainsval;
    //总市值
    private String totalval;
    //换手
    private String changeHand;
    //买入价
    private String buyPrice;
    //卖出价
    private String sellPrice;
    //涨速
    private String higherSpeed;
    //总手
    private String totalHand;
    //成交金额
    private String totalPrice;
    //市盈率
    private String peRatio;
    //所属行业
    private String industryInvolved;
    //最高
    private String highest;
    //现手
    private String newvol;
    //开盘价
    private String startPrice;
    //昨日收盘价
    private String yesterdayEndPrice;
    //振幅
    private String amplitude;
    //量比
    private String than;
    //最低价
    private String lowest;
    //委比
    private String committeePoor;
    //均价
    private String averagePrice;
    //内盘
    private String insideDish;
    //外盘
    private String outsideDish;
    //内外比
    private String insideOutsideThan;
    //买一量
    private String buyOneVal;
    //委比
    private String appointThan;
    //市净率
    private String pbRatio;
    //总股本
    private String totalEquity;
    //卖一量
    private String sellOneVal;
    //流通股本
    private String circulationCapital;
    //流通市值
    private String currentMarket;
    //三日涨幅
    private String threeDaysGains;
    //六日涨幅
    private String sixDaysGains;
    //三日换手
    private String threeDaysChangeHand;
    //六日换手
    private String sixDaysChangeHand;
    //时间
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    public String getGains() {
        return gains;
    }

    public void setGains(String gains) {
        this.gains = gains == null ? null : gains.trim();
    }

    public String getGainsval() {
        return gainsval;
    }

    public void setGainsval(String gainsval) {
        this.gainsval = gainsval == null ? null : gainsval.trim();
    }

    public String getTotalval() {
        return totalval;
    }

    public void setTotalval(String totalval) {
        this.totalval = totalval == null ? null : totalval.trim();
    }

    public String getChangeHand() {
        return changeHand;
    }

    public void setChangeHand(String changeHand) {
        this.changeHand = changeHand == null ? null : changeHand.trim();
    }

    public String getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(String buyPrice) {
        this.buyPrice = buyPrice == null ? null : buyPrice.trim();
    }

    public String getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(String sellPrice) {
        this.sellPrice = sellPrice == null ? null : sellPrice.trim();
    }

    public String getHigherSpeed() {
        return higherSpeed;
    }

    public void setHigherSpeed(String higherSpeed) {
        this.higherSpeed = higherSpeed == null ? null : higherSpeed.trim();
    }

    public String getTotalHand() {
        return totalHand;
    }

    public void setTotalHand(String totalHand) {
        this.totalHand = totalHand == null ? null : totalHand.trim();
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice == null ? null : totalPrice.trim();
    }

    public String getPeRatio() {
        return peRatio;
    }

    public void setPeRatio(String peRatio) {
        this.peRatio = peRatio == null ? null : peRatio.trim();
    }

    public String getIndustryInvolved() {
        return industryInvolved;
    }

    public void setIndustryInvolved(String industryInvolved) {
        this.industryInvolved = industryInvolved == null ? null : industryInvolved.trim();
    }

    public String getHighest() {
        return highest;
    }

    public void setHighest(String highest) {
        this.highest = highest == null ? null : highest.trim();
    }

    public String getNewvol() {
        return newvol;
    }

    public void setNewvol(String newvol) {
        this.newvol = newvol == null ? null : newvol.trim();
    }

    public String getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(String startPrice) {
        this.startPrice = startPrice == null ? null : startPrice.trim();
    }

    public String getYesterdayEndPrice() {
        return yesterdayEndPrice;
    }

    public void setYesterdayEndPrice(String yesterdayEndPrice) {
        this.yesterdayEndPrice = yesterdayEndPrice == null ? null : yesterdayEndPrice.trim();
    }

    public String getAmplitude() {
        return amplitude;
    }

    public void setAmplitude(String amplitude) {
        this.amplitude = amplitude == null ? null : amplitude.trim();
    }

    public String getThan() {
        return than;
    }

    public void setThan(String than) {
        this.than = than == null ? null : than.trim();
    }

    public String getLowest() {
        return lowest;
    }

    public void setLowest(String lowest) {
        this.lowest = lowest == null ? null : lowest.trim();
    }

    public String getCommitteePoor() {
        return committeePoor;
    }

    public void setCommitteePoor(String committeePoor) {
        this.committeePoor = committeePoor == null ? null : committeePoor.trim();
    }

    public String getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(String averagePrice) {
        this.averagePrice = averagePrice == null ? null : averagePrice.trim();
    }

    public String getInsideDish() {
        return insideDish;
    }

    public void setInsideDish(String insideDish) {
        this.insideDish = insideDish == null ? null : insideDish.trim();
    }

    public String getOutsideDish() {
        return outsideDish;
    }

    public void setOutsideDish(String outsideDish) {
        this.outsideDish = outsideDish == null ? null : outsideDish.trim();
    }

    public String getInsideOutsideThan() {
        return insideOutsideThan;
    }

    public void setInsideOutsideThan(String insideOutsideThan) {
        this.insideOutsideThan = insideOutsideThan == null ? null : insideOutsideThan.trim();
    }

    public String getBuyOneVal() {
        return buyOneVal;
    }

    public void setBuyOneVal(String buyOneVal) {
        this.buyOneVal = buyOneVal == null ? null : buyOneVal.trim();
    }

    public String getAppointThan() {
        return appointThan;
    }

    public void setAppointThan(String appointThan) {
        this.appointThan = appointThan == null ? null : appointThan.trim();
    }

    public String getPbRatio() {
        return pbRatio;
    }

    public void setPbRatio(String pbRatio) {
        this.pbRatio = pbRatio == null ? null : pbRatio.trim();
    }

    public String getTotalEquity() {
        return totalEquity;
    }

    public void setTotalEquity(String totalEquity) {
        this.totalEquity = totalEquity == null ? null : totalEquity.trim();
    }

    public String getSellOneVal() {
        return sellOneVal;
    }

    public void setSellOneVal(String sellOneVal) {
        this.sellOneVal = sellOneVal == null ? null : sellOneVal.trim();
    }

    public String getCirculationCapital() {
        return circulationCapital;
    }

    public void setCirculationCapital(String circulationCapital) {
        this.circulationCapital = circulationCapital == null ? null : circulationCapital.trim();
    }

    public String getCurrentMarket() {
        return currentMarket;
    }

    public void setCurrentMarket(String currentMarket) {
        this.currentMarket = currentMarket == null ? null : currentMarket.trim();
    }

    public String getThreeDaysGains() {
        return threeDaysGains;
    }

    public void setThreeDaysGains(String threeDaysGains) {
        this.threeDaysGains = threeDaysGains == null ? null : threeDaysGains.trim();
    }

    public String getSixDaysGains() {
        return sixDaysGains;
    }

    public void setSixDaysGains(String sixDaysGains) {
        this.sixDaysGains = sixDaysGains == null ? null : sixDaysGains.trim();
    }

    public String getThreeDaysChangeHand() {
        return threeDaysChangeHand;
    }

    public void setThreeDaysChangeHand(String threeDaysChangeHand) {
        this.threeDaysChangeHand = threeDaysChangeHand == null ? null : threeDaysChangeHand.trim();
    }

    public String getSixDaysChangeHand() {
        return sixDaysChangeHand;
    }

    public void setSixDaysChangeHand(String sixDaysChangeHand) {
        this.sixDaysChangeHand = sixDaysChangeHand == null ? null : sixDaysChangeHand.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}