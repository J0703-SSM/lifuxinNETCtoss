package com.lanou.service;

import com.lanou.domain.Cost;

import java.util.List;

/**
 * Created by dllo on 17/11/11.
 */
public interface CostService {

    // 显示资费列表
    List<Cost> findAll();

    // 通过id查询对象
    Cost findById(Integer cost_id);

    // 修改资费状态,添加事件
    void updateQy(Cost cost);

    // 删除资费
    void deleteCost(Integer cost_id);

    //修改资费的详细信息
    void updateCost(Cost cost);
    // 添加资费
    void addCost(Cost cost);

}
