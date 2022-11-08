package com.example.java.Java8to11.InterFaceAndLambda;

import java.util.function.*;

//인스턴스를 만들어서 더해주면 된다.
public class Foo1 {
    public static void main(String[] args) {
        Plus10 plus10 = new Plus10();
        System.out.println(plus10.apply(1));


        Function<Integer, Integer> plus11 = (i) -> i + 11; // return (i) + 11;
        Function<Integer, Integer> multiply1 = (i) -> i * 2; // 두배 해서 값을 돌려주는 함수
        System.out.println(plus11.apply(1));
        System.out.println(multiply1.apply(3));

        // 두 함수를 조합 할 수 있다
        plus11.compose(multiply1); // compose가 입려값을 가지고 먼저 뒤에 오는 함수를 적용, 결과값을 다시 + 10에 입력 값을 적용
        // (high order function) compose를 구성하게 되면 = +10 compose *2
        // 어떤 값이 들어오면 x2를 먼저 하고 또다른 값을 +10에 입력 값으로 사용을 하면 값이 나옴
        Function<Integer, Integer> multiply2AndPlus10 = plus11.compose(multiply1);
        System.out.println(multiply2AndPlus10.apply(2));

        plus11.andThen(multiply1);
        // andThen을 하게 되면 지금 있는 function 뒤에다가 붙임
        // plus 11이라는 함수 뒤에다가 andThen을 하고 곱하기 2를 붙임
        // 어떤 입력값이 들어오면 먼저 +11에 가고, +11에 결과값을 다음에 이어서 곱하기 2를 해주는 function을 입력값으로 해줌

        System.out.println(multiply2AndPlus10.andThen(multiply1).apply(2));

        Consumer<Integer> printT = (i) -> System.out.println(i);// Integer Type을 받아서 print만 하는 것
            printT.accept(10); // 10을 출력

        Supplier<Integer> get10 = () -> 10; //입력해주는 값이 없기 때문에 람다 익스프레션에 아무것도 없음
        System.out.println(get10);

        Predicate<String> startWith = (s) -> s.startsWith("s");
        Predicate<Integer> isEven = (i) -> i%2 ==0;


        UnaryOperator<Integer> plus12 =  (i) -> i+10;
        UnaryOperator<Integer> multiply2 = (i) -> i*2;
    }
}

