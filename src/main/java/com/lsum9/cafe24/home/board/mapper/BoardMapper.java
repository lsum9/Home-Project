package com.lsum9.cafe24.home.board.mapper;

import com.lsum9.cafe24.home.board.vo.BoardVo;
import com.lsum9.cafe24.home.board.vo.PagingVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<BoardVo> selectBoardList(PagingVo pagingVo);

    BoardVo selectBoardDetail(int boardNo);

    int selectTotalRow();

    int insertBoard(BoardVo boardVo);

    int deleteBoard(int boardNo);

    int updateBoard(BoardVo boardVo);
}
