package com.lsum9.cafe24.board.service;

import com.lsum9.cafe24.board.mapper.BoardMapper;
import com.lsum9.cafe24.board.vo.BoardVo;
import com.lsum9.cafe24.board.vo.PagingVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    private BoardMapper boardMapper;

    @Autowired
    public void boardMapper(BoardMapper boardMapper){
        this.boardMapper = boardMapper;
    }

    public List<BoardVo> boardList(PagingVo pagingVo){
        return boardMapper.selectBoardList(pagingVo);
    }

    public int totalRow(){
        return boardMapper.selectTotalRow();
    }

    public BoardVo boardDetail(String boardNo){
        return boardMapper.selectBoardDetail(boardNo);
    }

}//end
