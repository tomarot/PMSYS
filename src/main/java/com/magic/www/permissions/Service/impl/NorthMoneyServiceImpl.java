package com.magic.www.permissions.Service.impl;

import com.magic.www.permissions.Service.NorthMoneyService;
import com.magic.www.permissions.base.PageBase;
import com.magic.www.permissions.domain.NorthMoneyMeta;
import com.magic.www.permissions.mapper.NorthMoneyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 2020/8/10
 * Time: 14:21
 * To change this template use File | Settings | File Templates.
 */
@Service
public class NorthMoneyServiceImpl implements NorthMoneyService {

    @Autowired(required = false)
    private NorthMoneyMapper northMoneyMapper;

    @Override
    public Date queryLatestDate(String dataType, String periodType) {
        NorthMoneyMeta queryNorthMoney =  new NorthMoneyMeta();
        if(dataType != null){
            queryNorthMoney.setType(dataType);
        }
        if(periodType != null){
            queryNorthMoney.setDateType(periodType);
        }
        queryNorthMoney.setPageState(PageBase.PAGE_STATE_ENABLE);
        queryNorthMoney.setPageNum(1);
        queryNorthMoney.setPageSize(1);
        List<NorthMoneyMeta> northMoneyMetaList = northMoneyMapper.querySelective(queryNorthMoney);
        NorthMoneyMeta stock = northMoneyMetaList.get(0);
        return stock.getHdDate();
    }
}
