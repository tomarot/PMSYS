package com.magic.www.permissions.collect;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 2020/7/27
 * Time: 9:01
 * 数据采集器
 */
@Component
public class Collector {

    /*————————北向资金URL————————*/
    //行业板块1日URL
    public static final String HY_1R_URL = "http://dcfm.eastmoney.com/EM_MutiSvcExpandInterface/api/js/get?type=HSGT20_HYTJ_SUM&token=894050c76af8597a853f5b408b759f5d&st=ShareSZ_ZC&sr=-1&p=1&ps=1000&js=var%20dBMlqdii={pages:(tp),data:(x)}&filter=(DateType=%271%27)&rt=53177425";
    //行业板块3日URL
    public static final String HY_3R_URL = "http://dcfm.eastmoney.com/EM_MutiSvcExpandInterface/api/js/get?type=HSGT20_HYTJ_SUM&token=894050c76af8597a853f5b408b759f5d&st=ShareSZ_ZC&sr=-1&p=1&ps=1000&js=var%20nSwOCcMJ={pages:(tp),data:(x)}&filter=(DateType=%273%27)&rt=53177438";
    //行业板块5日URL
    public static final String HY_5R_URL = "http://dcfm.eastmoney.com/EM_MutiSvcExpandInterface/api/js/get?type=HSGT20_HYTJ_SUM&token=894050c76af8597a853f5b408b759f5d&st=ShareSZ_ZC&sr=-1&p=1&ps=1000&js=var%20jAcXwsrN={pages:(tp),data:(x)}&filter=(DateType=%275%27)&rt=53177439";
    //行业板块10日URL
    public static final String HY_10R_URL = "http://dcfm.eastmoney.com/EM_MutiSvcExpandInterface/api/js/get?type=HSGT20_HYTJ_SUM&token=894050c76af8597a853f5b408b759f5d&st=ShareSZ_ZC&sr=-1&p=1&ps=1000&js=var%20dPIWnaJS={pages:(tp),data:(x)}&filter=(DateType=%2710%27)&rt=53177441";
    //行业板块1月URL
    public static final String HY_1Y_URL = "http://dcfm.eastmoney.com/EM_MutiSvcExpandInterface/api/js/get?type=HSGT20_HYTJ_SUM&token=894050c76af8597a853f5b408b759f5d&st=ShareSZ_ZC&sr=-1&p=1&ps=1000&js=var%20OgZFOzuR={pages:(tp),data:(x)}&filter=(DateType=%27m%27)&rt=53184926";
    //行业板块1季度URL
    public static final String HY_1JD_URL = "http://dcfm.eastmoney.com/EM_MutiSvcExpandInterface/api/js/get?type=HSGT20_HYTJ_SUM&token=894050c76af8597a853f5b408b759f5d&st=ShareSZ_ZC&sr=-1&p=1&ps=1000&js=var%20KVNfoDIW={pages:(tp),data:(x)}&filter=(DateType=%27jd%27)&rt=53184926";
    //行业板块1年URL
    public static final String HY_1N_URL = "http://dcfm.eastmoney.com/EM_MutiSvcExpandInterface/api/js/get?type=HSGT20_HYTJ_SUM&token=894050c76af8597a853f5b408b759f5d&st=ShareSZ_ZC&sr=-1&p=1&ps=1000&js=var%20FoKdporb={pages:(tp),data:(x)}&filter=(DateType=%27y%27)&rt=53184952";


    //概念板块1日URL
    public static final String GN_1R_URL = "http://dcfm.eastmoney.com/EM_MutiSvcExpandInterface/api/js/get?type=HSGT20_GNTJ_SUM&token=894050c76af8597a853f5b408b759f5d&st=ShareSZ_ZC&sr=-1&p=1&ps=1000&js=var%20sJoJeQOc={pages:(tp),data:(x)}&filter=(DateType=%271%27)&rt=53185017";
    //概念板块3日URL
    public static final String GN_3R_URL = "http://dcfm.eastmoney.com/EM_MutiSvcExpandInterface/api/js/get?type=HSGT20_GNTJ_SUM&token=894050c76af8597a853f5b408b759f5d&st=ShareSZ_ZC&sr=-1&p=1&ps=1000&js=var%20rRAYqLgc={pages:(tp),data:(x)}&filter=(DateType=%273%27)&rt=53185018";
    //概念板块5日URL
    public static final String GN_5R_URL = "http://dcfm.eastmoney.com/EM_MutiSvcExpandInterface/api/js/get?type=HSGT20_GNTJ_SUM&token=894050c76af8597a853f5b408b759f5d&st=ShareSZ_ZC&sr=-1&p=1&ps=1000&js=var%20YJZgYPia={pages:(tp),data:(x)}&filter=(DateType=%275%27)&rt=53185018";
    //概念板块10日URL
    public static final String GN_10R_URL = "http://dcfm.eastmoney.com/EM_MutiSvcExpandInterface/api/js/get?type=HSGT20_GNTJ_SUM&token=894050c76af8597a853f5b408b759f5d&st=ShareSZ_ZC&sr=-1&p=1&ps=1000&js=var%20pepWxbtM={pages:(tp),data:(x)}&filter=(DateType=%2710%27)&rt=53185019";
    //概念板块1月URL
    public static final String GN_1Y_URL = "http://dcfm.eastmoney.com/EM_MutiSvcExpandInterface/api/js/get?type=HSGT20_GNTJ_SUM&token=894050c76af8597a853f5b408b759f5d&st=ShareSZ_ZC&sr=-1&p=1&ps=1000&js=var%20KsrRbyAC={pages:(tp),data:(x)}&filter=(DateType=%27m%27)&rt=53185019";
    //概念板块1季度URL
    public static final String GN_1JD_URL = "http://dcfm.eastmoney.com/EM_MutiSvcExpandInterface/api/js/get?type=HSGT20_GNTJ_SUM&token=894050c76af8597a853f5b408b759f5d&st=ShareSZ_ZC&sr=-1&p=1&ps=1000&js=var%20RntAVmPt={pages:(tp),data:(x)}&filter=(DateType=%27jd%27)&rt=53185020";
    //概念板块1年URL
    public static final String GN_1N_URL = "http://dcfm.eastmoney.com/EM_MutiSvcExpandInterface/api/js/get?type=HSGT20_GNTJ_SUM&token=894050c76af8597a853f5b408b759f5d&st=ShareSZ_ZC&sr=-1&p=1&ps=1000&js=var%20GORTlkxe={pages:(tp),data:(x)}&filter=(DateType=%27y%27)&rt=53185020";

    //个股1日URL
    public static final String GG_1R_URL = "http://dcfm.eastmoney.com/EM_MutiSvcExpandInterface/api/js/get?type=HSGT20_GGTJ_SUM&token=894050c76af8597a853f5b408b759f5d&st=ShareSZ_Chg_One&sr=-1&p=1&ps=10000&js=var%20daNvOsuS={pages:(tp),data:(x)}&filter=(DateType=%271%27%20and%20HdDate=%272020-09-30%27)&rt=53392912";
    //个股3日URL
    public static final String GG_3R_URL = "http://dcfm.eastmoney.com/EM_MutiSvcExpandInterface/api/js/get?type=HSGT20_GGTJ_SUM&token=894050c76af8597a853f5b408b759f5d&st=ShareSZ_Chg_One&sr=-1&p=1&ps=10000&js=var%20FRFwgQAD={pages:(tp),data:(x)}&filter=(DateType=%273%27%20and%20HdDate=%272020-09-30%27)&rt=53392916";
    //个股5日URL
    public static final String GG_5R_URL = "http://dcfm.eastmoney.com/EM_MutiSvcExpandInterface/api/js/get?type=HSGT20_GGTJ_SUM&token=894050c76af8597a853f5b408b759f5d&st=ShareSZ_Chg_One&sr=-1&p=1&ps=10000&js=var%20hXmtkTer={pages:(tp),data:(x)}&filter=(DateType=%275%27%20and%20HdDate=%272020-09-30%27)&rt=53392923";
    //个股10日URL
    public static final String GG_10R_URL = "http://dcfm.eastmoney.com/EM_MutiSvcExpandInterface/api/js/get?type=HSGT20_GGTJ_SUM&token=894050c76af8597a853f5b408b759f5d&st=ShareSZ_Chg_One&sr=-1&p=1&ps=10000&js=var%20eYUNWPIG={pages:(tp),data:(x)}&filter=(DateType=%2710%27%20and%20HdDate=%272020-09-30%27)&rt=53392924";
    //个股1月URL
    public static final String GG_1Y_URL = "http://dcfm.eastmoney.com/EM_MutiSvcExpandInterface/api/js/get?type=HSGT20_GGTJ_SUM&token=894050c76af8597a853f5b408b759f5d&st=ShareSZ_Chg_One&sr=-1&p=1&ps=10000&js=var%20SzKEgWKE={pages:(tp),data:(x)}&filter=(DateType=%27m%27%20and%20HdDate=%272020-09-30%27)&rt=53392925";
    //个股1季度URL
    public static final String GG_1JD_URL = "http://dcfm.eastmoney.com/EM_MutiSvcExpandInterface/api/js/get?type=HSGT20_GGTJ_SUM&token=894050c76af8597a853f5b408b759f5d&st=ShareSZ_Chg_One&sr=-1&p=1&ps=10000&js=var%20kHpeHbXd={pages:(tp),data:(x)}&filter=(DateType=%27jd%27%20and%20HdDate=%272020-09-30%27)&rt=53392926";
    //个股1年URL
    public static final String GG_1N_URL = "http://dcfm.eastmoney.com/EM_MutiSvcExpandInterface/api/js/get?type=HSGT20_GGTJ_SUM&token=894050c76af8597a853f5b408b759f5d&st=ShareSZ_Chg_One&sr=-1&p=1&ps=10000&js=var%20dVJhlBYE={pages:(tp),data:(x)}&filter=(DateType=%27y%27%20and%20HdDate=%272020-09-30%27)&rt=53392927";



    /*————————股票信息采集URL——————————*/
    public static final String STOCK_BASE_INFO_URL = "http://70.push2.eastmoney.com/api/qt/clist/get?cb=jQuery112403359411797212848_1597891603350&pn=1&pz=10000&po=1&np=1&ut=bd1d9ddb04089700cf9c27f6f7426281&fltt=2&invt=2&fid=f3&fs=m:0+t:6,m:0+t:13,m:0+t:80,m:1+t:2,m:1+t:23&fields=f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f12,f13,f14,f15,f16,f17,f18,f20,f21,f23,f24,f25,f22,f11,f62,f128,f136,f115,f152&_=1597891603351";

    /*————————实时个股涨跌数据URL————————*/
    public static final String CURRENT_STOCK_GAINS_INFO_URL = "http://59.push2.eastmoney.com/api/qt/clist/get?cb=jQuery112407299899240931866_1599875871377&pn=1&pz=10000&po=1&np=1&ut=bd1d9ddb04089700cf9c27f6f7426281&fltt=2&invt=2&fid=f3&fs=m:0+t:6,m:0+t:13,m:0+t:80,m:1+t:2,m:1+t:23&fields=f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f12,f13,f14,f15,f16,f17,f18,f20,f21,f23,f24,f25,f22,f11,f62,f128,f136,f115,f152&_=1599875871378";

    /*————————股票核心题材采集URL————————*/
    public static final String STOCK_CORE_CONCEPTION_URL = "http://f10.eastmoney.com/CoreConception/CoreConceptionAjax?code=";

    /*————————板块信息采集URL——————————*/
    //行业板块
    public static final String PLATE_HY_URL = "http://58.push2.eastmoney.com/api/qt/clist/get?cb=jQuery112403973166983836198_1597933371818&pn=1&pz=10000&po=1&np=1&ut=bd1d9ddb04089700cf9c27f6f7426281&fltt=2&invt=2&fid=f3&fs=m:90+t:2+f:!50&fields=f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f12,f13,f14,f15,f16,f17,f18,f20,f21,f23,f24,f25,f26,f22,f33,f11,f62,f128,f136,f115,f152,f124,f107,f104,f105,f140,f141,f207,f208,f209,f222&_=1597933371841";
    //概念板块
    public static final String PLATE_GN_URL = "http://58.push2.eastmoney.com/api/qt/clist/get?cb=jQuery112403973166983836198_1597933371818&pn=1&pz=10000&po=1&np=1&ut=bd1d9ddb04089700cf9c27f6f7426281&fltt=2&invt=2&fid=f3&fs=m:90+t:3+f:!50&fields=f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f12,f13,f14,f15,f16,f17,f18,f20,f21,f23,f24,f25,f26,f22,f33,f11,f62,f128,f136,f115,f152,f124,f107,f104,f105,f140,f141,f207,f208,f209,f222&_=1597933371887";
    //地域
    public static final String PLATE_DY_URL = "http://58.push2.eastmoney.com/api/qt/clist/get?cb=jQuery112403973166983836198_1597933371814&pn=1&pz=10000&po=1&np=1&ut=bd1d9ddb04089700cf9c27f6f7426281&fltt=2&invt=2&fid=f3&fs=m:90+t:1+f:!50&fields=f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f12,f13,f14,f15,f16,f17,f18,f20,f21,f23,f24,f25,f26,f22,f33,f11,f62,f128,f136,f115,f152,f124,f107,f104,f105,f140,f141,f207,f208,f209,f222&_=1597933371867";

    /*————————板块排行信息采集URL——————————*/
    //概念板块
    public static final String PLATE_RANKING_GN_URL = "http://60.push2.eastmoney.com/api/qt/clist/get?cb=jQuery112404937030508977105_1601807126714&pn=1&pz=10000&po=1&np=1&ut=bd1d9ddb04089700cf9c27f6f7426281&fltt=2&invt=2&fid=f3&fs=m:90+t:3+f:!50&fields=f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f12,f13,f14,f15,f16,f17,f18,f20,f21,f23,f24,f25,f26,f22,f33,f11,f62,f128,f136,f115,f152,f124,f107,f104,f105,f140,f141,f207,f208,f209,f222&_=1601807126717";
    //行业板块
    public static final String PLATE_RANKING_HY_URL = "http://18.push2.eastmoney.com/api/qt/clist/get?cb=jQuery112408080147688654697_1601794700554&pn=1&pz=10000&po=1&np=1&ut=bd1d9ddb04089700cf9c27f6f7426281&fltt=2&invt=2&fid=f3&fs=m:90+t:2+f:!50&fields=f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f12,f13,f14,f15,f16,f17,f18,f20,f21,f23,f24,f25,f26,f22,f33,f11,f62,f128,f136,f115,f152,f124,f107,f104,f105,f140,f141,f207,f208,f209,f222&_=1601794701007";
    //地域板块
    public static final String PLATE_RANKING_DY_URL = "http://60.push2.eastmoney.com/api/qt/clist/get?cb=jQuery112404937030508977105_1601807126714&pn=1&pz=10000&po=1&np=1&ut=bd1d9ddb04089700cf9c27f6f7426281&fltt=2&invt=2&fid=f3&fs=m:90+t:1+f:!50&fields=f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f12,f13,f14,f15,f16,f17,f18,f20,f21,f23,f24,f25,f26,f22,f33,f11,f62,f128,f136,f115,f152,f124,f107,f104,f105,f140,f141,f207,f208,f209,f222&_=1601807126728";

    /*————————板块资金排行信息采集URL——————————*/
    //行业板块 1日
    public static final String PLATE_MONEY_RANKING_HY1_URL = "http://push2.eastmoney.com/api/qt/clist/get?pn=1&pz=10000&po=1&np=1&ut=b2884a393a59ad64002292a3e90d46a5&fltt=2&invt=2&fid=f62&fs=m:90+t:2&stat=1&fields=f12,f14,f2,f3,f62,f184,f66,f69,f72,f75,f78,f81,f84,f87,f204,f205,f124&rt=53395808&cb=jQuery1830655774113471369_1601871015458&_=1601874265424";
    //行业板块 5日
    public static final String PLATE_MONEY_RANKING_HY5_URL = "http://push2.eastmoney.com/api/qt/clist/get?pn=1&pz=10000&po=1&np=1&ut=b2884a393a59ad64002292a3e90d46a5&fltt=2&invt=2&fid=f164&fs=m:90+t:2&stat=5&fields=f12,f14,f2,f109,f164,f165,f166,f167,f168,f169,f170,f171,f172,f173,f257,f258,f124&rt=53396067&cb=jQuery18309992149821868697_1601881899221&_=1601882013365";
    //行业板块 10日
    public static final String PLATE_MONEY_RANKING_HY10_URL = "http://push2.eastmoney.com/api/qt/clist/get?pn=1&pz=10000&po=1&np=1&ut=b2884a393a59ad64002292a3e90d46a5&fltt=2&invt=2&fid=f174&fs=m:90+t:2&stat=10&fields=f12,f14,f2,f160,f174,f175,f176,f177,f178,f179,f180,f181,f182,f183,f260,f261,f124&rt=53396068&cb=jQuery18309992149821868697_1601881899221&_=1601882043149";

    //概念板块 1日
    public static final String PLATE_MONEY_RANKING_GN1_URL = "http://push2.eastmoney.com/api/qt/clist/get?pn=1&pz=10000&po=1&np=1&ut=b2884a393a59ad64002292a3e90d46a5&fltt=2&invt=2&fid=f62&fs=m:90+t:3&stat=1&fields=f12,f14,f2,f3,f62,f184,f66,f69,f72,f75,f78,f81,f84,f87,f204,f205,f124&rt=53395829&cb=jQuery183011511861783966704_1601874867012&_=1601874874402";
    //概念板块 5日
    public static final String PLATE_MONEY_RANKING_GN5_URL = "http://push2.eastmoney.com/api/qt/clist/get?pn=1&pz=10000&po=1&np=1&ut=b2884a393a59ad64002292a3e90d46a5&fltt=2&invt=2&fid=f164&fs=m:90+t:3&stat=5&fields=f12,f14,f2,f109,f164,f165,f166,f167,f168,f169,f170,f171,f172,f173,f257,f258,f124&rt=53395833&cb=jQuery183011511861783966704_1601874867012&_=1601875016903";
    //概念板块 10日
    public static final String PLATE_MONEY_RANKING_GN10_URL = "http://push2.eastmoney.com/api/qt/clist/get?pn=1&pz=10000&po=1&np=1&ut=b2884a393a59ad64002292a3e90d46a5&fltt=2&invt=2&fid=f174&fs=m:90+t:3&stat=10&fields=f12,f14,f2,f160,f174,f175,f176,f177,f178,f179,f180,f181,f182,f183,f260,f261,f124&rt=53395834&cb=jQuery183011511861783966704_1601874867012&_=1601875041666";

    //地域板块 1日
    public static final String PLATE_MONEY_RANKING_DY1_URL = "http://push2.eastmoney.com/api/qt/clist/get?pn=1&pz=10000&po=1&np=1&ut=b2884a393a59ad64002292a3e90d46a5&fltt=2&invt=2&fid=f62&fs=m:90+t:1&stat=1&fields=f12,f14,f2,f3,f62,f184,f66,f69,f72,f75,f78,f81,f84,f87,f204,f205,f124&rt=53395837&cb=jQuery183042732628659857474_1601875127902&_=1601875135554";
    //地域板块 5日
    public static final String PLATE_MONEY_RANKING_DY5_URL = "http://push2.eastmoney.com/api/qt/clist/get?pn=1&pz=10000&po=1&np=1&ut=b2884a393a59ad64002292a3e90d46a5&fltt=2&invt=2&fid=f164&fs=m:90+t:1&stat=5&fields=f12,f14,f2,f109,f164,f165,f166,f167,f168,f169,f170,f171,f172,f173,f257,f258,f124&rt=53396080&cb=jQuery18306879289783238951_1601882395634&_=1601882417206";
    //地域板块 10日
    public static final String PLATE_MONEY_RANKING_DY10_URL = "http://push2.eastmoney.com/api/qt/clist/get?pn=1&pz=10000&po=1&np=1&ut=b2884a393a59ad64002292a3e90d46a5&fltt=2&invt=2&fid=f174&fs=m:90+t:1&stat=10&fields=f12,f14,f2,f160,f174,f175,f176,f177,f178,f179,f180,f181,f182,f183,f260,f261,f124&rt=53396081&cb=jQuery18306879289783238951_1601882395634&_=1601882447765";

    /*————————个股资金排行信息采集URL——————————*/
    //个股资金排行 1日
    public static final String STOCK_MONEY_RANKING1_URL = "http://push2.eastmoney.com/api/qt/clist/get?pn=1&pz=10000&po=1&np=1&ut=b2884a393a59ad64002292a3e90d46a5&fltt=2&invt=2&fid0=f4001&fid=f62&fs=m:0+t:6+f:!2,m:0+t:13+f:!2,m:0+t:80+f:!2,m:1+t:2+f:!2,m:1+t:23+f:!2,m:0+t:7+f:!2,m:1+t:3+f:!2&stat=1&fields=f12,f14,f2,f3,f62,f184,f66,f69,f72,f75,f78,f81,f84,f87,f204,f205,f124&rt=53396235&cb=jQuery18308345672541354092_1601885423999&_=1601887076550";
    //个股资金排行 3日
    public static final String STOCK_MONEY_RANKING3_URL = "http://push2.eastmoney.com/api/qt/clist/get?pn=1&pz=10000&po=1&np=1&ut=b2884a393a59ad64002292a3e90d46a5&fltt=2&invt=2&fid0=f4001&fid=f267&fs=m:0+t:6+f:!2,m:0+t:13+f:!2,m:0+t:80+f:!2,m:1+t:2+f:!2,m:1+t:23+f:!2,m:0+t:7+f:!2,m:1+t:3+f:!2&stat=3&fields=f12,f14,f2,f127,f267,f268,f269,f270,f271,f272,f273,f274,f275,f276,f257,f258,f124&rt=53396236&cb=jQuery18308345672541354092_1601885423999&_=1601887102914";
    //个股资金排行 5日
    public static final String STOCK_MONEY_RANKING5_URL = "http://push2.eastmoney.com/api/qt/clist/get?pn=1&pz=10000&po=1&np=1&ut=b2884a393a59ad64002292a3e90d46a5&fltt=2&invt=2&fid0=f4001&fid=f164&fs=m:0+t:6+f:!2,m:0+t:13+f:!2,m:0+t:80+f:!2,m:1+t:2+f:!2,m:1+t:23+f:!2,m:0+t:7+f:!2,m:1+t:3+f:!2&stat=5&fields=f12,f14,f2,f109,f164,f165,f166,f167,f168,f169,f170,f171,f172,f173,f257,f258,f124&rt=53396237&cb=jQuery18308345672541354092_1601885423999&_=1601887126074";
    //个股资金排行 10日
    public static final String STOCK_MONEY_RANKING10_URL = "http://push2.eastmoney.com/api/qt/clist/get?pn=1&pz=10000&po=1&np=1&ut=b2884a393a59ad64002292a3e90d46a5&fltt=2&invt=2&fid0=f4001&fid=f174&fs=m:0+t:6+f:!2,m:0+t:13+f:!2,m:0+t:80+f:!2,m:1+t:2+f:!2,m:1+t:23+f:!2,m:0+t:7+f:!2,m:1+t:3+f:!2&stat=10&fields=f12,f14,f2,f160,f174,f175,f176,f177,f178,f179,f180,f181,f182,f183,f260,f261,f124&rt=53396238&cb=jQuery18308345672541354092_1601885423999&_=1601887146282";


    /**
     * 采集数据
     * @param strURL
     * @return
     */
    public String doCollect(String strURL){
        URL url = null;
        String result= "";
        try {
            url = new URL(strURL);
            HttpURLConnection httpConn = null;
            httpConn = (HttpURLConnection) url.openConnection();
            InputStreamReader input = new InputStreamReader(httpConn.getInputStream(), "utf-8");
            BufferedReader bufReader = new BufferedReader(input);
            String line = "";
            StringBuilder contentBuf = new StringBuilder();
            while ((line = bufReader.readLine()) != null) {
                contentBuf.append(line);
            }
            result = contentBuf.toString();
//            System.out.println("结果：\n" + result);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
