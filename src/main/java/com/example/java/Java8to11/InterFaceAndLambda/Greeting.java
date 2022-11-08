package com.example.java.Java8to11.InterFaceAndLambda;

public class Greeting {

        private String name;

        public Greeting(){ // 비어있는 생성자

        }

        public Greeting(String name){// name을 받는 생성자
            this.name = name;
        }

    public String getName() {
        return name;
    }

    public String hello(String name){ // instant 생성자
            return "hello" + name;
    }

    public static String hi (String name){ // static method
            return "hi" +name;
    }
}
