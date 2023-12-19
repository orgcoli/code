package com.board.mboard;

import com.board.mboard.DTO.CManageDTO;
import com.board.mboard.Entity.CManage_tbl;
import com.board.mboard.Service.CManageService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class CmanageServiceTest {
    @Autowired
    CManageService cManageService;

    @DisplayName("서비스 추가 테스트")
    @Test
    public void TestInsert() throws Exception{
        CManageDTO cManageDTO = CManageDTO.builder()
                .cid("example1")
                .cpassword("example1")
                .cname("연습이")
                .cemail("연습 이메일")
                .build();
        CManage_tbl result = cManageService.insert(cManageDTO);
        log.info("성공적으로 저장 처리" + result.getCid());
    }

    @DisplayName("서비스 개별 검색 테스트")
    @Test
    public void testSelectOne() throws Exception{
        String cid = "example1";

        CManageDTO cManageDTO = cManageService.SelectOne(cid);

        log.info("작업성공! 이름:" + cManageDTO.getCname());
    }

    @DisplayName("서비스 수정 테스트")
    @Test
    public void testUpdate() throws Exception{
        CManageDTO cManageDTO = CManageDTO.builder()
                .cpassword("수정된 비밀 번호")
                .cname("수정된 이름")
                .cemail("수정된 이메일")
                .cid("example1")
                .build();
        cManageService.update(cManageDTO);
        log.info("수정작업성공");
    }
}
