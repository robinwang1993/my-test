package com.robin.wang.test.mytestdemo.proxy;

public class MyInterfaceImpl implements MyInterface {
    @Override
    public String doSomthing() {
        System.out.println("MyInterface doSomething!");
        return "MyInterface doSomething!";
    }
}
