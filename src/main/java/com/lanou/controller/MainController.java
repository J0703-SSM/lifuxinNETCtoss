package com.lanou.controller;

import com.lanou.domain.Cost;
import com.lanou.response.AjaxLoginResult;
import com.lanou.service.CostService;
import com.lanou.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/11/11.
 */
@Controller
public class MainController {

    @Qualifier("costService")
    @Autowired
    private CostService costService;

    // 登录
    @RequestMapping(value = "/login")
    public String index() {
        return "index";
    }

    // 跳转到资费管理
    @RequestMapping(value = "/fee_list")
    public String fee_List(Model model, Integer pc, String str,
                           String sort, HttpServletRequest request,
                           HttpSession session) {
        if (pc == null){
            pc = 1;
        }
        int ps = 3;
        if (sort == ""){
            sort = null;
        }
        if (str == ""){
            str = null;
        }
        PageBean<Cost> pb = costService.findAll(pc,ps,str);
        model.addAttribute("pb",pb);
        request.setAttribute("sort",sort);
        session.setAttribute("str",str);
        System.out.println("cost:"+ pb.getBeanList());
        return "fee/fee_list";
    }


    // 点击修改时间并且添加时间
    @RequestMapping("/updateQy")
    @ResponseBody
    public String updateQy(
            @RequestParam("cost_id")
                    Integer id, Model model) {
        Cost cost = costService.findById(id);
        Date date = new Date();
        long time = date.getTime();
        Timestamp timestamp = new Timestamp(time);
        cost.setStarTime(timestamp);
        cost.setStatus("1");
        costService.updateQy(cost);
        return "redirect:fee_list";
    }

    // 删除资费
    @RequestMapping("/deleteCost")
    @ResponseBody
    public String deleteCost(
            @RequestParam("cost_id")
                    Integer cost_id, Model model) {
        costService.deleteCost(cost_id);
        return "redirect:fee_list";
    }

    // 跳转到修改的页面
    @RequestMapping("/fee_modi")
    public String fee_modi(Integer cost_id,Model model) {
        Cost cost = costService.findById(cost_id);
        model.addAttribute("cost", cost);
        return "fee/fee_modi";
    }

    //修改资费的详细内容
    @RequestMapping("/updateCost")
    public String updateCost(Cost cost){
        costService.updateCost(cost);
        return "redirect:fee_list";
    }

    // 跳转到添加资费的页面
    @RequestMapping("/addCost1")
    public String addCost1(){
        return "fee/fee_add";
    }
    // 添加资费
    @RequestMapping("/addCost")
    public String addCoat(Cost cost){
        cost.setStatus("0");
        cost.setCreaTime(new Timestamp(System.currentTimeMillis()));
        costService.addCost(cost);
        return "redirect:fee_list";
    }

    // 点击跳转到详细信息
    @RequestMapping("/fee_detail")
    public String fee_detail1(Integer cost_id,Model model){
        Cost cost = costService.findById(cost_id);
        model.addAttribute("cost",cost);
        return "fee/fee_detail";
    }

}
