package com.lsum9.cafe24.board.service;

import com.lsum9.cafe24.board.mapper.BoardMapper;
import com.lsum9.cafe24.board.vo.BoardVo;
import com.lsum9.cafe24.board.vo.PagingVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BoardService {

    private BoardMapper boardMapper;

    @Autowired
    public void boardMapper(BoardMapper boardMapper){
        this.boardMapper = boardMapper;
    }

   /* public List<BoardVo> boardList(PagingVo pagingVo){
        return boardMapper.selectBoardList(pagingVo);
    }*/

    public Page<BoardVo> boardList(Pageable pageable){
        PagingVo pagingVo = new PagingVo();
        pagingVo.setStartRow((int)pageable.getOffset());
        pagingVo.setRowPerPage(pageable.getPageSize());
        List<BoardVo> boardList = boardMapper.selectBoardList(pagingVo);
        Page<BoardVo> result = new PageImpl<>(boardList, pageable, totalRow());
        return result;
    }
    public int totalRow(){
        return boardMapper.selectTotalRow();
    }

    public BoardVo boardDetail(int boardNo){
        return boardMapper.selectBoardDetail(boardNo);
    }

    public int insert(BoardVo boardVo){
        return boardMapper.insertBoard(boardVo);
    }

    public int delete(int boardNo){
        return boardMapper.deleteBoard(boardNo);
    }

    public int update(BoardVo boardVo){
        return boardMapper.updateBoard(boardVo);
    }
}//end
