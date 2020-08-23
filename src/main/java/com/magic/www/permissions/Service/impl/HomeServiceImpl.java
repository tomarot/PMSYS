package com.magic.www.permissions.Service.impl;

import com.magic.www.permissions.Service.HomeService;
import com.magic.www.permissions.Service.NorthMoneyService;
import com.magic.www.permissions.Service.StockService;
import com.magic.www.permissions.base.ResultVo;
import com.magic.www.permissions.common.Dictionary;
import com.magic.www.permissions.domain.NorthMoneyMeta;
import com.magic.www.permissions.domain.Stock;
import com.magic.www.permissions.mapper.NorthMoneyMapper;
import com.magic.www.permissions.mapper.StockMapper;
import com.magic.www.permissions.mapper.WindVaneMapper;
import com.magic.www.permissions.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 2020/8/9
 * Time: 13:22
 * To change this template use File | Settings | File Templates.
 */
@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    private StockService stockService;
    @Autowired(required = false)
    private StockMapper stockMapper;
    @Autowired(required = false)
    private WindVaneMapper windVaneMapper;
    @Autowired(required = false)
    private NorthMoneyMapper northMoneyMapper;
    @Autowired
    private NorthMoneyService northMoneyService;


    @Override
    public ResultVo getLatestHardenDropProportionData() {
        ResultVo resultVo = new ResultVo();
        Map<String,String> resultMap = new HashMap<String,String>();
        //获取最新日期
        Date latestDate = stockService.queryLatestDate();
        //获取涨停数量
        List<Stock> hardenStockList = stockMapper.queryHardenStock(latestDate);
        //获取跌停数量
        List<Stock> dropStockList = stockMapper.queryDropStock(latestDate);
        resultMap.put("date", DateUtils.date2String(latestDate));
        resultMap.put("hardenCount",hardenStockList==null?0+"":hardenStockList.size()+"");
        resultMap.put("dropCount",hardenStockList==null?0+"":dropStockList.size()+"");
        resultVo.setResultData(resultMap);
        return resultVo;
    }

    @Override
    public ResultVo getLatestMakeMoneyEffectData() {
        ResultVo resultVo = new ResultVo();
        Map<String,String> resultMap = new HashMap<String,String>();
        //获取最新日期
        Date latestDate = stockService.queryLatestDate();
        //获取涨幅大于3%的数据数量
        List<Stock> stockList = stockMapper.queryStockByGreater3(DateUtils.date2String(latestDate));
        //获取总股票数量
        Stock queryStock = new Stock();
        queryStock.setCreateTime(latestDate);
        List<Stock> countStockList = stockMapper.querySelective(queryStock);
        resultMap.put("date",DateUtils.date2String(latestDate));
        resultMap.put("stockNum",stockList==null?0+"":stockList.size()+"");
        resultMap.put("countNum",countStockList==null?0+"":countStockList.size()+"");
        resultVo.setResultData(resultMap);
        return resultVo;
    }

    @Override
    public ResultVo getWindVaneCountData() {
        ResultVo resultVo = new ResultVo();
        Map<String,Object> rootMap = new HashMap<String,Object>();
        //获取风向标数量最小值
        int minNum = windVaneMapper.queryMinWindVaneNum(Dictionary.Dictionary_WindVane.TYPE_DAY,null,null);
        //获取风向标数量最大值
        int maxNum = windVaneMapper.queryMaxWindVaneNum(Dictionary.Dictionary_WindVane.TYPE_DAY,null,null);
        //获取风向标数据
        List<Map<String,Object>> resultMap = windVaneMapper.queryWindVaneNum(Dictionary.Dictionary_WindVane.TYPE_DAY,null,null);
        //日期
        List<String> dateList = new ArrayList<String>();
        //数值
        List<String> numList = new ArrayList<>();
        for(Map<String,Object> map:resultMap){
            dateList.add(DateUtils.date2String((Date) map.get("create_time")));
            numList.add(map.get("count")+"");
        }
        rootMap.put("minNum",minNum);
        rootMap.put("maxNum",maxNum);
        rootMap.put("dateList",dateList);
        rootMap.put("numList",numList);
        resultVo.setResultData(rootMap);
        return resultVo;
    }

    @Override
    public ResultVo getNorthMoneyHyCountData(String periodType) {
        ResultVo resultVo = new ResultVo();
        Map<String,Object> rootMap = new HashMap<String,Object>();
        //获取最新日期
        Date latestDate = northMoneyService.queryLatestDate(null,null);
        //获取资金流入前十名
        List<NorthMoneyMeta> topInflowsNorthMoneyList = northMoneyMapper.queryInflowsTop(Dictionary.Dictionary_NorthMoney.DATA_TYPE_HY,periodType,DateUtils.date2String(latestDate),10);
        //获取资金流出前十名
        List<NorthMoneyMeta> topOutOfNorthMoneyList = northMoneyMapper.queryOutOfTop(Dictionary.Dictionary_NorthMoney.DATA_TYPE_HY,periodType,DateUtils.date2String(latestDate),10);
        Collections.reverse(topOutOfNorthMoneyList);
        topInflowsNorthMoneyList.addAll(topOutOfNorthMoneyList);
        List<String> plateNameList = new ArrayList<String>();
        List<String> plateValueList = new ArrayList<String>();
        for(NorthMoneyMeta northMoneyMeta:topInflowsNorthMoneyList){
            plateNameList.add(northMoneyMeta.getHYName());
            BigDecimal val = new BigDecimal(northMoneyMeta.getShareSZ_ZC());
            BigDecimal resultVal = val.divide(new BigDecimal("100000000"));
            resultVal = resultVal.setScale(2, RoundingMode.HALF_UP);
            plateValueList.add(resultVal.toString());
        }
        rootMap.put("latestDate",DateUtils.date2String(latestDate));
        rootMap.put("plateNameList",plateNameList);
        rootMap.put("plateValueList",plateValueList);
        resultVo.setResultData(rootMap);
        return resultVo;
    }

    @Override
    public ResultVo getNorthMoneyGnCountData(String periodType) {
        ResultVo resultVo = new ResultVo();
        Map<String,Object> rootMap = new HashMap<String,Object>();
        //获取最新日期
        Date latestDate = northMoneyService.queryLatestDate(null,null);
        //获取资金流入前十名
        List<NorthMoneyMeta> topInflowsNorthMoneyList = northMoneyMapper.queryInflowsTop(Dictionary.Dictionary_NorthMoney.DATA_TYPE_GN,periodType,DateUtils.date2String(latestDate),10);
        //获取资金流出前十名
        List<NorthMoneyMeta> topOutOfNorthMoneyList = northMoneyMapper.queryOutOfTop(Dictionary.Dictionary_NorthMoney.DATA_TYPE_GN,periodType,DateUtils.date2String(latestDate),10);
        Collections.reverse(topOutOfNorthMoneyList);
        topInflowsNorthMoneyList.addAll(topOutOfNorthMoneyList);
        List<String> plateNameList = new ArrayList<String>();
        List<String> plateValueList = new ArrayList<String>();
        for(NorthMoneyMeta northMoneyMeta:topInflowsNorthMoneyList){
            plateNameList.add(northMoneyMeta.getHYName());
            BigDecimal val = new BigDecimal(northMoneyMeta.getShareSZ_ZC());
            BigDecimal resultVal = val.divide(new BigDecimal("100000000"));
            resultVal = resultVal.setScale(2, RoundingMode.HALF_UP);
            plateValueList.add(resultVal.toString());
        }
        rootMap.put("latestDate",DateUtils.date2String(latestDate));
        rootMap.put("plateNameList",plateNameList);
        rootMap.put("plateValueList",plateValueList);
        resultVo.setResultData(rootMap);
        return resultVo;
    }

    @Override
    public ResultVo getGainsCountData(){
        ResultVo resultVo = new ResultVo();
        Map<String,Object> rootMap = new HashMap<>();
        Date latestDate = stockService.queryLatestDate();
        List<Map<String,Object>> resultList = stockMapper.queryGainsCount(DateUtils.date2String(latestDate),DateUtils.date2String(latestDate),"1",0,1);
        if(resultList == null){
            resultVo.setResult_code(ResultVo.CODE_FAILED);
            resultVo.setResult_msg("查询结果为null");
            return resultVo;
        }
        Map<String,Object> map = resultList.get(0);
        Set keySet = map.keySet();
        List<String> keyList = new ArrayList<>(keySet);
        Collections.sort(keyList,new Comparator<Object>(){
            @Override
            public int compare(Object o1, Object o2) {
                String[] oStr1 = o1.toString().split("gains");
                String[] oStr2 = o2.toString().split("gains");
                if(oStr1.length<2){
                    return -1;
                }
                if(oStr2.length<2){
                    return 1;
                }
                Integer a1 = Integer.valueOf(oStr1[1]);
                Integer a2 = Integer.valueOf(oStr2[1]);
                if(a1 > a2){
                    return -1;
                }else if(a1 < a2){
                    return 1;
                }
                return 0;
            }
        });
        List<String> nameList = new ArrayList<>();
        List<String> valueList = new ArrayList<>();
        for(String key : keyList){
            if(key.startsWith("gains")){
                String[] str = key.split("gains");
                nameList.add(str[1]);
                valueList.add(map.get(key)+"");
            }
        }
        rootMap.put("latestDate",DateUtils.date2String(latestDate));
        rootMap.put("nameList",nameList);
        rootMap.put("valueList",valueList);
        resultVo.setResultData(rootMap);
        return resultVo;
    }
}
