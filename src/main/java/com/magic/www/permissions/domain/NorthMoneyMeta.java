package com.magic.www.permissions.domain;

import com.magic.www.permissions.parameterExpand.QueryParameter;

import java.util.Date;

public class NorthMoneyMeta extends QueryParameter {

    //行业
    public static final String TYPE_HY = "0";
    //概念
    public static final String TYPE_GN = "1";

    //主键
    private Integer id;
    //东财行业编号
    private String HYCode;
    //原形编号
    private String ORIGINALCODE;
    private String ShareHold_JC_Min;
    private String ShareHold_ZC_Max;
    private String ShareSZ_JC_Min;
    private String ShareSZ_ZC_Max;
    private String SCode_Min_ZB;
    private String SCode_Max_ZB;
    private String ShareSZ_BK;
    private String ShareSZ_Min;
    private String ShareSZ_Max;
    //类型 0 行业 1 概念
    private String type;
    //周期类型 1日:1 3日:3 5日:5 10日:10 1月:m 季度:jd 1年:y
    private String DateType;
    //日期
    private Date HdDate;
    //板块名称
    private String HYName;
    //今日涨跌幅
    private String Zdf;
    //今日持股股票数量
    private String Count;
    //今日北向资金市值
    private String ShareSZ_GZ;
    // 今日占板块比
    private String ShareHold_Chg_BK;
    //今日占北向资金比
    private String ShareHold_Chg_GZ;
    //本周期持股数量
    private String ZC_Count;
    //本周期北向资金市值
    private String ShareSZ_ZC;
    //本周期市值增幅
    private String ShareHold_ZC_Chg;
    //本周期占板块比
    private String ShareHold_ZC_Chg_BK;
    //本周期占北向资金比
    private String ShareHold_ZC_Chg_GZ;
    //本周期增持最大市值股编号
    private String Max_SZ_Code;
    //本周期增持最大市值股名称
    private String Max_SZ_Name;
    //本周期最大占股本比股票编号
    private String Max_ZB_Code;
    //本周期最大占股本比股票名称
    private String Max_ZB_Name;
    //本周期最大减持股票编号
    private String Min_SZ_Code;
    //本周期最大减持股票名称
    private String Min_SZ_Name;
    //本周期最大减持占股本比股票编号
    private String Min_ZB_Code;
    //本周期最大减持占股本比股票编号
    private String Min_ZB_Name;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHYCode() {
        return HYCode;
    }

    public void setHYCode(String HYCode) {
        this.HYCode = HYCode;
    }

    public String getORIGINALCODE() {
        return ORIGINALCODE;
    }

    public void setORIGINALCODE(String ORIGINALCODE) {
        this.ORIGINALCODE = ORIGINALCODE;
    }

    public String getShareHold_JC_Min() {
        return ShareHold_JC_Min;
    }

    public void setShareHold_JC_Min(String shareHold_JC_Min) {
        ShareHold_JC_Min = shareHold_JC_Min;
    }

    public String getShareHold_ZC_Max() {
        return ShareHold_ZC_Max;
    }

    public void setShareHold_ZC_Max(String shareHold_ZC_Max) {
        ShareHold_ZC_Max = shareHold_ZC_Max;
    }

    public String getShareSZ_JC_Min() {
        return ShareSZ_JC_Min;
    }

    public void setShareSZ_JC_Min(String shareSZ_JC_Min) {
        ShareSZ_JC_Min = shareSZ_JC_Min;
    }

    public String getShareSZ_ZC_Max() {
        return ShareSZ_ZC_Max;
    }

    public void setShareSZ_ZC_Max(String shareSZ_ZC_Max) {
        ShareSZ_ZC_Max = shareSZ_ZC_Max;
    }

    public String getSCode_Min_ZB() {
        return SCode_Min_ZB;
    }

    public void setSCode_Min_ZB(String SCode_Min_ZB) {
        this.SCode_Min_ZB = SCode_Min_ZB;
    }

    public String getSCode_Max_ZB() {
        return SCode_Max_ZB;
    }

    public void setSCode_Max_ZB(String SCode_Max_ZB) {
        this.SCode_Max_ZB = SCode_Max_ZB;
    }

    public String getShareSZ_BK() {
        return ShareSZ_BK;
    }

    public void setShareSZ_BK(String shareSZ_BK) {
        ShareSZ_BK = shareSZ_BK;
    }

    public String getShareSZ_Min() {
        return ShareSZ_Min;
    }

    public void setShareSZ_Min(String shareSZ_Min) {
        ShareSZ_Min = shareSZ_Min;
    }

    public String getShareSZ_Max() {
        return ShareSZ_Max;
    }

    public void setShareSZ_Max(String shareSZ_Max) {
        ShareSZ_Max = shareSZ_Max;
    }

    public String getDateType() {
        return DateType;
    }

    public void setDateType(String dateType) {
        DateType = dateType;
    }

    public Date getHdDate() {
        return HdDate;
    }

    public void setHdDate(Date hdDate) {
        HdDate = hdDate;
    }

    public String getHYName() {
        return HYName;
    }

    public void setHYName(String HYName) {
        this.HYName = HYName;
    }

    public String getZdf() {
        return Zdf;
    }

    public void setZdf(String zdf) {
        Zdf = zdf;
    }

    public String getCount() {
        return Count;
    }

    public void setCount(String count) {
        Count = count;
    }

    public String getShareSZ_GZ() {
        return ShareSZ_GZ;
    }

    public void setShareSZ_GZ(String shareSZ_GZ) {
        ShareSZ_GZ = shareSZ_GZ;
    }

    public String getShareHold_Chg_BK() {
        return ShareHold_Chg_BK;
    }

    public void setShareHold_Chg_BK(String shareHold_Chg_BK) {
        ShareHold_Chg_BK = shareHold_Chg_BK;
    }

    public String getShareHold_Chg_GZ() {
        return ShareHold_Chg_GZ;
    }

    public void setShareHold_Chg_GZ(String shareHold_Chg_GZ) {
        ShareHold_Chg_GZ = shareHold_Chg_GZ;
    }

    public String getZC_Count() {
        return ZC_Count;
    }

    public void setZC_Count(String ZC_Count) {
        this.ZC_Count = ZC_Count;
    }

    public String getShareSZ_ZC() {
        return ShareSZ_ZC;
    }

    public void setShareSZ_ZC(String shareSZ_ZC) {
        ShareSZ_ZC = shareSZ_ZC;
    }

    public String getShareHold_ZC_Chg() {
        return ShareHold_ZC_Chg;
    }

    public void setShareHold_ZC_Chg(String shareHold_ZC_Chg) {
        ShareHold_ZC_Chg = shareHold_ZC_Chg;
    }

    public String getShareHold_ZC_Chg_BK() {
        return ShareHold_ZC_Chg_BK;
    }

    public void setShareHold_ZC_Chg_BK(String shareHold_ZC_Chg_BK) {
        ShareHold_ZC_Chg_BK = shareHold_ZC_Chg_BK;
    }

    public String getShareHold_ZC_Chg_GZ() {
        return ShareHold_ZC_Chg_GZ;
    }

    public void setShareHold_ZC_Chg_GZ(String shareHold_ZC_Chg_GZ) {
        ShareHold_ZC_Chg_GZ = shareHold_ZC_Chg_GZ;
    }

    public String getMax_SZ_Code() {
        return Max_SZ_Code;
    }

    public void setMax_SZ_Code(String max_SZ_Code) {
        Max_SZ_Code = max_SZ_Code;
    }

    public String getMax_SZ_Name() {
        return Max_SZ_Name;
    }

    public void setMax_SZ_Name(String max_SZ_Name) {
        Max_SZ_Name = max_SZ_Name;
    }

    public String getMax_ZB_Code() {
        return Max_ZB_Code;
    }

    public void setMax_ZB_Code(String max_ZB_Code) {
        Max_ZB_Code = max_ZB_Code;
    }

    public String getMax_ZB_Name() {
        return Max_ZB_Name;
    }

    public void setMax_ZB_Name(String max_ZB_Name) {
        Max_ZB_Name = max_ZB_Name;
    }

    public String getMin_SZ_Code() {
        return Min_SZ_Code;
    }

    public void setMin_SZ_Code(String min_SZ_Code) {
        Min_SZ_Code = min_SZ_Code;
    }

    public String getMin_SZ_Name() {
        return Min_SZ_Name;
    }

    public void setMin_SZ_Name(String min_SZ_Name) {
        Min_SZ_Name = min_SZ_Name;
    }

    public String getMin_ZB_Code() {
        return Min_ZB_Code;
    }

    public void setMin_ZB_Code(String min_ZB_Code) {
        Min_ZB_Code = min_ZB_Code;
    }

    public String getMin_ZB_Name() {
        return Min_ZB_Name;
    }

    public void setMin_ZB_Name(String min_ZB_Name) {
        Min_ZB_Name = min_ZB_Name;
    }
}