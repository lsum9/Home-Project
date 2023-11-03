package com.lsum9.cafe24.board.mapper;

import com.lsum9.cafe24.board.vo.BoardVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<BoardVo> selectBoardList();

    BoardVo selectBoardDetail(String boardNum);
}
