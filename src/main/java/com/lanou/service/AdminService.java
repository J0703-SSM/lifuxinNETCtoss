package com.lanou.service;

import com.lanou.domain.Admin_info;

import java.util.List;

/**
 * Created by dllo on 17/11/13.
 */
public interface AdminService {
    // 管理员查询所有
    List<Admin_info> findAll();
}
