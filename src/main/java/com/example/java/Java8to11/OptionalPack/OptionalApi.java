package com.example.java.Java8to11.OptionalPack;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalApi {
    public static void main(String[] args) {
        List<OnlineClass1> springClasses1 = new ArrayList<>();
        springClasses1.add(new OnlineClass1(1,"spring boot", true));
        springClasses1.add(new OnlineClass1(5, "rest api development", false));

        //stream에서의 Mapping => input은 하나지만 output이 여러개
       /*
        springClasses1.stream()
                .flatMap()
         */

        //Optional을 return => 종료형 오퍼레이션
        Optional<OnlineClass1> spring = springClasses1.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();
        boolean present = spring.isPresent(); // 있는지 없는지 유무 검사
        System.out.println(present);

        Optional<OnlineClass1> optional= springClasses1.stream()
                .filter(oc -> oc.getTitle().startsWith("jpa"))
                .findFirst();
        boolean present1 =optional.isPresent();//isEmpty - 반대 내용도 사용
        System.out.println(!present1);
/*
        Optional에 있는 값을 가져오는 방법이 있음 => get을 사용
        값이 들어 있으면 문제 되는 부분은 없다.
        비어있는 Optional일 경우에는 비어있는거로 부터 무언가를 꺼내려고 할때, => run time exception이 발생한다.
        if (optional.isPresent()){ => if 문을 추가 하는 것이 아닌 다양한 Optional이 제공하는 다양한 method를 통해서 cover
        OnlineClass1 onlineClass1 = optional.get(); // get 하기 전에 있는지 확인해보기
         System.out.println(onlineClass1.getTitle());

        get을 사용하지 않고 api 호출
        optional.ifPresent(oc -> System.out.println(oc.getTitle()));
        Optional<OnlineClass1> spring = springClasses1.stream()에 넘겨준
        Consumer functional interface에 람다 expression이 호출이 안된 경우 이다.
 */

        /*
        //참조를 해야하고 OnlineClass로 참조를 해야 할때
        //OnlineClass1 onlineClass1 = optional.get(); => X
        */

         OnlineClass1 onlineClass1 =optional.orElseGet(()->createNewJpaClass());
         //orElse의 경우에는 이미 만들어 져있는 instance를 참고할 경우 , 동적으로 작업을 해야 할 경우 orElseGet
         //만들수 없을 때는 orElseThrow(() -> ) return new IllegalArgumentExcpeiton or method reference로 생서자를 참조 할 수 있다. (IllegalStateException :: new)
         //orElseGet을 사용 하면 있는경우 supplier를 구현 X, 없는 경우에는 newClass를 생성
         //createNewJpaClass() 이자리에는 functional interface 구현이 들어가는 것이 아닌 instance가 들어오는 것
        System.out.println(onlineClass1.getTitle());

        //있다는 가정 하에
        Optional<OnlineClass1> onlineClass11 = optional
                .filter(oc -> !oc.isClosed());//false면 비어있는 그대로 나옴

        System.out.println(onlineClass11.isEmpty()); // 비어있는 결과로

        Optional<OnlineClass1> onlineClass12 = optional
                .filter(OnlineClass1::isClosed);
        System.out.println(onlineClass12.isPresent());

        //만약에 map으로 변환 하는 타입이 Optional일 경우
       /*
        Optional<Object> integer= optional.map(onlineClass1::getId);
        System.out.println(integer.isPresent());
         */

        //flatMap을 사용
        Optional<Progress> progress = optional.flatMap(OnlineClass1::getProgress);
        Optional<Optional<Progress>> progress1 = optional.map(OnlineClass1::getProgress);
        Optional<Progress> progress2 = progress1.orElseThrow(); //=> empty type

        Optional<Integer> integer = optional.map(OnlineClass1::getId);
        System.out.println(integer.isPresent());
        //if) get을 progress로 설정 해 줄 경우 Optional에 Optional이 된다.
        // public Optional<Progress> getProgress() {
        //        return Optional.empty(); => 여기서 Optional로 설정을 해놓음

    }

    private static OnlineClass1 createNewJpaClass() {
        System.out.println("creating new online class");
        return new OnlineClass1(10, "New class" , false);
    }
}
