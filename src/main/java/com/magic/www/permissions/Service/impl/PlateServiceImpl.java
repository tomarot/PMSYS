package com.magic.www.permissions.Service.impl;

import com.magic.www.permissions.Service.PlateService;
import com.magic.www.permissions.base.ResultVo;
import com.magic.www.permissions.collect.impl.CollectServiceImpl;
import com.magic.www.permissions.common.Dictionary;
import com.magic.www.permissions.domain.PlateBaseInfo;
import com.magic.www.permissions.domain.PlatePlateRelation;
import com.magic.www.permissions.domain.StockBaseInfo;
import com.magic.www.permissions.mapper.PlateBaseInfoMapper;
import com.magic.www.permissions.mapper.PlatePlateRelationMapper;
import com.magic.www.permissions.mapper.StockBaseInfoMapper;
import com.magic.www.permissions.mapper.StockPlateRelationMapper;
import com.magic.www.permissions.vo.StockPlateRelationVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 2020/8/19
 * Time: 13:56
 * To change this template use File | Settings | File Templates.
 */
@Service
public class PlateServiceImpl implements PlateService{

    private static final Logger log = LoggerFactory.getLogger(PlateServiceImpl.class);

    @Autowired(required = false)
    private PlatePlateRelationMapper platePlateRelationMapper;
    @Autowired(required = false)
    private PlateBaseInfoMapper plateBaseInfoMapper;
    @Autowired(required = false)
    private StockPlateRelationMapper stockPlateRelationMapper;
    @Autowired(required = false)
    private StockBaseInfoMapper stockBaseInfoMapper;

    @Override
    public List<PlateBaseInfo> querySelective(PlateBaseInfo queryPlate) {
        return plateBaseInfoMapper.querySelective(queryPlate);
    }

    @Override
    public ResultVo getPlateRelationData() {
        ResultVo resultVo = new ResultVo();
        Map<String,Object> rootMap = new HashMap<String,Object>();
        resultVo.setResultData(rootMap);
        //获取行业板块关联关系数据
        PlateBaseInfo hyPlateBaseInfo = new PlateBaseInfo();
        hyPlateBaseInfo.setType(Dictionary.Dictionary_PlateBase.TYPE_HY);
        hyPlateBaseInfo.setAvailable(Dictionary.Dictionary_PlateBase.AVAILABLE_Y);
        List<PlateBaseInfo> hyPlateBaseInfoList = querySelective(hyPlateBaseInfo);

        List<Map<String,Object>> hyPlateList = new ArrayList<Map<String,Object>>();
        rootMap.put("hyPlateList",hyPlateList);
        for(PlateBaseInfo hyPlate:hyPlateBaseInfoList){
            Map<String,Object> hyMap = new HashMap<String,Object>();
            hyMap.put("id",hyPlate.getId());
            hyMap.put("code",hyPlate.getCode());
            hyMap.put("name",hyPlate.getName());
            hyMap.put("type",hyPlate.getType());
            //获取行业板块的关联板块
            PlatePlateRelation platePlateRelation = new PlatePlateRelation();
            platePlateRelation.setmPlateCode(hyPlate.getCode());
            List<PlatePlateRelation> relationList = platePlateRelationMapper.querySelective(platePlateRelation);
            List<Map<String,Object>> relationPlateList = new ArrayList<Map<String,Object>>();
            hyMap.put("relationPlateList",relationPlateList);
            for(PlatePlateRelation list:relationList){
                Map<String,Object> relationGnMap = new HashMap<String,Object>();
                relationGnMap.put("relationCode",list.getvPlateCode());
                relationGnMap.put("relationId",list.getvPlateId());
                relationPlateList.add(relationGnMap);
            }
            hyPlateList.add(hyMap);
        }

        //获取概念板块数据
        PlateBaseInfo gnPlateBaseInfo = new PlateBaseInfo();
        gnPlateBaseInfo.setType(Dictionary.Dictionary_PlateBase.TYPE_GN);
        gnPlateBaseInfo.setAvailable(Dictionary.Dictionary_PlateBase.AVAILABLE_Y);
        List<PlateBaseInfo> gnPlateBaseInfoList = querySelective(gnPlateBaseInfo);

        List<Map<String,Object>> gnPlateList = new ArrayList<Map<String,Object>>();
        rootMap.put("gnPlateList",gnPlateList);
        for(PlateBaseInfo gnPlate:gnPlateBaseInfoList){
            Map<String,Object> gnMap = new HashMap<String,Object>();
            gnMap.put("id",gnPlate.getId());
            gnMap.put("code",gnPlate.getCode());
            gnMap.put("name",gnPlate.getName());
            gnMap.put("type",gnPlate.getType());
            //获取概念板块的关联板块
            PlatePlateRelation platePlateRelation = new PlatePlateRelation();
            platePlateRelation.setvPlateCode(gnPlate.getCode());
            List<PlatePlateRelation> relationList = platePlateRelationMapper.querySelective(platePlateRelation);
            List<Map<String,Object>> relationPlateList = new ArrayList<Map<String,Object>>();
            gnMap.put("relationPlateList",relationPlateList);
            for(PlatePlateRelation list:relationList){
                Map<String,Object> relationHyMap = new HashMap<String,Object>();
                relationHyMap.put("relationCode",list.getmPlateCode());
                relationHyMap.put("relationId",list.getvPlateId());
                relationPlateList.add(relationHyMap);
            }
            gnPlateList.add(gnMap);
        }
        return resultVo;
    }

    @Override
    @Transactional
    public ResultVo setPlateRelation(String hyCode, String gnCode) {
        ResultVo resultVo = new ResultVo();
        //清空原来的关联关系
        platePlateRelationMapper.deleteByHyCode(hyCode);
        //保存最新的关联关系
        String[] codes = gnCode.split(",");
        for(String code:codes){
            PlatePlateRelation platePlateRelation = new PlatePlateRelation();
            platePlateRelation.setmPlateCode(hyCode);
            platePlateRelation.setvPlateCode(code);
            platePlateRelation.setCreateTime(new Date());
            platePlateRelationMapper.insertSelective(platePlateRelation);
        }
        resultVo.setResult_msg("设置完成！");
        return resultVo;
    }

    @Override
    @Transactional
    public ResultVo CorrelationPlatePlateRelationData() {
        log.info("行业板块与概念板块创建关联关系服务开始......");
        ResultVo resultVo = new ResultVo();
        //清空板块与板块的关联关系
        platePlateRelationMapper.deleteAll();

        //缓存已创建的板块与板块的关联关系
        Map<String,Object> PlatePlateRelationCacheMap = new HashMap<String,Object>();

        //获取全部股票数据
        StockBaseInfo queryStockBaseInfo = new StockBaseInfo();
        List<StockBaseInfo> stockList = stockBaseInfoMapper.querySelective(queryStockBaseInfo);
        //遍历数据
        for(StockBaseInfo stock : stockList){
            //获取股票关联的行业板块
            StockPlateRelationVo queryStockPlateRelationHyVo = new StockPlateRelationVo();
            queryStockPlateRelationHyVo.setStockCode(stock.getCode());
            queryStockPlateRelationHyVo.setType(Dictionary.Dictionary_PlateBase.TYPE_HY);
            List<StockPlateRelationVo> stockPlateRelationHyVoList = stockPlateRelationMapper.queryStockPlateRelation(queryStockPlateRelationHyVo);

            //获取股票关联的概念板块
            StockPlateRelationVo queryStockPlateRelationGnVo = new StockPlateRelationVo();
            queryStockPlateRelationGnVo.setStockCode(stock.getCode());
            queryStockPlateRelationGnVo.setType(Dictionary.Dictionary_PlateBase.TYPE_GN);
            List<StockPlateRelationVo> stockPlateRelationGnVoList = stockPlateRelationMapper.queryStockPlateRelation(queryStockPlateRelationGnVo);

            //将板块与概念建立关联
            for(StockPlateRelationVo hy : stockPlateRelationHyVoList){
                for(StockPlateRelationVo gn: stockPlateRelationGnVoList){
                    //关联是否已经创建
                    PlatePlateRelation cachePlatePlateRelation = (PlatePlateRelation) PlatePlateRelationCacheMap.get(hy.getPlateCode()+"_"+gn.getPlateCode());
                    if(cachePlatePlateRelation != null){
                        log.info("行业板块[代码："+hy.getPlateCode()+",名称："+hy.getPlateName()+"]与概念板块[代码："+gn.getPlateCode()+",名称："+gn.getPlateName()+"]关联关系已存在！");
                        continue;
                    }
                    PlatePlateRelation platePlateRelation = new PlatePlateRelation();
                    platePlateRelation.setmPlateId(hy.getPlateId());
                    platePlateRelation.setmPlateCode(hy.getPlateCode());
                    platePlateRelation.setvPlateId(gn.getPlateId());
                    platePlateRelation.setvPlateCode(gn.getPlateCode());
                    platePlateRelation.setCreateTime(new Date());
                    platePlateRelationMapper.insertSelective(platePlateRelation);

                    log.debug("行业板块[代码："+hy.getPlateCode()+",名称："+hy.getPlateName()+"]与概念板块[代码："+gn.getPlateCode()+",名称："+gn.getPlateName()+"]关联关系创建完成。");

                    //将创建的关系同步到缓存
                    PlatePlateRelationCacheMap.put(hy.getPlateCode()+"_"+gn.getPlateCode(),platePlateRelation);
                }
            }
        }
        resultVo.setResult_msg("行业板块与概念板块关联服务完成！");
        log.info("行业板块与概念板块创建关联关系服务完成");
        return resultVo;
    }
}
