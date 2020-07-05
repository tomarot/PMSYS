package com.magic.www.permissions.Service.impl;

import com.magic.www.permissions.Service.RoleService;
import com.magic.www.permissions.base.ResultVo;
import com.magic.www.permissions.domain.SysRole;
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
public class RoleServiceImpl implements RoleService {

    @Override
    public ResultVo addRole(SysRole role) throws Exception {
        return null;
    }

    @Override
    public ResultVo updateRole(SysRole role) throws Exception {
        return null;
    }

    @Override
    public ResultVo deleteRole(Long roleId) throws Exception {
        return null;
    }

    @Override
    public SysRole getRole(Long roleId) throws Exception {
        return null;
    }

    @Override
    public List<SysRole> getRoleList(SysRole role) throws Exception {
        return null;
    }
}
