package com.lsum9.cafe24.home.scheduler.mapper;

import com.lsum9.cafe24.home.scheduler.dto.SchedulerDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SchedulerMapper {
    List<SchedulerDto> selectScheduleList(SchedulerDto schedulerDto);

    int insertSchedule(SchedulerDto schedulerDto);

    int deleteSchedule(int scheduleNo);

    int updateSchedule(SchedulerDto schedulerDto);

}
