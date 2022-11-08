package com.example.java.Java8to11.InterFaceAndLambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class MethodRefference {
    public static void main(String[] args) {
        //따로 구현을 하는 것이 아닌 기존에 이미 있는 메소드를 똑같이 하는 일이 있음
        // 그 메소드를 참조하는 것 => 그 메소드 자체를 Function<Integer, String> intToString 인타페이스를 사용 하게 되는 것
        Function<Integer, String> intToString = (i) -> "number";

        UnaryOperator<String> hi =  (s) -> "hi" +s;
        //같은 의미
        UnaryOperator<String> bye = Greeting::hi; // 메소드 레퍼런스 표현 방식

        Greeting greeting =new Greeting();
        UnaryOperator<String> hello = greeting::hello;
        System.out.println(hello.apply("tkddlr")); // hello를 갖고 apply를 해야 hello method애 전달
        // =public String hello(String name){
        //            return "hello" + name;
        //    } => 인스턴스 메소드 참조

        Supplier<Greeting> newGreeting = Greeting::new;
        //=  public Greeting(){ // 비어있는 생성자
        //        }
        //이 자체로는 아무 일도 발생 하지 않음
        newGreeting.get(); // get을 해야 생성

        //생성자 받는 레퍼런스
        Function<String , Greeting> sangikGreeting
                = Greeting::new;

        Greeting sangiik = sangikGreeting.apply("상익"); // greeting이 형성
        System.out.println(sangiik.getName());

        Supplier<Greeting> newGreeting1 = Greeting::new;
        //두개의 레퍼런스는 같아보이지만, 서로 다른 생성자를 참조함

        //불특정 다수 인스턴스 참조
        String [] names = {"상익", "주연", "루키"};
        Arrays.sort(names, new Comparator<String>() { //Arrays.sort에 파라미터 두개를 구현 => comparator 사용 (= 함수형 interface) => 람다를 사용 할 수 있음
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });

        Arrays.sort(names , String:: compareToIgnoreCase);
        //compareToIgnoreCase 자기 자신의 문자열과 파라미터로 받은 문자 열과 비교
        //int 값을 넘겨주는 것
        System.out.println(Arrays.toString(names));

    }
}
