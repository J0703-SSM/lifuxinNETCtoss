package com.lanou.domain;

/**
 * Created by dllo on 17/11/15.
 */
public class Role_module {
    private int role_id;
    private int module_id;

    public Role_module() {
    }

    public Role_module(int role_id, int module_id) {
        this.role_id = role_id;
        this.module_id = module_id;
    }

    public Role_module(int module_id) {
        this.module_id = module_id;
    }

    @Override
    public String toString() {
        return "Role_module{" +
                "role_id=" + role_id +
                ", module_id=" + module_id +
                '}';
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public int getModule_id() {
        return module_id;
    }

    public void setModule_id(int module_id) {
        this.module_id = module_id;
    }
}
