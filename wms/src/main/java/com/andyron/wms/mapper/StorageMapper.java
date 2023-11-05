package com.andyron.wms.mapper;

import com.andyron.wms.entity.Storage;
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
public interface StorageMapper extends BaseMapper<Storage> {

    IPage pageCC(Page<Storage> page, LambdaQueryWrapper<Storage> lambdaQueryWrapper);
}
