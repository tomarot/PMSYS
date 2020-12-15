package com.magic.www.permissions.domain;

import com.magic.www.permissions.parameterExpand.QueryParameter;

import java.util.Date;

public class NorthMoneyStockMeta extends QueryParameter {
    private Integer id;

    private String dateType;

    private Date hdDate;

    private String sCode;

    private String sName;

    private String hYName;

    private String hYCode;

    private String qYName;

    private String qYCode;

    private String sharesRate;

    private String newPrice;

    private String zdf;

    private String shareHold;

    private String shareSZ;

    private String ltzb;

    private String zzb;

    private String shareHoldChgOne;

    private String shareSZChgOne;

    private String shareSZChgRateOne;

    private String ltzbOne;

    private String zzbOne;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDateType() {
        return dateType;
    }

    public void setDateType(String dateType) {
        this.dateType = dateType == null ? null : dateType.trim();
    }

    public Date getHdDate() {
        return hdDate;
    }

    public void setHdDate(Date hdDate) {
        this.hdDate = hdDate;
    }

    public String getsCode() {
        return sCode;
    }

    public void setsCode(String sCode) {
        this.sCode = sCode == null ? null : sCode.trim();
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName == null ? null : sName.trim();
    }

    public String gethYName() {
        return hYName;
    }

    public void sethYName(String hYName) {
        this.hYName = hYName == null ? null : hYName.trim();
    }

    public String gethYCode() {
        return hYCode;
    }

    public void sethYCode(String hYCode) {
        this.hYCode = hYCode == null ? null : hYCode.trim();
    }

    public String getqYName() {
        return qYName;
    }

    public void setqYName(String qYName) {
        this.qYName = qYName == null ? null : qYName.trim();
    }

    public String getqYCode() {
        return qYCode;
    }

    public void setqYCode(String qYCode) {
        this.qYCode = qYCode == null ? null : qYCode.trim();
    }

    public String getSharesRate() {
        return sharesRate;
    }

    public void setSharesRate(String sharesRate) {
        this.sharesRate = sharesRate == null ? null : sharesRate.trim();
    }

    public String getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(String newPrice) {
        this.newPrice = newPrice == null ? null : newPrice.trim();
    }

    public String getZdf() {
        return zdf;
    }

    public void setZdf(String zdf) {
        this.zdf = zdf == null ? null : zdf.trim();
    }

    public String getShareHold() {
        return shareHold;
    }

    public void setShareHold(String shareHold) {
        this.shareHold = shareHold == null ? null : shareHold.trim();
    }

    public String getShareSZ() {
        return shareSZ;
    }

    public void setShareSZ(String shareSZ) {
        this.shareSZ = shareSZ == null ? null : shareSZ.trim();
    }

    public String getLtzb() {
        return ltzb;
    }

    public void setLtzb(String ltzb) {
        this.ltzb = ltzb == null ? null : ltzb.trim();
    }

    public String getZzb() {
        return zzb;
    }

    public void setZzb(String zzb) {
        this.zzb = zzb == null ? null : zzb.trim();
    }

    public String getShareHoldChgOne() {
        return shareHoldChgOne;
    }

    public void setShareHoldChgOne(String shareHoldChgOne) {
        this.shareHoldChgOne = shareHoldChgOne == null ? null : shareHoldChgOne.trim();
    }

    public String getShareSZChgOne() {
        return shareSZChgOne;
    }

    public void setShareSZChgOne(String shareSZChgOne) {
        this.shareSZChgOne = shareSZChgOne == null ? null : shareSZChgOne.trim();
    }

    public String getShareSZChgRateOne() {
        return shareSZChgRateOne;
    }

    public void setShareSZChgRateOne(String shareSZChgRateOne) {
        this.shareSZChgRateOne = shareSZChgRateOne == null ? null : shareSZChgRateOne.trim();
    }

    public String getLtzbOne() {
        return ltzbOne;
    }

    public void setLtzbOne(String ltzbOne) {
        this.ltzbOne = ltzbOne == null ? null : ltzbOne.trim();
    }

    public String getZzbOne() {
        return zzbOne;
    }

    public void setZzbOne(String zzbOne) {
        this.zzbOne = zzbOne == null ? null : zzbOne.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}