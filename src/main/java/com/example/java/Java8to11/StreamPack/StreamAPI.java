package com.example.java.Java8to11.StreamPack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPI {
    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1,"spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa" , true));
        springClasses.add(new OnlineClass(3,"spring mvc" , false));
        springClasses.add(new OnlineClass(4, "spring core" ,false));
        springClasses.add(new OnlineClass(5 , "rest api development" , false));

        System.out.println("spring 으로 시작 하는 수업");
        // 스트림 파이프 라인을 만드는 것인데, stream이 지나기는 특정 파이프 라인만 만드는 것
        //online class라는 타입의 인스턴스가 지나가는 것
        //Stream Pipe Line에서 오퍼레이션에서 들어오는 타입 인자가 무엇인지? => stream을 리턴 하지 않는 것은 종료 오퍼레이션
        //Data의 타입은 onlineclass 타입
        springClasses.stream().filter(oc -> oc.getTitle().startsWith("spring"))
                        .forEach(oc -> System.out.println(oc.getId()));

        System.out.println("close 되지 않은 수업");
        springClasses.stream().filter(oc -> !oc.isClosed()) //! => 되지 않았다.
                        .forEach(oc -> System.out.println(oc.getId()));

        //method 레퍼런스랑 static 메소드 활용하기
        //method 레퍼런스 (online class에 임의에 인스턴스에 임의의 객체에 참조)
        springClasses.stream()
                        .filter(Predicate.not(OnlineClass::isClosed))// closed 된 수업 + predicate + not => close 되지 않은 수업
                                .forEach(oc -> System.out.println(oc.getId()));

        //map을 정의 => 들어오는 타입은 online class => Map에서 나갈때는 다른 타입으로 변경 가능
        //forEach의 경우에는 onlineclass type이 아닌 String type이 들어옴 (변경했기 때문)
        System.out.println("수업 이름만 모아서 스트림 만들기");
        springClasses.stream()
                .map(oc -> oc.getTitle())
                .forEach(s-> System.out.println(s));
/*
        flat Map
        리스트 한 & 리스트를 담고 있는 리스트
        KessunEvents collection => 리스트 함에 리스트가 들어 있고 => 하나의 stream으로 , List가 들어감
        이 List를 flat하게 만듬 => 리스트 하나의 덩어리를 flatten 시켜서 하나하나씩 리스트를 꺼냄


 */
        List<OnlineClass> javaClasses = new ArrayList<>();
        javaClasses.add(new OnlineClass(6, "The Java , test", true ));
        javaClasses.add(new OnlineClass(7, "The Java Code manipulation" ,true));
        javaClasses.add(new OnlineClass(8, "The Java 8 to 11" , false));

        List<List<OnlineClass>> keesunEvents = new ArrayList<>();
        keesunEvents.add(springClasses);
        keesunEvents.add(javaClasses);

        //리스트를 => stream으로 바꾸어 주면 flatten 시킬 수 있음
        //오퍼레이터에 오는 현재 타입이 무엇인가를 생각해야 함
        System.out.println("두 수업 목록에 들어있는 모든 수업 아이디 출력");
        keesunEvents.stream().flatMap((Collection::stream))
                .forEach(oc-> System.out.println(oc.getId()));

        //10부터 1까지 무제한 stream을 작성
        System.out.println("10부터 1씩 증가하는 무제한 스트림 중에서 앞에 10개 빼고 최대 10개 까지만");
        Stream.iterate(10, i -> i+1) //시드에 해당하는 데이터는 10 & 1씩 증가 => 무제한 데이터 (중계형 오퍼레이터 이기에 아무일도 하지 않음)
                .skip(10)
                .limit(10)
                .forEach(System.out::println);

        //종료형 오퍼레이터인데, Match 하는지 보는 것
        System.out.println("자바 수업 중에 Test가 들어있는 수업이 있는지 확인");
        javaClasses.stream().allMatch(oc -> oc.getTitle().contains("Test"));
        System.out.println("test");

        //boolean이 들어감
        //오퍼레이터들의 순서에 따라 다음 오퍼레이터들이 바뀔 수 있음
        System.out.println("스프링 수업중에 제목에 spring이 들어간 것만 제목만 모아서 List 만들기");
        List<String> spring = springClasses.stream()
                .map(OnlineClass::getTitle)
                .collect(Collectors.toList());
        spring.forEach(System.out::println);

    }
}
