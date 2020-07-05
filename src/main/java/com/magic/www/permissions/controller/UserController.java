package com.magic.www.permissions.controller;

import com.magic.www.permissions.Service.UserService;
import com.magic.www.permissions.base.ResultVo;
import com.magic.www.permissions.domain.SysUser;
import org.apache.shiro.web.session.HttpServletSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 2019/12/16
 * Time: 15:48
 * To change this template use File | Settings | File Templates.
 * 用户管理控制器
 */
@RequestMapping("user/")
@Controller
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /**
     * 跳转用户管理页面
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("toUserManagePage")
    public ModelAndView toUserManagePage(HttpServletRequest request, HttpServletResponse response){
        return new ModelAndView("user/userManage");
    }

    /**
     * 获取用户
     * 根据查询条件，查询出符合条件的用户
     * @param userCondition
     * @return
     */
    @GetMapping("queryUser")
    @ResponseBody
    public ResultVo queryUserList(SysUser userCondition){

        ResultVo resultVo = null;
        try{
            resultVo = userService.getUserList(userCondition);
        }catch (Exception e){
            log.error("错误：用户管理---->获取用户：异常",e);
        }
        return resultVo;
    }
}
