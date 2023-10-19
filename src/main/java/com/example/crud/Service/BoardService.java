package com.example.crud.Service;

import com.example.crud.DTO.BoardDTO;
import com.example.crud.Entity.BoardEntity;
import com.example.crud.Repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

//예외처리를 반드시 적용(throws, try~catch)
@Service
@RequiredArgsConstructor
@Transactional
public class BoardService {
    //사용할 Repository
    private final BoardRepository boardRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    //service 와 Repository 설계를 참고해서 작성
    public void insert(BoardDTO boardDTO) throws Exception{   //삽입
        //DTO->Entity 변환
        BoardEntity boardEntity = modelMapper.map(boardDTO, BoardEntity.class);

        boardRepository.save(boardEntity);
    }

    public void update(BoardDTO boardDTO) throws Exception{   //수정
        int id = boardDTO.getId();  //조회에 필요한 변수를 추출
        Optional<BoardEntity> data = boardRepository.findById(id); //in(int)->out(Optional<Entity>)
        //조회한 Entity와 작업할 Entity
        BoardEntity boardEntity = data.orElseThrow();
        //1. BoardEntity에 setter를 이용해서 수정할 내용만 변경
            //boardEntity.setSubject(boardDTO.getSubject());
            //boardEntity.setSubject(boardDTO.getContent());
        //2. BoardEntity에 setter를 이용해서 조회한 내용만 변경

        //DTO->Entity 변환(수정할 내용들을 변환
        BoardEntity update = modelMapper.map(boardDTO, BoardEntity.class);
        update.setId(boardEntity.getId());  //조회한 내용을 추가
        boardRepository.save(update);
    }

    public void delete(int id) throws Exception{   //삭제
        boardRepository.deleteById(id);
    }

    public List<BoardDTO> findAll() throws Exception{       //모두 조회
        List<BoardEntity> list = boardRepository.findAll();  //in()->out(List<BoardEntity>)
        //변환
        List<BoardDTO> result = Arrays.asList(modelMapper.map(list, BoardDTO[].class));
        return result;
    }

    public BoardDTO fineOne(int id) throws Exception{       //개별 조회(상세)
        Optional<BoardEntity> data = boardRepository.findById(id);

        BoardDTO result = modelMapper.map(data,BoardDTO.class);
        return result;
    }
}
