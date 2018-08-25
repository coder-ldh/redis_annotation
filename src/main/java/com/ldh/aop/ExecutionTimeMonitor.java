package com.ldh.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Author: ldh
 * 监控每个请求执行时间
 */
@Aspect
@Component
public class ExecutionTimeMonitor {

  private static final Logger logger = LoggerFactory.getLogger(ExecutionTimeMonitor.class);

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
    logger.info("[执行方法]——>{}: [执行时间]——>{}",pjp.getTarget().getClass()+"."+pjp.getSignature().getName(),(end-begin)/1000000);
    return o;
  }
}