package com.lsum9.cafe24.scheduler.service;

import com.lsum9.cafe24.scheduler.mapper.SchedulerMapper;
import com.lsum9.cafe24.scheduler.dto.SchedulerDto;
import com.lsum9.cafe24.scheduler.mapper.SchedulerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchedulerService {

    private SchedulerMapper schedulerMapper;

    @Autowired
    public void SchedulerMapper(SchedulerMapper schedulerMapper){
        this.schedulerMapper = schedulerMapper;
    }

   /* public List<SchedulerVo> SchedulerList(PagingVo pagingVo){
        return SchedulerMapper.selectSchedulerList(pagingVo);
    }*/

}//end
