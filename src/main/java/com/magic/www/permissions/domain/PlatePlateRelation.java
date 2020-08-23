package com.magic.www.permissions.domain;

import java.util.Date;

public class PlatePlateRelation {
    private Integer id;

    private Integer mPlateId;

    private String mPlateCode;

    private Integer vPlateId;

    private String vPlateCode;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getmPlateId() {
        return mPlateId;
    }

    public void setmPlateId(Integer mPlateId) {
        this.mPlateId = mPlateId;
    }

    public String getmPlateCode() {
        return mPlateCode;
    }

    public void setmPlateCode(String mPlateCode) {
        this.mPlateCode = mPlateCode == null ? null : mPlateCode.trim();
    }

    public Integer getvPlateId() {
        return vPlateId;
    }

    public void setvPlateId(Integer vPlateId) {
        this.vPlateId = vPlateId;
    }

    public String getvPlateCode() {
        return vPlateCode;
    }

    public void setvPlateCode(String vPlateCode) {
        this.vPlateCode = vPlateCode == null ? null : vPlateCode.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}