package com.lanou.controller;

import com.lanou.domain.Role_info;
import com.lanou.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by dllo on 17/11/14.
 */
@Controller
public class RoleController {

    @Qualifier("roleService")
    @Autowired
    private RoleService roleService;
    @RequestMapping(value = "/role_add")
    public String role_add(){
        return "role/role_add";
    }

    @RequestMapping(value = "/role_list")
    public String role_list(Model model){
        List<Role_info> roleModule = roleService.findRoleModule();
        model.addAttribute("roleModule",roleModule);
        return "role/role_list";
    }

    @RequestMapping(value = "/role_modi")
    public String findRoleById(Integer role_id,Model model){
        Role_info roleInfo = roleService.findRoleById(role_id);
        model.addAttribute("roleInfo",roleInfo);
        return "role/role_modi";
    }

}
