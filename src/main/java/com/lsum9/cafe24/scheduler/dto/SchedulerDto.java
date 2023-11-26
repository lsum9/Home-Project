package com.lsum9.cafe24.scheduler.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class SchedulerDto {
    private int schedulNo;
    private int schedulYear;
    private int schedulMonth;
    private int schedulDate;
    private String schedulDay;
    private String schedulTime;
    private String text;
    private String regId;
    private String regDate;
    private String modifyId;
    private String modifyDate;
}
