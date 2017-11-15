package com.lanou.test;


import com.lanou.controller.MainController;
import com.lanou.domain.Admin_info;
import com.lanou.domain.Cost;
import com.lanou.domain.Module_info;
import com.lanou.domain.Role_info;
import com.lanou.mapper.AdminMapper;
import com.lanou.mapper.CostMapper;
import com.lanou.mapper.RoleMapper;
import com.lanou.service.CostService;
import com.lanou.service.RoleService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ui.Model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by dllo on 17/11/11.
 */
public class CostTest {

    private ApplicationContext context;
    private CostMapper costMapper;
    private AdminMapper adminMapper;
    private RoleMapper roleMapper;


    @Before
    public void init(){
        context = new ClassPathXmlApplicationContext("spring-config.xml");
        costMapper = (CostMapper) context.getBean("costMapper");
        adminMapper = (AdminMapper) context.getBean("adminMapper");
        roleMapper = (RoleMapper) context.getBean("roleMapper");

    }

    @Test
    public void testCost(){
//        List<Cost> all = costMapper.findAll();
//        for (Cost cost : all) {
//            System.out.println(cost);
//        }
    }
    @Test
    public void testService(){
        CostService costService = (CostService) context.getBean("costService");
//        Cost cost = costService.findById(1);
//        Date date = new Date();
//        long time = date.getTime();
//        Timestamp timestamp = new Timestamp(time);
//        cost.setStarTime(timestamp);
//        cost.setStatus("1");
//        costService.updateQy(cost);
//        System.out.println(cost);
//        cost.setCost_id(6);
        costService.deleteCost(6);
    }
    @Test
    public void testController(){
        MainController mainController = (MainController) context.getBean("mainController");
//        mainController.deleteCost(6);
//        String s = mainController.fee_modi(1);
//        System.out.println(s);

    }
    // 修改资费的详细信息
    @Test
    public void updateCost(){
        CostService costService = (CostService) context.getBean("costService");
        Cost cost = costService.findById(6);
        cost.setBase_duration(2);
        costService.updateCost(cost);
    }
    @Test
    public void testsss(){
        List<Admin_info> all = adminMapper.findAll();
        for (Admin_info info : all) {
            System.out.println(info);
            for (Role_info role_info : info.getRole_infos()) {
                System.out.println(role_info.getRole_name());
            }
        }
    }

    @Test
    public void test111(){
        Role_info roleById = roleMapper.findRoleById(100);
        System.out.println(roleById);
    }

    @Test
    public void rest21(){
        RoleService roleService = (RoleService) context.getBean("roleService");
        List<Module_info> roleModuleByRoleId = roleService.findRoleModuleByRoleId(611);
        for (Module_info module_info : roleModuleByRoleId) {
            System.out.println(module_info);
        }
    }


}
