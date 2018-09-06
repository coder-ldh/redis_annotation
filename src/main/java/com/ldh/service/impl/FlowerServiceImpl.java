package com.ldh.service.impl;

import com.ldh.entity.Flower;
import com.ldh.dao.FlowerMapper;
import com.ldh.service.FlowerService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ldh123
 * @since 2018-09-06
 */
@Service
public class FlowerServiceImpl extends ServiceImpl<FlowerMapper, Flower> implements FlowerService {

}
