package com.tiger.javase.aop.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MyMethodInterceptor implements MethodInterceptor {

    @SuppressWarnings("unchecked")
	public <T> T getProxyClass(Class<T>  cls){
       return (T)Enhancer.create(cls, this);
    }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before(method);
        Object result = methodProxy.invokeSuper(o, objects);
        after(method);
        return result;
    }

    private void before(Method method) {
        System.out.println("Before " + method.getName());
    }

    private void after(Method method) {
        System.out.println("After " + method.getName());
    }
}
