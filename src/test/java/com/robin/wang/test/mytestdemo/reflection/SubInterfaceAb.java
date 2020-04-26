package com.robin.wang.test.mytestdemo.reflection;

public interface SubInterfaceAb extends InterfaceA, InterfaceB {

    @Override
    default String defaultMethod() {
        return "SubInterfaceAb>>>>>><<<<<<<<<defaultMethod";
    }
}
