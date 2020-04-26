package com.robin.wang.test.relection;

import org.junit.Test;

import java.lang.reflect.Proxy;

public class TestProxy {

    @Test
    public void testInvocationhandler(){
        Coder coder = new Coder("wyz",27);
        Class<? extends Coder> coderClass = coder.getClass();
        Person person = (Person) Proxy.newProxyInstance(coderClass.getClassLoader(), coderClass.getInterfaces(), new PersonInvocationHandler(coder));
        int age = person.getAge();
        System.out.println(age);
    }


}
