package com.robin.wang.test.mytestdemo.test;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestAnnotation {

    public void test1() {
        System.out.println("test1");
    }

    @MyAnnotation
    public void test2() {
        System.out.println("test2");
    }

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
        TestAnnotation testAnnotation = new TestAnnotation();
        testClass(testAnnotation);
    }

    public static <T> void testClass(T t) throws InvocationTargetException, IllegalAccessException {
        if (t == null) {
            System.out.println("t should not be null");
        }
        Class<?> tClass = t.getClass();
        Method[] methods = tClass.getMethods();
        if (methods.length == 0) {
            System.out.println("没有可执行的方法");
        }
        for (Method method : methods) {
            Annotation[] methodAnnotations = method.getAnnotations();
            if (methodAnnotations.length == 0) {
                continue;
            }

            List<? extends Class<? extends Annotation>> collect = Arrays.asList(methodAnnotations).stream().map(x -> x.annotationType()).collect(Collectors.toList());
            if (collect.contains(MyAnnotation.class)) {
                method.invoke(t);
            }
            boolean annotationPresent = method.isAnnotationPresent(MyAnnotation.class);

        }

    }
    public <T,V> V test(Class<T> clazz){
        boolean annotationPresent = clazz.isAnnotationPresent(Entity.class);
        if (!annotationPresent){
            throw new UnsupportedOperationException("不支持的类型");
        }
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            Column annotation = field.getAnnotation(Column.class);
//            annotation.
        }
        return null;
    }
}
