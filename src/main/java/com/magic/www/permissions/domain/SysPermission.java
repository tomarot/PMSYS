package com.magic.www.permissions.domain;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 2019/12/16
 * Time: 15:19
 * To change this template use File | Settings | File Templates.
 *
 * 权限信息表
 */
public class SysPermission {
    private Long id;//编号
    private String permission;//权限标识符
    private String description;//描述
    private Integer available;//是否可用 1 可用 0 不可用

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }
}
