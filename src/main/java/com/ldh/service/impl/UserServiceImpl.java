package com.ldh.service.impl;

import com.ldh.entity.User;
import com.ldh.dao.UserMapper;
import com.ldh.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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
@CacheConfig(cacheNames = "user")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

  @Autowired
  UserService userService;


  @Override
  public boolean insert(User user) {
    return super.insert(user);
  }

  @Override
  @CacheEvict( key = "#user.userId")
  public boolean updateById(User user) {
    return super.updateById(user);
  }

  @Override
  @Cacheable(key = "#id",value = "user")
  public User selectById(Serializable id) {
    return super.selectById(id);
  }

  @CacheEvict( key = "#id")
  @Override
  public boolean deleteById(Serializable id) {
    return super.deleteById(id);
  }
}
