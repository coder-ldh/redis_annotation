package com.ldh.service.impl;

import com.ldh.entity.UserLike;
import com.ldh.dao.UserLikeMapper;
import com.ldh.service.UserLikeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户点赞表 服务实现类
 * </p>
 *
 * @author ldh123
 * @since 2018-09-06
 */
@Service
public class UserLikeServiceImpl extends ServiceImpl<UserLikeMapper, UserLike> implements UserLikeService {

}
