package com.lsum9.cafe24.scheduler.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
public class SchedulerDto {
    private int scheduleNo;
    private String fullDate;
    private String scheduleStartTime;
    private String scheduleEndTime;
    private String text;
    private String regId;
    private String regDate;
    private String modifyId;
    private String modifyDate;
    private int scheduleYear;
    private int scheduleMonth;
    private int scheduleDate;
}
