package com.ldh.dao;

import com.ldh.entity.User;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ldh123
 * @since 2018-08-25
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}