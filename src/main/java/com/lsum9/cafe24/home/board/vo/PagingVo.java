package com.lsum9.cafe24.home.board.vo;

import lombok.Data;

@Data
public class PagingVo {
    private int totalRow;
    private int rowPerPage;
    private int totalPage;
    private int startRow;
    private int startPageNum;
    private int endPageNum;
    private int nowPage;
    private int pageNumCnt;
}


