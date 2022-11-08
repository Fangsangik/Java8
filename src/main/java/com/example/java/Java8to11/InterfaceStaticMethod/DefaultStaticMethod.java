package com.example.java.Java8to11.InterfaceStaticMethod;

import com.example.java.Java8to11.InterFaceAndLambda.Foo2;

public class DefaultStaticMethod implements Foo2 {
    public static void main(String[] args) {
        Foo2 foo2 = new DefaultStaticMethod("s");
        foo2.printName();
        foo2.printNameUppercase();

        Foo2.printAnything();

    }
    String name;

    public DefaultStaticMethod(String name) {
        this.name = name;
    }

    //재 정의 하는 벙법
    @Override
    public void printNameUppercase() {
        System.out.println(this.name.toUpperCase());
    }

    @Override
    public void printName() {
        System.out.println(this.name);
    }

    @Override
    public String getName() {
        return this.name;
    }
}
