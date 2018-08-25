package com.ldh.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: ldh
 */
@NoArgsConstructor
@Data
@AllArgsConstructor
@ApiModel(value="user entity",description="user")
public class User {
  @TableId("user_id")
  @ApiModelProperty(value="userId",name="userId",example="1")
  private Long userId;
  @ApiModelProperty(value="name",name="name",required=true,example="Tom")
  private String name;
  @ApiModelProperty(value="password",name="password",example="123456")
  private String password;
}