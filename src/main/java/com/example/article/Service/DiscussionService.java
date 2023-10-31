package com.example.article.Service;

import com.example.article.DTO.DiscussionDTO;
import com.example.article.Entity.DiscussionEntity;
import com.example.article.Repository.DiscussionRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional

public class DiscussionService {
    private final DiscussionRepository discussionRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    //삭제(메소드명은 맵핑이름을 discussion/remove)
    //(번호)에 해당하는 게시물을 삭제
    public void remove(Integer id) throws Exception{
        discussionRepository.deleteById(id);
    }

    //삽입
    //DTO로 전달받은 내용을 Entity로 변환해서 저장
    public void register(DiscussionDTO discussionDTO) throws Exception{
        DiscussionEntity discussionEntity = modelMapper.map(discussionDTO, DiscussionEntity.class);

        discussionRepository.save(discussionEntity);
    }

    //개별조회
    //해당번호를 조회해서 DTO로 변환해서 전달
    public DiscussionDTO read(Integer id) throws Exception{
        Optional<DiscussionEntity> disscusionEntity = discussionRepository.findById(id);
        //DTO변환
        DiscussionDTO discussionDTO = modelMapper.map(disscusionEntity, DiscussionDTO.class);
        return discussionDTO;
    }

    //수정
    //DTO를 전달받아서 해당 자료가 있는지 확인하고 수정한 내용을 Entity로 변환후 수정처리
    public void modify(DiscussionDTO discussionDTO)throws Exception{
        //DTO에서 id만 추출
        Integer id = discussionDTO.getId();
        //해당 id를 조회
        Optional<DiscussionEntity> search = discussionRepository.findById(id);
        DiscussionEntity discussionEntity =search.orElseThrow();   //오류검사(존재여부)

        //수정할 내용을 변환(DTO->Entity)
        DiscussionEntity update =modelMapper.map(discussionDTO, DiscussionEntity.class);

        update.setId(discussionEntity.getId()); //조회한 id로 제차 확인

        discussionRepository.save(update);
    }
    //전체조회
    //페이지정보를 이용해서 해당페이지로 부터 10개의 데이터를 읽어서 전달
    public Page<DiscussionDTO> list(Pageable pageable) throws Exception{
        //화면페이지번호(1,2,3,4....) 데이터베이스 페이지 번호(0,1,2,3,4....)
        //화면에서 페이지번호를 데이터베이스 페이지번호 계산
        int curPage = pageable.getPageNumber()-1;
        int pageLimit = 10; //한페이지당 읽을 데이터의 개수

        //계산된 정보를 이용해서 새로운 페이지 정보를 만든다.
        //(현재페이지, 개수, 정렬(오름/내림차순, 필드명))
        Pageable newPage = PageRequest.of(curPage, pageLimit, Sort.by(Sort.Direction.DESC, "id"));

        //페이지정보로 조회
        Page<DiscussionEntity> disscusionEntities = discussionRepository.findAll(newPage);

        //Entity를 DTO로 변환(Mapper X, 하나씩 읽어서 하나씩 DTO에 저장)
        //Entity.map(별칭-> 변환할 DTO
        Page<DiscussionDTO> disscussionDTOS = disscusionEntities.map(data-> DiscussionDTO.builder()
                .id(data.getId())
                .subject(data.getSubject())
                .viewcnt(data.getViewcnt())
                .regDate(data.getRegDate())
                .modDate(data.getModDate())
                .build());  //순서는 중요하지 않고, .DTO필드명(Entity.필드명)

        return disscussionDTOS;

    }

    //조회수(추가)
    //해당id에 조회수를 1증가 처리
    public void viewcnt(Integer id) throws Exception{
        discussionRepository.viewcnt(id);   //정상동작시, 비정상동작 조회-> 수정작업->수정처리리
    }
}
