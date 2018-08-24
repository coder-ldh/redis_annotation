package com.ldh.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: ldh
 */
@NoArgsConstructor
@Data
@AllArgsConstructor
public class User {

  private Long userId;

  private String name;

  private String password;


}