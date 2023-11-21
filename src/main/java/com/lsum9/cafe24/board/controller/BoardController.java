package com.lsum9.cafe24.board.controller;

import com.lsum9.cafe24.board.service.BoardService;
import com.lsum9.cafe24.board.vo.BoardVo;
import com.lsum9.cafe24.board.vo.PagingVo;
import com.lsum9.cafe24.util.Paging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
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
    public ModelAndView board(Pageable pageable
                             , @RequestParam(value = "nowPage", defaultValue = "1") int nowPage
                              ) throws Exception{

        ModelAndView mav = new ModelAndView();

        pageable = PageRequest.of(nowPage-1, 5); //offset은 0부터 시작해야 하므로 nowPage-1
        Page<BoardVo> boardList = boardService.boardList(pageable);
        //페이징 처리 위한 클래스 호출
        Paging paging = new Paging();

        //페이징 처리 위한 vo객체 생성
        PagingVo pagingVo = new PagingVo();

        //페이지당 행수, 네비 페이지숫자 노출갯수
        int rowPerPage = 5;
        int pageNumCnt = 5;
        int totalPage = boardList.getTotalPages();

        //페이징정보 구성 위한 파라미터 set
        pagingVo.setNowPage(nowPage);
        pagingVo.setRowPerPage(rowPerPage);
        pagingVo.setPageNumCnt(pageNumCnt);
        pagingVo.setTotalPage(totalPage);

        //페이징정보 구성 위한 클래스에 필요 파라미터 넘기기
        paging.pagingInfo(pagingVo);

        //페이징정보 넘겨서 게시글목록 받기
        mav.setViewName("/board/boardList");
        mav.addObject("list", boardList.getContent());
        mav.addObject("pagingVo", pagingVo);

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
