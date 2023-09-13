package com.example.guestboard.Service;

import com.example.guestboard.DTO.GuestbookDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//1. 데이터베이스 연결 테스트
//2. Repository 데이터베이스 조작 테스트(삽입, 수정, 삭제, 조회)
//3. Service 연동 테스트(Service에 선언된 모든 메소드)
//Service 영역에 있는 메소드를 체크
@SpringBootTest //테스트 클래스
public class GuestbookServiceTest {
    @Autowired
    private GuestBoardService guestBoardService;

    @Test
    public void testRegister(){ //등록테스트
        //가상의 컨트롤에서 값을 전달
        GuestbookDTO guestbookDTO = GuestbookDTO.builder()
                .title("테스트 제목")
                .content("테스트 내용")
                .writer("테스터")
                .build();

        System.out.println(guestBoardService.register(guestbookDTO));
   }

   @Test
   public void TestRemove(){    //레코드삭제
        Long gno = 5L;
        //          컨트롤러에서 전달받은 입력값     서비스가 컨트롤러에 전달할 값
        //Remove(Long gno)  void
        guestBoardService.remove(gno);
   }
}
