package com.lsum9.cafe24.board.controller;

import com.lsum9.cafe24.board.service.BoardService;
import com.lsum9.cafe24.board.vo.BoardVo;
import com.lsum9.cafe24.board.vo.PagingVo;
import com.lsum9.cafe24.util.Paging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class BoardController {

    private BoardService boardService;

    @Autowired
    public void BoardService(BoardService boardService){
        this.boardService = boardService;
    }

    @RequestMapping(value = "/board/boardList")
    public ModelAndView board(@PageableDefault(value = 5) Pageable pageable
                             , @RequestParam(value = "nowPage", defaultValue = "0") int nowPage
                              ) throws Exception{

        ModelAndView mav = new ModelAndView();
        Page<BoardVo> boardList = boardService.boardList(pageable);

        //페이징정보 넘겨서 게시글목록 받기
        mav.setViewName("/board/boardList");
        mav.addObject("list", boardList.getContent());


        return mav;
    }

    //게시글상세조회
    @GetMapping(value = "board/detail/{boardNo}")
    public ModelAndView detail(int boardNo){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/board/detail");
        mav.addObject("detail", boardService.boardDetail(boardNo));
        return mav;
    }//detail() end

    @GetMapping(value = "/board/writeForm")
    public String writeForm(){
        return "/board/writeForm";
    }//writeForm

    @PostMapping(value = "/board/insert")
    public String insert(BoardVo boardVo){
        ModelAndView mav = new ModelAndView();

        int cnt = 0;
        cnt = boardService.insert(boardVo);
        if(cnt < 1){
            return "board/boardList";
        }else{
            return "board/detail";
        }//if end

        //int board_no = boardService
    }
}//end
