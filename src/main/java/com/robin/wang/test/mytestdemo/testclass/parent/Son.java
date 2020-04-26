package com.robin.wang.test.mytestdemo.testclass.parent;

public class Son extends Father {
    protected static String name = "son";

//        protected static String hello(){ //编译器报错

    /**
     * Error:(6, 31) java: com.robin.wang.test.mytestdemo.testclass.parent.Son中的hello()无法覆盖com.robin.wang.test.mytestdemo.testclass.parent.Father中的hello()
     * 正在尝试分配更低的访问权限; 以前为public
     */
    public static String hello() {
        String son = "son";
        System.out.println(son);
        return son;
    }
}
