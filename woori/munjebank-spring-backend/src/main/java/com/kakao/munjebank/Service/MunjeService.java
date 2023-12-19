package com.kakao.munjebank.Service;

import com.kakao.munjebank.VO.MunjeVO;

import java.util.List;

//DAO의 선언된 메소드를 그대로 복사
public interface MunjeService {
    public List<MunjeVO> findSelectAll() throws Exception;
    public List<MunjeVO> findSelectBySubject(String subject) throws Exception;
    public void save(MunjeVO munjeVO) throws Exception;
    public MunjeVO findSelectByNo(int no) throws Exception;
    public void update(MunjeVO munjeVO) throws Exception;
    public void deleteByNo(int no) throws Exception;
}
