package com.lsum9.cafe24.home.mapper;

import com.lsum9.cafe24.home.vo.HomeVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HomeMapper {
    List<HomeVo> selectBoardList();

    HomeVo selectBoardDetail(String boardNum);
}
