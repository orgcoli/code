package com.example.jpauses.Service;

import com.example.jpauses.DTO.BoardDTO;
import com.example.jpauses.Entity.BoardEntity;
import com.example.jpauses.Repository.SearchRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor    //자동주입 Autowired 대체
@Transactional
public class SearchService {
    private final SearchRepository searchRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    //원하는 결과가 나오도록 프로그래밍
    //if문을 주로 사용, 유효성검사, 작업별 분기
    public List<BoardDTO> subjectSearch(String gubun, String search) throws Exception{
        List<BoardEntity> boardEntityList;  //여기에서 선언하는것이 중요 if문 안에서 절대로 사용금지.
        //3가지 검색에 따른 조회처리
        //gubun이 1이면서 search에 내용이 있으면
        if (gubun.equals("1") && search != null){
            //List<BoardEntity> if 내에서 존재하고 if를 벗어나면 소멸
            boardEntityList = searchRepository.findAllBySubjectContains(search);
        }else if(gubun.equals("2") && search != null){
            boardEntityList = searchRepository.findAllByUsernameContains(search);
        }else if(gubun.equals("3") && search != null){
            boardEntityList = searchRepository.findSearch(search);
        } else{ //모든 검색인 경우
            boardEntityList = searchRepository.findAll();
        }

        List<BoardDTO> result = Arrays.asList((modelMapper.map(boardEntityList, BoardDTO[].class)));

        return result;
    }

}
