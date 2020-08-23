package com.magic.www.permissions.controller;

import com.magic.www.permissions.Service.PlateService;
import com.magic.www.permissions.base.ResultVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 2019/12/5
 * Time: 17:12
 * To change this template use File | Settings | File Templates.
 * 板块分析控制器
 */
@Controller
@RequestMapping("/plate")
public class PlateController {

    private static final Logger log = LoggerFactory.getLogger(PlateController.class);

    @Autowired
    private PlateService plateService;

    /**
     * 跳转板块关联关系页
     * @return
     */
    @RequestMapping("/toPlateRelationPage")
    public String toPlateRelationPage(){
        return "plate/plateRelationPage";
    }

    /**
     * 获取板块关联关系
     * @return
     */
    @RequestMapping("/getPlateRelationData")
    @ResponseBody
    public ResultVo getPlateRelationData(){
        ResultVo resultVo = plateService.getPlateRelationData();
        return resultVo;
    }

    /**
     * 跳转调整板块关联页
     * @return
     */
    @RequestMapping("/toUpdatePlateRelationPage")
    public String toUpdatePlateRelationPage(){
        return "plate/updatePlateRelationPage";
    }

    /**
     * 设置板块关联关系
     * @param hyCode
     * @param gnCode
     * @return
     */
    @RequestMapping("/setPlateRelation")
    @ResponseBody
    public ResultVo setPlateRelation(String hyCode,String gnCode){
        ResultVo resultVo = plateService.setPlateRelation(hyCode, gnCode);
        return resultVo;
    }

}
