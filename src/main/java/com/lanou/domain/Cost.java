package com.lanou.domain;

import java.sql.Timestamp;


/**
 * Created by dllo on 17/11/11.
 */
public class Cost {
    private int cost_id; // 主键id
    private String name; // 资费名称
    private int base_duration;//基本时长
    private double base_cost; // 基本费用
    private double unit_cost; //单位费用
    private String status; // 状态
    private String descr; // 资费说明
    private Timestamp creaTime; // 创建时间
    private Timestamp starTime; // 开通时间
    private String cost_type;

    public Cost() {
    }

    public Cost(String name, int base_duration, double base_cost, double unit_cost, String status, String descr, Timestamp creaTime, Timestamp srarTime, String cost_type) {
        this.name = name;
        this.base_duration = base_duration;
        this.base_cost = base_cost;
        this.unit_cost = unit_cost;
        this.status = status;
        this.descr = descr;
        this.creaTime = creaTime;
        this.starTime = srarTime;
        this.cost_type = cost_type;
    }

    public Cost(int cost_id, String name, int base_duration, double base_cost, double unit_cost, String status, String descr, Timestamp creaTime, Timestamp srarTime, String cost_type) {
        this.cost_id = cost_id;
        this.name = name;
        this.base_duration = base_duration;
        this.base_cost = base_cost;
        this.unit_cost = unit_cost;
        this.status = status;
        this.descr = descr;
        this.creaTime = creaTime;
        this.starTime = srarTime;
        this.cost_type = cost_type;
    }

    @Override
    public String toString() {
        return "Cost{" +
                "cost_id=" + cost_id +
                ", name='" + name + '\'' +
                ", base_duration=" + base_duration +
                ", base_cost=" + base_cost +
                ", unit_cost=" + unit_cost +
                ", status='" + status + '\'' +
                ", descr='" + descr + '\'' +
                ", creaTime=" + creaTime +
                ", starTime=" + starTime +
                ", cost_type='" + cost_type + '\'' +
                '}';
    }

    public int getCost_id() {
        return cost_id;
    }

    public void setCost_id(int cost_id) {
        this.cost_id = cost_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBase_duration() {
        return base_duration;
    }

    public void setBase_duration(int base_duration) {
        this.base_duration = base_duration;
    }

    public double getBase_cost() {
        return base_cost;
    }

    public void setBase_cost(double base_cost) {
        this.base_cost = base_cost;
    }

    public double getUnit_cost() {
        return unit_cost;
    }

    public void setUnit_cost(double unit_cost) {
        this.unit_cost = unit_cost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public Timestamp getCreaTime() {
        return creaTime;
    }

    public void setCreaTime(Timestamp creaTime) {
        this.creaTime = creaTime;
    }

    public Timestamp getStarTime() {
        return starTime;
    }

    public void setStarTime(Timestamp starTime) {
        this.starTime = starTime;
    }

    public String getCost_type() {
        return cost_type;
    }

    public void setCost_type(String cost_type) {
        this.cost_type = cost_type;
    }


}
