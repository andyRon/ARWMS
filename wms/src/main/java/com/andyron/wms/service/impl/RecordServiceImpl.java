package com.andyron.wms.service.impl;

import com.andyron.wms.entity.Record;
import com.andyron.wms.mapper.RecordMapper;
import com.andyron.wms.service.RecordService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
public class RecordServiceImpl extends ServiceImpl<RecordMapper, Record> implements RecordService {

    @Resource
    private RecordMapper recordMapper;

    @Override
    public IPage pageCC(Page<Record> page, Wrapper wrapper) {
        return recordMapper.pageCC(page, wrapper);
    }
}
