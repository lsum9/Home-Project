package com.lsum9.cafe24.home.util;


import com.lsum9.cafe24.home.board.vo.PagingVo;


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
        int endPageNum = 0;

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
        
        //네비 끝번호 노출 로직
        if(totalPage <= pageNumCnt){
            //총페이지수가 노출할 페이지숫자 수보다 적을 경우
            endPageNum = totalPage;
        }else{
            //총페이지수가 노출할 페이지숫자 수보다 클 경우

            //
            if(nowPage <= pageNumCnt/2 + 1){
                endPageNum = pageNumCnt;
            }else{

                endPageNum = nowPage + pageNumCnt/2;
            }//if end
            //뒷번호
            if(totalPage < nowPage + pageNumCnt/2 +1){
                endPageNum = totalPage;
            }//if end
        }//if end

        pagingVo.setStartPageNum(startPageNum);
        pagingVo.setEndPageNum(endPageNum);

        return pagingVo;
    }

}//end
