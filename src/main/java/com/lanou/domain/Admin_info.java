package com.lanou.domain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by dllo on 17/11/13.
 */
public class Admin_info {

    private int admin_id;// 主键id
    private String admin_code; // 管理员登录名
    private String password; // 登录密码
    private String name; // 管理员名称
    private String telephone; // 电话号码
    private String email;//邮箱
    private Timestamp enrolldate; // 授权日期
    private List<Role_info> role_infos = new ArrayList<Role_info>();

    public Admin_info() {
    }

    public Admin_info(String admin_code, String password, String name, String telephone, String email, Timestamp enrolldate) {
        this.admin_code = admin_code;
        this.password = password;
        this.name = name;
        this.telephone = telephone;
        this.email = email;
        this.enrolldate = enrolldate;
    }

    public Admin_info(int admin_id, String admin_code, String password, String name, String telephone, String email, Timestamp enrolldate) {
        this.admin_id = admin_id;
        this.admin_code = admin_code;
        this.password = password;
        this.name = name;
        this.telephone = telephone;
        this.email = email;
        this.enrolldate = enrolldate;
    }



    @Override
    public String toString() {
        return "Admin_info{" +
                "admin_id=" + admin_id +
                ", admin_code='" + admin_code + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", enrolldate=" + enrolldate +
                ", role_infos=" + role_infos +
                '}';
    }

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public String getAdmin_code() {
        return admin_code;
    }

    public void setAdmin_code(String admin_code) {
        this.admin_code = admin_code;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getEnrolldate() {
        return enrolldate;
    }

    public void setEnrolldate(Timestamp enrolldate) {
        this.enrolldate = enrolldate;
    }

    public List<Role_info> getRole_infos() {
        return role_infos;
    }

    public void setRole_infos(List<Role_info> role_infos) {
        this.role_infos = role_infos;
    }
}
