package com.magic.www.permissions.Service.impl;

import com.magic.www.permissions.Service.PermissionService;
import com.magic.www.permissions.base.ResultVo;
import com.magic.www.permissions.domain.SysPermission;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 2019/12/16
 * Time: 15:53
 * To change this template use File | Settings | File Templates.
 */
@Service
public class PermissionServiceImpl implements PermissionService{
    @Override
    public ResultVo addPermission(SysPermission permission) throws Exception {
        return null;
    }

    @Override
    public ResultVo updatePermission(SysPermission permission) throws Exception {
        return null;
    }

    @Override
    public ResultVo deletePermission(Long permissionId) throws Exception {
        return null;
    }

    @Override
    public SysPermission getPermission(Long permissionId) throws Exception {
        return null;
    }

    @Override
    public List<SysPermission> getPermissionList(SysPermission permission) throws Exception {
        return null;
    }
}
