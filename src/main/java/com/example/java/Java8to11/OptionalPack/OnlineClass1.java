package com.example.java.Java8to11.OptionalPack;

import java.util.Optional;

public class OnlineClass1 {
    private Integer id;

    private String title;

    private boolean closed;

    public Progress progress;

    public OnlineClass1(Integer id, String title, boolean closed) {
        this.id = id;
        this.title = title;
        this.closed = closed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public boolean isClosed() {
        return closed;
    }

    public Optional<Progress> getProgress() {
        return Optional.empty();

        //return null; null을 리턴 하지 말자 => 사용하는 코드는 get.Progress을 꺼냈는데,
    }
 /*
            1. error를 던짐
            error를 던지는 옵션의 문제는
            checktheexception을 던지면 error 처리를 강제하는게 된다
            error를 발생하게 되면 자바는 stack trace를 찍기 시작
            => error가 발생하기 전 까지의 어떠한 stack을 거쳐서 어떠한 정보를 담게 됨
            자체로 resource를 사용하게 됨

            필요한 경우에만 예외로 처리 / 로직을 처리할때는 좋은 습관은 아니다.

            if (this.progress == null) {
                throw new IllegalStateException();
            }

            비어있는 값이 전달 될 수 있는 경우에  Optional 이라는 것으로 감싸서
            return type 에만 사용
            문법적으로 사용 제한은 없지만, 리턴 타입으로만 쓰는 것만이 권장사항이다.

            Optional이라는 Box를 만들어서 => Null 일 수도 있고, 아무 것도 없을 수도 있음
            Box 안에 넣을 때 넣는 reference type 자체가 Null일 수가 있다. => ofNullable

            그냥 of 만 쓸때는 뒤에 오는 것이 무조건 Null이 아니라는 가정 하. 사용

            Optional 안에다가 Null을 넣을 경우 => 비어있는 객체가 Optional에 아무것도 안들어 있는 것 처럼 처리
            */

/*
        public void setProgress(Optional<Progress> progress){
            if (progress.isPresent()) => 자체가 nullpotin excetion
            progress.ifPresent(p -> this.progress = p);
            // 이 방법 또한 위험 => null point excetion 발생

 */
}


