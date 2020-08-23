package com.magic.www.permissions.Service.impl;

import com.magic.www.permissions.Service.StockService;
import com.magic.www.permissions.base.PageBase;
import com.magic.www.permissions.domain.Stock;
import com.magic.www.permissions.mapper.StockMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 2020/8/9
 * Time: 15:27
 * To change this template use File | Settings | File Templates.
 */
@Service
public class StockServiceImpl implements StockService {

    @Autowired(required = false)
    private StockMapper stockMapper;

    @Override
    public Date queryLatestDate() {
        Stock queryStock = new Stock();
        queryStock.setPageState(PageBase.PAGE_STATE_ENABLE);
        queryStock.setPageNum(1);
        queryStock.setPageSize(1);
        List<Stock> stockList = stockMapper.querySelective(queryStock);
        Stock stock = stockList.get(0);
        return stock.getCreateTime();
    }
}
