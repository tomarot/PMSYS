package com.magic.www.permissions.controller;

import com.magic.www.permissions.base.ResultVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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


}
