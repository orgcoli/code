package com.board.mboard;

import com.board.mboard.Entity.CManage_tbl;
import com.board.mboard.Repository.CManageRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class CmanageRepoTest {
    @Autowired
    private CManageRepository cManageRepository;

    @Test
    public void testInsertLot()throws Exception{
        IntStream.rangeClosed(1,10).forEach(i->{
            CManage_tbl cManage_tbl = CManage_tbl.builder()
                    .cid("ID"+i)
                    .cpassword("password"+i)
                    .cname("연습이")
                    .cemail("이메일")
                    .build();
                    cManageRepository.save(cManage_tbl);
        });
        log.info("저장작업 성공");
    }

    @Test
    public void testUpdate(){
        String cid = "ID1";

        Optional<CManage_tbl> result = cManageRepository.findById(cid);
        CManage_tbl cManage_tbl = result.orElseThrow();

        cManage_tbl.change("passwordfixed","수정된이름", "수정된 이메일");
        cManageRepository.save(cManage_tbl);
    }
}
