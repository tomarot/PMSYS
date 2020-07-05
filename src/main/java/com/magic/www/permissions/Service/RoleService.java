package com.magic.www.permissions.Service;

import com.magic.www.permissions.base.ResultVo;
import com.magic.www.permissions.domain.SysRole;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Role: T5S
 * Date: 2019/12/16
 * Time: 15:51
 * To change this template use File | Settings | File Templates.
 */
public interface RoleService {
    /**
     * 新增角色
     * @param role
     * @return
     * @throws Exception
     */
    public ResultVo addRole(SysRole role) throws Exception;

    /**
     * 修改角色
     * @param role
     * @return
     * @throws Exception
     */
    public ResultVo updateRole(SysRole role) throws Exception;
    /**
     * 删除角色
     * @param roleId
     * @return
     * @throws Exception
     */
    public ResultVo deleteRole(Long roleId) throws Exception;

    /**
     * 获取角色
     * @param roleId
     * @return
     * @throws Exception
     */
    public SysRole getRole(Long roleId) throws Exception;

    /**
     * 获取角色集合
     * @param role
     * @return
     * @throws Exception
     */
    public List<SysRole> getRoleList(SysRole role) throws Exception;
}
