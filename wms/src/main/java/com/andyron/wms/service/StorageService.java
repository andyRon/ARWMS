package com.andyron.wms.service;

import com.andyron.wms.entity.Storage;
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
public interface StorageService extends IService<Storage> {

    IPage pageCC(Page<Storage> page, LambdaQueryWrapper<Storage> lambdaQueryWrapper);
}
