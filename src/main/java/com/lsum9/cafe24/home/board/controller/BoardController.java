package com.lsum9.cafe24.home.board.controller;

import com.lsum9.cafe24.home.board.service.BoardService;
import com.lsum9.cafe24.home.board.vo.BoardVo;
import com.lsum9.cafe24.home.board.vo.PagingVo;
import com.lsum9.cafe24.home.util.Paging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {

    private BoardService boardService;

    @Autowired
    public void BoardService(BoardService boardService){
        this.boardService = boardService;
    }

    @RequestMapping(value = "/board/boardList")
    public ModelAndView board(Pageable pageable
                              ,@RequestParam(value = "nowPage", defaultValue = "1") int nowPage
                              ,@RequestParam(value = "keyWord", defaultValue = "") String keyWord
                              ,@RequestParam(value = "searchType", defaultValue = "title") String searchType
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

        //페이징정보 구성 위한 클래스에 필요 파라미터 넘기고 네비정보 추가해오기
        pagingVo = paging.pagingInfo(pagingVo);

        //페이징정보 넘겨서 게시글목록 받기
        mav.setViewName("/board/boardList");
        mav.addObject("list", boardList.getContent());
        mav.addObject("totalRow", boardService.totalRow());
        mav.addObject("pagingVo", pagingVo);

        return mav;
    }

    //게시글상세조회
    @GetMapping(value = "/board/detail")
    public ModelAndView detail(@RequestParam(value = "boardNo") int boardNo){
        ModelAndView mav = new ModelAndView();

        mav.setViewName("/board/detail");
        mav.addObject("boardVo", boardService.boardDetail(boardNo));
        System.out.println("디테일:"+mav);
        return mav;
    }//detail() end

    //게시글 작성
    @GetMapping(value = "/board/writeForm")
    public String writeForm(){
        return "/board/writeForm";
    }//writeForm

    @PostMapping(value = "/board/insert")
    public String insert(@ModelAttribute BoardVo boardVo){

        int cnt = 0;
        cnt = boardService.insert(boardVo);
        System.out.println("인서트확인: " + cnt);
        System.out.println("인서트내용 : " + boardVo);

        return "redirect:/board/boardList";
    }

    //게시글 삭제
    @RequestMapping(value = "/board/delete")
    public String delete(@RequestParam(value = "boardNo") int boardNo){
        System.out.println(boardNo);
        int cnt = 0;
        cnt = boardService.delete(boardNo);

        return "redirect:/board/boardList";
    }

    //게시글 수정
    @GetMapping(value = "/board/updateForm")
    public ModelAndView updateForm(@RequestParam(value = "boardNo") int boardNo) {
        ModelAndView mav = new ModelAndView();

        mav.setViewName("/board/updateForm");
        mav.addObject("boardVo", boardService.boardDetail(boardNo));

        return mav;
    }//writeForm

    @PostMapping(value = "/board/update")
    public String update(@ModelAttribute BoardVo boardVo){
        System.out.println("수정내용:"+boardVo);
        int cnt = 0;
        cnt = boardService.update(boardVo);
        System.out.println("업데이트확인: " + cnt);

        return "redirect:/board/boardList";
    }

}//end
