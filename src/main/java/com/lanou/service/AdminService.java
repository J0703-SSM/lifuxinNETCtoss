package com.lanou.service;

import com.lanou.domain.Admin_info;
import com.lanou.domain.Admin_role;
import com.lanou.domain.Module_info;
import com.lanou.domain.Role_info;

import java.util.List;

/**
 * Created by dllo on 17/11/13.
 */
public interface AdminService {
    // 管理员查询所有
    List<Admin_info> findAll();

    // 通过名字查询role_info的对象
    Role_info findByName(String[] role_name);

    // 添加管理员账号
    void addAdmin(Admin_info admin_info);

    // 添加角色信息
    void addRole(Role_info role_info);

    // 添加中间表
    void addAdmin_Role(Admin_role admin_role);

    // 管理员登录
    Admin_info loginAdmin(Admin_info admin_info);

    // 根据姓名查询用户
    Admin_info findByName(String name);

    // 密码重置
    int rePassword(Admin_info admin_info);

    // 通过id查询管理员的id
    Admin_info findByAdminId(Integer admin_id);

    // 查询所有权限
    List<Module_info> findAllModule();



}
