package com.lsum9.cafe24.scheduler.dto;

import lombok.Data;
import lombok.Setter;

import java.time.LocalDate;

@Data
public class SchedulerDto {
    private int scheduleNo;
    private String fullDate;
    private int scheduleYear;
    private int scheduleMonth;
    private int scheduleDate;
    private String scheduleDay;
    private String scheduleStartTime;
    private String scheduleEndTime;
    private String text;
    private String regId;
    private String regDate;
    private String modifyId;
    private String modifyDate;

    /*public int getScheduleYear() {
        return scheduleYear;
    }

    public int getScheduleMonth() {
        return scheduleMonth;
    }

    public int getScheduleDate() {
        return scheduleDate;
    }

    public String getScheduleDay() {
        return scheduleDay;
    }*/
}
