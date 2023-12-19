package com.example.guestboard.Service;

import com.example.guestboard.DTO.GuestbookDTO;
import com.example.guestboard.DTO.PageRequestDTO;
import com.example.guestboard.DTO.PageResultDTO;
import com.example.guestboard.Entity.Guestbook;

//서비스에 사용할 메소드 뼈대 지정
//Controller에서 호출할 메소드이름->작업내역과 비슷하게

//default 기본형 - 오버라이드 x
//일반 메소드는 implement에서 내용을 채우기가 필요
public interface GuestBoardService {
    //데이터베이스 작업을 위해 필요한 메소드
    //저장(DTO로 받아서 -> Entity에 전달)
    Long register(GuestbookDTO guestbookDTO);

    //수정(DTO로 받아서 -> Entity에 전달)
    void modify(GuestbookDTO guestbookDTO);

    //삭제(번호 받아서 -> Entity에 전달)
    void remove(Long gno);

    //상세보기(번호 받아서 -> Entity에 전달 -> DTO결과 받기)
    GuestbookDTO read(Long gno);

    //페이지별 조회(requestDTO ->Entity에 전달->GuestbookDTO, Guestbook 받기)
    PageResultDTO<GuestbookDTO, Guestbook> getList(PageRequestDTO requestDTO);

    //부수적으로 작업에 필요한 메소드
    //DTO->Entity 변환, Entity->DTO 변환
    default Guestbook dtoTOEntity(GuestbookDTO guestbookDTO){   //DTO에서 Entity로
        Guestbook entity = Guestbook.builder()
                .gno(guestbookDTO.getGno())
                .title(guestbookDTO.getTitle())
                .content(guestbookDTO.getContent())
                .writer(guestbookDTO.getWriter())
                .build();
        return entity;
    }

    default GuestbookDTO entityTODto(Guestbook guestbook){   //DTO에서 Entity로
        GuestbookDTO guestbookDTO = GuestbookDTO.builder()
                .gno(guestbook.getGno())
                .title(guestbook.getTitle())
                .content(guestbook.getContent())
                .writer(guestbook.getWriter())
                .build();
        return guestbookDTO;
    }

}
