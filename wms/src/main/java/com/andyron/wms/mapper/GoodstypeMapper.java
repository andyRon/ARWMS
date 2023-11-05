package com.andyron.wms.mapper;

import com.andyron.wms.entity.Goodstype;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author andyron
 * @since 2023-11-05
 */
@Mapper
public interface GoodstypeMapper extends BaseMapper<Goodstype> {

    IPage pageCC(Page<Goodstype> page, LambdaQueryWrapper<Goodstype> wrapper);
}
