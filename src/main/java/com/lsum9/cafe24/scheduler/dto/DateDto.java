package com.lsum9.cafe24.scheduler.dto;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class DateDto {
    //현재 날짜정보 가져오기
    LocalDate nowDate = LocalDate.now();
    //LocalTime nowTime = LocalTime.now();
    private int year;
    private int month;
    private int date;
    private String day;
    private String time;
    private String nowDateString;

    private int firstDay;
    private int lastDate;


    public int getYear() {
        return nowDate.getYear();
    }

    public int getMonth() {
        return nowDate.getMonthValue();
    }

    public int getDate() {
        return nowDate.getDayOfMonth();
    }

    public String getNowDate(){
        return nowDate.toString();
    }

    //이번달의 마지막일
    public int getLastDate(){
        int lastDate =  nowDate.with(TemporalAdjusters.lastDayOfMonth()).getDayOfMonth();
        return lastDate;
    }

    public String getDay() {
        String day = nowDate.getDayOfWeek().toString();
        day = switch (day) {
            case "SUNDAY" -> "일";
            case "MONDAY" -> "월";
            case "TUESDAY" -> "화";
            case "WEDNESDAY" -> "수";
            case "THURSDAY" -> "목";
            case "FRIDAY" -> "금";
            case "SATURDAY" -> "토";
            default -> day;
        };
        return day;
    }

    //이번달 첫날요일
    public int getFirstDay() {
        String firstDay = nowDate.withDayOfMonth(1).getDayOfWeek().toString();
        int firstDayNum = switch (firstDay) {
            case "SUNDAY" -> 1;
            case "MONDAY" -> 2;
            case "TUESDAY" -> 3;
            case "WEDNESDAY" -> 4;
            case "THURSDAY" -> 5;
            case "FRIDAY" -> 6;
            case "SATURDAY" -> 7;
            default -> 0;
        };
        return firstDayNum;
    }

    /* public String getTime() {
        String time =
        return nowTime.getHour();
    }
*/

}
