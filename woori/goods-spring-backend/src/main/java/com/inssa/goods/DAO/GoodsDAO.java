package com.inssa.goods.DAO;

import com.inssa.goods.VO.GoodsVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/*
    <select id="selectAll">
    <insert id="insert">
    <select id="selectByGno">
    <update id="updateByGno">
    <delete id="deleteByGno">
*/
@Mapper
public interface GoodsDAO {
    //SQL id명으로 메소드화 시킨다 ==>ResultType 에 있는 VO 전달자 선언
    //By 가 있는 메소드는 BY 뒤에 단어로 변수를 선언
    //삽입, 수정인VO로 인수
    public List<GoodsVO> selectAll() throws Exception;
    public void insert(GoodsVO goodsVO) throws Exception;
    public GoodsVO selectByGno(int gno) throws Exception;
    public void updateByGno(GoodsVO goodsVO) throws Exception;
    public void deleteByGno(int gno) throws Exception;
}