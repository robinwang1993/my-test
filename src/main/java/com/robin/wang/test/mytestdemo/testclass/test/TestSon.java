package com.robin.wang.test.mytestdemo.testclass.test;

import com.robin.wang.test.mytestdemo.testclass.parent.Father;
import com.robin.wang.test.mytestdemo.testclass.parent.Son;
import org.junit.Test;

public class TestSon {
    @Test
    public void testSon(){
        Son.hello();
        Father son = new Son();
        son.hello();
        Class<? extends Father> clazz = son.getClass();
        System.out.println(clazz);
    }
}
