package com.lanou.controller;

import com.lanou.domain.Admin_info;
import com.lanou.response.AjaxResult;
import com.lanou.service.AdminService;
import com.lanou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * Created by dllo on 17/11/16.
 */
@Controller
public class UserController {

    @Qualifier("userService")
    @Autowired
    private UserService userService;


    @RequestMapping(value = "/index")
    public String index() {
        return "index";
    }

    // 跳转到user_info界面
    @RequestMapping(value = "/user_info")
    public String user_info(Model model,HttpServletRequest request) {
        Admin_info admin_info = (Admin_info) request.getServletContext().getAttribute("admin_info");
        List<Admin_info> ms = userService.findModuleInfo(admin_info.getAdmin_id());
        model.addAttribute("ms",ms);
        return "user/user_info";
    }

    // 跳转到user_modi_pwd界面
    @RequestMapping(value = "/user_modi_pwd")
    public String user_modi_pwd() {
        return "user/user_modi_pwd";
    }

    @RequestMapping("/quit")
    public String quit(HttpServletRequest request) {
        request.getServletContext().removeAttribute("admin_info");
        return "login";
    }

    // 修改密码
    @ResponseBody
    @RequestMapping(value = "/updatePassword", produces = "application/json;charset=UTF-8")
    public AjaxResult updatePassword(String rePwd, String newPwd, String oldPwd,
                                     HttpServletRequest request) {
        AjaxResult result = new AjaxResult();
        Admin_info admin_info = (Admin_info) request.getServletContext().getAttribute("admin_info");
        System.out.println(admin_info);
        admin_info.setPassword(newPwd);
        if (oldPwd != null && newPwd != null && rePwd != null) {
            int i = userService.updatePassword(admin_info);
            if (i == 1) {
                result.setErrorCode(0);
                result.setMessage("恭喜修改成功");
                return result;
            }
        }
        return result;
    }

    @RequestMapping("/updateAdminInfo")
    public void updateAdminInfo(Admin_info admin_info,HttpServletRequest request){
        Admin_info admin_info1 = (Admin_info) request.getServletContext().getAttribute("admin_info");
        admin_info1.setName(admin_info.getName());
        admin_info1.setTelephone(admin_info.getTelephone());
        admin_info1.setEmail(admin_info.getEmail());
        request.getServletContext().setAttribute("admin_info",admin_info);
        userService.updateAdminInfo(admin_info1);
    }


}
