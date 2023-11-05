package com.andyron.wms.service;

import com.andyron.wms.entity.Goodstype;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author andyron
 * @since 2023-11-05
 */
public interface GoodstypeService extends IService<Goodstype> {

    IPage pageCC(Page<Goodstype> page, LambdaQueryWrapper<Goodstype> wrapper);
}
