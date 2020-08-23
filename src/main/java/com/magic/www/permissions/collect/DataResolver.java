package com.magic.www.permissions.collect;

import com.magic.www.permissions.domain.NorthMoneyMeta;
import com.magic.www.permissions.domain.PlateBaseInfo;
import com.magic.www.permissions.domain.StockBaseInfo;
import com.magic.www.permissions.utils.DateUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Component;
import sun.applet.Main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
     * 解析北向资金字符
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
}
