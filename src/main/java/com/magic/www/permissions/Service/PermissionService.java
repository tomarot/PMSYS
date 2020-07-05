package com.magic.www.permissions.Service;

import com.magic.www.permissions.base.ResultVo;
import com.magic.www.permissions.domain.SysPermission;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Permission: T5S
 * Date: 2019/12/16
 * Time: 15:51
 * To change this template use File | Settings | File Templates.
 * 权限管理服务
 */
public interface PermissionService {
    /**
     * 新增权限
     * @param permission
     * @return
     * @throws Exception
     */
    public ResultVo addPermission(SysPermission permission) throws Exception;

    /**
     * 修改权限
     * @param permission
     * @return
     * @throws Exception
     */
    public ResultVo updatePermission(SysPermission permission) throws Exception;
    /**
     * 删除权限
     * @param permissionId
     * @return
     * @throws Exception
     */
   public ResultVo deletePermission(Long permissionId) throws Exception;

    /**
     * 获取权限
     * @param permissionId
     * @return
     * @throws Exception
     */
    public SysPermission getPermission(Long permissionId) throws Exception;

    /**
     * 获取权限集合
     * @param permission
     * @return
     * @throws Exception
     */
    public List<SysPermission> getPermissionList(SysPermission permission) throws Exception;
}
