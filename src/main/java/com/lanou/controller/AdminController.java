package com.lanou.controller;

import com.lanou.domain.Admin_info;
import com.lanou.domain.Admin_role;
import com.lanou.domain.Role_info;
import com.lanou.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by dllo on 17/11/13.
 */
@Controller
public class AdminController {

    @Qualifier("adminService")
    @Autowired
    private AdminService adminService;

    private List<Role_info> role_infos;

    // 跳转到admin_list主页
    @RequestMapping("/admin_list")
    public String admin_List(Model model){
        List<Admin_info> adminInfos = adminService.findAll();
        model.addAttribute("adminInfos",adminInfos);
        return "admin/admin_list";
    }

    // 跳转到add界面
    @RequestMapping(value = "/admin_add")
    public String admin_add(){
        return "admin/admin_add";
    }

    @RequestMapping(value = "/add_admin")
    public String add_admin(Admin_info admin_info, Role_info role_info,
                            Admin_role admin_role, String[] role_name){
        Date date = new Date();
        long time = date.getTime();
        Timestamp timestamp = new Timestamp(time);
        admin_info.setEnrolldate(timestamp);
        adminService.addAdmin(admin_info);
        for (int i = 0; i < role_name.length; i++) {
//            Role_info role_info1 = adminService.findByName(role_name);
//            admin_info.getRole_infos().add(role_info1);
            role_info.setRole_name(role_name[i]);
            adminService.addRole(role_info);
            admin_role.setAdmin_id(admin_info.getAdmin_id());
            admin_role.setRole_id(role_info.getRole_id());
            adminService.addAdmin_Role(admin_role);
        }
        return "redirect:admin_list";
    }

    // 跳转到detail页面
    @RequestMapping(value = "admin_modi")
    public String admin_modi(){
        return "admin/admin_modi";
    }







}
