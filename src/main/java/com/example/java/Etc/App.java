package com.example.java.Etc;

import java.lang.annotation.Repeatable;
import java.util.Arrays;
import java.util.List;

@Chicken//("양녕")
//("마늘간장")
public class App {
    public static void main(String[] args) {

        /*
        1.class.getAnnotationsByType으로 바로 읽어 오는 방법
        두개의 에노테이션이 배열로 온다. (양념, 마늘간장)
        Chicken[] chickens = App.class.getAnnotationsByType(Chicken.class);
        Arrays.stream(chickens).forEach(c ->{
            System.out.println(c.value());
        });
 */

        /*
        2.ContainerType

        ChickenContainer chickenContainer = App.class.getAnnotation(ChickenContainer.class);
         Arrays.stream(chickenContainer.value().forEach(c->{
             System.out.println(c.value());
         });
    */
    }
/*
    static class FeelsLikeChicken<T> { // 특정 타입에 정의 되어있는 것 <T>/<R> = Type Parameter


        public static <C> void print(C c) {
            // 리턴타입 전에다가 타입을 지정해야한다, 접근지시자와 리턴타입 사이에다가 파라미터 지정
            // <C>는 타입 파라미터 <= 에노테이션 지정, (C c)는 타입
            System.out.println(c);
 */
        }

