package com.andyron.wms.mapper;

import com.andyron.wms.entity.Record;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
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
public interface RecordMapper extends BaseMapper<Record> {

    IPage pageCC(Page<Record> page, Wrapper wrapper);
}
