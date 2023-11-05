package com.andyron.wms.service.impl;

import com.andyron.wms.entity.Storage;
import com.andyron.wms.mapper.StorageMapper;
import com.andyron.wms.service.StorageService;
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
public class StorageServiceImpl extends ServiceImpl<StorageMapper, Storage> implements StorageService {
    @Resource
    private StorageMapper storageMapper;

    @Override
    public IPage pageCC(Page<Storage> page, LambdaQueryWrapper<Storage> lambdaQueryWrapper) {
        return storageMapper.pageCC(page, lambdaQueryWrapper);
    }
}
