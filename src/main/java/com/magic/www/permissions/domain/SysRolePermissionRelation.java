package com.magic.www.permissions.domain;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 2019/12/16
 * Time: 15:23
 * To change this template use File | Settings | File Templates.
 */
public class SysRolePermissionRelation {
    private Long id;//编号
    private Long roleId;//角色编号
    private Long permissionId;//权限编号

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }
}
