package com.lsum9.cafe24.home.board.vo;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
public class BoardVo {
    private int boardNo;
    private String userId;
    private String title;
    private String contents;
    private String regDate;
    private String regId;
    private String modifyDate;
    private String modifyId;
}
