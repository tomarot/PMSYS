package com.magic.www.permissions.Service;

import com.magic.www.permissions.base.ResultVo;
import com.magic.www.permissions.domain.SysUser;
import com.magic.www.permissions.exception.QueryCountErrorException;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 2019/12/16
 * Time: 15:50
 * To change this template use File | Settings | File Templates.
 * 用户服务
 */
public interface UserService {

    /**
     * 新增用户
     * @param user
     * @return
     * @throws Exception
     */
    public ResultVo addUser(SysUser user) throws Exception;

    /**
     * 修改用户
     * @param user
     * @return
     * @throws Exception
     */
    public ResultVo updateUser(SysUser user) throws Exception;
    /**
     * 删除用户
     * @param userId
     * @return
     * @throws Exception
     */
    public ResultVo deleteUser(Long userId) throws Exception;

    /**
     * 获取用户
     * @param userId
     * @return
     * @throws Exception
     */
    public ResultVo getUser(Long userId) throws Exception;

    /**
     * 获取用户集合
     * @param user
     * @return
     * @throws Exception
     */
    public ResultVo getUserList(SysUser user) throws Exception;

    /**
     * 获取用户
     * 根据用户名获取用户
     * @param name
     * @return
     * @throws Exception
     */
    public SysUser getUserByName(String name) throws QueryCountErrorException;
}
