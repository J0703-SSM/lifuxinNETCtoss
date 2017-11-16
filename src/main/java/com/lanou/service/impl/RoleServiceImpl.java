package com.lanou.service.impl;

import com.lanou.domain.Module_info;
import com.lanou.domain.Role_info;
import com.lanou.domain.Role_module;
import com.lanou.mapper.RoleMapper;
import com.lanou.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dllo on 17/11/14.
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Qualifier("roleMapper")
    @Autowired
    private RoleMapper roleMapper;
    public List<Role_info> findRoleModule() {
        return roleMapper.findRoleModule();
    }
    // 查询所有权限
    public List<Module_info> findAllModule() {
        return roleMapper.findAllModule();
    }

    public List<Module_info> findRoleModuleByRoleId(Integer role_id) {
        return roleMapper.findRoleModuleByRoleId(role_id);
    }

    // 添加角色表
    public void addRole(Role_info role_info) {
        roleMapper.addRole(role_info);
    }
    //添加权限表
    public void addModule(Module_info module_info) {
        roleMapper.addModule(module_info);
    }
    // 添加中间表
    public void addRoleModule(Role_module role_module) {
        roleMapper.addRoleModule(role_module);
    }
    // 通过name查询module_info返回一个对象
    public Module_info findModuleByName(String name) {
        return roleMapper.findModuleByName(name);
    }

    public Role_info findRoleById(Integer role_id) {
        return roleMapper.findRoleById(role_id);
    }

    // 通过role_id修改角色名称
    public void updateRole(Role_info role_info) {
        roleMapper.updateRole(role_info);
    }

    // 删除中间表的关联
    public void deleteRoleModule(Integer role_id) {
        roleMapper.deleteRoleModule(role_id);
    }
    public void deleteRoleInfo(Integer role_id) {
        roleMapper.deleteRoleInfo(role_id);
    }

    public Role_info findByName(String role_name) {
        return roleMapper.findByName(role_name);
    }

}
