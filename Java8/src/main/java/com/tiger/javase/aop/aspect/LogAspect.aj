package com.tiger.javase.aop.aspect;

public aspect LogAspect {
    pointcut logPointcut():execution(void HelloWorld.say());
    after():logPointcut(){
        System.out.println("Before");
    }
}
