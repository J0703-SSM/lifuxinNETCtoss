package com.lanou.controller;

import com.lanou.domain.Admin_info;
import com.lanou.response.AjaxResult;
import com.lanou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    public String user_info() {
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
                                     HttpServletRequest request, HttpServletResponse response) {
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

}
