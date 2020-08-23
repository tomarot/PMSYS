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
import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 2019/12/5
 * Time: 17:12
 * To change this template use File | Settings | File Templates.
 * 登录控制器
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    /**
     * 跳转登录页面
     * @return
     */
    @RequestMapping("/toLogin")
    public String toLoginPage(){
        return "login/login";
    }


    /**
     * 用户登录
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/doLogin")
    @ResponseBody
    public ResultVo doLoginPage(String username,String password,HttpServletRequest request, HttpServletResponse response){
        ResultVo resultVo = new ResultVo();
//        HttpSession session = request.getSession();
//        session.setAttribute("system.user.id","1");

        // 1、获取Subject实例对象
        Subject currentUser = SecurityUtils.getSubject();
        // 2、判断当前用户是否登录
        if (currentUser.isAuthenticated() == false) {

        }
        // 3、将用户名和密码封装到UsernamePasswordToken
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        // 4、认证
        try {
            currentUser.login(token);// 传到MyAuthorizingRealm类中的方法进行认证
            Session session = currentUser.getSession();
            session.setAttribute("username", username);
            return resultVo;
        }catch (UnknownAccountException e){
            log.info("UnknownAccountException -- > 账号不存在：",e);
            resultVo.setResult_code(ResultVo.CODE_FAILED);
            resultVo.setResult_msg("UnknownAccountException -- > 账号不存在：");
        }catch (IncorrectCredentialsException e){
            log.info("IncorrectCredentialsException -- > 密码不正确：",e);
            resultVo.setResult_code(ResultVo.CODE_FAILED);
            resultVo.setResult_msg("IncorrectCredentialsException -- > 密码不正确：");
        }catch (AuthenticationException e) {
            log.info("用户验证失败",e);
            resultVo.setResult_code(ResultVo.CODE_FAILED);
            resultVo.setResult_msg("用户验证失败");
        }
        return resultVo;
    }

}
