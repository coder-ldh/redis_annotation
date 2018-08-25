package com.ldh.service.impl;

import com.ldh.entity.User;
import com.ldh.dao.UserMapper;
import com.ldh.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import java.io.Serializable;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

  public static final String USER = "USER";

  public static final String USER_ID_ = "USER_ID_";

  @Override
  public boolean insert(User user) {
    return super.insert(user);
  }

  @Override
  @CachePut (value = USER ,key = "#user.userId")
  public boolean updateById(User user) {
    return super.updateById(user);
  }

  @Override
  @Cacheable(value = USER ,key = "#root.targetClass+'.'+#root.methodName+'_'+#id")
  public User selectById(Serializable id) {
    return super.selectById(id);
  }

  @CacheEvict( key = "#id")
  @Override
  public boolean deleteById(Serializable id) {
    return super.deleteById(id);
  }
}
