package com.lanou.service.impl;

import com.lanou.domain.Admin_info;
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
}
