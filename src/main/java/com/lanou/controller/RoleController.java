package com.lanou.controller;

import com.lanou.domain.Module_info;
import com.lanou.domain.Role_info;
import com.lanou.domain.Role_module;
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

    // 跳转到添加页面
    @RequestMapping(value = "/role_add")
    public String role_add(Model model) {
//        List<Module_info> moduleInfos = roleService.findAllModule();
//        model.addAttribute("moduleInfos", moduleInfos);
        return "role/role_add";
    }

    // 添加角色,权限,中间表
    @RequestMapping(value = "/add_role")
    public String add_role(Role_info role_info, Role_module role_module,
                           Module_info module_info, String[] name) {
        roleService.addRole(role_info);
        for (int i = 0; i < name.length; i++) {
            Module_info moduleByName = roleService.findModuleByName(name[i]);
            if (moduleByName != null){
                role_module.setModule_id(moduleByName.getModule_id());
                role_module.setRole_id(role_info.getRole_id());
                roleService.addRoleModule(role_module);
            }else {
                module_info.setName(name[i]);
                roleService.addModule(module_info);
                role_module.setRole_id(role_info.getRole_id());
                role_module.setModule_id(module_info.getModule_id());
                roleService.addRoleModule(role_module);
            }
        }
        return "redirect:role_list";
    }
    // 首页显示所有人的业务
    @RequestMapping(value = "/role_list")
    public String role_list(Model model) {
        List<Role_info> roleModule = roleService.findRoleModule();
        model.addAttribute("roleModule", roleModule);
        return "role/role_list";
    }

    // 跳转到修改的页面
    @RequestMapping(value = "/role_modi")
    public String findRoleById(Integer role_id, Model model) {
        Role_info roleInfo = roleService.findRoleById(role_id);
        model.addAttribute("roleInfo", roleInfo);
        List<Module_info> roleModuleByRoleId = roleService.findRoleModuleByRoleId(role_id);
        model.addAttribute("roleModuleByRoleId",roleModuleByRoleId);
        return "role/role_modi";
    }

}
