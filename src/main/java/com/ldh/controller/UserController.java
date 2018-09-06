package com.ldh.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ldh.controller.base.AbstractController;
import com.ldh.result.ResultVo;
import com.ldh.entity.User;
import com.ldh.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
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
 * @author ldh
 * @since 2018-08-25
 */
@RestController
@RequestMapping("/user")
@Api(value = "user interface", description = "user interface",tags={"user interface"})
public class UserController extends AbstractController {

  @Autowired
  UserService userService;

  @GetMapping(value = "/list")
  @ApiOperation(value = "user list", notes = "user list interface")
  public ResultVo getList(){
    List<User> users = userService.selectList(new EntityWrapper<>());
    return ResultVo.success("query success",users);
  }

  @GetMapping(value = "/get/{userId}")
  @ApiOperation(value = "user ", notes = "a user  interface")
  public ResultVo getOne(@PathVariable Long userId){
    User user = userService.selectById(userId);
    return ResultVo.success("query success",user);
  }

  @PostMapping(value = "/create")
  @ApiOperation(value = "create a user", notes = "create a user interface")
  public ResultVo create(@RequestBody User user){
    if (user == null){
      return ResultVo.fail("parameter is wrong");
    }
    String name = user.getName();
    if (StringUtils.isEmpty(name)){
      return ResultVo.fail("parameter is wrong");
    }
    userService.insert(user);
    return ResultVo.success("create success");
  }
}