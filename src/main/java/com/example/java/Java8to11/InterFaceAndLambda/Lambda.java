package com.example.java.Java8to11.InterFaceAndLambda;

import java.util.function.*;

public class Lambda {
    public static void main(String[] args) {

        Supplier<Integer> get10 = ()-> 10; //supplier가 인자 아무것도 받지 않음
            //바디가 한줄일 경우 바디 생략 가능

            BinaryOperator<Integer> sum = (a, b) -> a + b; //첫번째 인자 두번째 인자 받아서 더함
        BinaryOperator<Integer> sum1 = (Integer c, Integer d) -> c+d; // 타입 또한 정의 할 수 있음, 타입의 경우 선언한 제네릭 타입을 갖고 추론을 할 수 있음 / 생략 또한 가능

        //람다를 감쌓고 있는 localvariable이 있다고 가정
        Lambda lambda = new Lambda();
        lambda.run();

    }
//변수 캡쳐 하기
    /*
baseNumber라고 하는 localvariable이 캡쳐가 됨
익명 클래스랑 내부 클래스에서도 사용
항상 반드시 final 이라는게 붙어 있어야 함
final 변수 생략 => 사실상 int baseNumber가 사실상 final인 경우 (변수를 어디서 더이상 변경 하지 않는 경우)
effective final => final이라는 참조 없이도 모두 final로 지정 가능
final이 붙을경우 변경 불가능


     */

    /*
    공통점- local class & 익명 클래스 & 람다는 참조 할 수 있다
    차이점- local class & 익명 클래스 VS 람다 => 쉐도잉 차이
    쉐도잉이란 -> class name => local variable 어디임을 정의 => local variable 에 name이라는 값을 사용하면
    변수 name이 local variable에 name에 가려짐

    class가 하나 있고, method가 하나 있음, 그 안에 local class & 익명 클래스 & 람다 있음
    local class & 익명 클래스 => 쉐도잉 O / 람다의 경우 => 쉐도잉 X
    local class & 익명 클래스에 선언한 변수들 중 이름이 같은 변수들이 올 경우 가려짐
    사실상 람다의 경우 스콥이 동일함 => 쉐도잉이 발생 X

    if effective final이 아닌 것을 알 수 있는 방법 = > 나중에 바뀌게 되면 참조를 할 수 없음
    effective final이 아니기 떄문에 참조 할 수 없다.

     */
    private void run(){
        //local 변수를 참조 한다는 가정
        int baseNumber = 10;

        //local class
        class LocalClass {
            void printBaseNumber(){
                int baseNumber = 11;
                System.out.println(baseNumber); // run 변수 int를 localclass 변수 int가 가려버림 => 결과 11이 찍힘
            }
        }

        //익명 클래스에서 local variable 참조 하는 것
        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(baseNumber); //public void accept(Integer baseNumber) { => 될 경우 sout의 baseNumber는 파라미터에 있는 baseNumber를 참조하게 됨
            }
        };

        //람다에서 local variable 참조 하는 것
        IntConsumer printInt = (i) -> {
            System.out.println(i + baseNumber);
            // private void run(){
            //int baseNumber = 10; => 같은 scope이다. 같은 scope 안에 동일한 이름의 변수를 정의 할 수없다
            // 따라서 int baseNumber를 사용 하게 되면 ERROR 발생
        };

        printInt.accept(3);
    }

}
