package com.ldh.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ldh.controller.base.AbstractController;
import com.ldh.result.ResultVo;
import com.ldh.entity.User;
import com.ldh.service.UserService;
import com.ldh.transformer.UserVoToUser;
import com.ldh.vo.LoginVo;
import com.ldh.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
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

  @Autowired
  UserVoToUser userVoToUser;
  /**
   * 条件查询所有
   * @return
   */
  @PostMapping(value = "/list")
  @ApiOperation(value = "user list", notes = "user list interface")
  public ResultVo list(@RequestBody UserVo userVo,@RequestParam(value = "pages") Integer pages,
      @RequestParam(value = "size") Integer size){
    User user = userVoToUser.mapping(userVo);
    EntityWrapper<User> userEntityWrapper = new EntityWrapper<>(user);
    Page<User> page = userService.selectPage(new Page<>(size,pages),userEntityWrapper);
    return ResultVo.success("query success",page);
  }

  /**
   * 查询单个
   * @param userId
   * @return
   */
  @GetMapping(value = "/get/{userId}")
  @ApiOperation(value = "user ", notes = "a user  interface")
  public ResultVo getOne(@PathVariable Long userId){
    User user = userService.selectById(userId);
    return ResultVo.success("query success",user);
  }

  /**
   * 新增
   * @param user
   * @return
   */
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

  /**
   * 登录
   * @param loginVo
   * @return
   */
  @PostMapping(value = "/login")
  @ApiOperation(value = "login", notes = "login interface")
  public ResultVo login(@RequestBody LoginVo loginVo){
    if (loginVo == null){
      return ResultVo.fail("parameter is wrong");
    }
    String loginName = loginVo.getLoginName();
    String password = loginVo.getPassword();
    if (StringUtils.isEmpty(loginName) || StringUtils.isEmpty(password)){
      return ResultVo.fail("parameter is wrong");
    }
    User user = userService.selectOne(new EntityWrapper<User>().eq("name", loginName));
    if (user == null){
      return ResultVo.fail(loginName + " in existent");
    }
    String userPassword = user.getPassword();
    if (!userPassword.equalsIgnoreCase(password)){
      return ResultVo.fail("password is wrong");
    }
    return ResultVo.success("login success",user);
  }

  /**
   * 注册
   * @param loginName
   * @param password
   * @return
   */
  @PostMapping(value = "/register/{loginName}/{password}")
  @ApiOperation(value = "register", notes = "register interface")
  public ResultVo register(@PathVariable String loginName,@PathVariable String password){
    if (StringUtils.isEmpty(loginName) || StringUtils.isEmpty(password)){
      return ResultVo.fail("parameter is wrong");
    }
    User user = userService.selectOne(new EntityWrapper<User>().eq("name", loginName));
    if (user == null){
      User u = new User();
      u.setName(loginName);
      u.setPassword(password);
      u.setStatus(0);
      userService.insert(u);
      return ResultVo.success("register success",u);
    }
    return ResultVo.fail(loginName + " already exist");
  }
}