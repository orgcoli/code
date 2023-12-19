package com.blue.blboard.Service;

import com.blue.blboard.DAO.BoardDAO;
import com.blue.blboard.VO.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    BoardDAO boardDAO;

    @Override
    public List<BoardVO> boardAllList() throws Exception {
        return boardDAO.boardAllList();
    }

    @Override
    public void boardInsert(BoardVO boardVO) throws Exception {
        boardDAO.boardInsert(boardVO);
    }

    @Override
    public void boardDelete(int bno) throws Exception {
        boardDAO.boardDelete(bno);
    }

    @Override
    public void boardUpdate(BoardVO boardVO) throws Exception {
        boardDAO.boardUpdate(boardVO);
    }

    @Override
    public BoardVO boardOneList(int bno) throws Exception {
        return boardDAO.boardOneList(bno);
    }

    public List<BoardVO> boardByName(String bname) throws Exception{
        return boardDAO.boardByName(bname);
    }
}
