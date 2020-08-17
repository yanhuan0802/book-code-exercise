package com.yanhuan.modernjavainaction.cap12;

import java.time.*;
import java.time.chrono.HijrahDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.*;
import java.util.concurrent.ExecutorService;

/**
 * @author : yan
 * @Project Name : test
 * @Package Name : com.ikingtech.javashizhan.cap12
 * @Description : java8 日期
 * @Creation Date: 2020-03-10 0:05
 * -----------------------------------------------------
 */
public class DateTest {
    public static void main(String[] args) {
//        LocalDate date = LocalDate.of(2020, 3, 10);
//        int year = date.getYear();
//        System.out.println(year);
//        Month month = date.getMonth();
//        System.out.println(month);
//        int dayOfMonth = date.getDayOfMonth();
//        System.out.println(dayOfMonth);
//        DayOfWeek dayOfWeek = date.getDayOfWeek();
//        System.out.println(dayOfWeek);
//        int length = date.lengthOfMonth();
//        System.out.println(length);
//        boolean leapYear = date.isLeapYear();
//        System.out.println(leapYear);

//        int i = date.get(ChronoField.YEAR);
//        System.out.println(i);
//        int j = date.get(ChronoField.MONTH_OF_YEAR);
//        System.out.println(j);
//        int l = date.get(ChronoField.DAY_OF_MONTH);
//        System.out.println(l);
//        LocalTime time = LocalTime.of(00, 13, 25);
//        int hour = time.getHour();
//        int minute = time.getMinute();
//        int second = time.getSecond();
//        System.out.println(hour);
//        System.out.println(minute);
//        System.out.println(second);
//        LocalTime parse = LocalTime.parse("21:25:00");
//        System.out.println(parse);
//        LocalDate parse = LocalDate.parse("2020-02-29");
//        System.out.println(parse);
//        LocalDateTime of = LocalDateTime.of(2020, 3, 10, 20, 56, 30);
//        System.out.println(of);
//        LocalDateTime of = LocalDateTime.of(2020, Month.APRIL, 21, 5, 54,21);
//        System.out.println(of);
//        Instant instant = Instant.ofEpochSecond(3);
//        System.out.println(instant);
//        Duration.between(time1,time2)
//        Period between = Period.between(LocalDate.now(), LocalDate.now().plusDays(1));
//        System.out.println(between);
//        LocalDateTime now = LocalDateTime.now();
//        System.out.println(now);
//        DateTimeFormatter chinaFormatter = DateTimeFormatter.ofPattern("d. MMMM yyyy", Locale.CHINA);
//        LocalDate date1 = LocalDate.of(2020, 3, 18);
//        String format = date1.format(chinaFormatter);
//        LocalDate parse = LocalDate.parse(format, chinaFormatter);
//        System.out.println(parse);
//        DateTimeFormatter dateTimeFormatter = new DateTimeFormatterBuilder()
//                .appendText(ChronoField.DAY_OF_MONTH)
//                .appendLiteral(". ")
//                .appendText(ChronoField.MONTH_OF_YEAR)
//                .appendLiteral(" ")
//                .appendText(ChronoField.YEAR)
//                .parseCaseSensitive()
//                .toFormatter(Locale.CHINA);
//        ZoneId romeZone = ZoneId.of("Europe/Rome");
//        ZoneId zoneId = TimeZone.getDefault().toZoneId();
//        LocalDate date = LocalDate.of(2014, Month.MARCH, 18);
//        ZonedDateTime zonedDateTime = date.atStartOfDay(romeZone);
//        System.out.println(zonedDateTime);
//        Instant now = Instant.now();
//        ZonedDateTime zonedDateTime1 = now.atZone(romeZone);
//        System.out.println(zonedDateTime1);
//        List<Integer> numbers = Arrays.asList(3, 5, 1, 2, 6);
//        numbers.sort(Comparator.naturalOrder());
//        System.out.println(numbers);\

    }
}
