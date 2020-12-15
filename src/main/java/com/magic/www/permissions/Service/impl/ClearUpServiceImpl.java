package com.magic.www.permissions.Service.impl;

import com.magic.www.permissions.Service.ClearUpService;
import com.magic.www.permissions.base.ResultVo;
import com.magic.www.permissions.collect.impl.CollectServiceImpl;
import com.magic.www.permissions.domain.Stock;
import com.magic.www.permissions.domain.StockContinuousHarden;
import com.magic.www.permissions.mapper.StockContinuousHardenMapper;
import com.magic.www.permissions.mapper.StockMapper;
import com.magic.www.permissions.utils.DateUtils;
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
 * Date: 2020/9/19
 * Time: 19:50
 * To change this template use File | Settings | File Templates.
 */
@Service
public class ClearUpServiceImpl implements ClearUpService {

    private static final Logger log = LoggerFactory.getLogger(ClearUpServiceImpl.class);

    @Autowired(required = false)
    private StockMapper stockMapper;
    @Autowired(required = false)
    private StockContinuousHardenMapper stockContinuousHardenMapper;

    @Override
    @Transactional
    public ResultVo clearUpStockHarderData(Date date) {
        log.info("整理连续涨停个股数据开始。["+DateUtils.date2String(date,DateUtils.DATE_PATTERN_1)+"]");
        ResultVo resultVo = new ResultVo();
        //验证数据是否已经采集
        log.debug("验证数据是否已经采集。["+DateUtils.date2String(date)+"]");
        StockContinuousHarden currentStockContinuousHarden = new StockContinuousHarden();
        currentStockContinuousHarden.setCreateTime(date);
        List<StockContinuousHarden> currentStockContinuousHardenList = stockContinuousHardenMapper.querySelective(currentStockContinuousHarden);
        if (currentStockContinuousHardenList.size() > 0){
            log.info("整理连续涨停个股数据开始。["+DateUtils.date2String(date,DateUtils.DATE_PATTERN_1)+"]");
            resultVo.setResult_msg("数据已经采集!["+DateUtils.date2String(date)+"]");
            return resultVo;
        }

        //获取前一日连续涨停数据
        List<Date> dateList = stockMapper.queryDateList();
        Date perDate = dateList.get(dateList.size()-2);
        log.debug("获取前一日连续涨停数据。["+DateUtils.date2String(perDate,DateUtils.DATE_PATTERN_1)+"]");
        StockContinuousHarden stockContinuousHarden = new StockContinuousHarden();
        stockContinuousHarden.setCreateTime(perDate);
        List<StockContinuousHarden> stockContinuousHardenList = stockContinuousHardenMapper.querySelective(stockContinuousHarden);
        //缓存前一日连续涨停数据
        log.debug("缓存前一日连续涨停数据。");
        Map stockContinuousHardenDataCache = new HashMap();
        for(StockContinuousHarden hardenData : stockContinuousHardenList){
            stockContinuousHardenDataCache.put(hardenData.getCode(),hardenData);
        }

        //获取个股数据涨停数据
        log.debug("获取个股数据涨停数据。["+DateUtils.date2String(date,DateUtils.DATE_PATTERN_1)+"]");
        Stock stock = new Stock();
        stock.setCreateTime(date);
        stock.setMinGains("9.8");
        stock.setSellPrice(" ----");
        List<Stock> stockList = stockMapper.querySelective(stock);
        for(Stock s : stockList){
            StockContinuousHarden newStockContinuousHarden = new StockContinuousHarden();
            newStockContinuousHarden.setCode(s.getCode());
            newStockContinuousHarden.setName(s.getName());
            StockContinuousHarden oldStockContinuousHarden = (StockContinuousHarden) stockContinuousHardenDataCache.get(s.getCode());
            //新涨停的股票
            if(oldStockContinuousHarden == null){
                newStockContinuousHarden.setContinuousHardenNum(1);
            }else{
                newStockContinuousHarden.setContinuousHardenNum(oldStockContinuousHarden.getContinuousHardenNum()+1);
            }
            newStockContinuousHarden.setCreateTime(DateUtils.getDayStartTime(date));
            log.debug("保存个股数据涨停数据。["+newStockContinuousHarden.toString()+"]");
            stockContinuousHardenMapper.insertSelective(newStockContinuousHarden);
        }
        log.info("整理连续涨停个股数据完成。["+DateUtils.date2String(new Date(),DateUtils.DATE_PATTERN_1)+"]");
        return resultVo;
    }
}
