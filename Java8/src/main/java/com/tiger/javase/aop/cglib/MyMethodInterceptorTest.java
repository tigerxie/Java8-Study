package com.tiger.javase.aop.cglib;

import net.sf.cglib.proxy.Enhancer;

public class MyMethodInterceptorTest {

    public static void main(String[] args){
    	way1();
        way2();
    }
    private static void way2() {
    	Enhancer enhancer = new Enhancer();
    	enhancer.setSuperclass(MyMethodInterceptorTest.class);
    	enhancer.setCallback(new MyMethodInterceptor());
    	MyMethodInterceptorTest mit = (MyMethodInterceptorTest) Enhancer.create(MyMethodInterceptorTest.class, new MyMethodInterceptor());
    	mit.say();
	}
	private static void way1() {
    	MyMethodInterceptorTest mit = new MyMethodInterceptor().getProxyClass(MyMethodInterceptorTest.class);
    	mit.say();		
	}
	public void say(){
        System.out.println("Hello world.");
    }
}
