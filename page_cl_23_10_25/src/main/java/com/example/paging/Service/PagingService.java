/*
 * 프로그램명   : PagingService
 * 설명        : Repository를 처리하기 위한 준비작업
 *              처리된 결과를 재가공처리 작업
 *              Controller와 Repository를 연결하는 작업
 * 작 성 자    : 이민호
 * 작성일      : 2023년 10월 25일
 * 수정 사항 : 수정한 내용, 수정일자 수정자
 */
package com.example.paging.Service;

import com.example.paging.DTO.PagingDTO;
import com.example.paging.Entity.PagingEntity;
import com.example.paging.Repository.PagingRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service    //클래스의 사용 목적
@RequiredArgsConstructor    //자동주입
@Transactional
public class PagingService {
    //주입할 클래스를 지정 (Controller에서도 동일)
    private final PagingRepository pagingRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    //개발자가 메소드명을 임의로 지정해서 작업내용을 작성
    //public 사용할 Repository 메소드를 참고 search(사용할 Repository 참고)
    public List<PagingDTO> search(String subject) throws Exception{
        List<PagingEntity> pagingEntity;

        //List Entity를 개별 Entity로 바꾼후 개별 DTO에 저장하고, List DTO에 개별 DTO를 다시 저장장
       //메소드명의 전달값과 결과값의 유형이 틀리면 변환작업
        if(subject == null){    //검색어가 없는 경우
            pagingEntity = pagingRepository.findAll();
        }else { //검색어가 있는 경우
            pagingEntity =pagingRepository.findSearch(subject);
        }


        List<PagingDTO> result = Arrays.asList(modelMapper.map(pagingEntity, PagingDTO[].class));
        return result;
    }

    //페이징 처리 (FindAll을 이용해서)
    //Page는 DTO+Page정보를 같이 전달, Pageable은 page 정보만
    public Page<PagingDTO> paging(Pageable pageable) throws Exception{
        //조회할 페이지 번호와 읽어올 개수가 필요하다.
        //화면페이지번화 1,2,3,4,5........ 데이터베이스 페이지번호 0,1,2,3,4,5
        int page = pageable.getPageNumber()-1; //화면번호 -1로 실제 데이터베이스 페이지 번호를 변경
        int pageLimit = 10; //페이지당 읽어올 개수 지정
        //PageRequest.of(읽어올 페이지, 개수, 정렬(정렬방식, 필드)) 변경된 pageable 정보를 설정
        //page정보 + Entity자료

        //중요=====================
        //결과처리
        Page<PagingEntity> pagingEntities =pagingRepository
                .findAll(PageRequest.of(page, pageLimit, Sort.by(Sort.Direction.DESC, "id")));

        //변환(mapper DTO->Entity, Entity->DTO, Page->DTO(X)
        //                           pagingEntities의 개별자료를 board_paging지정->(재조립)->DTO
        //entity로 보내는 경우엔 생략가능
        Page<PagingDTO> pagingDTOS = pagingEntities.map(board_paging->PagingDTO.builder()
                .id(board_paging.getId())
                .subject(board_paging.getSubject())
                .username(board_paging.getUsername())
                .createdDate(board_paging.getCreatedDate())
                .viewcnt(board_paging.getViewcnt())
                .build());
        return pagingDTOS;
    }
}

//html 디자인, Service 까지 오류가 없으면 html 적용(모든 오류)
//Repository, Service 는 한 기능별로 작업 후 적용... 작업 후 적용....
