package com.manage.productm;

import com.manage.productm.Entity.Productm_tbl;
import com.manage.productm.Repository.ProductmRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class RepositoryTest {
    @Autowired
    private ProductmRepository productmRepository;

    @Test
    public void TestInsert(){
        Productm_tbl Productm = Productm_tbl.builder()
                .pname("연습 이름")
                .pcontent("연습 내용")
                .pprice(30000)
                .pamount(40)
                .build();
        Productm_tbl result = productmRepository.save(Productm);
        log.info("데이터 삽입 성공 "+result.getPno());
    }

    @Test
    public void testInsertalot() throws Exception{
        //1~20까지 반복처리
        IntStream.rangeClosed(1,20).forEach(i->{
            Productm_tbl productm_tbl = Productm_tbl.builder()
                    .pname("상품명..." + i)
                    .pcontent("상품설명..."+ i)
                    .pprice(100)
                    .pamount(1)
                    .build();
                    productmRepository.save(productm_tbl);
        });
        log.info("저장작업 성공");
    }

    @Test
    public void testSelect(){
        Long pno = 2L;

        Optional<Productm_tbl> result = productmRepository.findById(pno);
        Productm_tbl productm_tbl = result.orElseThrow();
        log.info(productm_tbl);
    }

    @Test
    public void testUpdate(){
        Long pno = 2L;

        Optional<Productm_tbl> result = productmRepository.findById(pno);
        Productm_tbl productm_tbl = result.orElseThrow();

        productm_tbl.change("수정한 이름", "수정한내용", 1234, 50);
        productmRepository.save(productm_tbl);
    }

    @Test
    public void testDelete(){
        Long pno = 1L;
        productmRepository.deleteById(pno);
        log.info("삭제 성공");
    }

}
