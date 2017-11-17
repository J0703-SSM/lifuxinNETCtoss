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
    public String add_role(Model model, Role_info role_info, Role_module role_module,
                           Module_info module_info, String[] name) {
        Role_info info = roleService.findByName(role_info.getRole_name());
        if (info != null) {
            model.addAttribute("addRoleName_msg", "亲,用户名已经存在了,换一个吧!");
            return "role/role_add";
        } else {
            roleService.addRole(role_info);
        }
        if (name != null && name.length != 0) {
            for (int i = 0; i < name.length; i++) {
                Module_info moduleByName = roleService.findModuleByName(name[i]);
                if (moduleByName != null) {
                    role_module.setModule_id(moduleByName.getModule_id());
                    role_module.setRole_id(role_info.getRole_id());
                    roleService.addRoleModule(role_module);
                } else {
                    module_info.setName(name[i]);
                    roleService.addModule(module_info);
                    role_module.setRole_id(role_info.getRole_id());
                    role_module.setModule_id(module_info.getModule_id());
                    roleService.addRoleModule(role_module);
                }
            }
        } else {
            model.addAttribute("add_msg", "亲,你必须选一个权限");
            return "role/role_add";
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
        // 表单回显角色名称
        Role_info roleInfo = roleService.findRoleById(role_id);
        model.addAttribute("roleInfo", roleInfo);
        // 集合中含有当前角色中的所有权限集合
        List<Module_info> roleModuleByRoleId = roleService.findRoleModuleByRoleId(role_id);
        model.addAttribute("roleModuleByRoleId", roleModuleByRoleId);
        // 当前表中含有的所有权限的集合
        List<Module_info> allModule = roleService.findAllModule();
        model.addAttribute("allModule", allModule);
        return "role/role_modi";
    }

    // 修改权限的信息
    @RequestMapping(value = "/updateRoleInfoAndModuleInfo")
    public String updateRoleInfoAndModuleInfo(Model model, Role_info role_info, Role_module role_module, String[] name) {
        Role_info role_info1 = new Role_info();
        if (!role_info.getRole_name().equals("")) {
            role_info1.setRole_name(role_info.getRole_name());
            role_info1.setRole_id(role_info.getRole_id());
            roleService.updateRole(role_info1);
        } else {
            model.addAttribute("msg1", "角色信息不能为空!");
            return "forward:role_modi";
        }
        if (name != null && name.length != 0) {
            roleService.deleteRoleModule(role_info.getRole_id());
            for (int i = 0; i < name.length; i++) {
                Module_info moduleByName = roleService.findModuleByName(name[i]);
                role_module.setRole_id(role_info1.getRole_id());
                role_module.setModule_id(moduleByName.getModule_id());
                roleService.addRoleModule(role_module);
            }
        } else {
            model.addAttribute("msg", "对不起!你必须选一个权限");
            return "forward:role_modi";
        }
        return "redirect:role_list";
    }


    // 删除角色,以及中间表
    @RequestMapping("/deleteRoleInfo")
    public String deleteRoleInfo(Integer role_id) {
        roleService.deleteRoleModule(role_id);
        roleService.deleteRoleInfo(role_id);
        return "redirect:role_list";
    }


}
