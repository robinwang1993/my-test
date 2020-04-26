package com.robin.wang.test.relection;

public class Coder implements Person {
    String name;
    int age;

    public Coder(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public String getName() {
        return name;
    }
}
