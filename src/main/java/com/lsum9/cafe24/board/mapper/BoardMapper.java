package com.lsum9.cafe24.board.mapper;

import com.lsum9.cafe24.board.vo.BoardVo;
import com.lsum9.cafe24.board.vo.PagingVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<BoardVo> selectBoardList(PagingVo pagingVo);

    BoardVo selectBoardDetail(String boardNo);

    int selectTotalRow();
}
