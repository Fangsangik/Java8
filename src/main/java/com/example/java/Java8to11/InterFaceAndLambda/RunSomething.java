package com.example.java.Java8to11.InterFaceAndLambda;

@FunctionalInterface //functionalinterface 에노테이션을 붙여서
public interface RunSomething {
    /*
추상 메소드가 하나만 존재하면 = 함수형 인터페이스
추상 메소드가 두개가 있으면 = 함수형 인터페이스 X
인터페이스에서는 원래 abstract를 생략할 수 있지만, 인터페이스 구현체를 만날때는 구현을 해야 함

    */
    //void doit();

    /*
    public static 메소드 생략 할 수 있다.
    default 메소드 정의가능

    다른 형태의 메소드가 있더라도 추상메소드가 몇개인가
    한개일 경우 무조건 functional interface

     */
    static void PrintName() {
        System.out.println("황상익");
    }

    default void printAge() {
        System.out.println("28");
    }

    //void doitagain() {
        //} 이 경우 functional interface 위반
//    }

    int doit(int number);
}
