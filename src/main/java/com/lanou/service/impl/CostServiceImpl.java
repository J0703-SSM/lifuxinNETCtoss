package com.lanou.service.impl;

import com.lanou.domain.Cost;
import com.lanou.mapper.CostMapper;
import com.lanou.service.CostService;
import com.lanou.util.PageBean;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/11/11.
 */
@Service("costService")
public class CostServiceImpl implements CostService {

    @Qualifier("costMapper")
    @Autowired
    private CostMapper costMapper;
    // 查询所有资费
    public PageBean<Cost> findAll(int pc, int ps, String str) {
        PageBean<Cost> pb = new PageBean<Cost>();
        pb.setPc(pc);
        pb.setPs(ps);
        int count = costMapper.findCount();
        pb.setTr(count);
        Map<String,Object> map = new HashMap<String,Object>();

        map.put("start",(pc-1)*ps);
        map.put("pagesize",ps);
        map.put("orderByClause",str);
        List<Cost> costs = costMapper.findAll(map);
        pb.setBeanList(costs);
        return pb;
    }

    // 通过id查询COS对象
    public Cost findById(Integer cost_id) {
        return costMapper.findById(cost_id);
    }
    // 启用, 修改状态
    public void updateQy(Cost cost) {
        costMapper.updateQy(cost);
    }

    // 删除资费
    public void deleteCost(Integer cost_id) {
        costMapper.deleteCost(cost_id);
    }

    //修改资费的详细信息
    public void updateCost(Cost cost) {
        costMapper.updateCost(cost);
    }

    // 添加资费
    public void addCost(Cost cost) {
        costMapper.addCost(cost);
    }


}
