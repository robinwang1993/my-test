package com.robin.wang.test.mytestdemo.testclass;


import com.alibaba.fastjson.JSON;

import java.io.*;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import org.junit.Test;

public class TestClass {

    public int[] getSomething() {
        return new int[8];
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, IOException {
        test03();
    }

    @Test
    public void test01() throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<TestClass> clazz = TestClass.class;
        Method method = clazz.getMethod("getInt", Integer.class);
        Class<?> returnType = method.getReturnType();
        TestClass target = clazz.newInstance();
        Object returnValue = method.invoke(target, 2);
        boolean array = returnType.isArray();
        Object cast = returnType.cast(returnValue);
        if (array) {
            Class<?> componentType = returnType.getComponentType();
//            Array.newInstance(componentType,)
        }
    }

    @Test
    public void testPrimitives() throws ClassNotFoundException {
        Class<Character> characterClass = char.class;
        String name = characterClass.getName();
        Class<?> clazz = Class.forName(name);
        System.out.println(clazz);
    }

    @Test
    public void testConstructor() {
        Class childClass = Child.class;
        Constructor<?>[] constructors = childClass.getConstructors();
        System.out.println(Arrays.deepToString(constructors));
    }

    @Test
    public void testArray() {
        Object instance01 = Array.newInstance(String[].class, 2, 3, 4);
        Object sub1 = Array.get(instance01, 0);
        Object sub2 = Array.get(sub1, 0);
        String[] strings = {"1"};
        String[][] strings1 = {{"12"}, {"12"}};
        Array.set(sub2, 0, strings);
        Array.set(sub2,1,strings1);
        int length = Array.getLength(sub2);
        Object instance02 = Array.newInstance(String.class, 2, 3, 4);
        System.out.println(instance01);
    }

    public static void test02() {
        int a = 1;
//        Parent a =new Parent();
        getInt(a);
        Integer integer = a;
        getInt(integer);
        Integer integer1 = new Integer(2);
        int int2 = integer1;
        getInt(integer1);
        getInt(int2);
    }

    public static void getInt(int integer) {
        System.out.println("int");
    }

    public static void getInt(Integer integer) {
        System.out.println("integer");
    }

    public static void test03() throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, IOException {
        Class<Child> clazz = Child.class;
        String clazzString = JSON.toJSONString(clazz);
        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(new File("/myClassString.txt")));
        writer.write(clazzString);
        writer.flush();
        writer.close();
        Class parseObject = JSON.parseObject(clazzString, Class.class);
        Class superclass = parseObject.getSuperclass();
        Method hello = clazz.getMethod("hello");
        Child child = clazz.newInstance();
        hello.invoke(child, null);
    }
}

class Parent {
    private String name;

    public Parent() {
    }

    public Parent(String name) {
        this.name = name;
    }

    public void hello() {
        System.out.println("parent hello");
    }
}

class Child extends Parent implements MyInterfaceA {
    private String name = "name";

    @Override
    public void hello() {
        System.out.println("child hello");
    }
}

interface MyInterfaceA {
    default void hello() {
        System.out.println("interface hello");
    }

    default void doSomething() {
        System.out.println("interface A doSomething");
    }
}

interface MyInterfaceB {
    default void hello() {
        System.out.println("interface hello");
    }

    default void doSomething() {
        System.out.println("interface B doSomething");
    }
}

interface MyInterfaceC extends MyInterfaceB {

}