package com.example.java.Java8to11.InterFaceAndLambda;

import java.util.function.Function;

// 첫번째 파라미터가 입력값의 T 두번째 파라미터는 리턴값의 R
public class Plus10 implements Function<Integer, Integer> {
    @Override
    public Integer apply(Integer integer) {
        return integer +10;
    }
}
