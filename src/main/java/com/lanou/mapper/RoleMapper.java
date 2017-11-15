package com.lanou.mapper;

import com.lanou.domain.Role_info;

import java.util.List;

/**
 * Created by dllo on 17/11/14.
 */
public interface RoleMapper {

    // 角色管理的查询所有
    List<Role_info> findRoleModule();
    // 通过id查询对象
    Role_info findRoleById(Integer role_id);
}
