package com.net.hrd.Service;

import com.net.hrd.VO.HrdVO;

import java.util.List;

public interface HrdService {
    public List<HrdVO> SelectAll() throws Exception;
    public void insert(HrdVO hrdVO) throws Exception;
    public HrdVO SelectById(int id) throws Exception;
    public void update(HrdVO hrdVO) throws Exception;
    public void deleteById(int id) throws Exception;
}
