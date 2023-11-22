package com.lsum9.cafe24.board.mapper;

import com.lsum9.cafe24.board.vo.BoardVo;
import com.lsum9.cafe24.board.vo.PagingVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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
