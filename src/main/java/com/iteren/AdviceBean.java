package com.iteren;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AdviceBean{
    @Pointcut("execution(* com.iteren..*A()) && bean(provider)")
    public void pointcutA() {
    }


    @Before("pointcutA()")
    public void adviceA() {
        System.out.println("Inside adviceA...");
    }

    @Before("pointcutA()")
    public void adviceAB() {
        System.out.println("Inside Advice Bean Name...");
    }

    @Before("pointcutA()")
    public void adviceAll() {
        System.out.println("Inside adviceAll...");
    }
}
