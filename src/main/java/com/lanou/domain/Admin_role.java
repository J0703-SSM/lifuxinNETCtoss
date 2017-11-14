package com.lanou.domain;

/**
 * Created by dllo on 17/11/13.
 */
public class Admin_role {

    private int admin_id;
    private int role_id;


    public Admin_role() {
    }

    public Admin_role(int admin_id, int role_id) {
        this.admin_id = admin_id;
        this.role_id = role_id;
    }

    public Admin_role(int role_id) {
        this.role_id = role_id;
    }

    @Override
    public String toString() {
        return "Admin_role{" +
                "admin_id=" + admin_id +
                ", role_id=" + role_id +
                '}';
    }

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {

        this.role_id = role_id;
    }
}
