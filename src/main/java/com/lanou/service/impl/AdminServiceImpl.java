package com.lanou.service.impl;

import com.lanou.domain.Admin_info;
import com.lanou.domain.Admin_role;
import com.lanou.domain.Module_info;
import com.lanou.domain.Role_info;
import com.lanou.mapper.AdminMapper;
import com.lanou.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dllo on 17/11/13.
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService{

    @Qualifier("adminMapper")
    @Autowired
    private AdminMapper adminMapper;
    // 管理员查询所有
    public List<Admin_info> findAll() {
        return adminMapper.findAll();
    }

    public Role_info findByName(String[] role_name) {
        return adminMapper.findByName(role_name);
    }

    // 添加管理员账号
    public void addAdmin(Admin_info admin_info) {
        adminMapper.addAdmin(admin_info);
    }
    // 添加角色信息
    public void addRole(Role_info role_info) {
        adminMapper.addRole(role_info);
    }

    // 添加中间表
    public void addAdmin_Role(Admin_role admin_role) {
        adminMapper.addAdmin_Role(admin_role);
    }

    // 管理员登录
    public Admin_info loginAdmin(Admin_info admin_info) {
       return adminMapper.loginAdmin(admin_info);
    }

    // 根据名字查询用户
    public Admin_info findByName(String name) {
        return adminMapper.findByName(name);
    }

    // 密码重置
    public int rePassword(Admin_info admin_info) {
      return   adminMapper.rePassword(admin_info);
    }

    // 通过id查询管理员的对象
    public Admin_info findByAdminId(Integer admin_id) {
        return adminMapper.findByAdminId(admin_id);
    }

    public List<Module_info> findAllModule() {
        return adminMapper.findAllModule();
    }

//    public List<Admin_info> findHigh(Integer module_id) {
//        return adminMapper.findHigh(module_id);
//    }


}
