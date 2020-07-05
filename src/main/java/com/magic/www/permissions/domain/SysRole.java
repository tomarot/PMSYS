package com.magic.www.permissions.domain;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 2019/12/16
 * Time: 15:19
 * To change this template use File | Settings | File Templates.
 *
 * 角色信息表
 */
public class SysRole {
    private Long id;//编号
    private String role;//角色标识符
    private String description;//描述
    private Integer available;//是否可用 1 可用 0 不可用

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
