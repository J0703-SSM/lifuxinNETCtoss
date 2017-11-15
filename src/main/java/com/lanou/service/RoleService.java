package com.lanou.service;

import com.lanou.domain.Module_info;
import com.lanou.domain.Role_info;
import com.lanou.domain.Role_module;

import java.util.List;

/**
 * Created by dllo on 17/11/14.
 */
public interface RoleService {

    // 角色管理的查询所有
    List<Role_info> findRoleModule();

    // 查询所有权限
    List<Module_info> findAllModule();

    // 查询指定role_id
    List<Module_info> findRoleModuleByRoleId(Integer role_id);

    // 添加角色表
    void addRole(Role_info role_info);

    // 添加权限表
    void addModule(Module_info module_info);

    // 添加中间表
    void addRoleModule(Role_module role_module);

    // 通过name查询返回module_info的对象
    Module_info findModuleByName(String name);

    // 通过id查询对象
    Role_info findRoleById(Integer role_id);


}
