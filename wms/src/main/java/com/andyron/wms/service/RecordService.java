package com.andyron.wms.service;

import com.andyron.wms.entity.Record;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
public interface RecordService extends IService<Record> {

    IPage pageCC(Page<Record> page, Wrapper wrapper);
}
