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
    //行业1日URL
    public static final String HY_1R_URL = "http://dcfm.eastmoney.com/EM_MutiSvcExpandInterface/api/js/get?type=HSGT20_HYTJ_SUM&token=894050c76af8597a853f5b408b759f5d&st=ShareSZ_ZC&sr=-1&p=1&ps=1000&js=var%20dBMlqdii={pages:(tp),data:(x)}&filter=(DateType=%271%27)&rt=53177425";
    //行业3日URL
    public static final String HY_3R_URL = "http://dcfm.eastmoney.com/EM_MutiSvcExpandInterface/api/js/get?type=HSGT20_HYTJ_SUM&token=894050c76af8597a853f5b408b759f5d&st=ShareSZ_ZC&sr=-1&p=1&ps=1000&js=var%20nSwOCcMJ={pages:(tp),data:(x)}&filter=(DateType=%273%27)&rt=53177438";
    //行业5日URL
    public static final String HY_5R_URL = "http://dcfm.eastmoney.com/EM_MutiSvcExpandInterface/api/js/get?type=HSGT20_HYTJ_SUM&token=894050c76af8597a853f5b408b759f5d&st=ShareSZ_ZC&sr=-1&p=1&ps=1000&js=var%20jAcXwsrN={pages:(tp),data:(x)}&filter=(DateType=%275%27)&rt=53177439";
    //行业10日URL
    public static final String HY_10R_URL = "http://dcfm.eastmoney.com/EM_MutiSvcExpandInterface/api/js/get?type=HSGT20_HYTJ_SUM&token=894050c76af8597a853f5b408b759f5d&st=ShareSZ_ZC&sr=-1&p=1&ps=1000&js=var%20dPIWnaJS={pages:(tp),data:(x)}&filter=(DateType=%2710%27)&rt=53177441";
    //行业1月URL
    public static final String HY_1Y_URL = "http://dcfm.eastmoney.com/EM_MutiSvcExpandInterface/api/js/get?type=HSGT20_HYTJ_SUM&token=894050c76af8597a853f5b408b759f5d&st=ShareSZ_ZC&sr=-1&p=1&ps=1000&js=var%20OgZFOzuR={pages:(tp),data:(x)}&filter=(DateType=%27m%27)&rt=53184926";
    //行业1季度URL
    public static final String HY_1JD_URL = "http://dcfm.eastmoney.com/EM_MutiSvcExpandInterface/api/js/get?type=HSGT20_HYTJ_SUM&token=894050c76af8597a853f5b408b759f5d&st=ShareSZ_ZC&sr=-1&p=1&ps=1000&js=var%20KVNfoDIW={pages:(tp),data:(x)}&filter=(DateType=%27jd%27)&rt=53184926";
    //行业1年URL
    public static final String HY_1N_URL = "http://dcfm.eastmoney.com/EM_MutiSvcExpandInterface/api/js/get?type=HSGT20_HYTJ_SUM&token=894050c76af8597a853f5b408b759f5d&st=ShareSZ_ZC&sr=-1&p=1&ps=1000&js=var%20FoKdporb={pages:(tp),data:(x)}&filter=(DateType=%27y%27)&rt=53184952";


    //行业1日URL
    public static final String GN_1R_URL = "http://dcfm.eastmoney.com/EM_MutiSvcExpandInterface/api/js/get?type=HSGT20_GNTJ_SUM&token=894050c76af8597a853f5b408b759f5d&st=ShareSZ_ZC&sr=-1&p=1&ps=1000&js=var%20sJoJeQOc={pages:(tp),data:(x)}&filter=(DateType=%271%27)&rt=53185017";
    //行业3日URL
    public static final String GN_3R_URL = "http://dcfm.eastmoney.com/EM_MutiSvcExpandInterface/api/js/get?type=HSGT20_GNTJ_SUM&token=894050c76af8597a853f5b408b759f5d&st=ShareSZ_ZC&sr=-1&p=1&ps=1000&js=var%20rRAYqLgc={pages:(tp),data:(x)}&filter=(DateType=%273%27)&rt=53185018";
    //行业5日URL
    public static final String GN_5R_URL = "http://dcfm.eastmoney.com/EM_MutiSvcExpandInterface/api/js/get?type=HSGT20_GNTJ_SUM&token=894050c76af8597a853f5b408b759f5d&st=ShareSZ_ZC&sr=-1&p=1&ps=1000&js=var%20YJZgYPia={pages:(tp),data:(x)}&filter=(DateType=%275%27)&rt=53185018";
    //行业10日URL
    public static final String GN_10R_URL = "http://dcfm.eastmoney.com/EM_MutiSvcExpandInterface/api/js/get?type=HSGT20_GNTJ_SUM&token=894050c76af8597a853f5b408b759f5d&st=ShareSZ_ZC&sr=-1&p=1&ps=1000&js=var%20pepWxbtM={pages:(tp),data:(x)}&filter=(DateType=%2710%27)&rt=53185019";
    //行业1月URL
    public static final String GN_1Y_URL = "http://dcfm.eastmoney.com/EM_MutiSvcExpandInterface/api/js/get?type=HSGT20_GNTJ_SUM&token=894050c76af8597a853f5b408b759f5d&st=ShareSZ_ZC&sr=-1&p=1&ps=1000&js=var%20KsrRbyAC={pages:(tp),data:(x)}&filter=(DateType=%27m%27)&rt=53185019";
    //行业1季度URL
    public static final String GN_1JD_URL = "http://dcfm.eastmoney.com/EM_MutiSvcExpandInterface/api/js/get?type=HSGT20_GNTJ_SUM&token=894050c76af8597a853f5b408b759f5d&st=ShareSZ_ZC&sr=-1&p=1&ps=1000&js=var%20RntAVmPt={pages:(tp),data:(x)}&filter=(DateType=%27jd%27)&rt=53185020";
    //行业1年URL
    public static final String GN_1N_URL = "http://dcfm.eastmoney.com/EM_MutiSvcExpandInterface/api/js/get?type=HSGT20_GNTJ_SUM&token=894050c76af8597a853f5b408b759f5d&st=ShareSZ_ZC&sr=-1&p=1&ps=1000&js=var%20GORTlkxe={pages:(tp),data:(x)}&filter=(DateType=%27y%27)&rt=53185020";

    /*————————股票信息采集URL——————————*/
    public static final String STOCK_BASE_INFO_URL = "http://70.push2.eastmoney.com/api/qt/clist/get?cb=jQuery112403359411797212848_1597891603350&pn=1&pz=10000&po=1&np=1&ut=bd1d9ddb04089700cf9c27f6f7426281&fltt=2&invt=2&fid=f3&fs=m:0+t:6,m:0+t:13,m:0+t:80,m:1+t:2,m:1+t:23&fields=f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f12,f13,f14,f15,f16,f17,f18,f20,f21,f23,f24,f25,f22,f11,f62,f128,f136,f115,f152&_=1597891603351";

    /*————————股票核心题材采集URL————————*/
    public static final String STOCK_CORE_CONCEPTION_URL = "http://f10.eastmoney.com/CoreConception/CoreConceptionAjax?code=";

    /*————————板块信息采集URL——————————*/
    //行业板块
    public static final String PLATE_HY_URL = "http://58.push2.eastmoney.com/api/qt/clist/get?cb=jQuery112403973166983836198_1597933371818&pn=1&pz=10000&po=1&np=1&ut=bd1d9ddb04089700cf9c27f6f7426281&fltt=2&invt=2&fid=f3&fs=m:90+t:2+f:!50&fields=f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f12,f13,f14,f15,f16,f17,f18,f20,f21,f23,f24,f25,f26,f22,f33,f11,f62,f128,f136,f115,f152,f124,f107,f104,f105,f140,f141,f207,f208,f209,f222&_=1597933371841";
    //概念板块
    public static final String PLATE_GN_URL = "http://58.push2.eastmoney.com/api/qt/clist/get?cb=jQuery112403973166983836198_1597933371818&pn=1&pz=1000&po=1&np=1&ut=bd1d9ddb04089700cf9c27f6f7426281&fltt=2&invt=2&fid=f3&fs=m:90+t:3+f:!50&fields=f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f12,f13,f14,f15,f16,f17,f18,f20,f21,f23,f24,f25,f26,f22,f33,f11,f62,f128,f136,f115,f152,f124,f107,f104,f105,f140,f141,f207,f208,f209,f222&_=1597933371887";
    //地域
    public static final String PLATE_DY_URL = "http://58.push2.eastmoney.com/api/qt/clist/get?cb=jQuery112403973166983836198_1597933371814&pn=1&pz=1000&po=1&np=1&ut=bd1d9ddb04089700cf9c27f6f7426281&fltt=2&invt=2&fid=f3&fs=m:90+t:1+f:!50&fields=f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f12,f13,f14,f15,f16,f17,f18,f20,f21,f23,f24,f25,f26,f22,f33,f11,f62,f128,f136,f115,f152,f124,f107,f104,f105,f140,f141,f207,f208,f209,f222&_=1597933371867";

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
