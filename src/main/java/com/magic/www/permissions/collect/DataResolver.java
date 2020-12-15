package com.magic.www.permissions.collect;

import com.magic.www.permissions.common.Dictionary;
import com.magic.www.permissions.domain.*;
import com.magic.www.permissions.utils.DateUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 2020/7/27
 * Time: 9:06
 * To change this template use File | Settings | File Templates.
 * 数据解析器
 */
@Component
public class DataResolver {


    /**
     * 解析北向板块资金字符
     * @param responseStr
     * @return
     */
    public List<NorthMoneyMeta> resolverNorthMoney(String responseStr,String type, Class clazz) throws Exception {
        List<NorthMoneyMeta> resultList = new ArrayList();
        String result="";
        String[] str = responseStr.split("=");
        if(str.length < 1){
            throw new Exception("数据采集异常！");
        }
        result = str[1];
        JSONObject jsonObject = JSONObject.fromObject(result);
        JSONArray jsonArray = (JSONArray) jsonObject.get("data");
        for(Object object:jsonArray){
            JSONObject metaObject = JSONObject.fromObject(object);
//            NorthMoneyMeta northMoneyMeta = (NorthMoneyMeta) JSONObject.toBean(metaObject, NorthMoneyMeta.class);
            NorthMoneyMeta northMoneyMeta = new NorthMoneyMeta();
            northMoneyMeta.setORIGINALCODE(metaObject.get("ORIGINALCODE")+"");
            northMoneyMeta.setShareHold_JC_Min(metaObject.get("ShareHold_JC_Min")+"");
            northMoneyMeta.setShareHold_ZC_Max(metaObject.get("ShareHold_ZC_Max")+"");
            northMoneyMeta.setShareSZ_JC_Min(metaObject.get("ShareSZ_JC_Min")+"");
            northMoneyMeta.setShareSZ_ZC_Max(metaObject.get("ShareSZ_ZC_Max")+"");
            northMoneyMeta.setSCode_Min_ZB(metaObject.get("SCode_Min_ZB")+"");
            northMoneyMeta.setSCode_Max_ZB(metaObject.get("SCode_Max_ZB")+"");
            northMoneyMeta.setShareSZ_BK(metaObject.get("ShareSZ_BK")+"");
            northMoneyMeta.setShareSZ_Min(metaObject.get("ShareSZ_Min")+"");
            northMoneyMeta.setShareSZ_Max(metaObject.get("ShareSZ_Max")+"");
            northMoneyMeta.setDateType(metaObject.get("DateType")+"");
            northMoneyMeta.setType(type);
            northMoneyMeta.setHYCode(metaObject.get("HYCode")+"");
            //日期
            northMoneyMeta.setHdDate(DateUtils.stringToDate(metaObject.get("HdDate")+""));
            //板块名称
            northMoneyMeta.setHYName(metaObject.get("HYName")+"");
            //今日涨跌幅
            northMoneyMeta.setZdf(metaObject.get("Zdf")+"");
            //今日持股股票数量
            northMoneyMeta.setCount(metaObject.get("Count")+"");
            //今日北向资金市值
            northMoneyMeta.setShareSZ_GZ(metaObject.get("ShareSZ_GZ")+"");
            // 今日占板块比
            northMoneyMeta.setShareHold_Chg_BK(metaObject.get("ShareHold_Chg_BK")+"");
            //今日占北向资金比
            northMoneyMeta.setShareHold_Chg_GZ(metaObject.get("ShareHold_Chg_GZ")+"");
            //本周期持股数量
            northMoneyMeta.setZC_Count(metaObject.get("ZC_Count")+"");
            //本周期北向资金市值
            northMoneyMeta.setShareSZ_ZC(metaObject.get("ShareSZ_ZC")+"");
            //本周期市值增幅
            northMoneyMeta.setShareHold_ZC_Chg(metaObject.get("ShareHold_ZC_Chg")+"");
            //本周期占板块比
            northMoneyMeta.setShareHold_ZC_Chg_BK(metaObject.get("ShareHold_ZC_Chg_BK")+"");
            //本周期占北向资金比
            northMoneyMeta.setShareHold_Chg_GZ(metaObject.get("ShareHold_ZC_Chg_GZ")+"");
            //本周期增持最大市值股编号
            northMoneyMeta.setMax_SZ_Code(metaObject.get("Max_SZ_Code")+"");
            //本周期增持最大市值股名称
            northMoneyMeta.setMax_SZ_Name(metaObject.get("Max_SZ_Name")+"");
            //本周期最大占股本比股票编号
            northMoneyMeta.setMax_ZB_Code(metaObject.get("Max_ZB_Code")+"");
            //本周期最大占股本比股票名称
            northMoneyMeta.setMax_ZB_Name(metaObject.get("Max_ZB_Name")+"");
            //本周期最大减持股票编号
            northMoneyMeta.setMin_SZ_Code(metaObject.get("Min_SZ_Code")+"");
            //本周期最大减持股票名称
            northMoneyMeta.setMin_SZ_Name(metaObject.get("Min_SZ_Name")+"");
            //本周期最大减持占股本比股票编号
            northMoneyMeta.setMin_ZB_Code(metaObject.get("Min_ZB_Code")+"");
            //本周期最大减持占股本比股票编号
            northMoneyMeta.setMin_ZB_Name(metaObject.get("Min_ZB_Name")+"");
            resultList.add(northMoneyMeta);
        }
        return resultList;
    }

    public List<NorthMoneyStockMeta> resolverNorthMoneyStock(String responseStr, Class clazz) throws Exception {
        List<NorthMoneyStockMeta> resultList = new ArrayList();
        String result="";
        String[] str = responseStr.split("=");
        if(str.length < 1){
            throw new Exception("数据采集异常！");
        }
        result = str[1];
        JSONObject jsonObject = JSONObject.fromObject(result);
        JSONArray jsonArray = (JSONArray) jsonObject.get("data");
        for(Object object:jsonArray){
            JSONObject metaObject = JSONObject.fromObject(object);
            NorthMoneyStockMeta northMoneyStockMeta = new NorthMoneyStockMeta();
            northMoneyStockMeta.setsCode(metaObject.get("SCode")+"");//个股代码
            northMoneyStockMeta.setsName( metaObject.get("SName")+"");//个股名称
            northMoneyStockMeta.sethYCode(metaObject.get("HYCode")+"");//行业代码
            northMoneyStockMeta.sethYName(metaObject.get("HYName")+"");//行业名称
            northMoneyStockMeta.setqYCode(metaObject.get("DQCode")+"");//地域代码
            northMoneyStockMeta.setqYName(metaObject.get("DQName")+"");//地域名称
            northMoneyStockMeta.setDateType(metaObject.get("DateType")+"");//周期
            northMoneyStockMeta.setHdDate(DateUtils.stringToDate(metaObject.get("HdDate")+""));//日期
            northMoneyStockMeta.setSharesRate( metaObject.get("SharesRate")+"");//占总股本比
            northMoneyStockMeta.setNewPrice(metaObject.get("NewPrice")+""); //收盘价格
            northMoneyStockMeta.setZdf(metaObject.get("Zdf")+"");//涨跌幅
            northMoneyStockMeta.setShareHold(metaObject.get("ShareHold")+"");//股数
            northMoneyStockMeta.setShareSZ(metaObject.get("ShareSZ")+"");//市值
            northMoneyStockMeta.setLtzb(metaObject.get("LTZB")+"");//占流通股比
            northMoneyStockMeta.setZzb(metaObject.get("ZZB")+"");//占总股本比
            northMoneyStockMeta.setShareHoldChgOne(metaObject.get("ShareHold_Chg_One")+"");//今日增持估计股数
            northMoneyStockMeta.setShareSZChgOne(metaObject.get("ShareSZ_Chg_One")+"");//今日增持估计市值
            northMoneyStockMeta.setShareSZChgRateOne(metaObject.get("ShareSZ_Chg_Rate_One")+"");//今日增持估计市值增幅
            northMoneyStockMeta.setLtzbOne(metaObject.get("LTZB_One")+"");//今日增持估计占流通股比
            northMoneyStockMeta.setZzbOne(metaObject.get("ZZB_One")+"");//今日增持估计占总股本比
            northMoneyStockMeta.setCreateTime(new Date());//创建时间
            resultList.add(northMoneyStockMeta);
        }
        return resultList;
    }

    /**
     * 解析股票数据字符
     * @param str
     * @param clazz
     * @return
     */
    public List<StockBaseInfo> resolverStock(String str, Class clazz){
        List<StockBaseInfo> resultList = new ArrayList();

        int startIndex = str.indexOf("\"data\":{")+7;
        int endIndex = str.indexOf(")")-1;
        String resultStr = str.substring(startIndex,endIndex);
        JSONObject jsonObject = JSONObject.fromObject(resultStr);
        JSONArray jsonArray = (JSONArray) jsonObject.get("diff");
        for(Object object:jsonArray) {
            JSONObject metaObject = JSONObject.fromObject(object);
            StockBaseInfo stockBaseInfo = new StockBaseInfo();
            stockBaseInfo.setCode(metaObject.get("f12")+"");
            stockBaseInfo.setName(metaObject.get("f14")+"");
            stockBaseInfo.setCreateTime(new Date());
            resultList.add(stockBaseInfo);
        }
        return resultList;
    }

    /**
     * 解析股票的核心题材
     * @param str
     * @return
     */
    public List<String> resolverStockCoreConception(String str){
        List<String> resultList = new ArrayList();
        JSONObject jsonObject = JSONObject.fromObject(str);
        JSONArray jsonArray = (JSONArray) jsonObject.get("hxtc");
        if(jsonArray.size() > 0){
            JSONObject metaObject = JSONObject.fromObject(jsonArray.get(0));
            String plateNames = metaObject.get("ydnr")+"";
            String[] plates = plateNames.split(" ");
            for(String name:plates){
                resultList.add(name);
            }
        }
        return resultList;
    }

    /**
     * 解析板块数据字符
     * @param str
     * @param clazz
     * @return
     */
    public List<PlateBaseInfo> resolverPlate(String str,Class clazz){
        List<PlateBaseInfo> resultList = new ArrayList();

        int startIndex = str.indexOf("\"data\":{")+7;
        int endIndex = str.indexOf(")")-1;
        String resultStr = str.substring(startIndex,endIndex);
        JSONObject jsonObject = JSONObject.fromObject(resultStr);
        JSONArray jsonArray = (JSONArray) jsonObject.get("diff");
        for(Object object:jsonArray) {
            JSONObject metaObject = JSONObject.fromObject(object);
            PlateBaseInfo plateBaseInfo = new PlateBaseInfo();
            plateBaseInfo.setCode(metaObject.get("f12")+"");
            plateBaseInfo.setName(metaObject.get("f14")+"");
            plateBaseInfo.setCreateTime(new Date());
            resultList.add(plateBaseInfo);
        }
        return resultList;
    }

    /**
     * 解析板块排行数据字符
     * @param str
     * @param clazz
     * @return
     */
    public List<CollectPlateRanking> resolverPlateRanking(String str,String type,Class clazz){
        List<CollectPlateRanking> resultList = new ArrayList();

        int startIndex = str.indexOf("\"data\":{")+7;
        int endIndex = str.indexOf(")")-1;
        String resultStr = str.substring(startIndex,endIndex);
        JSONObject jsonObject = JSONObject.fromObject(resultStr);
        JSONArray jsonArray = (JSONArray) jsonObject.get("diff");
        for(Object object:jsonArray) {
            JSONObject metaObject = JSONObject.fromObject(object);
            CollectPlateRanking collectPlateRanking = new CollectPlateRanking();
            collectPlateRanking.setDataType(type);;
            collectPlateRanking.setF1(metaObject.get("f1")+"");
            collectPlateRanking.setF2(metaObject.get("f2")+"");
            collectPlateRanking.setF3(metaObject.get("f3")+"");
            collectPlateRanking.setF4(metaObject.get("f4")+"");
            collectPlateRanking.setF5(metaObject.get("f5")+"");
            collectPlateRanking.setF6(metaObject.get("f6")+"");
            collectPlateRanking.setF7(metaObject.get("f7")+"");
            collectPlateRanking.setF8(metaObject.get("f8")+"");
            collectPlateRanking.setF9(metaObject.get("f9")+"");
            collectPlateRanking.setF10(metaObject.get("f10")+"");
            collectPlateRanking.setF11(metaObject.get("f11")+"");
            collectPlateRanking.setF12(metaObject.get("f12")+"");
            collectPlateRanking.setF13(metaObject.get("f13")+"");
            collectPlateRanking.setF14(metaObject.get("f14")+"");
            collectPlateRanking.setF15(metaObject.get("f15")+"");
            collectPlateRanking.setF16(metaObject.get("f16")+"");
            collectPlateRanking.setF17(metaObject.get("f17")+"");
            collectPlateRanking.setF18(metaObject.get("f18")+"");
            collectPlateRanking.setF20(metaObject.get("f20")+"");
            collectPlateRanking.setF21(metaObject.get("f21")+"");
            collectPlateRanking.setF22(metaObject.get("f22")+"");
            collectPlateRanking.setF23(metaObject.get("f23")+"");
            collectPlateRanking.setF24(metaObject.get("f24")+"");
            collectPlateRanking.setF25(metaObject.get("f25")+"");
            collectPlateRanking.setF26(metaObject.get("f26")+"");
            collectPlateRanking.setF33(metaObject.get("f33")+"");
            collectPlateRanking.setF62(metaObject.get("f62")+"");
            collectPlateRanking.setF104(metaObject.get("f104")+"");
            collectPlateRanking.setF105(metaObject.get("f105")+"");
            collectPlateRanking.setF107(metaObject.get("f107")+"");
            collectPlateRanking.setF115(metaObject.get("f115")+"");
            collectPlateRanking.setF124(metaObject.get("f124")+"");
            collectPlateRanking.setF128(metaObject.get("f128")+"");
            collectPlateRanking.setF140(metaObject.get("f140")+"");
            collectPlateRanking.setF141(metaObject.get("f141")+"");
            collectPlateRanking.setF136(metaObject.get("f136")+"");
            collectPlateRanking.setF152(metaObject.get("f152")+"");
            collectPlateRanking.setF207(metaObject.get("f207")+"");
            collectPlateRanking.setF208(metaObject.get("f208")+"");
            collectPlateRanking.setF209(metaObject.get("f209")+"");
            collectPlateRanking.setF222(metaObject.get("f222")+"");
            collectPlateRanking.setCreateTime(new Date());
            resultList.add(collectPlateRanking);
        }
        return resultList;
    }

    /**
     * 解析板块资金排行数据字符
     * @param str
     * @param type
     * @param dateType
     * @param clazz
     * @return
     */
    public List<CollectPlateMoneyRanking> resolverPlateMoneyRanking(String str,String type,String dateType,Class clazz){
        List<CollectPlateMoneyRanking> resultList = new ArrayList();

        int startIndex = str.indexOf("\"data\":{")+7;
        int endIndex = str.indexOf(")")-1;
        String resultStr = str.substring(startIndex,endIndex);
        JSONObject jsonObject = JSONObject.fromObject(resultStr);
        JSONArray jsonArray = (JSONArray) jsonObject.get("diff");
        for(Object object:jsonArray) {
            JSONObject metaObject = JSONObject.fromObject(object);
            CollectPlateMoneyRanking collectPlateMoneyRanking = new CollectPlateMoneyRanking();
            collectPlateMoneyRanking.setCode(metaObject.get("f12")+"");
            collectPlateMoneyRanking.setName(metaObject.get("f14")+"");
            collectPlateMoneyRanking.setType(type);
            collectPlateMoneyRanking.setDateType(dateType);
            collectPlateMoneyRanking.setCreateTime(new Date());
            if(dateType.equals(Dictionary.Dictionary_PlateBase.PERIOD_TYPE_1R)){
                collectPlateMoneyRanking.setZdf(metaObject.get("f3")+"");
                collectPlateMoneyRanking.setMainNetInflow(metaObject.get("f62")+"");
                collectPlateMoneyRanking.setMainNetProportion(metaObject.get("f184")+"");
                collectPlateMoneyRanking.setVeryLargeSingleNet(metaObject.get("f66")+"");
                collectPlateMoneyRanking.setVeryLargeSingleProportion(metaObject.get("f69")+"");
                collectPlateMoneyRanking.setLargeSingleNet(metaObject.get("f72")+"");
                collectPlateMoneyRanking.setLargeSingleProportion(metaObject.get("f75")+"");
                collectPlateMoneyRanking.setSingleNet(metaObject.get("f78")+"");
                collectPlateMoneyRanking.setSingleNetProportion(metaObject.get("f81")+"");
                collectPlateMoneyRanking.setSmallSingleNet(metaObject.get("f84")+"");
                collectPlateMoneyRanking.setSmallSingleProportion(metaObject.get("f87")+"");
                collectPlateMoneyRanking.setInflowStockCode(metaObject.get("f205")+"");
                collectPlateMoneyRanking.setInflowStockName(metaObject.get("f204")+"");
            }else if(dateType.equals(Dictionary.Dictionary_PlateBase.PERIOD_TYPE_5R)){
                collectPlateMoneyRanking.setZdf(metaObject.get("f109")+"");
                collectPlateMoneyRanking.setMainNetInflow(metaObject.get("f164")+"");
                collectPlateMoneyRanking.setMainNetProportion(metaObject.get("f165")+"");
                collectPlateMoneyRanking.setVeryLargeSingleNet(metaObject.get("f166")+"");
                collectPlateMoneyRanking.setVeryLargeSingleProportion(metaObject.get("f167")+"");
                collectPlateMoneyRanking.setLargeSingleNet(metaObject.get("f168")+"");
                collectPlateMoneyRanking.setLargeSingleProportion(metaObject.get("f169")+"");
                collectPlateMoneyRanking.setSingleNet(metaObject.get("f170")+"");
                collectPlateMoneyRanking.setSingleNetProportion(metaObject.get("f171")+"");
                collectPlateMoneyRanking.setSmallSingleNet(metaObject.get("f172")+"");
                collectPlateMoneyRanking.setSmallSingleProportion(metaObject.get("f173")+"");
                collectPlateMoneyRanking.setInflowStockCode(metaObject.get("f257")+"");
                collectPlateMoneyRanking.setInflowStockName(metaObject.get("f258")+"");
            }else if(dateType.equals(Dictionary.Dictionary_PlateBase.PERIOD_TYPE_10R)){
                collectPlateMoneyRanking.setZdf(metaObject.get("f160")+"");
                collectPlateMoneyRanking.setMainNetInflow(metaObject.get("f174")+"");
                collectPlateMoneyRanking.setMainNetProportion(metaObject.get("f175")+"");
                collectPlateMoneyRanking.setVeryLargeSingleNet(metaObject.get("f176")+"");
                collectPlateMoneyRanking.setVeryLargeSingleProportion(metaObject.get("f177")+"");
                collectPlateMoneyRanking.setLargeSingleNet(metaObject.get("f178")+"");
                collectPlateMoneyRanking.setLargeSingleProportion(metaObject.get("f179")+"");
                collectPlateMoneyRanking.setSingleNet(metaObject.get("f180")+"");
                collectPlateMoneyRanking.setSingleNetProportion(metaObject.get("f181")+"");
                collectPlateMoneyRanking.setSmallSingleNet(metaObject.get("f182")+"");
                collectPlateMoneyRanking.setSmallSingleProportion(metaObject.get("f183")+"");
                collectPlateMoneyRanking.setInflowStockCode(metaObject.get("f260")+"");
                collectPlateMoneyRanking.setInflowStockName(metaObject.get("f261")+"");
            }

            resultList.add(collectPlateMoneyRanking);
        }
        return resultList;
    }

    /**
     * 解析个股资金排行数据字符
     * @param str
     * @param dateType
     * @param clazz
     * @return
     */
    public List<CollectStockMoneyRanking> resolverStockMoneyRanking(String str,String dateType,Class clazz){
        List<CollectStockMoneyRanking> resultList = new ArrayList();

        int startIndex = str.indexOf("\"data\":{")+7;
        int endIndex = str.indexOf(")")-1;
        String resultStr = str.substring(startIndex,endIndex);
        JSONObject jsonObject = JSONObject.fromObject(resultStr);
        JSONArray jsonArray = (JSONArray) jsonObject.get("diff");
        for(Object object:jsonArray) {
            JSONObject metaObject = JSONObject.fromObject(object);
            CollectStockMoneyRanking collectStockMoneyRanking = new CollectStockMoneyRanking();
            collectStockMoneyRanking.setCode(metaObject.get("f12")+"");
            collectStockMoneyRanking.setName(metaObject.get("f14")+"");
            collectStockMoneyRanking.setDateType(dateType);
            collectStockMoneyRanking.setCreateTime(new Date());
            if(dateType.equals(Dictionary.Dictionary_StockBase.PERIOD_TYPE_1R)){
                collectStockMoneyRanking.setZdf(metaObject.get("f3")+"");
                collectStockMoneyRanking.setMainNetInflow(metaObject.get("f62")+"");
                collectStockMoneyRanking.setMainNetProportion(metaObject.get("f184")+"");
                collectStockMoneyRanking.setVeryLargeSingleNet(metaObject.get("f66")+"");
                collectStockMoneyRanking.setVeryLargeSingleProportion(metaObject.get("f69")+"");
                collectStockMoneyRanking.setLargeSingleNet(metaObject.get("f72")+"");
                collectStockMoneyRanking.setLargeSingleProportion(metaObject.get("f75")+"");
                collectStockMoneyRanking.setSingleNet(metaObject.get("f78")+"");
                collectStockMoneyRanking.setSingleNetProportion(metaObject.get("f81")+"");
                collectStockMoneyRanking.setSmallSingleNet(metaObject.get("f84")+"");
                collectStockMoneyRanking.setSmallSingleProportion(metaObject.get("f87")+"");
            }else if(dateType.equals(Dictionary.Dictionary_StockBase.PERIOD_TYPE_3R)){
                collectStockMoneyRanking.setZdf(metaObject.get("f127")+"");
                collectStockMoneyRanking.setMainNetInflow(metaObject.get("f267")+"");
                collectStockMoneyRanking.setMainNetProportion(metaObject.get("f268")+"");
                collectStockMoneyRanking.setVeryLargeSingleNet(metaObject.get("f269")+"");
                collectStockMoneyRanking.setVeryLargeSingleProportion(metaObject.get("f270")+"");
                collectStockMoneyRanking.setLargeSingleNet(metaObject.get("f271")+"");
                collectStockMoneyRanking.setLargeSingleProportion(metaObject.get("f272")+"");
                collectStockMoneyRanking.setSingleNet(metaObject.get("f273")+"");
                collectStockMoneyRanking.setSingleNetProportion(metaObject.get("f274")+"");
                collectStockMoneyRanking.setSmallSingleNet(metaObject.get("f275")+"");
                collectStockMoneyRanking.setSmallSingleProportion(metaObject.get("f276")+"");
            }else if(dateType.equals(Dictionary.Dictionary_StockBase.PERIOD_TYPE_5R)){
                collectStockMoneyRanking.setZdf(metaObject.get("f109")+"");
                collectStockMoneyRanking.setMainNetInflow(metaObject.get("f164")+"");
                collectStockMoneyRanking.setMainNetProportion(metaObject.get("f165")+"");
                collectStockMoneyRanking.setVeryLargeSingleNet(metaObject.get("f166")+"");
                collectStockMoneyRanking.setVeryLargeSingleProportion(metaObject.get("f167")+"");
                collectStockMoneyRanking.setLargeSingleNet(metaObject.get("f168")+"");
                collectStockMoneyRanking.setLargeSingleProportion(metaObject.get("f169")+"");
                collectStockMoneyRanking.setSingleNet(metaObject.get("f170")+"");
                collectStockMoneyRanking.setSingleNetProportion(metaObject.get("f171")+"");
                collectStockMoneyRanking.setSmallSingleNet(metaObject.get("f172")+"");
                collectStockMoneyRanking.setSmallSingleProportion(metaObject.get("f173")+"");
            }else if(dateType.equals(Dictionary.Dictionary_StockBase.PERIOD_TYPE_10R)){
                collectStockMoneyRanking.setZdf(metaObject.get("f160")+"");
                collectStockMoneyRanking.setMainNetInflow(metaObject.get("f174")+"");
                collectStockMoneyRanking.setMainNetProportion(metaObject.get("f175")+"");
                collectStockMoneyRanking.setVeryLargeSingleNet(metaObject.get("f176")+"");
                collectStockMoneyRanking.setVeryLargeSingleProportion(metaObject.get("f177")+"");
                collectStockMoneyRanking.setLargeSingleNet(metaObject.get("f178")+"");
                collectStockMoneyRanking.setLargeSingleProportion(metaObject.get("f179")+"");
                collectStockMoneyRanking.setSingleNet(metaObject.get("f180")+"");
                collectStockMoneyRanking.setSingleNetProportion(metaObject.get("f181")+"");
                collectStockMoneyRanking.setSmallSingleNet(metaObject.get("f182")+"");
                collectStockMoneyRanking.setSmallSingleProportion(metaObject.get("f183")+"");
            }

            resultList.add(collectStockMoneyRanking);
        }
        return resultList;
    }

    /**
     * 解析个股实时涨跌幅数据
     * @param str
     * @param clazz
     * @return
     */
    public List<StockDataMeta> resolverCurrentStock(String str, Class clazz){
        List<StockDataMeta> resultList = new ArrayList();

        int startIndex = str.indexOf("\"data\":{")+7;
        int endIndex = str.indexOf(")")-1;
        String resultStr = str.substring(startIndex,endIndex);
        JSONObject jsonObject = JSONObject.fromObject(resultStr);
        JSONArray jsonArray = (JSONArray) jsonObject.get("diff");
        for(Object object:jsonArray) {
            JSONObject metaObject = JSONObject.fromObject(object);
            StockDataMeta stockDataMeta = new StockDataMeta();
            stockDataMeta.setCode(metaObject.get("f12")+"");//代码
            stockDataMeta.setName(metaObject.get("f14")+"");//名称
            stockDataMeta.setCurrentPrice(metaObject.get("f2")+"");//当前价格
            stockDataMeta.setGains(metaObject.get("f3")+"");//涨跌幅
            stockDataMeta.setGainsNum(metaObject.get("f4")+"");//涨跌额
            stockDataMeta.setTotalHand(metaObject.get("f5")+"");//成交量
            stockDataMeta.setTotalPrice(metaObject.get("f6")+"");//成交额
            stockDataMeta.setAmplitude(metaObject.get("f7")+"");//振幅
            stockDataMeta.setHighest(metaObject.get("f15")+"");//最高价格
            stockDataMeta.setLowest(metaObject.get("f16")+"");//最低价格
            stockDataMeta.setStartPrice(metaObject.get("f17")+"");//开盘价
            stockDataMeta.setYesterdayEndPrice(metaObject.get("f18")+"");//昨日收盘价格
            stockDataMeta.setThan(metaObject.get("f10")+"");//量比
            stockDataMeta.setChangeHand(metaObject.get("f8")+"");//换手
            stockDataMeta.setPeRatio(metaObject.get("f9")+"");//市盈率
            stockDataMeta.setPbRatio(metaObject.get("f23")+"");//市净率
            stockDataMeta.setTotalval(metaObject.get("f20")+"");//总市值
            stockDataMeta.setCurrentMarket(metaObject.get("f21")+"");//流通市值
            stockDataMeta.setCreateTime(new Date());//创建时间
            resultList.add(stockDataMeta);
        }
        return resultList;
    }

    /**
     * 解析个股实时涨跌幅数据
     * @param str
     * @param clazz
     * @return
     */
    public List<CollectStockRanking> resolverStockRanking(String str, Class clazz){
        List<CollectStockRanking> resultList = new ArrayList();

        int startIndex = str.indexOf("\"data\":{")+7;
        int endIndex = str.indexOf(")")-1;
        String resultStr = str.substring(startIndex,endIndex);
        JSONObject jsonObject = JSONObject.fromObject(resultStr);
        JSONArray jsonArray = (JSONArray) jsonObject.get("diff");
        for(Object object:jsonArray) {
            JSONObject metaObject = JSONObject.fromObject(object);
            CollectStockRanking collectStockRanking = new CollectStockRanking();
            collectStockRanking.setCode(metaObject.get("f12")+"");//代码
            collectStockRanking.setName(metaObject.get("f14")+"");//名称
            collectStockRanking.setCurrentPrice(metaObject.get("f2")+"");//当前价格
            collectStockRanking.setGains(metaObject.get("f3")+"");//涨跌幅
            collectStockRanking.setGainsNum(metaObject.get("f4")+"");//涨跌额
            collectStockRanking.setTotalHand(metaObject.get("f5")+"");//成交量
            collectStockRanking.setTotalPrice(metaObject.get("f6")+"");//成交额
            collectStockRanking.setAmplitude(metaObject.get("f7")+"");//振幅
            collectStockRanking.setHighest(metaObject.get("f15")+"");//最高价格
            collectStockRanking.setLowest(metaObject.get("f16")+"");//最低价格
            collectStockRanking.setStartPrice(metaObject.get("f17")+"");//开盘价
            collectStockRanking.setYesterdayEndPrice(metaObject.get("f18")+"");//昨日收盘价格
            collectStockRanking.setThan(metaObject.get("f10")+"");//量比
            collectStockRanking.setChangeHand(metaObject.get("f8")+"");//换手
            collectStockRanking.setPeRatio(metaObject.get("f9")+"");//市盈率
            collectStockRanking.setPbRatio(metaObject.get("f23")+"");//市净率
            collectStockRanking.setTotalval(metaObject.get("f20")+"");//总市值
            collectStockRanking.setCurrentMarket(metaObject.get("f21")+"");//流通市值
            collectStockRanking.setCreateTime(new Date());//创建时间
            resultList.add(collectStockRanking);
        }
        return resultList;
    }
}
