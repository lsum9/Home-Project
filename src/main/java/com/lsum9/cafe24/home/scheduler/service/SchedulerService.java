package com.lsum9.cafe24.home.scheduler.service;

import com.lsum9.cafe24.home.scheduler.mapper.SchedulerMapper;
import com.lsum9.cafe24.home.scheduler.dto.SchedulerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchedulerService {

    private SchedulerMapper schedulerMapper;

    @Autowired
    public void schedulerMapper(SchedulerMapper schedulerMapper){
        this.schedulerMapper = schedulerMapper;
    }

    public List<SchedulerDto> scheduleList(SchedulerDto schedulerDto){
        return schedulerMapper.selectScheduleList(schedulerDto);
    }

    public int insert(SchedulerDto schedulerDto){
        return schedulerMapper.insertSchedule(schedulerDto);
    }

    public int delete(int scheduleNo) {return schedulerMapper.deleteSchedule(scheduleNo);}


    public int update(SchedulerDto schedulerDto){return schedulerMapper.updateSchedule(schedulerDto);}
}//end
