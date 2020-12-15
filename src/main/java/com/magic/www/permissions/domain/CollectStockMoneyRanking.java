package com.magic.www.permissions.domain;

import com.magic.www.permissions.parameterExpand.QueryParameter;

import java.util.Date;

public class CollectStockMoneyRanking extends QueryParameter{
    private Integer id;

    private String dateType;

    private String code;

    private String name;

    private String zdf;

    private String mainNetInflow;

    private String mainNetProportion;

    private String veryLargeSingleNet;

    private String veryLargeSingleProportion;

    private String largeSingleNet;

    private String largeSingleProportion;

    private String singleNet;

    private String singleNetProportion;

    private String smallSingleNet;

    private String smallSingleProportion;

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

    public String getZdf() {
        return zdf;
    }

    public void setZdf(String zdf) {
        this.zdf = zdf == null ? null : zdf.trim();
    }

    public String getMainNetInflow() {
        return mainNetInflow;
    }

    public void setMainNetInflow(String mainNetInflow) {
        this.mainNetInflow = mainNetInflow == null ? null : mainNetInflow.trim();
    }

    public String getMainNetProportion() {
        return mainNetProportion;
    }

    public void setMainNetProportion(String mainNetProportion) {
        this.mainNetProportion = mainNetProportion == null ? null : mainNetProportion.trim();
    }

    public String getVeryLargeSingleNet() {
        return veryLargeSingleNet;
    }

    public void setVeryLargeSingleNet(String veryLargeSingleNet) {
        this.veryLargeSingleNet = veryLargeSingleNet == null ? null : veryLargeSingleNet.trim();
    }

    public String getVeryLargeSingleProportion() {
        return veryLargeSingleProportion;
    }

    public void setVeryLargeSingleProportion(String veryLargeSingleProportion) {
        this.veryLargeSingleProportion = veryLargeSingleProportion == null ? null : veryLargeSingleProportion.trim();
    }

    public String getLargeSingleNet() {
        return largeSingleNet;
    }

    public void setLargeSingleNet(String largeSingleNet) {
        this.largeSingleNet = largeSingleNet == null ? null : largeSingleNet.trim();
    }

    public String getLargeSingleProportion() {
        return largeSingleProportion;
    }

    public void setLargeSingleProportion(String largeSingleProportion) {
        this.largeSingleProportion = largeSingleProportion == null ? null : largeSingleProportion.trim();
    }

    public String getSingleNet() {
        return singleNet;
    }

    public void setSingleNet(String singleNet) {
        this.singleNet = singleNet == null ? null : singleNet.trim();
    }

    public String getSingleNetProportion() {
        return singleNetProportion;
    }

    public void setSingleNetProportion(String singleNetProportion) {
        this.singleNetProportion = singleNetProportion == null ? null : singleNetProportion.trim();
    }

    public String getSmallSingleNet() {
        return smallSingleNet;
    }

    public void setSmallSingleNet(String smallSingleNet) {
        this.smallSingleNet = smallSingleNet == null ? null : smallSingleNet.trim();
    }

    public String getSmallSingleProportion() {
        return smallSingleProportion;
    }

    public void setSmallSingleProportion(String smallSingleProportion) {
        this.smallSingleProportion = smallSingleProportion == null ? null : smallSingleProportion.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}