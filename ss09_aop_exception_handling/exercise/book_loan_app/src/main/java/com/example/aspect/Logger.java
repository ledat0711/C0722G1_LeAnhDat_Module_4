package com.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Logger {
    private int count = 0;

    @Pointcut("within(com.example.controller.BookController)")
    public void callAllMethod() {
    }

    @After("callAllMethod()")
    public void afterAllMethod(JoinPoint joinPoint) {
        count++;
        System.err.println("Method name: " + joinPoint.getSignature().getName() + " executed");
    }
}
