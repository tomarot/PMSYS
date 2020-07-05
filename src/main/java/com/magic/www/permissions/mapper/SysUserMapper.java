package com.magic.www.permissions.mapper;

import com.magic.www.permissions.domain.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysUserMapper {
    /**
     * 删除用户
     * @param id
     * @return
     */
    int deleteByPrimaryKey(String id);

    /**
     * 新增用户
     * @param record
     * @return
     */
    int insert(SysUser record);

    /**
     * 新增用户
     * @param record
     * @return
     */
    int insertSelective(SysUser record);

    /**
     * 获取用户
     * @param id
     * @return
     */
    SysUser selectByPrimaryKey(String id);

    /**
     * 修改用户信息
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(SysUser record);

    /**
     * 修改用户信息
     * @param record
     * @return
     */
    int updateByPrimaryKey(SysUser record);

    /**
     * 获取用户
     * @param record
     * @return
     */
    List<SysUser> selectUser(SysUser record);
}