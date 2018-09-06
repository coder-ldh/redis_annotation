package com.ldh.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ldh.controller.base.AbstractController;
import com.ldh.entity.Flower;
import com.ldh.result.ResultVo;
import com.ldh.service.FlowerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ldh123
 * @since 2018-09-06
 */
@RestController
@RequestMapping("/flower")
@Api(value = "flower interface", description = "flower interface",tags={"flower interface"})
@Slf4j
public class FlowerController extends AbstractController {

  @Autowired
  FlowerService flowerService;

  /**
   * 新增一个
   * @param flower
   * @return
   */
  @PostMapping(value = "/create")
  @ApiOperation(value = "create a flower", notes = "create a flower interface")
  public ResultVo create(@RequestBody Flower flower){
    log.info("[FlowerController][create][flower]——>{}",flower);
    Long userId = flower.getUserId();
    String name = flower.getName();
    if (userId == null || StringUtils.isEmpty(name)){
      return ResultVo.fail("parameter is wrong");
    }
    flowerService.insert(flower);
    return ResultVo.success();
  }

  /**
   * 修改
   * @param flower
   * @return
   */
  @PostMapping(value = "/update")
  @ApiOperation(value = "update a flower", notes = "update a flower interface")
  public ResultVo update(@RequestBody Flower flower){
    log.info("[FlowerController][update][flower]——>{}",flower);
    Long userId = flower.getUserId();
    String name = flower.getName();
    Long flowerId = flower.getFlowerId();
    if (userId == null || StringUtils.isEmpty(name) || flowerId == null){
      return ResultVo.fail("parameter is wrong");
    }
    flowerService.updateById(flower);
    return ResultVo.success();
  }

  /**
   * 查询一个
   * @param flowerId
   * @return
   */
  @GetMapping(value = "/{flowerId}")
  @ApiOperation(value = "get a flower", notes = "get a flower interface")
  public ResultVo getOne(@PathVariable Long flowerId){
    log.info("[FlowerController][getOne][flowerId]——>{}",flowerId);
    if (flowerId == null){
      return ResultVo.fail("parameter is wrong");
    }
    Flower flower = flowerService.selectById(flowerId);
    return ResultVo.success("query success",flower);
  }

  /**
   * 查询用户的List
   * @param userId
   * @return
   */
  @GetMapping(value = "/list/{userId}")
  @ApiOperation(value = "get a flower", notes = "get a flower interface")
  public ResultVo getList(@PathVariable Long userId){
    log.info("[FlowerController][getList][userId]——>{}",userId);
    if (userId == null){
      return ResultVo.fail("parameter is wrong");
    }
    List<Flower> flowers = flowerService.selectList(new EntityWrapper<Flower>().eq("user_id",userId));
    return ResultVo.success("query success",flowers);
  }
}