package com.example.java.Java8to11.StreamPack;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Stream {
    public static void main(String[] args) {
        /*
        Stream의 경우 element들의 연속이다.
        Stream의 경우 연속된 기능을 처리하는 오퍼레이션들의 모임 모음
        자체가 Data가 아님
        Collection은 Data를 갖고 있는 것이고, Stream은 Data를 Source로 사용해서
        처리를 하는 것 => 전달하면서 하나씩 적용하는 것
        나열한 것이 자체가 Stream이다.

        Stream은 Data를 담는 저장소가 아니다.
        Functional 하다 => Source를 변경하지 않는다.

        stream으로 처리하는 데이터는 한번만 처리될 수도 있다. 즉 한번만 지나간다는 의미
        또는 무제한 일 수 있다. 실시간으로 들어오는 stream data를 계속 적으로 처리
        그럴때는 short circuit 메소드를 사용해서 제한 시킬 수 있다.
        무제한이지만 제한이 있는 것 처럼 만들 수 있다.

        stream이 제공하는 api => 중계 오퍼레이션, 터미널 오퍼레이션으로 나눌 수 잇다.
        중계 오퍼레이션 - stream을 리턴 = 레이즈 하다
        터미널 오퍼레이션 - stream이 아닌 다른 타입을 리턴

        손쉽게 병렬처리 할 수 있다.
         */
        List<String> names = new ArrayList<>();
        names.add("주연");
        names.add("상익");
        names.add("RUCKY");

        names.stream().map(String::toUpperCase); // 이 결과가 또다른 stream이 됨
        java.util.stream.Stream<String> stringStream = names.stream()
                .map(String::toUpperCase); // map의 경우 중계 오퍼레이션
        //Stream으로 전달받은 데이터 자체를 대문자로 변경하는 것이 아니다.

        names.forEach(System.out::println);//안에 있는 데이터들은 변화 하지 않고 그대로 있음

        names.stream().map((s) -> {
            System.out.println(s);
            return s.toUpperCase();
        }); // 출력을 하고 uppercase로 변경 / 출력 되지 않음
        // 중계형 오퍼레이터 같은 경우는 종료형 오퍼레이터가 오기 전까지 실행을 하지 않는다
        /*
        Stream pipeline은 중계 오퍼레이터는 여러개가 올 수 있는데
                          종료형 오퍼레이터는 반드시 하나가 와야 함
        따라서 종료형 오퍼레이터가 오기 전까지는 중계형 오퍼레이터는 실행을 하지 않음

        레이즈 의미의 사용 => 중계형 오퍼레이터들의 레이즈 안에서 처리된다.
         */


        System.out.println("===============");

        names.forEach(System.out::println);
        //종료형 오퍼레이터인 collect 사용
        List<String> collect = names.stream().map((s) -> {
            System.out.println(s);
            return s.toUpperCase();
        }).collect(Collectors.toList()); // 종료형 오퍼레이터
        collect.forEach(System.out::println);

        System.out.println("===================");

        names.forEach(System.out::println);

        //stream 병렬처리 하기
        for (String name : names) {
            if (name.startsWith("K")) {
                System.out.println(name.toUpperCase());
            } // 루프를 도는 element를 돌면서 병렬처리하기가 어려움
        }

        List<String> collect1 = names.parallelStream().map(String::toUpperCase)//parallelStream()을 사용하면 자동적으로 병렬처리
                .collect(Collectors.toList());// collect를 쓰면 모아줌
        collect.forEach(System.out::println);
        //병렬처리가 다 좋다고는 할 수 없다. thread를 만들어서 처리를 하게 되면 그만큼 비용이 든다.
        // Data가 처리해야 할 것이 방대 할 경우

        List<String> collect2 = names.parallelStream().map((s) -> {
            System.out.println(s + ""  + Thread.currentThread().getName());
            return s.toUpperCase();
        }).collect(Collectors.toList());
        collect2.forEach(System.out::println);
    }
}
