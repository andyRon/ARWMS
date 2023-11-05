package com.andyron.wms.service.impl;

import com.andyron.wms.entity.Goods;
import com.andyron.wms.mapper.GoodsMapper;
import com.andyron.wms.service.GoodsService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author andyron
 * @since 2023-11-05
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {

    @Resource
    private GoodsMapper goodsMapper;

    @Override
    public IPage pageCC(Page<Goods> page, LambdaQueryWrapper<Goods> wrapper) {
        return goodsMapper.pageCC(page, wrapper);
    }
}
