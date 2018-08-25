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

  public static final Integer SUCCESS = 200;
  public static final Integer FAIL = 201;

  private String message;

  private Integer code;

  private T data;

  public static  ResultVo success(){
    ResultVo<Object> resultVo = new ResultVo<>();
    resultVo.setCode(SUCCESS);
    resultVo.setMessage("operate success");
    return resultVo;
  }

  public static  ResultVo success(String message){
    ResultVo<Object> resultVo = new ResultVo<>();
    resultVo.setCode(SUCCESS);
    resultVo.setMessage(message);
    return resultVo;
  }

  public static  ResultVo success(String message,Object data){
    ResultVo<Object> resultVo = new ResultVo<>();
    resultVo.setCode(SUCCESS);
    resultVo.setData(data);
    return resultVo;
  }

  public static ResultVo fail(){
    ResultVo<Object> resultVo = new ResultVo<>();
    resultVo.setCode(FAIL);
    resultVo.setMessage("operate fail");
    return resultVo;
  }

  public static ResultVo fail(String message){
    ResultVo<Object> resultVo = new ResultVo<>();
    resultVo.setCode(FAIL);
    resultVo.setMessage(message);
    return resultVo;
  }

  public static ResultVo fail(String message,Integer code){
    ResultVo<Object> resultVo = new ResultVo<>();
    resultVo.setCode(code);
    resultVo.setMessage(message);
    return resultVo;
  }
}