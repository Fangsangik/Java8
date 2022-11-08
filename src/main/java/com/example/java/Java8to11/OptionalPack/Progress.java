package com.example.java.Java8to11.OptionalPack;

import java.time.Duration;

public class Progress {
    private Duration studyDuration;

    private boolean finished;

    public Duration getStudyDuration(){
        return getStudyDuration();
    }

    public void setStudyDuration(Duration studyDuration){
        this.studyDuration = studyDuration;
    }

    /*
    instatnce field 타입으로 정의 하지 않기
    Progress가 있을 수도 있고 없을 수도 있음  => 어떠한 온라인 클래스에 progress가 있을 수도 있고 없을 수도 있으니까 Optional 사용 ? X
    ex) public Optional <Progress> progress; => Domain class 설계의 문제
    차라리 상위 하위 클래스 쪼개서 사용

     */
}
