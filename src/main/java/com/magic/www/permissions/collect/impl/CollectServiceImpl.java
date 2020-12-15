package com.magic.www.permissions.collect.impl;

import com.magic.www.permissions.base.ResultVo;
import com.magic.www.permissions.collect.CollectService;
import com.magic.www.permissions.collect.Collector;
import com.magic.www.permissions.collect.DataResolver;
import com.magic.www.permissions.common.Dictionary;
import com.magic.www.permissions.domain.*;
import com.magic.www.permissions.mapper.*;
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
    private NorthMoneyStockMetaMapper northMoneyStockMetaMapper;
    @Autowired(required = false)
    private StockBaseInfoMapper stockBaseInfoMapper;
    @Autowired(required = false)
    private PlateBaseInfoMapper plateBaseInfoMapper;
    @Autowired(required = false)
    private StockPlateRelationMapper stockPlateRelationMapper;
    @Autowired(required = false)
    private StockDataMetaMapper stockDataMetaMapper;
    @Autowired(required = false)
    private CollectPlateRankingMapper collectPlateRankingMapper;
    @Autowired(required = false)
    private CollectPlateMoneyRankingMapper collectPlateMoneyRankingMapper;
    @Autowired(required = false)
    private CollectStockRankingMapper collectStockRankingMapper;
    @Autowired(required = false)
    private CollectStockMoneyRankingMapper collectStockMoneyRankingMapper;

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
    public boolean valid_northMoneyStock(Date date) {
        NorthMoneyStockMeta northMoneyStockMeta = new NorthMoneyStockMeta();
        northMoneyStockMeta.setCreateTimeStr(DateUtils.date2String(date));
        List<NorthMoneyStockMeta> resultList = northMoneyStockMetaMapper.querySelective(northMoneyStockMeta);
        if(resultList.size() > 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean valid_plateRanking(Date date) {
        CollectPlateRanking plateRanking = new CollectPlateRanking();
        plateRanking.setCreateTimeStr(DateUtils.date2String(date));
        List<CollectPlateRanking> resultList = collectPlateRankingMapper.querySelective(plateRanking);
        if(resultList.size() > 0){
            return true;
        }
        return false;
    }
    @Override
    public boolean valid_stockRanking(Date date) {
        CollectStockRanking stockRanking = new CollectStockRanking();
        stockRanking.setCreateTimeStr(DateUtils.date2String(date));
        List<CollectStockRanking> resultList = collectStockRankingMapper.querySelective(stockRanking);
        if(resultList.size() > 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean valid_stockMoneyRanking(Date date) {
        CollectStockMoneyRanking stockMoneyRanking = new CollectStockMoneyRanking();
        stockMoneyRanking.setCreateTimeStr(DateUtils.date2String(date));
        List<CollectStockMoneyRanking> resultList = collectStockMoneyRankingMapper.querySelective(stockMoneyRanking);
        if(resultList.size() > 0){
            return true;
        }
        return false;
    }


    @Override
    public boolean valid_plateMoneyRanking(Date date) {
        CollectPlateMoneyRanking plateMoneyRanking = new CollectPlateMoneyRanking();
        plateMoneyRanking.setCreateTimeStr(DateUtils.date2String(date));
        List<CollectPlateMoneyRanking> resultList = collectPlateMoneyRankingMapper.querySelective(plateMoneyRanking);
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
    public ResultVo collectNorthMoneyStockData() throws Exception {
        log.info("采集北向资金个股数据.开始!["+DateUtils.date2String(new Date())+"]");
        ResultVo resultVo = new ResultVo();

        //----采集行业板块数据----

        String r1 = collector.doCollect(Collector.GG_1R_URL);
        List<NorthMoneyStockMeta> resultList1 = dataResolver.resolverNorthMoneyStock(r1,NorthMoneyStockMeta.class);

        NorthMoneyStockMeta data = resultList1.get(0);
        //验证数据是否已存在
        if(valid_northMoneyStock(data.getHdDate())){
            log.info("提示："+DateUtils.date2String(data.getHdDate())+"数据已存在,终止采集任务！");
            resultVo.setResult_msg("提示："+DateUtils.date2String(data.getHdDate())+"数据已存在,终止采集任务！");
            return resultVo;
        }

        //1日
        for(NorthMoneyStockMeta northMoneyStockMeta:resultList1){
            northMoneyStockMetaMapper.insertSelective(northMoneyStockMeta);
        }
        log.info("采集北向资金个股数据.今日排行完成!["+DateUtils.date2String(new Date())+"]");
        //3日
        String r3 = collector.doCollect(Collector.GG_3R_URL);
        List<NorthMoneyStockMeta> resultList3 = dataResolver.resolverNorthMoneyStock(r3,NorthMoneyStockMeta.class);
        for(NorthMoneyStockMeta northMoneyStockMeta:resultList3){
            northMoneyStockMetaMapper.insertSelective(northMoneyStockMeta);
        }
        log.info("采集北向资金个股数据.3日排行完成!["+DateUtils.date2String(new Date())+"]");
        //5日
        String r5 = collector.doCollect(Collector.GG_5R_URL);
        List<NorthMoneyStockMeta> resultList5 = dataResolver.resolverNorthMoneyStock(r5,NorthMoneyStockMeta.class);
        for(NorthMoneyStockMeta northMoneyStockMeta:resultList5){
            northMoneyStockMetaMapper.insertSelective(northMoneyStockMeta);
        }
        log.info("采集北向资金个股数据.5日排行完成!["+DateUtils.date2String(new Date())+"]");
        //10日
        String r10 = collector.doCollect(Collector.GG_10R_URL);
        List<NorthMoneyStockMeta> resultList10 = dataResolver.resolverNorthMoneyStock(r10,NorthMoneyStockMeta.class);
        for(NorthMoneyStockMeta northMoneyStockMeta:resultList10){
            northMoneyStockMetaMapper.insertSelective(northMoneyStockMeta);
        }
        log.info("采集北向资金个股数据.10日排行完成!["+DateUtils.date2String(new Date())+"]");
        //1月
        String r1y = collector.doCollect(Collector.GG_1Y_URL);
        List<NorthMoneyStockMeta> resultList1y = dataResolver.resolverNorthMoneyStock(r1y,NorthMoneyStockMeta.class);
        for(NorthMoneyStockMeta northMoneyStockMeta:resultList1y){
            northMoneyStockMetaMapper.insertSelective(northMoneyStockMeta);
        }
        log.info("采集北向资金个股数据.1月排行完成!["+DateUtils.date2String(new Date())+"]");
        //1季度
        String r1jd = collector.doCollect(Collector.GG_1JD_URL);
        List<NorthMoneyStockMeta> resultList1jd = dataResolver.resolverNorthMoneyStock(r1jd,NorthMoneyStockMeta.class);
        for(NorthMoneyStockMeta northMoneyStockMeta:resultList1jd){
            northMoneyStockMetaMapper.insertSelective(northMoneyStockMeta);
        }
        log.info("采集北向资金个股数据.1季度排行完成!["+DateUtils.date2String(new Date())+"]");
        //1年
        String r1n = collector.doCollect(Collector.GG_1N_URL);
        List<NorthMoneyStockMeta> resultList1n = dataResolver.resolverNorthMoneyStock(r1n,NorthMoneyStockMeta.class);
        for(NorthMoneyStockMeta northMoneyStockMeta:resultList1n){
            northMoneyStockMetaMapper.insertSelective(northMoneyStockMeta);
        }
        log.info("采集北向资金个股数据.1年排行完成!["+DateUtils.date2String(new Date())+"]");

        resultVo.setResult_msg("采集北向资金个股数据.["+DateUtils.date2String(data.getHdDate())+"]数据采集完成");
        log.info("采集北向资金个股数据.完成!["+DateUtils.date2String(new Date())+"]");
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

        //清空股票与板块建立的联系
        stockPlateRelationMapper.deleteAll();
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
                //建立股票与板块关联
                StockPlateRelation stockPlateRelation = new StockPlateRelation();
                stockPlateRelation.setStockId(stock.getId());
                stockPlateRelation.setStockCode(stock.getCode());
                stockPlateRelation.setPlateId(plateInfo.getId());
                stockPlateRelation.setPlateCode(plateInfo.getCode());
                stockPlateRelationMapper.insertSelective(stockPlateRelation);
            }
        }
        resultVo.setResult_msg("股票与板块关联完成！");
        return resultVo;
    }

    @Override
    @Transactional
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

    @Override
    @Transactional
    public ResultVo collectCurrentStockGainsData() {
        log.info("采集当前个股涨跌数据任务开始。["+DateUtils.date2String(new Date(),DateUtils.DATE_PATTERN_1)+"]");
        ResultVo resultVo = new ResultVo();

        //----采集当前个股涨跌数据----
        String r1 = collector.doCollect(Collector.CURRENT_STOCK_GAINS_INFO_URL);
        List<StockDataMeta> resultList1 = dataResolver.resolverCurrentStock(r1,StockDataMeta.class);
        //清除历史数据
        log.debug("清空历史数据开始");
        int deleteNum = stockDataMetaMapper.delete();
        log.debug("清空历史数据完成，共清除["+deleteNum+"]条。");
        //保存最新数据
        log.debug("保存最新数据开始");
        for(StockDataMeta stock : resultList1){
            stockDataMetaMapper.insertSelective(stock);
        }
        log.debug("保存最新数据完成");
        log.info("采集当前个股涨跌数据任务完成。["+DateUtils.date2String(new Date(),DateUtils.DATE_PATTERN_1)+"]");
        return resultVo;
    }

    @Override
    @Transactional
    public ResultVo collectPlateRankingData() {
        log.info("板块排行数据采集任务开始。["+DateUtils.date2String(new Date(),DateUtils.DATE_PATTERN_1)+"]");
        ResultVo resultVo = new ResultVo();

        //采集行业板块
        log.info("开始采集行业板块。["+DateUtils.date2String(new Date(),DateUtils.DATE_PATTERN_1)+"]");
        log.debug("采集URL：["+Collector.PLATE_RANKING_HY_URL+"]");
        String rhy = collector.doCollect(Collector.PLATE_RANKING_HY_URL);
        log.debug("解析结果：["+rhy+"]");
        List<CollectPlateRanking> resultHyList = dataResolver.resolverPlateRanking(rhy,Dictionary.Dictionary_PlateBase.TYPE_HY,CollectPlateRanking.class);
        //检验数据是否已经采集完成
        CollectPlateRanking data = resultHyList.get(0);
        //验证数据是否已存在
        if(valid_plateRanking(data.getCreateTime())){
            log.info("提示："+DateUtils.date2String(data.getCreateTime())+"数据已存在,终止采集任务！");
            resultVo.setResult_msg("提示："+DateUtils.date2String(data.getCreateTime())+"数据已存在,终止采集任务！");
            return resultVo;
        }
        for(CollectPlateRanking collectPlateRanking:resultHyList){
            collectPlateRanking.setDataType(Dictionary.Dictionary_PlateBase.TYPE_HY);
            collectPlateRankingMapper.insertSelective(collectPlateRanking);
            log.debug("采集板块：[名称："+collectPlateRanking.getF14()+",代码:"+collectPlateRanking.getF12()+"]完成!");
        }

        //采集概念
        log.info("开始采集概念板块。["+DateUtils.date2String(new Date(),DateUtils.DATE_PATTERN_1)+"]");
        log.debug("采集URL：["+Collector.PLATE_RANKING_GN_URL+"]");
        String rgn = collector.doCollect(Collector.PLATE_RANKING_GN_URL);
        log.debug("解析结果：["+rgn+"]");
        List<CollectPlateRanking> resultGnList = dataResolver.resolverPlateRanking(rgn,Dictionary.Dictionary_PlateBase.TYPE_GN,CollectPlateRanking.class);
        for(CollectPlateRanking collectPlateRanking:resultGnList){
            collectPlateRanking.setDataType(Dictionary.Dictionary_PlateBase.TYPE_GN);
            collectPlateRankingMapper.insertSelective(collectPlateRanking);
            log.debug("采集板块：[名称："+collectPlateRanking.getF14()+",代码:"+collectPlateRanking.getF12()+"]完成!");
        }

        //采集地域
        log.info("开始采集地域板块。["+DateUtils.date2String(new Date(),DateUtils.DATE_PATTERN_1)+"]");
        log.debug("采集URL：["+Collector.PLATE_RANKING_DY_URL+"]");
        String rdy = collector.doCollect(Collector.PLATE_RANKING_DY_URL);
        log.debug("解析结果：["+rgn+"]");
        List<CollectPlateRanking> resultDyList = dataResolver.resolverPlateRanking(rdy,Dictionary.Dictionary_PlateBase.TYPE_DY,CollectPlateRanking.class);
        for(CollectPlateRanking collectPlateRanking:resultDyList){
            collectPlateRanking.setDataType(Dictionary.Dictionary_PlateBase.TYPE_DY);
            collectPlateRankingMapper.insertSelective(collectPlateRanking);
            log.debug("采集板块：[名称："+collectPlateRanking.getF14()+",代码:"+collectPlateRanking.getF12()+"]完成!");
        }

        resultVo.setResult_msg("[板块排行数据]数据采集完成");
        log.info("板块排行数据采集任务完成。["+DateUtils.date2String(new Date(),DateUtils.DATE_PATTERN_1)+"]");
        return resultVo;
    }

    @Override
    @Transactional
    public ResultVo collectPlateMoneyRankingData() {
        log.info("板块资金排行数据采集任务开始。["+DateUtils.date2String(new Date(),DateUtils.DATE_PATTERN_1)+"]");
        ResultVo resultVo = new ResultVo();

        //————————采集行业板块————————
        log.info("开始采集行业板块资金数据。["+DateUtils.date2String(new Date(),DateUtils.DATE_PATTERN_1)+"]");

        //采集行业板块1日资金
        log.debug("开始采集行业板块资金1日数据。");
        log.debug("采集URL：["+Collector.PLATE_MONEY_RANKING_HY1_URL+"]");
        String rhy1 = collector.doCollect(Collector.PLATE_MONEY_RANKING_HY1_URL);
        log.debug("解析结果：["+rhy1+"]");
        List<CollectPlateMoneyRanking> resultHyList = dataResolver.resolverPlateMoneyRanking(rhy1,Dictionary.Dictionary_PlateBase.TYPE_HY,Dictionary.Dictionary_PlateBase.PERIOD_TYPE_1R,CollectPlateMoneyRanking.class);
        //检验数据是否已经采集完成
        CollectPlateMoneyRanking dataHy1 = resultHyList.get(0);
        //验证数据是否已存在
        if(valid_plateMoneyRanking(dataHy1.getCreateTime())){
            log.info("提示："+DateUtils.date2String(dataHy1.getCreateTime())+"数据已存在,终止采集任务！");
            resultVo.setResult_msg("提示："+DateUtils.date2String(dataHy1.getCreateTime())+"数据已存在,终止采集任务！");
            return resultVo;
        }
        for(CollectPlateMoneyRanking collectPlateMoneyRanking:resultHyList){
            collectPlateMoneyRankingMapper.insertSelective(collectPlateMoneyRanking);
            log.debug("采集板块：[名称："+collectPlateMoneyRanking.getName()+",代码:"+collectPlateMoneyRanking.getCode()+"]完成!");
        }
        log.debug("采集行业板块资金1日数据完成。");

        //采集行业板块5日资金
        log.debug("开始采集行业板块资金5日数据。");
        log.debug("采集URL：["+Collector.PLATE_MONEY_RANKING_HY5_URL+"]");
        String rhy5 = collector.doCollect(Collector.PLATE_MONEY_RANKING_HY5_URL);
        log.debug("解析结果：["+rhy5+"]");
        List<CollectPlateMoneyRanking> resultHy5List = dataResolver.resolverPlateMoneyRanking(rhy5,Dictionary.Dictionary_PlateBase.TYPE_HY,Dictionary.Dictionary_PlateBase.PERIOD_TYPE_5R,CollectPlateMoneyRanking.class);
        for(CollectPlateMoneyRanking collectPlateMoneyRanking:resultHy5List){
            collectPlateMoneyRankingMapper.insertSelective(collectPlateMoneyRanking);
            log.debug("采集板块：[名称："+collectPlateMoneyRanking.getName()+",代码:"+collectPlateMoneyRanking.getCode()+"]完成!");
        }
        log.debug("采集行业板块资金5日数据完成。");

        //采集行业板块10日资金
        log.debug("开始采集行业板块资金10日数据。");
        log.debug("采集URL：["+Collector.PLATE_MONEY_RANKING_HY10_URL+"]");
        String rhy10 = collector.doCollect(Collector.PLATE_MONEY_RANKING_HY10_URL);
        log.debug("解析结果：["+rhy10+"]");
        List<CollectPlateMoneyRanking> resultHy10List = dataResolver.resolverPlateMoneyRanking(rhy10,Dictionary.Dictionary_PlateBase.TYPE_HY,Dictionary.Dictionary_PlateBase.PERIOD_TYPE_10R,CollectPlateMoneyRanking.class);
        for(CollectPlateMoneyRanking collectPlateMoneyRanking:resultHy10List){
            collectPlateMoneyRankingMapper.insertSelective(collectPlateMoneyRanking);
            log.debug("采集板块：[名称："+collectPlateMoneyRanking.getName()+",代码:"+collectPlateMoneyRanking.getCode()+"]完成!");
        }
        log.debug("采集行业板块资金10日数据完成。");


        //————————采集概念————————
        log.info("开始采集概念板块资金数据。["+DateUtils.date2String(new Date(),DateUtils.DATE_PATTERN_1)+"]");

        //采集概念板块1日资金
        log.debug("开始采集概念板块资金1日数据。");
        log.debug("采集URL：["+Collector.PLATE_MONEY_RANKING_GN1_URL+"]");
        String rgn1 = collector.doCollect(Collector.PLATE_MONEY_RANKING_GN1_URL);
        log.debug("解析结果：["+rgn1+"]");
        List<CollectPlateMoneyRanking> resultGnList = dataResolver.resolverPlateMoneyRanking(rgn1,Dictionary.Dictionary_PlateBase.TYPE_GN,Dictionary.Dictionary_PlateBase.PERIOD_TYPE_1R,CollectPlateMoneyRanking.class);
        for(CollectPlateMoneyRanking collectPlateMoneyRanking:resultGnList){
            collectPlateMoneyRankingMapper.insertSelective(collectPlateMoneyRanking);
            log.debug("采集板块：[名称："+collectPlateMoneyRanking.getName()+",代码:"+collectPlateMoneyRanking.getCode()+"]完成!");
        }
        log.debug("采集概念板块资金1日数据完成。");

        //采集概念板块5日资金
        log.debug("开始采集概念板块资金5日数据。");
        log.debug("采集URL：["+Collector.PLATE_MONEY_RANKING_GN5_URL+"]");
        String rGn5 = collector.doCollect(Collector.PLATE_MONEY_RANKING_GN5_URL);
        log.debug("解析结果：["+rGn5+"]");
        List<CollectPlateMoneyRanking> resultGn5List = dataResolver.resolverPlateMoneyRanking(rGn5,Dictionary.Dictionary_PlateBase.TYPE_GN,Dictionary.Dictionary_PlateBase.PERIOD_TYPE_5R,CollectPlateMoneyRanking.class);
        for(CollectPlateMoneyRanking collectPlateMoneyRanking:resultGn5List){
            collectPlateMoneyRankingMapper.insertSelective(collectPlateMoneyRanking);
            log.debug("采集板块：[名称："+collectPlateMoneyRanking.getName()+",代码:"+collectPlateMoneyRanking.getCode()+"]完成!");
        }
        log.debug("采集概念板块资金5日数据完成。");

        //采集概念板块10日资金
        log.debug("开始采集概念板块资金10日数据。");
        log.debug("采集URL：["+Collector.PLATE_MONEY_RANKING_GN10_URL+"]");
        String rGn10 = collector.doCollect(Collector.PLATE_MONEY_RANKING_GN10_URL);
        log.debug("解析结果：["+rGn10+"]");
        List<CollectPlateMoneyRanking> resultGn10List = dataResolver.resolverPlateMoneyRanking(rGn10,Dictionary.Dictionary_PlateBase.TYPE_GN,Dictionary.Dictionary_PlateBase.PERIOD_TYPE_10R,CollectPlateMoneyRanking.class);
        for(CollectPlateMoneyRanking collectPlateMoneyRanking:resultGn10List){
            collectPlateMoneyRankingMapper.insertSelective(collectPlateMoneyRanking);
            log.debug("采集板块：[名称："+collectPlateMoneyRanking.getName()+",代码:"+collectPlateMoneyRanking.getCode()+"]完成!");
        }
        log.debug("采集概念板块资金10日数据完成。");

        //————————采集地域————————
        log.info("开始采集地域板块资金数据。["+DateUtils.date2String(new Date(),DateUtils.DATE_PATTERN_1)+"]");

        //采集概念板块1日资金
        log.debug("开始采集地域板块资金1日数据。");
        log.debug("采集URL：["+Collector.PLATE_MONEY_RANKING_DY1_URL+"]");
        String rDy1 = collector.doCollect(Collector.PLATE_MONEY_RANKING_DY1_URL);
        log.debug("解析结果：["+rDy1+"]");
        List<CollectPlateMoneyRanking> resultDyList = dataResolver.resolverPlateMoneyRanking(rDy1,Dictionary.Dictionary_PlateBase.TYPE_DY,Dictionary.Dictionary_PlateBase.PERIOD_TYPE_1R,CollectPlateMoneyRanking.class);
        for(CollectPlateMoneyRanking collectPlateMoneyRanking:resultDyList){
            collectPlateMoneyRankingMapper.insertSelective(collectPlateMoneyRanking);
            log.debug("采集板块：[名称："+collectPlateMoneyRanking.getName()+",代码:"+collectPlateMoneyRanking.getCode()+"]完成!");
        }
        log.debug("采集地域板块资金1日数据完成。");

        //采集地域板块5日资金
        log.debug("开始采集地域板块资金5日数据。");
        log.debug("采集URL：["+Collector.PLATE_MONEY_RANKING_DY5_URL+"]");
        String rDy5 = collector.doCollect(Collector.PLATE_MONEY_RANKING_DY5_URL);
        log.debug("解析结果：["+rDy5+"]");
        List<CollectPlateMoneyRanking> resultDy5List = dataResolver.resolverPlateMoneyRanking(rDy5,Dictionary.Dictionary_PlateBase.TYPE_DY,Dictionary.Dictionary_PlateBase.PERIOD_TYPE_5R,CollectPlateMoneyRanking.class);
        for(CollectPlateMoneyRanking collectPlateMoneyRanking:resultDy5List){
            collectPlateMoneyRankingMapper.insertSelective(collectPlateMoneyRanking);
            log.debug("采集板块：[名称："+collectPlateMoneyRanking.getName()+",代码:"+collectPlateMoneyRanking.getCode()+"]完成!");
        }
        log.debug("采集地域板块资金5日数据完成。");

        //采集地域板块10日资金
        log.debug("开始采集地域板块资金10日数据。");
        log.debug("采集URL：["+Collector.PLATE_MONEY_RANKING_DY10_URL+"]");
        String rDy10 = collector.doCollect(Collector.PLATE_MONEY_RANKING_DY10_URL);
        log.debug("解析结果：["+rDy10+"]");
        List<CollectPlateMoneyRanking> resultDy10List = dataResolver.resolverPlateMoneyRanking(rDy10,Dictionary.Dictionary_PlateBase.TYPE_DY,Dictionary.Dictionary_PlateBase.PERIOD_TYPE_10R,CollectPlateMoneyRanking.class);
        for(CollectPlateMoneyRanking collectPlateMoneyRanking:resultDy10List){
            collectPlateMoneyRankingMapper.insertSelective(collectPlateMoneyRanking);
            log.debug("采集板块：[名称："+collectPlateMoneyRanking.getName()+",代码:"+collectPlateMoneyRanking.getCode()+"]完成!");
        }
        log.debug("采集地域板块资金10日数据完成。");


        resultVo.setResult_msg("[板块资金排行数据]数据采集完成");
        log.info("板块资金排行数据采集任务完成。["+DateUtils.date2String(new Date(),DateUtils.DATE_PATTERN_1)+"]");
        return resultVo;
    }

    @Override
    @Transactional
    public ResultVo collectStockRankingData() {
        log.info("采集个股排行数据任务开始。["+DateUtils.date2String(new Date(),DateUtils.DATE_PATTERN_1)+"]");
        ResultVo resultVo = new ResultVo();
        //----采集当前个股涨跌数据----
        String r1 = collector.doCollect(Collector.CURRENT_STOCK_GAINS_INFO_URL);
        List<CollectStockRanking> resultList1 = dataResolver.resolverStockRanking(r1,CollectStockRanking.class);
        //验证数据是否已采集
        CollectStockRanking ranking = resultList1.get(0);
        //验证数据是否已存在
        if(valid_stockRanking(ranking.getCreateTime())){
            log.info("提示："+DateUtils.date2String(ranking.getCreateTime())+"数据已存在,终止采集任务！");
            resultVo.setResult_msg("提示："+DateUtils.date2String(ranking.getCreateTime())+"数据已存在,终止采集任务！");
            return resultVo;
        }
        //保存最新数据
        log.debug("保存最新数据开始");
        for(CollectStockRanking stockRanking : resultList1){
            collectStockRankingMapper.insertSelective(stockRanking);
        }
        log.debug("保存最新数据完成");
        log.info("采集个股排行数据任务完成。["+DateUtils.date2String(new Date(),DateUtils.DATE_PATTERN_1)+"]");
        return resultVo;
    }

    @Override
    @Transactional
    public ResultVo collectStockMoneyRankingData() {
        log.info("个股资金排行数据采集任务开始。["+DateUtils.date2String(new Date(),DateUtils.DATE_PATTERN_1)+"]");
        ResultVo resultVo = new ResultVo();

        //————————采集个股资金排行————————
        log.info("开始采集个股资金排行数据。["+DateUtils.date2String(new Date(),DateUtils.DATE_PATTERN_1)+"]");

        //采集个股板块1日资金
        log.debug("开始采集个股资金排行1日数据。");
        log.debug("采集URL：["+Collector.STOCK_MONEY_RANKING1_URL+"]");
        String r1 = collector.doCollect(Collector.STOCK_MONEY_RANKING1_URL);
        log.debug("解析结果：["+r1+"]");
        List<CollectStockMoneyRanking> result1List = dataResolver.resolverStockMoneyRanking(r1,Dictionary.Dictionary_StockBase.PERIOD_TYPE_1R,CollectStockMoneyRanking.class);
        //检验数据是否已经采集完成
        CollectStockMoneyRanking date1 = result1List.get(0);
        //验证数据是否已存在
        if(valid_stockMoneyRanking(date1.getCreateTime())){
            log.info("提示："+DateUtils.date2String(date1.getCreateTime())+"数据已存在,终止采集任务！");
            resultVo.setResult_msg("提示："+DateUtils.date2String(date1.getCreateTime())+"数据已存在,终止采集任务！");
            return resultVo;
        }
        for(CollectStockMoneyRanking collectStockMoneyRanking:result1List){
            collectStockMoneyRankingMapper.insertSelective(collectStockMoneyRanking);
            log.debug("采集板块：[名称："+collectStockMoneyRanking.getName()+",代码:"+collectStockMoneyRanking.getCode()+"]完成!");
        }
        log.debug("采集个股板块资金1日数据完成。");

        //采集行业板块3日资金
        log.debug("开始采集个股资金5日数据。");
        log.debug("采集URL：["+Collector.STOCK_MONEY_RANKING3_URL+"]");
        String r3 = collector.doCollect(Collector.STOCK_MONEY_RANKING3_URL);
        log.debug("解析结果：["+r3+"]");
        List<CollectStockMoneyRanking> result3List = dataResolver.resolverStockMoneyRanking(r3,Dictionary.Dictionary_StockBase.PERIOD_TYPE_3R,CollectStockMoneyRanking.class);
        for(CollectStockMoneyRanking collectStockMoneyRanking:result3List){
            collectStockMoneyRankingMapper.insertSelective(collectStockMoneyRanking);
            log.debug("采集板块：[名称："+collectStockMoneyRanking.getName()+",代码:"+collectStockMoneyRanking.getCode()+"]完成!");
        }
        log.debug("采集个股资金3日数据完成。");

        //采集行业板块5日资金
        log.debug("开始采集个股资金5日数据。");
        log.debug("采集URL：["+Collector.STOCK_MONEY_RANKING5_URL+"]");
        String r5 = collector.doCollect(Collector.STOCK_MONEY_RANKING5_URL);
        log.debug("解析结果：["+r5+"]");
        List<CollectStockMoneyRanking> result5List = dataResolver.resolverStockMoneyRanking(r5,Dictionary.Dictionary_StockBase.PERIOD_TYPE_5R,CollectStockMoneyRanking.class);
        for(CollectStockMoneyRanking collectStockMoneyRanking:result5List){
            collectStockMoneyRankingMapper.insertSelective(collectStockMoneyRanking);
            log.debug("采集板块：[名称："+collectStockMoneyRanking.getName()+",代码:"+collectStockMoneyRanking.getCode()+"]完成!");
        }
        log.debug("采集个股资金5日数据完成。");

        //采集行业板块10日资金
        log.debug("开始采集个股资金10日数据。");
        log.debug("采集URL：["+Collector.STOCK_MONEY_RANKING10_URL+"]");
        String r10 = collector.doCollect(Collector.STOCK_MONEY_RANKING10_URL);
        log.debug("解析结果：["+r10+"]");
        List<CollectStockMoneyRanking> result10List = dataResolver.resolverStockMoneyRanking(r10,Dictionary.Dictionary_StockBase.PERIOD_TYPE_10R,CollectStockMoneyRanking.class);
        for(CollectStockMoneyRanking collectStockMoneyRanking:result10List){
            collectStockMoneyRankingMapper.insertSelective(collectStockMoneyRanking);
            log.debug("采集板块：[名称："+collectStockMoneyRanking.getName()+",代码:"+collectStockMoneyRanking.getCode()+"]完成!");
        }
        log.debug("采集个股资金10日数据完成。");

        resultVo.setResult_msg("[个股资金排行数据]数据采集完成");
        log.info("个股资金排行数据采集任务完成。["+DateUtils.date2String(new Date(),DateUtils.DATE_PATTERN_1)+"]");
        return resultVo;
    }

}
