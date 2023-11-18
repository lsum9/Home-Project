package com.lsum9.cafe24.board.vo;

import lombok.Data;

@Data
public class BoardVo {
    private int board_no;
    private String user_id;
    private String title;
    private String contents;
    private String reg_date;
    private String reg_id;
    private String modify_date;
    private String modify_id;
}
