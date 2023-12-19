package com.blue.blboard.DAO;


import com.blue.blboard.VO.BoardVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface BoardDAO {
    public List<BoardVO> boardAllList() throws Exception;
    public void boardInsert(BoardVO boardVO) throws Exception;
    public void boardDelete(int bno) throws Exception;
    public void boardUpdate(BoardVO boardVO) throws Exception;
    public BoardVO boardOneList(int bno) throws Exception;
    public List<BoardVO> boardByName(String bname) throws Exception;
}

/*<select id="boardAllList" resultType="BoardVO">
<insert id="boardInsert">
<delete id="boardDelete">
<update id="boardUpdate">
<select id="boardOneList" resultType="BoardVO">*/