package com.robin.wang.test.mytestdemo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxyTest implements InvocationHandler {
    Class target;
    Object real;

    public JdkProxyTest(Object real) {
        this.real = real;
    }

    public Object bind(Object object) {
        this.real = object;
        this.target = real.getClass();
        return Proxy.newProxyInstance(target.getClassLoader(), target.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object invoke = method.invoke(real, args);
        System.out.println("after");
        return invoke;
    }

    public static void main(String[] args) {
        JdkProxyTest jdkProxyTest = new JdkProxyTest(MyInterfaceImpl.class);
        MyInterface myInterface = (MyInterface) jdkProxyTest.bind(new MyInterfaceImpl());
        myInterface.doSomthing();


    }
}
