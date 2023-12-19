package com.example.guestboard.CRUD;

import com.example.guestboard.Entity.Guestbook;
import com.example.guestboard.Repository.GuestbookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest //테스트 클래스
public class GuestbookRepositoryTest {
    @Autowired
    private GuestbookRepository guestbookRepository;

    @Test   //메소드별로 작업하고 싶거나 확인하고 싶은 부분을 메소드 구성
    public void insertTest(){
        //임의의 값으로 300번을 반복해서 테이블에 저장하는 작업
        //범위값 만큼 동작 후 종료
        //i-> i값이 변할 때 마다 처리
        IntStream.rangeClosed(1, 300).forEach(i->
                {
                    //guestbook 생성자를 만들기
                    //.멤버변수(값)
                    Guestbook guestbook = Guestbook.builder()
                            .title("제목..."+i)
                            .content("내용..."+i)
                            .writer("작성자"+(i%10))
                            .build();
                    //Repository.save(Entity) 저장, 수정정
                   System.out.println(guestbookRepository.save(guestbook));
                });
    }
    @Test
    public void  updateTest(){
        //수정은 수정할 레코드를 지정 -> 수정한 내용을 변경처리
        //Optional<Entity>
        Optional<Guestbook> result = guestbookRepository.findById(1L);  //수정할 레코드 번호
        if(result.isPresent()){ //해당레코드가 존재하면
            Guestbook guestbook = result.get(); //해당 레코드를 읽어와서
            guestbook.changeTitle("제목변경");
            guestbook.changeContent("내용변경");

            guestbookRepository.save(guestbook);    //수정작업
        }
    }
}
