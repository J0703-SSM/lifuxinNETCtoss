package com.lanou.controller;

import com.lanou.domain.Admin_info;
import com.lanou.domain.Admin_role;
import com.lanou.domain.Module_info;
import com.lanou.domain.Role_info;
import com.lanou.response.AjaxResult;
import com.lanou.service.AdminService;
import com.lanou.util.VerifyCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
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
    // 验证码内容
    private String verifyCodeText;

//    private List<Role_info> role_infos;

    // 登录
    @RequestMapping(value = "/login")
    public String login(Model model, Admin_info admin_info,
                        String admin_code, String verifyCodeInput,
                        HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        Admin_info admin_info1 = adminService.loginAdmin(admin_info);
        request.getServletContext().setAttribute("admin_info", admin_info1);
        Admin_info byName = adminService.findByName(admin_code);
        if (byName != null) {
            if (admin_info1 != null) {
                if (!verifyCodeInput.trim().toLowerCase().equals(verifyCodeText) || verifyCodeInput.trim().equals("")) {
                    model.addAttribute("codemsg", "验证码错误");
                    return "login";
                }
                return "index";
            } else {
                model.addAttribute("psw_msg", "密码有误,请重新输入");
            }
        } else {
            model.addAttribute("log_msg", "该管理员不存在");
            return "login";
        }
        return "login";
    }

    // 获取验证码图片
    @RequestMapping(value = "/getVerifyCode")
    public void getVerifyCode(HttpServletRequest request,
                              HttpServletResponse response) throws IOException {
        VerifyCode verifyCode = new VerifyCode();
        BufferedImage image = verifyCode.getImage();
        verifyCodeText = verifyCode.getText().toLowerCase();
        verifyCode.output(image, response.getOutputStream());

    }

    // 跳转到detail页面
    @RequestMapping(value = "admin_modi")
    public String admin_modi() {
        return "admin/admin_modi";
    }

    // 跳转到admin_list主页
    @RequestMapping("/admin_list")
    public String admin_List(Model model, HttpServletRequest request) {
        List<Admin_info> adminInfos = adminService.findAll();
        model.addAttribute("adminInfos", adminInfos);
        request.getServletContext().setAttribute("adminInfos", adminInfos);
        List<Module_info> allModule = adminService.findAllModule();
        model.addAttribute("allModule", allModule);
        return "admin/admin_list";
    }

    // 跳转到add界面
    @RequestMapping(value = "/admin_add")
    public String admin_add() {
        return "admin/admin_add";
    }

    @RequestMapping(value = "/add_admin")
    public String add_admin(Model model,Admin_info admin_info, Role_info role_info,
                            Admin_role admin_role, String[] role_name) {
        if (admin_info != null && role_info != null && admin_role != null) {
            Date date = new Date();
            long time = date.getTime();
            Timestamp timestamp = new Timestamp(time);
            admin_info.setEnrolldate(timestamp);
            adminService.addAdmin(admin_info);
            if (role_name != null && role_name.length > 0) {
                for (int i = 0; i < role_name.length; i++) {
                    role_info.setRole_name(role_name[i]);
                    adminService.addRole(role_info);
                    admin_role.setAdmin_id(admin_info.getAdmin_id());
                    admin_role.setRole_id(role_info.getRole_id());
                    adminService.addAdmin_Role(admin_role);
                }
                return "redirect:admin_list";
            }
        }
        model.addAttribute("add_msg","请将信息填写完整");
        return "admin/admin_add";

    }

    // 密码重置
    @ResponseBody
    @RequestMapping("/admin_resetPwd")
    public AjaxResult resetPwd(String cbValue) {
        AjaxResult ajaxResult = new AjaxResult();
        System.out.println(cbValue);
        String[] admin_ids = cbValue.split(",");
        Admin_info admin = new Admin_info();
        admin.setPassword("1234");
        for (String admin_id : admin_ids) {
            admin.setAdmin_id(Integer.parseInt(admin_id));
            int count = adminService.rePassword(admin);
            if (count > 0) {
                ajaxResult.setErrorCode(0);
                ajaxResult.setMessage("密码重置成功");
            } else {
                ajaxResult.setErrorCode(404);
                ajaxResult.setMessage("密码重置失败");
            }
        }
        return ajaxResult;
    }

//    @RequestMapping(value = "/findHigh")
//    public String findHigh(Model model,Integer module_id){
//        List<Admin_info> adminInfos = adminService.findHigh(module_id);
//        model.addAttribute("adminInfos",adminInfos);
//        return "admin/admin_list";
//    }

}
