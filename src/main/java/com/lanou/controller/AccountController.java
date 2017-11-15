package com.lanou.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by dllo on 17/11/14.
 */
@Controller
public class AccountController {

    @RequestMapping(value = "/account_list")
    public String account_list(){
        return "account/account_list";
    }

    @RequestMapping(value = "/account_add")
    public String account_add(){
        return "account/account_add";
    }

    @RequestMapping(value = "account_detail")
    public String account_detail(){
        return "account/account_detail";
    }

    @RequestMapping(value = "/account_modi")
    private String account_modi(){
        return "account/account_modi";
    }


}
