package com.lsum9.cafe24.board.controller;

import com.lsum9.cafe24.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {

    private BoardService boardService;

    @Autowired
    public void BoardService(BoardService boardService){
        this.boardService = boardService;
    }

    @RequestMapping(value = "/board/boardList")
    public ModelAndView board() throws Exception{

        ModelAndView mav = new ModelAndView();

        mav.setViewName("boardList");
        mav.addObject(boardService.boardList());
        return mav;
    }



}//end
