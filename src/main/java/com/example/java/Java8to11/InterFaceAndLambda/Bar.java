package com.example.java.Java8to11.InterFaceAndLambda;

public interface Bar extends Foo2 { //if Bar interface의 경우 Foo2에서 제공하는 인터페이스를 받고 싶지 않을때

    // 1. 새롭게 재정의 => 단 이렇게 재정의 하면 다른 것들 모두 다 재정의
   void printNameUpperCase();

   default void printName(){

   }

    /**
    Foo2에도 default가 있고 bar에도 default가 있을 경우
     DefaultStaticMethod에 Foo2가 이미 implements가 되어 있는 상황에서
     Bar 또한 implements를 하게 될 경우 => default 끼리 충돌! => ERROR
     충돌하는 default 메소드가 있는 경우에는 직접 overriding을 해야 함


     */
}
