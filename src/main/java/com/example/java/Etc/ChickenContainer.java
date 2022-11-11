package com.example.java.Etc;

import java.lang.annotation.*;

@Chicken
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE_USE)
public @interface ChickenContainer {
    Chicken[] value(); //=> 자기 자신이 감싸고 있을 에노테이션 배열로 갖고 있으면 된다.


}
