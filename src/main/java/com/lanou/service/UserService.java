package com.lanou.service;

import com.lanou.domain.Admin_info;

/**
 * Created by dllo on 17/11/16.
 */
public interface UserService {

    // 修改密码
    int updatePassword(Admin_info admin_info);
}
