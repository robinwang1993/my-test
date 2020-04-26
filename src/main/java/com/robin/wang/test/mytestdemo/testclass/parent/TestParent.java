package com.robin.wang.test.mytestdemo.testclass.parent;

import javafx.scene.Parent;
import org.junit.Test;

public class TestParent {

    @Test
    public void test01(){
        Son son = new Son();
        testParent(son);
    }

    public void testParent(Father parent){
        System.out.println("parent");
    }

    public void testParent(Son son){
        System.out.println("son");
    }
}
