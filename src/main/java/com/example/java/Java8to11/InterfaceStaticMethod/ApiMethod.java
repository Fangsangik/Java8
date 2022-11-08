package com.example.java.Java8to11.InterfaceStaticMethod;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ApiMethod {
    public static void main(String[] args) {
        //Collection이 Iterable을 상속
        List<String> name = new ArrayList<>();
        name.add("상익");
        name.add("주연");
        name.add("루키");

        name.forEach((s) -> {
            System.out.println(s);
        });// 각각의 element들을 순회, ()안에 Functional interface consumer가 들어옴
        // => 각가의 String 차례대로 들어오고 return value가 없음

        for (String n : name) {
            System.out.println(n);
        }

        name.spliterator();//eterator와 같은 기능 => 쪼개는 기능

        Spliterator<String> spliterator = name.spliterator(); // 순환하는데 사용가능
        Spliterator<String> spliterator1 = spliterator.trySplit();
        // trysplit을 하게 되면 위에 참조 하고 있던 spliterator
        // 절반으로 줄고 그 다음 spliterator1에 참조가 된다
        while (spliterator.tryAdvance(System.out::println)) ; // 값이 있는 경우 계속 순회
        System.out.println("============");
        while (spliterator.tryAdvance(System.out::println)) ;
        //두개의 split으로 나누고 절반으로 나누고, 다시 또 쪼개면
        //spliterator.trySplit(); // 쪼개어짐


        name.stream();//모든 하위 collection들에 모두 Stream을 갖고 있음 => spliterator의 속성을 갖고 있음
        //element들을 stream으로 만들어서 functional 하게 처리
        name.stream().map(String::toUpperCase)// Map 처리 해서 Uppercase로 변환
                .filter(s -> s.startsWith("k")) //K로 시작 하는 것만 남김
                .collect(Collectors.toSet())
                .stream().count();
        System.out.println("k");

        name.removeIf(s->s.startsWith("K")); // k로 시작하는 것을 빼라
        name.forEach(System.out::println);

        name.sort(String::compareToIgnoreCase);//comparator => 정열할때 사용 하는데, functional interface
        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;

        name.sort(compareToIgnoreCase.reversed());//역순으로 주고 싶을때 + 더 뒤에 정렬을 하고 싶을때는 then compareTo...

        /*
        기본 메소드나 static 메소드를 사용하면서 API의 설계나 구현에 제공하는 라이브러리를 제공하는 부분에 변화
        Interface에 추상 메소드 a,b,c를 갖고 있을 때
        => 이전 자바의 경우 추상 클레스를 만듬 + 비어있는 구현체를 넣음
           실제로 클래스를 구현할때 인터페이스를 다 구현하는 것이 아닌, 필요한 인터페이스만 구현할 수 있겠끔, 편의성을 제공
        => 자바 8 이후에는 인터페이스에 기본 메소드를 a,b,c로 구현, 실제로 구현 하는 클래스는 추상메소드를 구현하는 것이 아닌 implements를 하는 것임
           상속을 사용하면 상속은 하나만 상속이 가능 하지만 구현하는 클래스들은 인터페이스를 구현하는 것이기 때문에 상속 부분에서 자유로움
           = non-invasive = 상속을 강제하지 않기 때문에 코드는 자유로워 진다.

         public interface WebMvcConfigurer 과 WebMvcConfigurerAdapter 라는 클래스가 있음
         WebMvcConfigurerAdapter - 비어있는 구현체들 필요 없다. 상속을 일일히 하나하나 해줘야 함
         하지만 지금은 interface를 default로 제공하기에 상속에서는 자유로워 짐

         */



    }
}
