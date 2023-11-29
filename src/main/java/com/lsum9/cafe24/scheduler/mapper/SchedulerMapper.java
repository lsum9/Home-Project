package com.lsum9.cafe24.scheduler.mapper;

import com.lsum9.cafe24.scheduler.dto.SchedulerDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SchedulerMapper {
    List<SchedulerDto> selectScheduleList(SchedulerDto schedulerDto);

    int insertSchedule(SchedulerDto schedulerDto);

    int deleteSchedule(int scheduleNo);

}
