package com.lanou.mapper;

import com.lanou.domain.Admin_info;

import java.util.List;

/**
 * Created by dllo on 17/11/16.
 */
public interface UserMapper {

    // 修改密码
    int updatePassword(Admin_info admin_info);

    // 查询该管理员的权限
    List<Admin_info> findModuleInfo(Integer admin_id);

    // 修改个人信息
    void updateAdminInfo(Admin_info admin_info);

}
