package com.andyron.wms.controller;


import com.andyron.wms.common.QueryPageParam;
import com.andyron.wms.common.Result;
import com.andyron.wms.entity.Goods;
import com.andyron.wms.entity.Record;
import com.andyron.wms.service.GoodsService;
import com.andyron.wms.service.RecordService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author andyron
 * @since 2023-11-05
 */
@Api(tags = {"操作记录管理"})
@RestController
@RequestMapping("/record")
public class RecordController {
    @Autowired
    private RecordService recordService;
    @Autowired
    private GoodsService goodsService;

    @PostMapping("/listPage")
    public Result listPage(@RequestBody QueryPageParam query) {
        HashMap param = query.getParam();
        String name = (String)param.get("name");
        String goodstype = (String)param.get("goodstype");
        String storage = (String)param.get("storage");
        String roleId = (String)param.get("roleId");
        String userId = (String)param.get("userId");

        Page<Record> page = new Page(query.getPageNum(), query.getPageSize());
        // TODO  Mybatis怎么联表查询
        QueryWrapper<Record> queryWrapper = new QueryWrapper();
        queryWrapper.apply(" a.goods=b.id and b.storage=c.id and b.goodsType=d.id ");

        if("2".equals(roleId)) {
            // queryWrapper.eq(Record::getUserid,userId);
            queryWrapper.apply(" a.userId= "+userId);
        }
        if(StringUtils.isNotBlank(name) && !"null".equals(name)) {
            queryWrapper.like("b.name", name);
        }
        if(StringUtils.isNotBlank(goodstype) && !"null".equals(goodstype)) {
            queryWrapper.eq("d.id", goodstype);
        }
        if(StringUtils.isNotBlank(storage) && !"null".equals(storage)) {
            queryWrapper.eq("c.id", storage);
        }

        IPage result = recordService.pageCC(page,queryWrapper);
        return Result.suc(result.getRecords(),result.getTotal());
    }

    @PostMapping("/save")
    public Result save(@RequestBody Record record){
        Goods goods = goodsService.getById(record.getGoods());
        int n = record.getCount();
        //出库
        if("2".equals(record.getAction())){
            n = -n;
            record.setCount(n);
        }

        int num = goods.getCount() + n;
        goods.setCount(num);
        goodsService.updateById(goods);

        return recordService.save(record) ? Result.suc() : Result.fail();
    }
}
