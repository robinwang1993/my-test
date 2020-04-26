package com.robin.wang.test.mytestdemo.reflection;

public interface InterfaceA {
    public void interfaceAMethod();

    default String defaultMethod() {
        return "interface A default method";
    }
}
