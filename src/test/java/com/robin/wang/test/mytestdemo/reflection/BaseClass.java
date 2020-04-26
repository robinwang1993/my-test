package com.robin.wang.test.mytestdemo.reflection;

public class BaseClass implements SubInterfaceA {
    String field = null;

    public InterfaceA baseMethod() {
        System.out.println("BaseClass methodName->baseMethod->args->null->return->InterfaceA");
        return () -> {
            System.out.println("lambda interfaceA implement");
        };
    }

    public InterfaceA baseMethod(InterfaceA interfaceA) {
        System.out.println("BaseClass methodName->baseMethod->args->InterfaceA->return->InterfaceA");
        return () -> {
            System.out.println("lambda interfaceA implement");
        };
    }

    @Override
    public void subInterfaceAMethod() {
        System.out.println("base class subInterfaceAMethod");
    }

    @Override
    public void interfaceAMethod() {
        System.out.println("base class interfaceAMethod");
    }
}
