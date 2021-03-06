package com.lanou.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 17/11/13.
 */
public class Role_info {

    private int role_id;//主键role_id
    private String role_name; // 角色名称

    private List<Module_info> module_infos = new ArrayList<Module_info>();

    public Role_info() {
    }

    public Role_info(String role_name) {
        this.role_name = role_name;
    }

    public Role_info(int role_id, String role_name) {
        this.role_id = role_id;
        this.role_name = role_name;
    }

    @Override
    public String toString() {
        return "Role_info{" +
                "role_id=" + role_id +
                ", role_name='" + role_name + '\'' +
                '}';
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public List<Module_info> getModule_infos() {
        return module_infos;
    }

    public void setModule_infos(List<Module_info> module_infos) {
        this.module_infos = module_infos;
    }
}
