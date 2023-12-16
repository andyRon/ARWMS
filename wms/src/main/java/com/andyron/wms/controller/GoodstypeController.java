package com.andyron.wms.controller;


import com.andyron.wms.common.QueryPageParam;
import com.andyron.wms.common.Result;
import com.andyron.wms.entity.Goodstype;
import com.andyron.wms.service.GoodstypeService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * @author andyron
 * @since 2023-11-05
 */
@Api(tags = {"货品类型管理"})
@RestController
@RequestMapping("/goodstype")
public class GoodstypeController {
    private GoodstypeService goodstypeService;
    public GoodstypeController(GoodstypeService goodstypeService) {
        this.goodstypeService = goodstypeService;
    }

    @PostMapping("/save")
    public Result save(@RequestBody Goodstype goodstype) {
        return goodstypeService.save(goodstype) ? Result.suc() : Result.fail();
    }
    @PostMapping("/update")
    public Result update(@RequestBody Goodstype goodstype) {
        return goodstypeService.updateById(goodstype) ? Result.suc() : Result.fail();
    }
    @GetMapping("/del")
    public Result del(@RequestParam String id) {
        return goodstypeService.removeById(id) ? Result.suc() : Result.fail();
    }

    @PostMapping("/listPage")
    public Result listPage(@RequestBody QueryPageParam query){
        HashMap param = query.getParam();
        String name = (String)param.get("name");

        Page<Goodstype> page = new Page();
        page.setCurrent(query.getPageNum());
        page.setSize(query.getPageSize());

        LambdaQueryWrapper<Goodstype> wrapper = new LambdaQueryWrapper();
        if(StringUtils.isNotBlank(name) && !"null".equals(name)){
            wrapper.like(Goodstype::getName, name);
        }
        // TODO
//        IPage result = goodstypeService.pageCC(page, wrapper);
        Page<Goodstype> result = goodstypeService.page(page, wrapper);
        return Result.suc(result.getRecords(), result.getTotal());
    }

    @GetMapping("/list")
    public Result list(){
        List list = goodstypeService.list();
        return Result.suc(list);
    }

}
