package com.lsum9.cafe24.util;


import com.lsum9.cafe24.board.vo.PagingVo;

public class Paging {
    public PagingVo pagingInfo(PagingVo pagingVo){

        //넘겨받는 값
        //총 글개수
        int totalRow = pagingVo.getTotalRow();
        //페이지 당 행개수
        int rowPerPage = pagingVo.getRowPerPage();
        //현재 페이지
        int nowPage = pagingVo.getNowPage();


        //총 페이지 수
        int totalPage =  totalRow / rowPerPage + 1;
        pagingVo.setTotalPage(totalPage);

        //한 페이지의 첫 행
        int startRow = 1;
        if(nowPage !=1){
            startRow = rowPerPage * (nowPage-1) + 1;
        }//if end


       /*
        private int startPage;
        private int endPage;
        private int nowPage;
        private int limitStart;           // LIMIT 시작 위치
        private boolean existPrevPage;    // 이전 페이지 존재 여부
        private boolean existNextPage;    // 다음 페이지 존재 여부
        private int rowPerPage;
        private int pageSize;수


		//페이징
		//총 게시글개수
		int pageSize = 5;
		int totalRecord = 0;
		int totalPage = 1;

			totalRecord = boardDao.totalRecord();
			//System.out.println("유형별총게시글개수: " + totalRecord);

			//게시글 총페이지수
			if ((double) totalRecord % (double) pageSize == 0) {
				totalPage = totalRecord / pageSize;
				if (totalPage == 0) {
					totalPage = 1;
				} //if end
			} else {
				totalPage = totalRecord / pageSize + 1;
				//System.out.println("totalPage:"+totalPage);
			} //if end

			int start = (pageNum - 1) * pageSize;
			int end = pageSize;

			//총 게시글
			map.put("totalRecord", totalRecord);

			//1~5개의 게시글 불러오기
			map.put("list", boardDao.paginglist(start, end));
        */



        return pagingVo;
    }




}//end
