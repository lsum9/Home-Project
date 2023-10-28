package com.lsum9.cafe24.home.service;

import com.lsum9.cafe24.home.mapper.HomeMapper;
import com.lsum9.cafe24.home.vo.HomeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeServ {

    private HomeMapper homeMapper;

    @Autowired
    public void homeMapper(HomeMapper homeMapper){
        this.homeMapper = homeMapper;
    };

    public List<HomeVo> boardList(){
        System.out.println(homeMapper.selectBoardList());
        return homeMapper.selectBoardList();
    }

    public HomeVo boardDetail(String boardNum){
        return homeMapper.selectBoardDetail(boardNum);
    }

}//end
