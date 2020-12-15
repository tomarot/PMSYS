package com.magic.www.permissions.domain;

import java.util.Date;

public class StockDataMeta {
    private Integer id;

    private String code;

    private String name;

    private String currentPrice;

    private String gains;

    private String gainsNum;

    private String totalHand;

    private String totalPrice;

    private String amplitude;

    private String highest;

    private String lowest;

    private String startPrice;

    private String yesterdayEndPrice;

    private String than;

    private String changeHand;

    private String peRatio;

    private String pbRatio;

    private String totalval;

    private String currentMarket;

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

    public String getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(String currentPrice) {
        this.currentPrice = currentPrice == null ? null : currentPrice.trim();
    }

    public String getGains() {
        return gains;
    }

    public void setGains(String gains) {
        this.gains = gains == null ? null : gains.trim();
    }

    public String getGainsNum() {
        return gainsNum;
    }

    public void setGainsNum(String gainsNum) {
        this.gainsNum = gainsNum == null ? null : gainsNum.trim();
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

    public String getAmplitude() {
        return amplitude;
    }

    public void setAmplitude(String amplitude) {
        this.amplitude = amplitude == null ? null : amplitude.trim();
    }

    public String getHighest() {
        return highest;
    }

    public void setHighest(String highest) {
        this.highest = highest == null ? null : highest.trim();
    }

    public String getLowest() {
        return lowest;
    }

    public void setLowest(String lowest) {
        this.lowest = lowest == null ? null : lowest.trim();
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

    public String getThan() {
        return than;
    }

    public void setThan(String than) {
        this.than = than == null ? null : than.trim();
    }

    public String getChangeHand() {
        return changeHand;
    }

    public void setChangeHand(String changeHand) {
        this.changeHand = changeHand == null ? null : changeHand.trim();
    }

    public String getPeRatio() {
        return peRatio;
    }

    public void setPeRatio(String peRatio) {
        this.peRatio = peRatio == null ? null : peRatio.trim();
    }

    public String getPbRatio() {
        return pbRatio;
    }

    public void setPbRatio(String pbRatio) {
        this.pbRatio = pbRatio == null ? null : pbRatio.trim();
    }

    public String getTotalval() {
        return totalval;
    }

    public void setTotalval(String totalval) {
        this.totalval = totalval == null ? null : totalval.trim();
    }

    public String getCurrentMarket() {
        return currentMarket;
    }

    public void setCurrentMarket(String currentMarket) {
        this.currentMarket = currentMarket == null ? null : currentMarket.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}