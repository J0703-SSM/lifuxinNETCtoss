package com.lanou.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 17/11/14.
 */
public class Admin_module {
    private int admin_id;
    private int module_id;
    private List<Module_info> module_infos = new ArrayList<Module_info>();

    public Admin_module() {
    }

    public Admin_module(int admin_id, int module_id) {
        this.admin_id = admin_id;
        this.module_id = module_id;
    }

    public Admin_module(int module_id) {
        this.module_id = module_id;
    }

    public List<Module_info> getModule_infos() {
        return module_infos;
    }

    public void setModule_infos(List<Module_info> module_infos) {
        this.module_infos = module_infos;
    }

    public int getModule_id() {
        return module_id;
    }

    public void setModule_id(int module_id) {
        this.module_id = module_id;
    }

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }
}
