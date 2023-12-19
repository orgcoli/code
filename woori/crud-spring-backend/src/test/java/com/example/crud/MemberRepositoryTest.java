package com.example.crud;

import com.example.crud.Entity.MemberEntity;
import com.example.crud.Repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class MemberRepositoryTest {
    //연결할 클래스가 아니고 테스트를 하고 싶은 클래스를 주입
    @Autowired
    MemberRepository memberRepository;

    //API설계 나 Service설계, Repository설계를 참고해서 이름지정
    @Test   //API설계에서 처리부분에 해당하는 개수만큼, 조회
    public void listForm(){     //목록테스트(받는값 없이 조회 findAll(), List<Entity반환>)
        List<MemberEntity> list = memberRepository.findAll();

        for(MemberEntity data : list){
            System.out.println(data.toString());    //확인은 콘솔로
        }
    }

    @Test
    public void insertProc(){   //삽입테스트(Entity받아서 save() , Entity반환)
        //불안하면 1개만, 정확하면 여러개 레코드를 삽입
        for(int i = 1; i<50; i++) {
            MemberEntity memberEntity = MemberEntity.builder()
                    .username("홍길동" +i)
                    .userid("sample" + i)
                    .userpwd("12345678")
                    .useremail("sample"+i+"@naver.com")
                    .usertel("010-123-4568")
                    .build();

            memberRepository.save(memberEntity);    //확인은 데이터베이스에서
            //MemberEntity result = memberRepository.save(memberEntity);    //저장
        }
    }

    @Test
    public void updateProc(){   //수정테스트(DTO로 받아서 조회(findById) 후 수정부분을 변경해서 저장(save) 반환값(Entity))
        int id = 1001;

        Optional<MemberEntity> find = memberRepository.findById(id);    //조회
        MemberEntity data = find.orElseThrow(); //읽어온 내용을 Entity에 저장
        //수정할 내용을 지정
        data.setUseremail("test@naver.com");
        data.setUserid("test");
        data.setUsername("테스트");

        MemberEntity result = memberRepository.save(data);    //수정된 내용 저장, 확인은 데이터베이스에서
        if(result==null){
            System.out.println("삽입/수정을 실패하였습니다.");
        }else{
            System.out.println("삽입/수정을 성공하였습니다.");
        }
    }

    @Test
    public void deleteProc(){   //삭제테스트(id를 받아서 삭제(delete), 반환값 없음)
        int id =1006;

        memberRepository.deleteById(id);    //삭제 확인은 데이터베이스에서
        boolean check = memberRepository.existsById(id);

        if(check){  //Controller, View 에서 사용가능능
           System.out.println("삭제를 실패하였습니다.");
        }else{
            System.out.println("삭제를 성공하였습니다.");
        }
        System.out.println(memberRepository.existsById(id));
    }

    @Test
    public void detailForm(){   //상세테스트(id를 받아서, 조회(findById), Optional<Entity>반환
        int id = 1005;
        Optional<MemberEntity> result = memberRepository.findById(id);

        System.out.println(result.toString());  //결과확인은 콘솔에서
    }
}
