package com.magic.www.permissions.Service.impl;

import com.magic.www.permissions.Service.UserService;
import com.magic.www.permissions.base.ResultVo;
import com.magic.www.permissions.domain.SysUser;
import com.magic.www.permissions.exception.QueryCountErrorException;
import com.magic.www.permissions.mapper.SysUserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 2019/12/16
 * Time: 15:52
 * To change this template use File | Settings | File Templates.
 */
@Service
public class UserServiceImpl implements UserService{

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired(required = false)
    private SysUserMapper userMapper;
    @Override
    public ResultVo addUser(SysUser user) throws Exception {
        return null;
    }

    @Override
    public ResultVo updateUser(SysUser user) throws Exception {
        return null;
    }

    @Override
    public ResultVo deleteUser(Long userId) throws Exception {
        return null;
    }

    @Override
    public ResultVo getUser(Long userId) throws Exception {
        return null;
    }

    @Override
    public ResultVo getUserList(SysUser user) throws Exception {
        ResultVo resultVo = new ResultVo();
        List<SysUser> userList = userMapper.selectUser(user);
        resultVo.setResultList(userList);
        return resultVo;
    }

    @Override
    public SysUser getUserByName(String name) throws QueryCountErrorException{
        SysUser user = new SysUser();
        user.setUserName(name);
        List<SysUser> userList = userMapper.selectUser(user);
        if(userList.size() == 0){
            return null;
        }
        if(userList.size() > 1){
            throw new QueryCountErrorException("[name:"+name+"]查询出两条及以上结果");
        }
        return userList.get(0);
    }
}
