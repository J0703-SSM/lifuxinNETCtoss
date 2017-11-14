package com.lanou.controller;

import com.lanou.domain.Admin_info;
import com.lanou.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by dllo on 17/11/13.
 */
@Controller
public class AdminController {

    @Qualifier("adminService")
    @Autowired
    private AdminService adminService;

    @RequestMapping("/admin_list")
    public String admin_List(Model model){
        List<Admin_info> adminInfos = adminService.findAll();
        model.addAttribute("adminInfos",adminInfos);
        return "admin/admin_list";
    }




}
