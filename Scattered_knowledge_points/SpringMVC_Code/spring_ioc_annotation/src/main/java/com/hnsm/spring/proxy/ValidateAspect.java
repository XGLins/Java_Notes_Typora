package com.hnsm.spring.proxy;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
/*切面的优先级，默认值为Integer的最大值，值越小，优先级越高*/
@Order(1)
public class ValidateAspect {

    ///@Before("execution(* com.hnsm.spring.proxy.CalculatorImpl.*(..))")
    @Before("com.hnsm.spring.proxy.LoggerAspect.pointCut()")
    public void beforeMethod(){
        System.out.println("ValidateAspect-->前置通知");
    }

}
