package com.example.java.Etc;
/*
에노테이션을 타입 선언부에 도입 & 중복 사용 가능
 */

import java.lang.annotation.*;


@Target(ElementType.TYPE_USE) // 조금더 자유롭게 사용 하고 싶다 할때 사용
//타입 파라미터를 포함해서 타입을 선언하는 모든곳에 에노테이션을 사용 할 수 있다.

//@Target(ElementType.PARAMETER) // 에노테이션을 사용 할 곳 => Type Parameter, Type Use
//generic을 쓸때 -> type 변수 type Parameter

@Retention(RetentionPolicy.RUNTIME) //에노테이션 정보를 언제까지 유지 할 것인가?

//@Repeatable(@ChickenContainer.class)
//여러개 같은 에노테이션들을 중복으로 사용 & Container Type을 선언 해주어야 한다.
//Container가 갖고 있는 Retention과 Target 정보는 자기 자신 보다 같거나 넓어야 한다.
//Container 에노테이션이 Chicken 에노테이션을 감싸고 있는 Container 성격의 에노테이션
//Chicken이라는 에노테이션의 Retention(얼마나 유지 할 것인가) 이나 타겟(어디에서 이용할 것인가) 그런 정보가 ChickenContainer로 들어감
//Container용 Retention 전략과 에노테이션 사용 할 수 있는 위치가 더 넓어야 한다. 자기 자신이 갖고 있을 에노테이션보다 같거나 넓어야 한다.
public@interface Chicken {
}
