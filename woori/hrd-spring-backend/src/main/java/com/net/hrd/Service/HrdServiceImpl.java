package com.net.hrd.Service;

import com.net.hrd.DAO.HrdDAO;
import com.net.hrd.VO.HrdVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HrdServiceImpl implements HrdService {

    @Autowired
    HrdDAO hrdDAO;

    //인터페이스를 오버라이딩에서 구성(예전)
    //버전업되면서 bean이용 등록(요새)
    @Override
    public List<HrdVO> SelectAll() throws Exception {
        return hrdDAO.SelectAll();
    }

    @Override
    public void insert(HrdVO hrdVO) throws Exception {
        hrdDAO.insert(hrdVO);
    }

    @Override
    public HrdVO SelectById(int id) throws Exception {
        return hrdDAO.SelectById(id);
    }

    @Override
    public void update(HrdVO hrdVO) throws Exception {
        hrdDAO.update(hrdVO);
    }

    @Override
    public void deleteById(int id) throws Exception {
        hrdDAO.deleteById(id);
    }


}
