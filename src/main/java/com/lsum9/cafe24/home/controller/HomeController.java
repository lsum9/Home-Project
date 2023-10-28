package com.lsum9.cafe24.home.controller;

import com.lsum9.cafe24.home.service.HomeServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    private HomeServ homeServ;

    @Autowired
    public void homeServ(HomeServ homeServ){
        this.homeServ = homeServ;
    }

    @RequestMapping(value = "/board/boardList")
    public ModelAndView home() throws Exception{

        ModelAndView mav = new ModelAndView();

        mav.setViewName("boardList");
        mav.addObject(homeServ.boardList());
        return mav;
    }



}//end
