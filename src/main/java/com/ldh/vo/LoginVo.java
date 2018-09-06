package com.ldh.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: ldh
 */
@NoArgsConstructor
@Data
@AllArgsConstructor
public class LoginVo {

  private String loginName;

  private String password;
}
