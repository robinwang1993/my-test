package com.robin.wang.test.mytestdemo.reflection;

public interface InterfaceB {
    public void interfaceBMethod();

    default String defaultMethod() {
        return "interface B default method";
    }
}
