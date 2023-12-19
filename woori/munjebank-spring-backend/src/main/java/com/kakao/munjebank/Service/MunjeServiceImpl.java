package com.kakao.munjebank.Service;

import com.kakao.munjebank.DAO.MunjeDAO;
import com.kakao.munjebank.VO.MunjeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MunjeServiceImpl implements MunjeService {

    @Autowired
    MunjeDAO munjeDAO;  //사용할 DAO

    //null, 빈곳에 메소드를 지정
    @Override
    public List<MunjeVO> findSelectAll() throws Exception {
        return munjeDAO.findSelectAll();
    }

    @Override
    public List<MunjeVO> findSelectBySubject(String subject) throws Exception {
        return munjeDAO.findSelectBySubject(subject);
    }

    @Override
    public void save(MunjeVO munjeVO) throws Exception {
        munjeDAO.save(munjeVO);
    }

    @Override
    public MunjeVO findSelectByNo(int no) throws Exception {
        return munjeDAO.findSelectByNo(no);
    }

    @Override
    public void update(MunjeVO munjeVO) throws Exception {
        munjeDAO.update(munjeVO);
    }

    @Override
    public void deleteByNo(int no) throws Exception {
        munjeDAO.deleteByNo(no);
    }
}
