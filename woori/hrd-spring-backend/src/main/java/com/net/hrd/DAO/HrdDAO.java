package com.net.hrd.DAO;

import com.net.hrd.VO.HrdVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HrdDAO {
    /*<select id="SelectAll">
    <insert id="insert">
    <select id="SelectById">
    <update id="update">
    <delete id="deleteById">*/
    public List<HrdVO> SelectAll() throws Exception;
    public void insert(HrdVO hrdVO) throws Exception;
    public HrdVO SelectById(int id) throws Exception;
    public void update(HrdVO hrdVO) throws Exception;
    public void deleteById(int id) throws Exception;
}
