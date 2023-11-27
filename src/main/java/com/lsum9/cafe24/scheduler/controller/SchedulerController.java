package com.lsum9.cafe24.scheduler.controller;

import com.lsum9.cafe24.scheduler.dto.SchedulDto;
import com.lsum9.cafe24.scheduler.service.SchedulerService;
import com.lsum9.cafe24.scheduler.dto.SchedulerDto;
import com.lsum9.cafe24.util.Paging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.Calendar;

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


        //SchedulDto schedulDto = new SchedulDto(showDate, chgMonth);
        SchedulDto schedulDto = new SchedulDto();
        //현재날짜 정보 넘겨 달력리스트 받기
        mav.setViewName("/scheduler/schedulerList");
        mav.addObject("schedulDto", schedulDto);

        System.out.println("nowdate: "+ schedulDto.getNowDate());
        return mav;
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

    //게시글 작성
    @GetMapping(value = "/Scheduler/writeForm")
    public String writeForm(){
        return "/Scheduler/writeForm";
    }//writeForm

    @PostMapping(value = "/Scheduler/insert")
    public String insert(@ModelAttribute SchedulerVo SchedulerVo){

        int cnt = 0;
        cnt = SchedulerService.insert(SchedulerVo);
        System.out.println("인서트확인: " + cnt);
        System.out.println("인서트내용 : " + SchedulerVo);

        return "redirect:/Scheduler/SchedulerList";
    }

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
