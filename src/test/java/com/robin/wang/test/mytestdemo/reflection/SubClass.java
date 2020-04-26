package com.robin.wang.test.mytestdemo.reflection;

public class SubClass extends BaseClass {

    @Override
    public SubInterfaceA baseMethod(InterfaceA interfaceA) {
        System.out.println("SubClass methodName-->baseMethod->args->InterfaceA->return->SubInterfaceA");
        return new SubInterfaceA() {
            @Override
            public void subInterfaceAMethod() {

            }

            @Override
            public void interfaceAMethod() {

            }
        };
    }

    /**
     * 私有方法
     */
    private void subClassPrivateMethod() {
        System.out.println("SubClass subClassPrivateMethiod");
    }
}
