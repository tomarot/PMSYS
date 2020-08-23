package com.magic.www.permissions.Service.impl;

import com.magic.www.permissions.Service.WindVaneService;
import com.magic.www.permissions.base.PageBase;
import com.magic.www.permissions.base.ResultVo;
import com.magic.www.permissions.common.Dictionary;
import com.magic.www.permissions.domain.Plate;
import com.magic.www.permissions.domain.PlateMoneyView;
import com.magic.www.permissions.domain.WindVane;
import com.magic.www.permissions.mapper.PlateMapper;
import com.magic.www.permissions.mapper.PlateMoneyViewMapper;
import com.magic.www.permissions.mapper.StockMapper;
import com.magic.www.permissions.mapper.WindVaneMapper;
import com.magic.www.permissions.parameterExpand.WindVaneParameter;
import com.magic.www.permissions.utils.Calculator;
import com.magic.www.permissions.utils.DateUtils;
import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 2020/7/1
 * Time: 11:19
 * To change this template use File | Settings | File Templates.
 */
@Service
public class WindVaneServiceImpl implements WindVaneService{

    @Autowired(required = false)
    private WindVaneMapper windVaneMapper;

    @Autowired(required = false)
    private PlateMapper plateMapper;

    @Autowired(required = false)
    private PlateMoneyViewMapper plateMoneyViewMapper;

    @Autowired(required = false)
    private StockMapper stockMapper;

    @Override
    public ResultVo getWindVaneShowInfo(WindVaneParameter windVaneParameter) {
        //构建接口数据格式
        ResultVo resultVo = new ResultVo();
        Map<String,Object> rootMap = new HashMap<String,Object>();
        resultVo.setResultData(rootMap);
        List<Map<String,Object>> monthResultDataList = new ArrayList<>();
        List<Map<String,Object>> weekResultDataList = new ArrayList<>();
        List<Map<String,Object>> dayResultDataList = new ArrayList<>();

        List<Date> dateDayList = windVaneMapper.getWindVaneDateList(Dictionary.Dictionary_WindVane.TYPE_DAY);
        List<Date> dateWeekList = windVaneMapper.getWindVaneDateList(Dictionary.Dictionary_WindVane.TYPE_WEEK);
        List<Date> dateMonthList = windVaneMapper.getWindVaneDateList(Dictionary.Dictionary_WindVane.TYPE_MONTH);

        //获取月风向标
        if(Dictionary.Dictionary_WindVane.OPTION_TYPE_ALL == windVaneParameter.getOptionType()||Dictionary.Dictionary_WindVane.OPTION_TYPE_MONTH == windVaneParameter.getOptionType()){
            WindVane monthWinVane = new WindVane();
            monthWinVane.setType(Dictionary.Dictionary_WindVane.TYPE_MONTH);
            monthWinVane.setStartDate(Calculator.getStartDate(windVaneParameter.getMonth_pageNum(),windVaneParameter.getMonth_pageSize(),dateMonthList));
            monthWinVane.setEndDate(Calculator.getEndDate(windVaneParameter.getMonth_pageNum(),windVaneParameter.getMonth_pageSize(),dateMonthList));
            List<WindVane> monthWindVaneList = windVaneMapper.querySelective(monthWinVane);
            monthResultDataList = buildDataJson(monthWindVaneList);

        }
        //获取周风向标
        if(Dictionary.Dictionary_WindVane.OPTION_TYPE_ALL == windVaneParameter.getOptionType()||Dictionary.Dictionary_WindVane.OPTION_TYPE_WEEK == windVaneParameter.getOptionType()){
            WindVane weekWinVane = new WindVane();
            weekWinVane.setType(Dictionary.Dictionary_WindVane.TYPE_WEEK);
            weekWinVane.setStartDate(Calculator.getStartDate(windVaneParameter.getWeek_pageNum(),windVaneParameter.getWeek_pageSize(),dateWeekList));
            weekWinVane.setEndDate(Calculator.getEndDate(windVaneParameter.getWeek_pageNum(),windVaneParameter.getWeek_pageSize(),dateWeekList));
            List<WindVane> weekWindVaneList = windVaneMapper.querySelective(weekWinVane);
            weekResultDataList = buildDataJson(weekWindVaneList);

        }
        //获取日风向标
        if(Dictionary.Dictionary_WindVane.OPTION_TYPE_ALL == windVaneParameter.getOptionType()||Dictionary.Dictionary_WindVane.OPTION_TYPE_DAY == windVaneParameter.getOptionType()){
            WindVane dayWinVane = new WindVane();
            dayWinVane.setType(Dictionary.Dictionary_WindVane.TYPE_DAY);
            dayWinVane.setStartDate(Calculator.getStartDate(windVaneParameter.getDay_pageNum(),windVaneParameter.getDay_pageSize(),dateDayList));
            dayWinVane.setEndDate(Calculator.getEndDate(windVaneParameter.getDay_pageNum(),windVaneParameter.getDay_pageSize(),dateDayList));
            List<WindVane> dayWindVaneList = windVaneMapper.querySelective(dayWinVane);
            dayResultDataList = buildDataJson(dayWindVaneList);

        }
        rootMap.put("monthResultData",monthResultDataList);
        rootMap.put("weekResultData",weekResultDataList);
        rootMap.put("dayResultData",dayResultDataList);
        return resultVo;
    }

    /**
     * 构建风向标展示数据结构
     * @param sourceDataList
     * @return
     */
    public List<Map<String,Object>> buildDataJson(List<WindVane> sourceDataList){
        List<Map<String,Object>> resultDataList = new ArrayList<Map<String,Object>>();
        Map<String,Object> dateMap = new HashMap<String,Object>();
        for(WindVane windVane:sourceDataList){
            if(dateMap.get(windVane.getCreateTime()+"") == null){
                Map<String,Object> map = new HashMap<String,Object>();
                resultDataList.add(map);
                map.put("datetime", DateUtils.date2String(windVane.getCreateTime()));
                map.put("plateList",new ArrayList<Map<String,Object>>());
                dateMap.put(windVane.getCreateTime()+"",map);
            }
            Map<String,Object> map = (Map<String, Object>) dateMap.get(windVane.getCreateTime()+"");
            List<Map<String,Object>> plateList = (List<Map<String,Object>>) map.get("plateList");
            Map<String,Object> jsonMap = new HashMap<String,Object>();
            jsonMap.put("id",windVane.getId());
            jsonMap.put("code",windVane.getCode());
            jsonMap.put("name",windVane.getName());
            jsonMap.put("increases_list",windVane.getIncreasesList());
            jsonMap.put("drop_list",windVane.getDropList());
            jsonMap.put("money_inflows",windVane.getMoneyInflows());
            jsonMap.put("money_out",windVane.getMoneyOut());
            jsonMap.put("have_harden",windVane.getHaveHarden());
            jsonMap.put("wind_vane",windVane.getWindVane());
            jsonMap.put("first_letter",windVane.getFirstLetter());
            plateList.add(jsonMap);
        }
        return resultDataList;
    }

    @Override
    @Transactional
    public Map getTodayImportant(String date) {
        Map resultMap = new HashMap();
        //获取行业涨幅榜前十
        List<Plate> performerTopList = plateMapper.queryPerformerTop("0",date,10);
        resultMap.put("performerTopList",performerTopList);
        //获取行业跌幅榜前十
        List<Plate> dropTopList = plateMapper.queryDropTop("0",date,10);
        resultMap.put("dropTopList",dropTopList);
        //获取行业资金流入前十
        List<PlateMoneyView> inflowsTopList = plateMoneyViewMapper.queryPlateMoneyInflowsTop("0",date,10);
        resultMap.put("inflowsTopList",inflowsTopList);
        //获取行业资金流出前十
        List<PlateMoneyView> outOfTopList = plateMoneyViewMapper.queryPlateMoneyOutOfTop("0",date,10);
        resultMap.put("outOfTopList",outOfTopList);
        //获取有涨停个股的行业板块列表
        List<Map> plateNameList = stockMapper.queryPlateListForHardenStock(date);
        resultMap.put("plateNameList",plateNameList);
        return resultMap;
    }

    @Override
    @Transactional
    public Map saveWindVane(String windVaneStr) {
        //处理无法正确解析时间的问题
        JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(new String[] {"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss"}));
        //解析字符串
        JSONArray jsonArray = JSONArray.fromObject(windVaneStr);
        for(Object object:jsonArray){
            JSONObject jsonObject = JSONObject.fromObject(object);
            WindVane windVane = (WindVane) JSONObject.toBean(jsonObject, WindVane.class);
            windVaneMapper.insertSelective(windVane);
        }
        return new HashMap();
    }
}
