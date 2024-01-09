package com.lsum9.cafe24.home.scheduler.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

@Data
public class DateDto {
    private int year;
    private int month;
    private int date;
    private String day;
    private String time;
    private String nowDate;
    private int firstDay;
    private int lastDate;
    private int chgMonth;

}
