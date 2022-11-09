package com.example.java.DateAndTime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class DateTimeApi {
    public static void main(String[] args) {
        //기계적 시간 사용법
        Instant instant = Instant.now(); // 기계시간으로 출력
        System.out.println(instant); // 기준시 UTC, GMT
        System.out.println(instant.atZone(ZoneId.of("UTC")));

        Instant nowInstant = Instant.now();
        ZonedDateTime zonedDateTime1 = nowInstant.atZone(ZoneId.of("Asia/Seoul"));
        System.out.println(zonedDateTime1); // Instant에서 ZonedDateTime과 ZonedDateTime에서 LocalTime 으로 변환 가능

        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());//Zoneid로 현재시간을 어디를 볼 것인가??
        System.out.println(zonedDateTime);

        //사람용
        //LocalDateTime

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now); //로컬 시간을 가져온다. 코드가 동작하고 있는 나라에 있는 시간을 찍힘
        LocalDateTime birth =
                LocalDateTime.of(1995, Month.JUNE, 5, 0, 0, 0);
        ZonedDateTime nowInKorea = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));//특정 Zone에 시간을 보고 싶다.


        //기간을 표현하는 방법
        LocalDate today = LocalDate.now();
        LocalDateTime plus = now.plus(10, ChronoUnit.DAYS);//ChronoUnit 암ㄱ
        // 예전 API 사용 하듯 now.plus()로 끝나면 아무 일도 일어나지 않음 => 새로운 인스턴스를 형성해주어서 해야 함


        LocalDate thisYearBirth = LocalDate.of(2022, Month.NOVEMBER, 8);

        Period period = Period.between(today, thisYearBirth);
        System.out.println(period.getDays());

        Period until = today.until(thisYearBirth);
        System.out.println(until.get(ChronoUnit.DAYS));

        Instant now1 = Instant.now();
        now.plus(10, ChronoUnit.SECONDS);

        Duration between = Duration.between(now, now1);//Instant을 갖고 비교
        System.out.println(between.getSeconds());

        //Formatting
        LocalDate date = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/YY");
        System.out.println(now.format(dateTimeFormatter));//LocalDateTime을 문자열로 변환
        System.out.println(DateTimeFormatter.ISO_DATE_TIME);//application을 원하는 데로 설정 하고 싶을때

        //Parsing
        LocalDate parse = LocalDate.parse("07/15/1995", dateTimeFormatter);
        System.out.println(parse);

        //레거시 API의 지원
        //새로운 API가 예전의 API로 호환이 가능 하다
        Date date2 = new Date();
        Instant instant1 = date2.toInstant(); // Date => Instant로 변환
        Date newDate = Date.from(instant1); //from을 사용 해서 instant => date

        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        LocalDateTime dateTime2 = gregorianCalendar.toInstant().atZone(ZoneId.systemDefault())
                .toLocalDateTime(); //instant로만 변환 할 수 있으면 최신 API로 변환 가능

        ZonedDateTime dateTime3 = gregorianCalendar.toInstant().atZone(ZoneId.systemDefault());
        GregorianCalendar.from(dateTime3); //ZonedDateTime에서 Gregori한 time으로 변환 가능

        ZoneId zoneId = TimeZone.getTimeZone("PST").toZoneId(); //예전 API에서 현재 API
        TimeZone timeZone = TimeZone.getTimeZone(zoneId); // 최근 API에서 예전 API에 해당하는 값을 형성 할 수 있음
    }
}
