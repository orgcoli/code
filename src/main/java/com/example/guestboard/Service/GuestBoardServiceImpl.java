package com.example.guestboard.Service;

import com.example.guestboard.DTO.GuestbookDTO;
import com.example.guestboard.DTO.PageRequestDTO;
import com.example.guestboard.DTO.PageResultDTO;
import com.example.guestboard.Entity.Guestbook;
import com.example.guestboard.Entity.QGuestbook;
import com.example.guestboard.Repository.GuestbookRepository;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Function;

@Service    //서비스 클래스 선언
@Log4j2     //로그 작업
@RequiredArgsConstructor    //사용할 Repository를 자동 주입, 컨트롤에서도 반드시 선언
public class GuestBoardServiceImpl implements GuestBoardService {
    //Repository를 반드시 선언
    private final GuestbookRepository guestbookRepository;  //주작업대상

    //Ctrl-I를 눌러서 인터페이스의 메소드를 추가
    @Override
    public Long register(GuestbookDTO guestbookDTO) {
        Guestbook entity = dtoTOEntity(guestbookDTO);
        guestbookRepository.save(entity);    //받아온 DTO를 Entity로 변환해서 저장
        return entity.getGno();     //번호를 전달(없음)
    }

    @Override
    public void modify(GuestbookDTO guestbookDTO) {
        //수정할 레코드를 읽어온다.
        //번호에 해당하는 레코드를 읽어온다.
        Optional<Guestbook> result = guestbookRepository.findById(guestbookDTO.getGno());
        if(result.isPresent()){ //레코드가 존재하면
            Guestbook entity = result.get();    //읽어온 레코드를 변수에 저장
            entity.changeTitle(guestbookDTO.getTitle());    //수정할 부분만 재저장
            entity.changeContent(guestbookDTO.getContent());

            guestbookRepository.save(entity);   //수정내용을 저장
        }

    }

    @Override
    public void remove(Long gno) {
        guestbookRepository.deleteById(gno);    //해당번호로 삭제
    }

    @Override
    public GuestbookDTO read(Long gno) {
        //해당하는 번호의 레코드를 읽어온다.
        Optional<Guestbook> result = guestbookRepository.findById(gno);
        //내용이 있으면 Entity를 DTO로 변환해서 전달
        //      읽어온 값이 있으면      DTO로 변환해서 전달        :없으면 null값을 전달달
        return result.isPresent()?entityTODto(result.get()):null;
    }

    @Override
    public PageResultDTO<GuestbookDTO, Guestbook> getList(PageRequestDTO requestDTO) {
        //정렬방식 (번호로 내림차순 정렬)
        Pageable pageable = requestDTO.getPageable(Sort.by("gno").descending());
        //검색 조건 처리
        BooleanBuilder booleanBuilder = getSearch(requestDTO);
        //해당 조건에 맞는 자료를 정렬해서 읽어온다.
        Page<Guestbook> result = guestbookRepository.findAll(booleanBuilder, pageable);
        //결과를 전달
        Function<Guestbook, GuestbookDTO> fn =(entity->entityTODto(entity));
        return new PageResultDTO<>(result, fn);
    }
    //조건 처리 하는 메소드
    private BooleanBuilder getSearch(PageRequestDTO requestDTO){
        //메소드를 이용해서 질의어를 만들어서 제공
        String type = requestDTO.getType(); //분류
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        //querydsl를 사용하기 위해서 기본 Entity이름 앞에 Q를 붙여 사용
        QGuestbook qGuestbook = QGuestbook.guestbook;
        String keyword = requestDTO.getKeyword();   //검색어
        //select * guestbook where gno>0
        //질의어문법   Where gno>0                       번호>0
        BooleanExpression expression = qGuestbook.gno.gt(0L);   /* *****주의****** */
        booleanBuilder.and(expression); //기존 조건에 추가

        //검색할 분류가 없으면 더이상 조건 없이 전달
        //분류가 없거나 여백제거후 길이가 0이면
        if(type==null||type.trim().length()==0){
            //번호가 0보다 큰 레코드만 읽어온다
            return booleanBuilder;
        }

        //t, c, w, tc, tcw
        //검색할 내용이 존재하면
        BooleanBuilder conditionBuilder = new BooleanBuilder();
        if(type.contains("t")){ //분류가 t가 포함되어 있으면
            //select * guestbook where gno>0 or title = "*keyword*"
            //제목에 검색어가 포함되어 있으면
            conditionBuilder.or(qGuestbook.title.contains(keyword));
        }
        if(type.contains("c")){ //분류가 t가 포함되어 있으면
            //select * guestbook where gno>0 or title = "*keyword*" or content = "*keyword*"
            //제목에 검색어가 포함되어 있으면
            conditionBuilder.or(qGuestbook.content.contains(keyword));
        }
        if(type.contains("w")){ //분류가 t가 포함되어 있으면
            //select * guestbook where gno>0 or title = "*keyword*" or content = "*keyword*" or writer
            //제목에 검색어가 포함되어 있으면
            conditionBuilder.or(qGuestbook.writer.contains(keyword));
        }
        //where gno>0 and title = "*keyword*" or content = "*keyword*" or writer = "*keyword*"
        //번호는 0보다 크고 제목에 검색어가 포함되어 있거나, 내용에 검색어가 포함되어 있거나,
        //작성자에 검색어가 포함되어있는 자료탐색
        booleanBuilder.and(conditionBuilder);

        return booleanBuilder;
    }

    //Test에서 서비스에 등록된 메소드에 대한 단위테스트 진행
}
