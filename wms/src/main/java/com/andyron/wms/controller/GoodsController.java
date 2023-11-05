package com.andyron.wms.controller;


import com.andyron.wms.common.QueryPageParam;
import com.andyron.wms.common.Result;
import com.andyron.wms.entity.Goods;
import com.andyron.wms.entity.User;
import com.andyron.wms.service.GoodsService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author andyron
 * @since 2023-11-05
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {
    private GoodsService goodsService;
    public GoodsController(GoodsService goodsService) {
        this.goodsService = goodsService;
    }
    @GetMapping("/list")
    public List<Goods> list() {
        return goodsService.list();
    }
    @PostMapping("/save")
    public Result save(@RequestBody Goods goods) {
        return goodsService.save(goods) ? Result.suc() : Result.fail();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Goods goods) {
        return goodsService.updateById(goods) ? Result.suc() : Result.fail();
    }

    @GetMapping("/del")
    public Result del(@RequestParam String id) {
        return goodsService.removeById(id) ? Result.suc() : Result.fail();
    }

    @PostMapping("/listPage")
    public Result listPage(@RequestBody QueryPageParam query) {
        HashMap param = query.getParam();
        String name = (String) param.get("name");
        String goodstype = (String) param.get("goodstype");
        String storage = (String) param.get("storage");

        Page<Goods> page = new Page(query.getPageNum(), query.getPageSize());

        LambdaQueryWrapper<Goods> wrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(name) && !"null".equals(name)) {
            wrapper.like(Goods::getName, name);
        }
        if (StringUtils.isNotBlank(goodstype) && !"null".equals(goodstype)) {
            wrapper.eq(Goods::getGoodstype, goodstype);
        }
        if (StringUtils.isNotBlank(storage) && !"null".equals(storage)) {
            wrapper.eq(Goods::getStorage, storage);
        }
        IPage res = goodsService.pageCC(page, wrapper);
        return Result.suc(res.getRecords(), res.getTotal());
    }
}
