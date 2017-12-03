package com.tiger.javase.aop.aspect;

public class HelloWorld {

    public static void main(String[] args){
        new HelloWorld().say("hello");
    }
    public void say(String s) {
        System.out.println(s);
    }
}
