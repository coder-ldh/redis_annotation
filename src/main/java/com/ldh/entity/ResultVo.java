package com.ldh.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: ldh
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultVo<T> {

  private String message;

  private Integer code;

  private T data;
}