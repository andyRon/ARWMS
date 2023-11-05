package com.andyron.wms.service.impl;

import com.andyron.wms.entity.Goodstype;
import com.andyron.wms.mapper.GoodstypeMapper;
import com.andyron.wms.service.GoodstypeService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class GoodstypeServiceImpl extends ServiceImpl<GoodstypeMapper, Goodstype> implements GoodstypeService {

    @Resource
    private GoodstypeMapper goodstypeMapper;

    @Override
    public IPage pageCC(Page<Goodstype> page, LambdaQueryWrapper<Goodstype> wrapper) {
        return goodstypeMapper.pageCC(page, wrapper);
    }
}
