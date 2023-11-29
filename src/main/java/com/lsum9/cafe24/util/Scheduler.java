package com.lsum9.cafe24.util;

import com.lsum9.cafe24.scheduler.dto.DateDto;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class Scheduler {
    public DateDto scheduler (DateDto dateDto){
        //불러올 날짜정보 가져오기
        LocalDate nowDate = LocalDate.now().plusMonths(dateDto.getChgMonth());

        //dto에 날짜정보 넣기
        dateDto.setYear(nowDate.getYear());
        dateDto.setMonth(nowDate.getMonthValue());
        dateDto.setDate(nowDate.getDayOfMonth());
        dateDto.setNowDate(nowDate.toString());
        dateDto.setLastDate(nowDate.with(TemporalAdjusters.lastDayOfMonth()).getDayOfMonth());

        //현재달 첫날짜 요일
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
        dateDto.setFirstDay(firstDayNum);

        return dateDto;
    }

}
