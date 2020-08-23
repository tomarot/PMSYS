package com.magic.www.permissions.domain;

import java.util.Date;

public class PlateMoneyView {
    //主键
    private Integer id;
    //类型 0 行业 1 概念
    private String type;
    //代码
    private String code;
    //名称
    private String name;
    //价格
    private String price;
    //涨幅
    private String gains;
    //主力净流入
    private String mainNetInflow;
    //时间
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
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

    public String getMainNetInflow() {
        return mainNetInflow;
    }

    public void setMainNetInflow(String mainNetInflow) {
        this.mainNetInflow = mainNetInflow == null ? null : mainNetInflow.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}