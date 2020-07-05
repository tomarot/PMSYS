package com.magic.www.permissions.domain;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 2019/12/16
 * Time: 15:22
 * To change this template use File | Settings | File Templates.
 */
public class SysUserRoleRelation {
    private Long id;//编号
    private Long userId;//用户编号
    private Long roleId;//角色编号

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
