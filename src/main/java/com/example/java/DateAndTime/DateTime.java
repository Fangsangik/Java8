package com.example.java.DateAndTime;


import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateTime {
    public static void main(String[] args) throws InterruptedException {

        Date date = new Date();
        long time = date.getTime(); // long time에서의 시간은 => 이폭타임을 리턴
        System.out.println(date);
        System.out.println(time);

        Thread.sleep(1000*3); // 3초를 재움
        Date after3Seconds = new Date();
        System.out.println(after3Seconds);//3초가 지난 시간을 출력

        after3Seconds.setTime(time);//3초 이전에 가져왔던 시간으로 설정 가능
        System.out.println(after3Seconds);
        // => Mutable 하다, 멀티 스레드 환경에서 사용하기 어렵다

        Calendar SangikBirth = new GregorianCalendar(1995,Calendar.JUNE,5);
        System.out.println(SangikBirth.getTime()); // Time을 했는데 Date가 나오는 상황
        SangikBirth.add(Calendar.DAY_OF_YEAR, 1);

        //java.time.chrono. => 여러 나라 달력 시간을 적용함

        // 버그가 이미 있다. => constantvariable을 사용 해라. Month에 숫자 들어가면 안됨 June 영어로 적어주어야 함
        // 타입을 특정한 인트만 받게 해놓움 = Timesafty가 없다.

        /*
        Date이지만 시간까지 나타낼 수 있음
        근본적으로는 Time Stamped

        날짜에서 => 시간 ??

        멀티 스레드에서 활용하기 어렵다라는 의미는
        T1 Date T2 => 스레드가 오퍼레이션 할때 싱크로나이즈로 막을 잡고 작동하고 있는 스레드가 다른 자원의
        스레드가 접근하지 못하도록 문제가 없지만,
        그냥 뮤터블한 객체를 사용하는 경우 오퍼레이션 하는 중간에 다른 스레드가 끼어들면
        전혀 다른 값으로 변화한다. = Thread safe 하지 않다.

        버그 발생 가능성이 높다.

        시간과 관련된 Library가 생성되고 => JSL 310으로 들어옴
        Clear, Fluent, Immutable, Extensible

         */
        Calendar calendar = new GregorianCalendar();
        SimpleDateFormat dateFormat = new SimpleDateFormat();
    /*
    Api를 두가지로 나눌 수 있는데 => 사람용 & 기계용
     */

        Date date1 = new Date();
        long time1 = date.getTime();
        System.out.println(time); // 기계용 시간

        //사람용 시간 LocalDateTime, LocalTime, LocalDate
        //기간을 표현할때는 Duration, 날짜 기반을 표현할 때는 Period
        //Formatting 사용 할때 => DateTimeFormatter





    }
}
