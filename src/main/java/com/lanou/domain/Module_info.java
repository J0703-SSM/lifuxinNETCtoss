package com.lanou.domain;

/**
 * Created by dllo on 17/11/14.
 */
public class Module_info {
    private int module_id;
    private String name;

    public Module_info() {
    }

    public Module_info(int module_id, String name) {
        this.module_id = module_id;
        this.name = name;
    }

    public Module_info(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Module_info{" +
                "module_id=" + module_id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getModule_id() {
        return module_id;
    }

    public void setModule_id(int module_id) {
        this.module_id = module_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
