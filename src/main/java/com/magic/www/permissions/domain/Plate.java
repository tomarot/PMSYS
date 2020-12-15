package com.magic.www.permissions.domain;

import java.util.Date;

public class Plate {
    //主键
    private Integer id;
    //正序排名
    private Integer rankingP;
    //倒叙排名
    private Integer rankingR;
    //类型 0 行业 1 概念 2 地域

    private String type;
    //名称
    private String name;
    //涨幅
    private String gains;
    //三日涨幅
    private String threeDaysGains;
    //涨速
    private String higherSpeed;
    //领涨股
    private String leadStock;
    //涨跌家数
    private String upDownNum;
    //涨跌比
    private String upDownProportion;
    //换手
    private String changeHand;
    //总手/成交量
    private String totalHand;
    //三日换手
    private String threeDaysChangeHand;
    //金额
    private String totalPrice;
    //总市值
    private String totalMarket;
    //流通市值
    private String currentMarket;
    //平均收益
    private String averageIncome;
    //平均股本
    private String averageEquity;
    //市盈率
    private String peRatio;
    //时间
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRankingP() {
        return rankingP;
    }

    public void setRankingP(Integer rankingP) {
        this.rankingP = rankingP;
    }

    public Integer getRankingR() {
        return rankingR;
    }

    public void setRankingR(Integer rankingR) {
        this.rankingR = rankingR;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getGains() {
        return gains;
    }

    public void setGains(String gains) {
        this.gains = gains == null ? null : gains.trim();
    }

    public String getThreeDaysGains() {
        return threeDaysGains;
    }

    public void setThreeDaysGains(String threeDaysGains) {
        this.threeDaysGains = threeDaysGains == null ? null : threeDaysGains.trim();
    }

    public String getHigherSpeed() {
        return higherSpeed;
    }

    public void setHigherSpeed(String higherSpeed) {
        this.higherSpeed = higherSpeed == null ? null : higherSpeed.trim();
    }

    public String getLeadStock() {
        return leadStock;
    }

    public void setLeadStock(String leadStock) {
        this.leadStock = leadStock == null ? null : leadStock.trim();
    }

    public String getUpDownNum() {
        return upDownNum;
    }

    public void setUpDownNum(String upDownNum) {
        this.upDownNum = upDownNum == null ? null : upDownNum.trim();
    }

    public String getUpDownProportion() {
        return upDownProportion;
    }

    public void setUpDownProportion(String upDownProportion) {
        this.upDownProportion = upDownProportion == null ? null : upDownProportion.trim();
    }

    public String getChangeHand() {
        return changeHand;
    }

    public void setChangeHand(String changeHand) {
        this.changeHand = changeHand == null ? null : changeHand.trim();
    }

    public String getTotalHand() {
        return totalHand;
    }

    public void setTotalHand(String totalHand) {
        this.totalHand = totalHand == null ? null : totalHand.trim();
    }

    public String getThreeDaysChangeHand() {
        return threeDaysChangeHand;
    }

    public void setThreeDaysChangeHand(String threeDaysChangeHand) {
        this.threeDaysChangeHand = threeDaysChangeHand == null ? null : threeDaysChangeHand.trim();
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice == null ? null : totalPrice.trim();
    }

    public String getTotalMarket() {
        return totalMarket;
    }

    public void setTotalMarket(String totalMarket) {
        this.totalMarket = totalMarket == null ? null : totalMarket.trim();
    }

    public String getCurrentMarket() {
        return currentMarket;
    }

    public void setCurrentMarket(String currentMarket) {
        this.currentMarket = currentMarket == null ? null : currentMarket.trim();
    }

    public String getAverageIncome() {
        return averageIncome;
    }

    public void setAverageIncome(String averageIncome) {
        this.averageIncome = averageIncome == null ? null : averageIncome.trim();
    }

    public String getAverageEquity() {
        return averageEquity;
    }

    public void setAverageEquity(String averageEquity) {
        this.averageEquity = averageEquity == null ? null : averageEquity.trim();
    }

    public String getPeRatio() {
        return peRatio;
    }

    public void setPeRatio(String peRatio) {
        this.peRatio = peRatio == null ? null : peRatio.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}