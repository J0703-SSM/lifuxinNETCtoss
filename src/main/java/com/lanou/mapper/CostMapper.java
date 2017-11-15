package com.lanou.mapper;


import com.lanou.domain.Cost;

import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/11/11.
 */
public interface CostMapper {
    // 查询所有资费
    List<Cost> findAll(Map<String,Object> map);

    int findCount();

    // 通过id查询对象
    Cost findById(Integer cost_id);

    // 启用修改状态
    void updateQy(Cost cost);

    // 删除资费
    void deleteCost(Integer cost_id);

    //修改资费的详细信息
    void updateCost(Cost cost);

    // 添加资费
    void addCost(Cost cost);
}
