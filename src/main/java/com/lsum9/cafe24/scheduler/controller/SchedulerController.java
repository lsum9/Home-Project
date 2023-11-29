package com.lsum9.cafe24.scheduler.controller;

import com.lsum9.cafe24.scheduler.dto.DateDto;
import com.lsum9.cafe24.scheduler.dto.SchedulerDto;
import com.lsum9.cafe24.scheduler.service.SchedulerService;
import com.lsum9.cafe24.util.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;


@Controller
@RequestMapping("/scheduler")
public class SchedulerController {

    private SchedulerService schedulerService;
    @Autowired
    public void SchedulerService(SchedulerService schedulerService){
        this.schedulerService = schedulerService;
    }

    @RequestMapping(value = "/schedulerList")
    public ModelAndView scheduler(@RequestParam(value = "chgMonth", defaultValue = "0") int chgMonth
                                  ,@ModelAttribute DateDto dateDto
                              ) throws Exception{
        ModelAndView mav = new ModelAndView();
        
        //달력 날짜구성 위한 클래스 객체생성
        Scheduler scheduler = new Scheduler();
        //변경된 달 세팅
        dateDto.setChgMonth(chgMonth);

        //달력 날짜구성
        dateDto = scheduler.scheduler(dateDto);

        mav.setViewName("/scheduler/schedulerList");

        //현재날짜 정보 넘겨 달력리스트 받기
        mav.addObject("dateDto", dateDto);

        //작성된 스케줄 정보 받기
        SchedulerDto schedulerDto = new SchedulerDto();
        schedulerDto.setScheduleYear(dateDto.getYear());
        schedulerDto.setScheduleMonth(dateDto.getMonth());
        //schedulerDto.setScheduleDate(dateDto.getDate());
        mav.addObject("list", schedulerService.scheduleList(schedulerDto));
        System.out.println(schedulerService.scheduleList(schedulerDto));
        return mav;
    }

    @PostMapping(value = "/insert")
    public String insert(@ModelAttribute SchedulerDto schedulerDto){

        //입력받은 일정의 전체날짜 가공하여 년월일에 넣기
        String fullDate = schedulerDto.getFullDate();
        String[] fullDateArray = fullDate.split("/");

        try {
            schedulerDto.setScheduleYear(Integer.parseInt(fullDateArray[2]));
            schedulerDto.setScheduleMonth(Integer.parseInt(fullDateArray[0]));
            schedulerDto.setScheduleDate(Integer.parseInt(fullDateArray[1]));
        }catch (NumberFormatException ex){
            System.out.println(ex);
        }

        int cnt = 0;
        cnt = schedulerService.insert(schedulerDto);
        System.out.println("인서트확인: " + cnt);
        if(cnt == 1){
            System.out.println("인서트내용 : " + schedulerDto);
            return "redirect:/scheduler/schedulerList";
        }
        return "redirect:/scheduler/schedulerList";
    }

    //게시글 삭제
    @RequestMapping(value = "/delete")
    public String delete(@ModelAttribute SchedulerDto schedulerDto){
        System.out.println(schedulerDto.getScheduleNo());
        int cnt = 0;
        cnt = schedulerService.delete(schedulerDto.getScheduleNo());

        return "redirect:/scheduler/schedulerList";
    }
/*

    //게시글상세조회
    @GetMapping(value = "/Scheduler/detail")
    public ModelAndView detail(@RequestParam(value = "SchedulerNo") int SchedulerNo){
        ModelAndView mav = new ModelAndView();

        mav.setViewName("/Scheduler/detail");
        mav.addObject("SchedulerVo", SchedulerService.SchedulerDetail(SchedulerNo));
        System.out.println("디테일:"+mav);
        return mav;
    }//detail() end


    //게시글 수정
    @GetMapping(value = "/Scheduler/updateForm")
    public ModelAndView updateForm(@RequestParam(value = "SchedulerNo") int SchedulerNo) {
        ModelAndView mav = new ModelAndView();

        mav.setViewName("/Scheduler/updateForm");
        mav.addObject("SchedulerVo", SchedulerService.SchedulerDetail(SchedulerNo));

        return mav;
    }//writeForm

    @PostMapping(value = "/Scheduler/update")
    public String update(@ModelAttribute SchedulerVo SchedulerVo){
        System.out.println("수정내용:"+SchedulerVo);
        int cnt = 0;
        cnt = SchedulerService.update(SchedulerVo);
        System.out.println("업데이트확인: " + cnt);

        return "redirect:/Scheduler/SchedulerList";
    }
*/

}//end
