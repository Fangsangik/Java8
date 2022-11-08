package com.example.java.Java8to11.OptionalPack;

import java.util.*;

public class Optional1 {
    public static void main(String[] args) {
        List<OnlineClass1> springClasses1 = new ArrayList<>();
        springClasses1.add(new OnlineClass1(1,"spring boot", true));
        springClasses1.add(new OnlineClass1(2, "spring data jpa" , true));
        springClasses1.add(new OnlineClass1(3,"spring mvc" , false));
        springClasses1.add(new OnlineClass1(4, "spring core" ,false));
        springClasses1.add(new OnlineClass1(5 , "rest api development" , false));

        /*
        OnlineClass1 spring_boot = new OnlineClass1(1, "spring boot", true );
        Optional<Progress> progress = spring_boot.getProgress();
        progress.ifPresent(p-> System.out.println(p.getStudyDuration())); => null

         public Optional<Progress> getProgress() {
         return null;
         } => 여기서 null을 리턴 했기 때문에 값은 null
         */

        /*
        Optional로 감싸면 안된다. 다른 Container 성격의 instance들을 감싸면 안된다.
        Collection, Map, Optional, Stream, Array => 비어 있다는 것 자체를 표현할 수 있는 것들. 따라서 Optional로 감싸지 말것
         */

        /*
        Optional.of(10); //Primitive Type을 넣을 수는 있지만, 안에서 Boxing unBoxing이 발생 => 성능 X
        => 대신 OptionalInt.of(10);
         */
  /*
        OnlineClass1 spring_boot = new OnlineClass1(1 , "spring boot", true );

        Progress progress = spring_boot.getProgress();

        if (progress ! = null){
            System.out.println(progress.getStudyDuration());
        } // error가 날 수 있음 & null을 return 하는 것이 문제


        spring_boot.setProgress(null);
         */
/*
        // 호출하는 쪾에서 얼마든지 파라미터 레퍼런스 타입에 null을 줄 수 있다.
        //=> public void setProgress(Optional<Progress> progress){
        //            progress.ifPresent(p -> this.progress = p); => null이 들어옴

        //Duration studyDuration = spring_boot.progress.getStudyDuration();
        // spring_boot.progress.getStudyDuration()
        // => progress가 null이기 때문에 null point exception error가 발생
        //System.out.println(studyDuration);

        Map에 key type을 OPtional 사용 => 좋지 않은 사용법
        Map의 contract를 깨뜨리는 것 => Map의 특징중 하나가 key는 Null이 아닙니다
        Key 값이 비어있을 수도 있다? => Optional을 사용해서 == 절대 있을 수 없는 일


 */




    }
}
