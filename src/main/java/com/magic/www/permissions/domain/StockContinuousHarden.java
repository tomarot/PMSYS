package com.magic.www.permissions.domain;

import java.util.Date;

public class StockContinuousHarden {
    private Integer id;

    private String code;

    private String name;

    private Integer continuousHardenNum;

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

    public Integer getContinuousHardenNum() {
        return continuousHardenNum;
    }

    public void setContinuousHardenNum(Integer continuousHardenNum) {
        this.continuousHardenNum = continuousHardenNum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}