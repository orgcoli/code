package com.blue.blboard.Service;

import com.blue.blboard.VO.BoardVO;

import java.util.List;

public interface BoardService {
    public List<BoardVO> boardAllList() throws Exception;
    public void boardInsert(BoardVO boardVO) throws Exception;
    public void boardDelete(int bno) throws Exception;
    public void boardUpdate(BoardVO boardVO) throws Exception;
    public BoardVO boardOneList(int bno) throws Exception;
    public List<BoardVO> boardByName(String bname) throws Exception;
}
