package com.magic.www.permissions.collect.impl;

import com.magic.www.permissions.base.ResultVo;
import com.magic.www.permissions.collect.CollectService;
import com.magic.www.permissions.collect.Collector;
import com.magic.www.permissions.collect.DataResolver;
import com.magic.www.permissions.common.Dictionary;
import com.magic.www.permissions.controller.UserController;
import com.magic.www.permissions.domain.NorthMoneyMeta;
import com.magic.www.permissions.domain.PlateBaseInfo;
import com.magic.www.permissions.domain.StockBaseInfo;
import com.magic.www.permissions.domain.StockPlateRelation;
import com.magic.www.permissions.mapper.NorthMoneyMapper;
import com.magic.www.permissions.mapper.PlateBaseInfoMapper;
import com.magic.www.permissions.mapper.StockBaseInfoMapper;
import com.magic.www.permissions.mapper.StockPlateRelationMapper;
import com.magic.www.permissions.utils.DateUtils;
import com.magic.www.permissions.utils.StockUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 2020/7/27
 * Time: 8:59
 * To change this template use File | Settings | File Templates.
 */
@Service
public class CollectServiceImpl implements CollectService {

    private static final Logger log = LoggerFactory.getLogger(CollectServiceImpl.class);

    @Autowired(required = false)
    private Collector collector;
    @Autowired(required = false)
    private DataResolver dataResolver;
    @Autowired(required = false)
    private NorthMoneyMapper northMoneyMapper;
    @Autowired(required = false)
    private StockBaseInfoMapper stockBaseInfoMapper;
    @Autowired(required = false)
    private PlateBaseInfoMapper plateBaseInfoMapper;
    @Autowired(required = false)
    private StockPlateRelationMapper stockPlateRelationMapper;

    @Override
    public boolean valid(Date date) {
        NorthMoneyMeta northMoneyMeta = new NorthMoneyMeta();
        northMoneyMeta.setHdDate(date);
        List<NorthMoneyMeta> resultList = northMoneyMapper.querySelective(northMoneyMeta);
        if(resultList.size() > 0){
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public ResultVo collectNorthMoneyData() throws Exception {
        ResultVo resultVo = new ResultVo();

        //----采集行业板块数据----

        String r1 = collector.doCollect(Collector.HY_1R_URL);
        List<NorthMoneyMeta> resultList1 = dataResolver.resolverNorthMoney(r1,Dictionary.Dictionary_NorthMoney.DATA_TYPE_HY,NorthMoneyMeta.class);

        NorthMoneyMeta data = resultList1.get(0);
        //验证数据是否已存在
        if(valid(data.getHdDate())){
            log.info("提示："+DateUtils.date2String(data.getHdDate())+"数据已存在,终止采集任务！");
            resultVo.setResult_msg("提示："+DateUtils.date2String(data.getHdDate())+"数据已存在,终止采集任务！");
            return resultVo;
        }

        //1日
        for(NorthMoneyMeta northMoneyMeta:resultList1){
            northMoneyMapper.insertSelective(northMoneyMeta);
        }
        //3日
        String r3 = collector.doCollect(Collector.HY_3R_URL);
        List<NorthMoneyMeta> resultList3 = dataResolver.resolverNorthMoney(r3,Dictionary.Dictionary_NorthMoney.DATA_TYPE_HY,NorthMoneyMeta.class);
        for(NorthMoneyMeta northMoneyMeta:resultList3){
            northMoneyMapper.insertSelective(northMoneyMeta);
        }
        //5日
        String r5 = collector.doCollect(Collector.HY_5R_URL);
        List<NorthMoneyMeta> resultList5 = dataResolver.resolverNorthMoney(r5,Dictionary.Dictionary_NorthMoney.DATA_TYPE_HY,NorthMoneyMeta.class);
        for(NorthMoneyMeta northMoneyMeta:resultList5){
            northMoneyMapper.insertSelective(northMoneyMeta);
        }
        //10日
        String r10 = collector.doCollect(Collector.HY_10R_URL);
        List<NorthMoneyMeta> resultList10 = dataResolver.resolverNorthMoney(r10,Dictionary.Dictionary_NorthMoney.DATA_TYPE_HY,NorthMoneyMeta.class);
        for(NorthMoneyMeta northMoneyMeta:resultList10){
            northMoneyMapper.insertSelective(northMoneyMeta);
        }
        //1月
        String r1y = collector.doCollect(Collector.HY_1Y_URL);
        List<NorthMoneyMeta> resultList1y = dataResolver.resolverNorthMoney(r1y,Dictionary.Dictionary_NorthMoney.DATA_TYPE_HY,NorthMoneyMeta.class);
        for(NorthMoneyMeta northMoneyMeta:resultList1y){
            northMoneyMapper.insertSelective(northMoneyMeta);
        }
        //1季度
        String r1jd = collector.doCollect(Collector.HY_1JD_URL);
        List<NorthMoneyMeta> resultList1jd = dataResolver.resolverNorthMoney(r1jd,Dictionary.Dictionary_NorthMoney.DATA_TYPE_HY,NorthMoneyMeta.class);
        for(NorthMoneyMeta northMoneyMeta:resultList1jd){
            northMoneyMapper.insertSelective(northMoneyMeta);
        }
        //1年
        String r1n = collector.doCollect(Collector.HY_1N_URL);
        List<NorthMoneyMeta> resultList1n = dataResolver.resolverNorthMoney(r1n,Dictionary.Dictionary_NorthMoney.DATA_TYPE_HY,NorthMoneyMeta.class);
        for(NorthMoneyMeta northMoneyMeta:resultList1n){
            northMoneyMapper.insertSelective(northMoneyMeta);
        }
        //采集概念板块数据
        //1日
        String g1r = collector.doCollect(Collector.GN_1R_URL);
        List<NorthMoneyMeta> resultListG1r = dataResolver.resolverNorthMoney(g1r,Dictionary.Dictionary_NorthMoney.DATA_TYPE_GN,NorthMoneyMeta.class);
        for(NorthMoneyMeta northMoneyMeta:resultListG1r){
            northMoneyMapper.insertSelective(northMoneyMeta);
        }
        //3日
        String g3r = collector.doCollect(Collector.GN_3R_URL);
        List<NorthMoneyMeta> resultListG3r = dataResolver.resolverNorthMoney(g3r,Dictionary.Dictionary_NorthMoney.DATA_TYPE_GN,NorthMoneyMeta.class);
        for(NorthMoneyMeta northMoneyMeta:resultListG3r){
            northMoneyMapper.insertSelective(northMoneyMeta);
        }
        //5日
        String g5r = collector.doCollect(Collector.GN_5R_URL);
        List<NorthMoneyMeta> resultListG5r = dataResolver.resolverNorthMoney(g5r,Dictionary.Dictionary_NorthMoney.DATA_TYPE_GN,NorthMoneyMeta.class);
        for(NorthMoneyMeta northMoneyMeta:resultListG5r){
            northMoneyMapper.insertSelective(northMoneyMeta);
        }
        //10日
        String g10r = collector.doCollect(Collector.GN_10R_URL);
        List<NorthMoneyMeta> resultListG10r = dataResolver.resolverNorthMoney(g10r,Dictionary.Dictionary_NorthMoney.DATA_TYPE_GN,NorthMoneyMeta.class);
        for(NorthMoneyMeta northMoneyMeta:resultListG10r){
            northMoneyMapper.insertSelective(northMoneyMeta);
        }
        //1月
        String g1y = collector.doCollect(Collector.GN_1Y_URL);
        List<NorthMoneyMeta> resultListG1y = dataResolver.resolverNorthMoney(g1y,Dictionary.Dictionary_NorthMoney.DATA_TYPE_GN,NorthMoneyMeta.class);
        for(NorthMoneyMeta northMoneyMeta:resultListG1y){
            northMoneyMapper.insertSelective(northMoneyMeta);
        }
        //1季度
        String g1jd = collector.doCollect(Collector.GN_1JD_URL);
        List<NorthMoneyMeta> resultListG1jd = dataResolver.resolverNorthMoney(g1jd,Dictionary.Dictionary_NorthMoney.DATA_TYPE_GN,NorthMoneyMeta.class);
        for(NorthMoneyMeta northMoneyMeta:resultListG1jd){
            northMoneyMapper.insertSelective(northMoneyMeta);
        }
        //1年
        String g1n = collector.doCollect(Collector.GN_1N_URL);
        List<NorthMoneyMeta> resultListG1n = dataResolver.resolverNorthMoney(g1n,Dictionary.Dictionary_NorthMoney.DATA_TYPE_GN,NorthMoneyMeta.class);
        for(NorthMoneyMeta northMoneyMeta:resultListG1n){
            northMoneyMapper.insertSelective(northMoneyMeta);
        }
        resultVo.setResult_msg("["+DateUtils.date2String(data.getHdDate())+"]数据采集完成");
        return resultVo;
    }

    @Override
    @Transactional
    public ResultVo collectStockData() {
        ResultVo resultVo = new ResultVo();
        String r1 = collector.doCollect(Collector.STOCK_BASE_INFO_URL);
        List<StockBaseInfo> resultList = dataResolver.resolverStock(r1,StockBaseInfo.class);

        //获取全部股票数据
        StockBaseInfo queryStockBaseInfo = new StockBaseInfo();
        List<StockBaseInfo> stockList = stockBaseInfoMapper.querySelective(queryStockBaseInfo);
        //缓存股票信息
        Map<String,Object> stockListMap = new HashMap<String,Object>();
        for(StockBaseInfo stock:stockList){
            stockListMap.put(stock.getCode(),stock);
        }

        for(StockBaseInfo stockBaseInfo:resultList){
            StockBaseInfo oldStock = (StockBaseInfo) stockListMap.get(stockBaseInfo.getCode());
            //验证数据是否为新数据
            if(oldStock == null){
                //插入数据
                stockBaseInfoMapper.insertSelective(stockBaseInfo);
            }
            //验证数据名称是否变更
            if(oldStock != null && !stockBaseInfo.getName().equals(oldStock.getName())){
                //更新数据
                oldStock.setName(stockBaseInfo.getName());
                stockBaseInfoMapper.updateByPrimaryKeySelective(oldStock);
            }
        }
        resultVo.setResult_msg("[股票数据]数据采集完成");
        return resultVo;
    }

    @Override
    @Transactional
    public ResultVo collectStockPlateInfoData() {
        ResultVo resultVo = new ResultVo();
        //缓存板块数据
        PlateBaseInfo queryPlate = new PlateBaseInfo();
        List<PlateBaseInfo> plateBaseInfoList = plateBaseInfoMapper.querySelective(queryPlate);
        Map<String,Object> allPlateBaseInfo = new HashMap<String,Object>();
        for(PlateBaseInfo plateBaseInfo : plateBaseInfoList){
            allPlateBaseInfo.put(plateBaseInfo.getName(),plateBaseInfo);
        }

        //缓存股票与板块是否已建立关联
        StockPlateRelation queryStockPlateRelation = new StockPlateRelation();
        List<StockPlateRelation> stockPlateRlationList = stockPlateRelationMapper.querySelective(queryStockPlateRelation);
        Map<String,Object> allStockPlateRelationInfo = new HashMap<String,Object>();
        for(StockPlateRelation stockPlateRelation : stockPlateRlationList){
            allStockPlateRelationInfo.put(stockPlateRelation.getStockCode()+"_"+stockPlateRelation.getPlateCode(),stockPlateRelation);
        }
        //获取全部股票数据
        StockBaseInfo queryStockBaseInfo = new StockBaseInfo();
        List<StockBaseInfo> stockList = stockBaseInfoMapper.querySelective(queryStockBaseInfo);
        for(StockBaseInfo stock:stockList){
            //抓取股票信息
            String markStr = StockUtils.getMark(stock.getCode());
            log.debug("URL:"+Collector.STOCK_CORE_CONCEPTION_URL+markStr+stock.getCode());
            String r1 = collector.doCollect(Collector.STOCK_CORE_CONCEPTION_URL+markStr+stock.getCode());
            log.debug("结果:"+r1);
            List<String> conceptionList = dataResolver.resolverStockCoreConception(r1);
            if(conceptionList.size() == 0){
                log.info("代码：["+markStr+stock.getCode()+"]未发现核心题材板块！");
                continue;
            }
            for(String plateName:conceptionList){
                //跳过特殊值
                if("--".equals(plateName)){
                    log.info("特殊板块名称已跳过：名称["+plateName+"]");
                    continue;
                }
                //获取板块信息
                PlateBaseInfo plateInfo = (PlateBaseInfo) allPlateBaseInfo.get(plateName);
                if(plateInfo == null){
                    try {
                        throw new Exception("板块名称：["+plateName+"]未在板块库中发现！");
                    } catch (Exception e) {
                        log.error("板块名称：["+plateName+"]未在板块库中发现！",e);
//                        e.printStackTrace();
                    }
                    continue;
                }
                //股票与板块是否已建立关联
                StockPlateRelation relation = (StockPlateRelation) allStockPlateRelationInfo.get(stock.getCode()+"_"+plateInfo.getCode());
                //未建立关联
                if(relation == null){
                    StockPlateRelation stockPlateRelation = new StockPlateRelation();
                    stockPlateRelation.setStockId(stock.getId());
                    stockPlateRelation.setStockCode(stock.getCode());
                    stockPlateRelation.setPlateId(plateInfo.getId());
                    stockPlateRelation.setPlateCode(plateInfo.getCode());
                    stockPlateRelationMapper.insertSelective(stockPlateRelation);
                }
            }
        }
        resultVo.setResult_msg("股票与板块关联完成！");
        return resultVo;
    }

    @Override
    public ResultVo collectPlateInfoData() {
        log.info("板块数据采集任务开始。["+DateUtils.date2String(new Date(),DateUtils.DATE_PATTERN_1)+"]");
        ResultVo resultVo = new ResultVo();
        //获取库中与存在的板块列表
        PlateBaseInfo queryPlate = new PlateBaseInfo();
        List<PlateBaseInfo> plateBaseInfoList = plateBaseInfoMapper.querySelective(queryPlate);
        //缓存板块信息
        Map<String,Object> plateListMap = new HashMap<String,Object>();
        for(PlateBaseInfo plate:plateBaseInfoList){
            plateListMap.put(plate.getCode(),plate);
        }

        //采集行业板块
        log.info("开始采集行业板块。["+DateUtils.date2String(new Date(),DateUtils.DATE_PATTERN_1)+"]");
        log.debug("采集URL：["+Collector.PLATE_HY_URL+"]");
        String rhy = collector.doCollect(Collector.PLATE_HY_URL);
        log.debug("解析结果：["+rhy+"]");
        List<PlateBaseInfo> resultHyList = dataResolver.resolverPlate(rhy,PlateBaseInfo.class);
        for(PlateBaseInfo plateBaseInfo:resultHyList){
            //检验库中是否已经存在
            if(plateListMap.get(plateBaseInfo.getCode()) == null){
                log.debug("新增板块：[名称："+plateBaseInfo.getName()+",代码:"+plateBaseInfo.getCode()+"]");
                plateBaseInfo.setType(Dictionary.Dictionary_PlateBase.TYPE_HY);
                plateBaseInfo.setConfirmState(Dictionary.Dictionary_PlateBase.CONFIRM_STATE_N);
                plateBaseInfo.setAvailable(Dictionary.Dictionary_PlateBase.AVAILABLE_Y);
                plateBaseInfoMapper.insertSelective(plateBaseInfo);
            }
        }

        //采集概念
        log.info("开始采集概念板块。["+DateUtils.date2String(new Date(),DateUtils.DATE_PATTERN_1)+"]");
        log.debug("采集URL：["+Collector.PLATE_GN_URL+"]");
        String rgn = collector.doCollect(Collector.PLATE_GN_URL);
        log.debug("解析结果：["+rgn+"]");
        List<PlateBaseInfo> resultGnList = dataResolver.resolverPlate(rgn,PlateBaseInfo.class);
        for(PlateBaseInfo plateBaseInfo:resultGnList){
            //检验库中是否已经存在
            if(plateListMap.get(plateBaseInfo.getCode()) == null){
                log.debug("新增板块：[名称："+plateBaseInfo.getName()+",代码:"+plateBaseInfo.getCode()+"]");
                plateBaseInfo.setType(Dictionary.Dictionary_PlateBase.TYPE_GN);
                plateBaseInfo.setConfirmState(Dictionary.Dictionary_PlateBase.CONFIRM_STATE_N);
                plateBaseInfo.setAvailable(Dictionary.Dictionary_PlateBase.AVAILABLE_Y);
                plateBaseInfoMapper.insertSelective(plateBaseInfo);
            }
        }

        //采集地域
        log.info("开始采集地域板块。["+DateUtils.date2String(new Date(),DateUtils.DATE_PATTERN_1)+"]");
        log.debug("采集URL：["+Collector.PLATE_DY_URL+"]");
        String rdy = collector.doCollect(Collector.PLATE_DY_URL);
        log.debug("解析结果：["+rgn+"]");
        List<PlateBaseInfo> resultDyList = dataResolver.resolverPlate(rdy,PlateBaseInfo.class);
        for(PlateBaseInfo plateBaseInfo:resultDyList){
            //检验库中是否已经存在
            if(plateListMap.get(plateBaseInfo.getCode()) == null){
                log.debug("新增板块：[名称："+plateBaseInfo.getName()+",代码:"+plateBaseInfo.getCode()+"]");
                plateBaseInfo.setType(Dictionary.Dictionary_PlateBase.TYPE_DY);
                plateBaseInfo.setConfirmState(Dictionary.Dictionary_PlateBase.CONFIRM_STATE_N);
                plateBaseInfo.setAvailable(Dictionary.Dictionary_PlateBase.AVAILABLE_Y);
                plateBaseInfoMapper.insertSelective(plateBaseInfo);
            }
        }
        resultVo.setResult_msg("[板块数据]数据采集完成");
        log.info("板块数据采集任务完成。["+DateUtils.date2String(new Date(),DateUtils.DATE_PATTERN_1)+"]");
        return resultVo;
    }

}
