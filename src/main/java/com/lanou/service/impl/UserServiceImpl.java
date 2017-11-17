package com.lanou.service.impl;

import com.lanou.domain.Admin_info;
import com.lanou.mapper.UserMapper;
import com.lanou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by dllo on 17/11/16.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Qualifier("userMapper")
    @Autowired
    private UserMapper userMapper;
    // 修改密码
    public int updatePassword(Admin_info admin_info) {
        return userMapper.updatePassword(admin_info);
    }
}
