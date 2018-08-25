package com.ldh.service.impl;

import com.ldh.entity.User;
import com.ldh.dao.UserMapper;
import com.ldh.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ldh123
 * @since 2018-08-25
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
