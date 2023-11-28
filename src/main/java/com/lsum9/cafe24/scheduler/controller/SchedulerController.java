package com.lsum9.cafe24.scheduler.controller;

import com.lsum9.cafe24.scheduler.dto.DateDto;
import com.lsum9.cafe24.scheduler.dto.SchedulerDto;
import com.lsum9.cafe24.scheduler.service.SchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/scheduler")
public class SchedulerController {

    private SchedulerService schedulerService;
    @Autowired
    public void SchedulerService(SchedulerService schedulerService){
        this.schedulerService = schedulerService;
    }

    @RequestMapping(value = "/schedulerList")
    public ModelAndView scheduler(@RequestParam(value = "showDate", defaultValue = "") String showDate
                                 ,@RequestParam(value = "chgMonth", defaultValue = "0") int chgMonth
                              ) throws Exception{
        ModelAndView mav = new ModelAndView();

        //dateDto dateDto = new dateDto(showDate, chgMonth);
        DateDto dateDto = new DateDto();
        mav.setViewName("/scheduler/schedulerList");

        //현재날짜 정보 넘겨 달력리스트 받기
        mav.addObject("dateDto", dateDto);

        //작성된 스케줄 정보 받기
        SchedulerDto schedulerDto = new SchedulerDto();
        /*schedulerDto.setSchedulYear(dateDto.getYear());
        schedulerDto.setSchedulMonth(dateDto.getMonth());
        mav.addObject("schedulerList", schedulerService.scheduleList(schedulerDto));
*/
        System.out.println("nowdate: "+ dateDto.getNowDate());
        return mav;
    }

    @PostMapping(value = "/insert")
    public String insert(@ModelAttribute SchedulerDto schedulerDto){

        int cnt = 0;
        /*cnt = SchedulerService.insert(schedulerDto);
        System.out.println("인서트확인: " + cnt);
        System.out.println("인서트내용 : " + schedulerDto);*/

        System.out.println(schedulerDto.getFullDate());
        System.out.println(schedulerDto.getScheduleStartTime());


        return "redirect:/Scheduler/SchedulerList";
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




    //게시글 삭제
    @RequestMapping(value = "/Scheduler/delete")
    public String delete(@RequestParam(value = "SchedulerNo") int SchedulerNo){
        System.out.println(SchedulerNo);
        int cnt = 0;
        cnt = SchedulerService.delete(SchedulerNo);

        return "redirect:/Scheduler/SchedulerList";
    }

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
