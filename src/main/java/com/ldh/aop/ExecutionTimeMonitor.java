package com.ldh.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Author: ldh
 * 监控每个请求执行时间
 */
@Aspect
@Component
@Slf4j
public class ExecutionTimeMonitor {


  @Pointcut("execution(* com.ldh.controller.*.*(..))")
  private void pointCutMethod() {
  }

  /**
   * 环绕通知
   * @param pjp
   * @return
   * @throws Throwable
   */
  @Around("pointCutMethod()")
  public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
    long begin = System.nanoTime();
    Object o = pjp.proceed();
    long end = System.nanoTime();
    Object[] args = pjp.getArgs();
    log.info("{}: [执行时间]——>{}","["+pjp.getTarget().getClass()+"]  ["+pjp.getSignature().getName()+"]",(end-begin)/1000000);
    return o;
  }
}