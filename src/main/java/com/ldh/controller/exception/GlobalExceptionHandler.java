package com.ldh.controller.exception;

import com.ldh.result.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartException;

/**
 * 全局异常处理
 * @Author: ldh
 */
@Component
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

  @ResponseBody
  @ExceptionHandler(value = Exception.class)
  public ResultVo defaultErrorHandler(Exception e) throws Exception {
    log.error("[系统异常]：——>{}", e);
    return ResultVo.fail("system error", HttpStatus.INTERNAL_SERVER_ERROR.value());
  }

  @ResponseBody
  @ExceptionHandler(MultipartException.class)
  public ResultVo multipartException() {
    return ResultVo.fail("mgt-600");
  }
}