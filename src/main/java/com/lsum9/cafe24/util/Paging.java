package com.lsum9.cafe24.util;


import com.lsum9.cafe24.board.vo.PagingVo;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Map;


/*
* 페이지 네비 노출 규칙
* 현재페이지가 네비 번호들 중앙에 노출
*
*
*
* */

public class Paging {
    public PagingVo pagingInfo(PagingVo pagingVo){

        //네비 페이지번호 노출개수
        int pageNumCnt = pagingVo.getPageNumCnt();
        int nowPage = pagingVo.getNowPage();
        int totalPage = pagingVo.getTotalPage();
        int startPageNum = 0;

        //현재페이지번호 네비 중앙에 노출 로직
        if(nowPage <= pageNumCnt / 2 + 1){
            //이전없는 앞번호일 경우
            startPageNum = 1;
        }else if(nowPage >= totalPage - (pageNumCnt / 2)){
            //다음없는 뒷번호일 경우
            startPageNum = totalPage - pageNumCnt + 1;
        }else {
            //이전, 다음 있는 경우
            startPageNum = nowPage - pageNumCnt / 2;
        }//if end

        pagingVo.setStartPageNum(startPageNum);

        return pagingVo;
    }

}//end
