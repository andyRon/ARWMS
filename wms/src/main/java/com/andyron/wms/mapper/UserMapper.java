package com.andyron.wms.mapper;

import com.andyron.wms.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author andyron
 * @since 2023-10-30
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
