package com.robin.wang.test.mytestdemo.reflection;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

import static java.lang.System.out;

public class TestReflection {
    /*
    方法1
方法名：	baseMethod
修饰符：	public
声明类：	SubClass
入参：	[interface com.robin.wang.test.mytestdemo.reflection.InterfaceA]
出参：	interface com.robin.wang.test.mytestdemo.reflection.SubInterfaceA


方法2
方法名：	baseMethod
修饰符：	public volatile
声明类：	SubClass
入参：	[interface com.robin.wang.test.mytestdemo.reflection.InterfaceA]
出参：	interface com.robin.wang.test.mytestdemo.reflection.InterfaceA


方法3
方法名：	interfaceAMethod
修饰符：	public
声明类：	BaseClass
入参：	[]
出参：	void


方法4
方法名：	subInterfaceAMethod
修饰符：	public
声明类：	BaseClass
入参：	[]
出参：	void


方法5
方法名：	wait
修饰符：	public final
声明类：	Object
入参：	[]
出参：	void


方法6
方法名：	wait
修饰符：	public final
声明类：	Object
入参：	[long, int]
出参：	void


方法7
方法名：	wait
修饰符：	public final native
声明类：	Object
入参：	[long]
出参：	void


方法8
方法名：	equals
修饰符：	public
声明类：	Object
入参：	[class java.lang.Object]
出参：	boolean


方法9
方法名：	toString
修饰符：	public
声明类：	Object
入参：	[]
出参：	class java.lang.String


方法10
方法名：	hashCode
修饰符：	public native
声明类：	Object
入参：	[]
出参：	int


方法11
方法名：	getClass
修饰符：	public final native
声明类：	Object
入参：	[]
出参：	class java.lang.Class


方法12
方法名：	notify
修饰符：	public final native
声明类：	Object
入参：	[]
出参：	void


方法13
方法名：	notifyAll
修饰符：	public final native
声明类：	Object
入参：	[]
出参：	void


方法14
方法名：	defaultMethod
修饰符：	public
声明类：	InterfaceA
入参：	[]
出参：	class java.lang.String

     */
    @Test
    public void printAllMethods() {
        Class<SubClass> subClassClazz = SubClass.class;
        Method[] methods = subClassClazz.getMethods();
        printMethods(methods);
    }

    private void printMethods(Method[] methods) {
        int count = 1;
        for (Method method : methods) {
            print("方法" + (count++));
            print("方法名：\t" + method.getName());
            print("修饰符：\t" + Modifier.toString(method.getModifiers()));
            print("声明类：\t" + method.getDeclaringClass().getSimpleName());
            print("入参：\t" + Arrays.deepToString(method.getParameterTypes()));
            print("出参：\t" + method.getReturnType());
            print("\r\n");
        }
    }

    @Test
    public void printAllDeclaredMethod() {
        Class<SubClass> subClassClazz = SubClass.class;
        Method[] declaredMethods = subClassClazz.getDeclaredMethods();
        printMethods(declaredMethods);
    }

    @Test
    public void getField() throws NoSuchFieldException {
        Class<BaseClass> baseClassClazz = BaseClass.class;
        Field[] fields = baseClassClazz.getFields();
        for (Field field : fields) {
            print(JSON.toJSONString(field));
        }
        Field name = baseClassClazz.getField("name");
        print(name);
    }

    @Test
    public void testArray() throws ClassNotFoundException {
        String[] strings=new String[8];
        Class<? extends String[]> stringsClass = strings.getClass();
        out.println(stringsClass);
        Class<?> aClass = Class.forName("[Ljava.lang.String;");
        out.println(aClass);
        Package aPackage = BaseClass.class.getPackage();
        Annotation[] annotations = aPackage.getAnnotations();
    }

    private static void print(Object object) {
        out.println(JSON.toJSONString(object) + "\t");
    }

}
