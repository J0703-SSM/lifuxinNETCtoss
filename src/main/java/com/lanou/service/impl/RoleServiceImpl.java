package com.lanou.service.impl;

import com.lanou.domain.Role_info;
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

    public Role_info findRoleById(Integer role_id) {
        return roleMapper.findRoleById(role_id);
    }
}
