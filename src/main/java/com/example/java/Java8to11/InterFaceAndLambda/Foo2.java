package com.example.java.Java8to11.InterFaceAndLambda;

public interface Foo2 {
    void printName();

    //인터페이스에 새로운 메소드 추가 했을 경우 Foo2를 implements한 클래스들 오류
    //void printNameUppercase();
/*
Static 사용 하기
기본적인 구현체들은 인스턴스만 사용 할 수 있는 것
해당 인터페이스를 구현한 모든 인스터스, 해당 타입에 관련한 유틸리티, Helper메소드를 구현하고 싶을때
=> static method 사용
 */
    static void printAnything() {
        System.out.println("Foo");
    }

    /**
     * @implSpec 이 구현체는 getName()으로 가져오는 문자열을 대문자로 출력한다.
     */
    default void printNameUppercase() {
       /*
        default를 사용하면 따로 추가 하지 않고 사용 가능
        ex) remove if 라는 default method를 collection에서 제공
        collection 하위 목록 들은 모두 default 값을 갖음

        default method의 경우 제공이 안되는 method가 있는데
        => Object를 제공 받는 메소드 ex) toString
        단 interface에 선언 하는 것은 괜찮음
        ex) String toString(); => 인터페이스가 갖는 특별한 제약 사항이 있는 경우

        default 메소드는 구현체로 제공을 해야 하기 때문에 만든 interface만 제공 할 수 있고,
        다른 라이브러리에 있는 인터페이스에 적용 하는 것은 X
        */
        System.out.println(getName().toString());
    }

    String getName();
    /*
    항상 제대로 동작 하는지 알 수 없음
    getName에 어떤 값이 올지 모름
    if 어떤 구현체가 Null을 리턴 -> runtime exception 발생 가능
    문서화를 잘 해야함
    문제가 된다면 재정의 할 수 있음 => overriding

     */

}
