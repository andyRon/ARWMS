package com.andyron.wms.service;

import com.andyron.wms.entity.Goods;
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
public interface GoodsService extends IService<Goods> {

    IPage pageCC(Page<Goods> page, LambdaQueryWrapper<Goods> wrapper);
}
