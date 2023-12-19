package com.kakao.munjebank.DAO;

import com.kakao.munjebank.VO.MunjeVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MunjeDAO {
    /*<select id="findSelectAll" resultType="MunjeVO">
    <select id="findSelectBySubject" parameterType="String" resultType="MunjeVO">
    <insert id="save" parameterType="MunjeVO">
    <select id="findSelectByNo" parameterType="int" resultType="MunjeVO">
    <update id="update" parameterType="MunjeVO">
    <delete id="deleteByNo" parameterType="int">*/
    public List<MunjeVO> findSelectAll() throws Exception;
    public List<MunjeVO> findSelectBySubject(String subject) throws Exception;
    public void save(MunjeVO munjeVO) throws Exception;
    public MunjeVO findSelectByNo(int no) throws Exception;
    public void update(MunjeVO munjeVO) throws Exception;
    public void deleteByNo(int no) throws Exception;
}
