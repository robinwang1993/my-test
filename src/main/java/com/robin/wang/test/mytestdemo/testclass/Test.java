package com.robin.wang.test.mytestdemo.testclass;

public class Test {
}

/**
 * 控制台打印
 */
class Log {
    public static String baseFinalInit(Integer integer) {
        System.out.println("Base Final Field:"+integer);
        return "";
    }
    public static String baseFieldInit() {
        System.out.println("Base Normal Field");
        return "";
    }

    public static String baseStaticFieldInit() {
        System.out.println("Base Static Field");
        return "";
    }

    public static String fieldInit() {
        System.out.println("Normal Field");
        return "";
    }

    public static String staticFieldInit() {
        System.out.println("Static Field");
        return "";
    }
}

/**
 * 基类
 */
class Base {
    final static String finalStr=Log.baseFinalInit(1);
    /*1*/ static {
        System.out.println("Base Static Block 1");
    }
    final static String finalStr1=Log.baseFinalInit(2);
    /*1*/ private static String staticValue = Log.baseStaticFieldInit();

    /*1*/ static {
        System.out.println("Base Static Block 2");
    }

    /*3*/ {
        System.out.println("Base Normal Block 1");
    }

    /*3*/ private String value = Log.baseFieldInit();

    /*3*/ {
        System.out.println("Base Normal Block 2");
    }

    /*4*/ Base() {
        System.out.println("Base Constructor");
    }
}

/**
 * 派生类
 */
class Derived extends Base {

    /*2*/ static {
        System.out.println("Static Block 1");
    }

    /*2*/ private static String staticValue = Log.staticFieldInit();

    /*2*/ static {
        System.out.println("Static Block 2");
    }

    /*5*/ {
        System.out.println("Normal Block 1");
    }

    /*5*/ private String value = Log.fieldInit();

    /*5*/ {
        System.out.println("Normal Block 2");
    }

    /*6*/ Derived() {
        System.out.println("Derived Constructor");
    }

    public static void main(String[] args) {
        Derived derived=new Derived();
    }
}