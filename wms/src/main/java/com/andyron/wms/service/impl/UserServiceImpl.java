package com.andyron.wms.service.impl;

import com.andyron.wms.entity.User;
import com.andyron.wms.mapper.UserMapper;
import com.andyron.wms.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author andyron
 * @since 2023-10-30
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
