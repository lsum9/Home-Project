package com.lsum9.cafe24.board.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.lsum9.cafe24.board.service.BoardService;
import com.lsum9.cafe24.board.vo.BoardVo;
import com.lsum9.cafe24.board.vo.PagingVo;
import com.lsum9.cafe24.util.Paging;
import org.eclipse.tags.shaded.org.apache.xpath.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {

    private BoardService boardService;

    @Autowired
    public void BoardService(BoardService boardService){
        this.boardService = boardService;
    }

    @RequestMapping(value = "/board/boardList")
    public ModelAndView board(@RequestParam(value = "nowPage", defaultValue = "1") int nowPage
                            ,@RequestParam(value = "startPageNum", defaultValue = "1") int startPageNum
                            ) throws Exception{

        ModelAndView mav = new ModelAndView();

        //페이징 정보 구성
        PagingVo pagingVo= new PagingVo();

        //총 게시글 수 가져오기
        int totalRow = boardService.totalRow();

        //페이지당 행수
        int rowPerPage = 5;
        pagingVo.setRowPerPage(rowPerPage);

        //현재페이지
        pagingVo.setNowPage(nowPage);

        //총페이지
        int totalPage = totalRow / rowPerPage + 1;
        pagingVo.setTotalPage(totalPage);

        //현재페이지 시작행
        int startRow = 0;
        if(nowPage !=1){
            startRow = rowPerPage * (nowPage-1) + 1;
        }//if end
        pagingVo.setStartRow(startRow);

        //페이지숫자 노출갯수
        int pageNumCnt = 5;
        pagingVo.setPageNumCnt(pageNumCnt);

        //페이지 시작 숫자
        if(startPageNum <= 1){
            startPageNum = 1;
        }else if(startPageNum >= totalPage){
            startPageNum = totalPage;
        }//if end
        pagingVo.setStartPageNum(startPageNum);

        //페이지 종료 숫자
        int endPageNum = startPageNum + pageNumCnt;
        if(endPageNum >= totalPage){
            endPageNum = totalPage;
        }//if end
        pagingVo.setEndPageNum(endPageNum);

        //페이징정보 넘겨서 게시글목록 받기
        mav.setViewName("/board/boardList");
        mav.addObject("list", boardService.boardList(pagingVo));
        mav.addObject("pagingVo", pagingVo);

        //System.out.printf("mav: "+ mav);
        //System.out.printf("paging"+pagingVo);


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
