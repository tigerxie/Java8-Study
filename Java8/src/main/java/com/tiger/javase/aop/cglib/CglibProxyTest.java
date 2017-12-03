package com.tiger.javase.aop.cglib;

public class CglibProxyTest {

    public static void main(String[] args){

        CglibProxyTest cglibProxyTest = new CglibProxy().getProxyClass(CglibProxyTest.class);
        cglibProxyTest.say();

    }
    public void say(){
        System.out.println("Hello world.");
    }

}
