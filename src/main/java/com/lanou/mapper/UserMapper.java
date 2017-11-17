package com.lanou.mapper;

import com.lanou.domain.Admin_info;

/**
 * Created by dllo on 17/11/16.
 */
public interface UserMapper {

    // 修改密码
    int updatePassword(Admin_info admin_info);

}
