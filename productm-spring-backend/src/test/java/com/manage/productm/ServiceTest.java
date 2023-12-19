package com.manage.productm;

import com.manage.productm.DTO.ProductmDTO;
import com.manage.productm.Entity.Productm_tbl;
import com.manage.productm.Service.ProductmService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
@Log4j2
public class ServiceTest {
    //서비스테스트는 자료와 결과값이 DTO로 구성
    @Autowired
    ProductmService productmService;

    @DisplayName("서비스 추가 테스트")
    @Test
    public void testInsert() throws Exception{
        ProductmDTO productmDTO = ProductmDTO.builder()
                .pname("서비스 테스트 이름")
                .pcontent("서비스 테스트 내용")
                .pprice(10000)
                .pamount(50)
                .build();
        Productm_tbl result = productmService.insert(productmDTO);
        log.info("성공적으로 저장 처리" + result.getPname());
    }

    @DisplayName("서비스 개별 검색 테스트")
    @Test
    public void testFindById() throws Exception{
        long pno = 2L;

        ProductmDTO productmDTO = productmService.selectOne(pno);

        log.info("작업성공 상품이름:" + productmDTO.getPname());
    }

    @DisplayName("서비스 수정 테스트")
    @Test
    public void testUpdate() throws Exception{
        ProductmDTO productmDTO = ProductmDTO.builder()
                .pname("서비스에서 수정된 이름")
                .pcontent("서비스에서 수정된 내용")
                .pprice(2345)
                .pamount(55)
                .pno(2L)
                .build();
        productmService.update(productmDTO);
        log.info("수정작업 성공");
    }

    @DisplayName("서비스 삭제 테스트")
    @Test
    public void delete() throws Exception{
        Long pno = 2L;
        productmService.delete(pno);
        log.info("삭제 성공");
    }
}
