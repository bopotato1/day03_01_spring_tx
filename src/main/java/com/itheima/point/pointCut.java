package com.itheima.point;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Aspect
@Component
public class pointCut {
    @Around("execution(* com.itheima.service..*.*(..))")
    public void around(ProceedingJoinPoint joinPoint){
        try {
            System.out.println("前置");
            joinPoint.proceed();
            System.out.println("后置");
        } catch (Throwable throwable) {
            System.out.println("异常");
            throwable.printStackTrace();
        }finally {
            System.out.println("最终");
        }
    }
}
