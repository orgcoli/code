package com.example.jpauses.Service;

import com.example.jpauses.DTO.BoardDTO;
import com.example.jpauses.Entity.BoardEntity;
import com.example.jpauses.Repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor    //자동주입 Autowired 대체
@Transactional
public class BoardService {
    //사용할 Repository를 선언
    private final BoardRepository boardRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    //조회처리만...
    //throws Exception 반드시 매 메소드에 추가
    //1. 전체 목록 불러오기
    public List<BoardDTO> findAll() throws Exception{
        List<BoardEntity> list = boardRepository.findAll(); //조회작업
        List<BoardDTO> result = Arrays.asList(modelMapper.map(list, BoardDTO[].class));   //변환

        return result;
    }
    //2. 전체 목록 불러오기(결과를 Entity로 전달)
    public List<BoardEntity> findAllEntity() throws Exception{
        List<BoardEntity> list = boardRepository.findAll();

        return list;
    }
/*
    //3. 전체 목록은 내림차순으로 조회
    public List<BoardDTO> listOrder() throws Exception{
        List<BoardEntity> list = boardRepository.findAllByOrderByIdDesc(); //조회작업

        List<BoardDTO> result = Arrays.asList(modelMapper.map(list, BoardDTO[].class));   //변환

        return result;
    }

    //4. 검색어를통해서 해당제목을 조회
    public List<BoardDTO> listSubjectSearch(String search) throws Exception{
        List<BoardEntity> list = boardRepository.findAllBySubject(search);

        List<BoardDTO> result = Arrays.asList(modelMapper.map(list, BoardDTO[].class));   //변환

        return result;
    }

    //5. 앞에 문자열이 포함되어 있는 제목을 조회
    public List<BoardDTO> listSubjectStart(String search) throws Exception{
        List<BoardEntity> list = boardRepository.findAllBySubjectStartsWith(search);

        List<BoardDTO> result = Arrays.asList(modelMapper.map(list, BoardDTO[].class));   //변환

        return result;
    }

    //6. 뒤에 문자열이 포함되어 있는 제목을 조회
    public List<BoardDTO> listSubjectEnd(String search) throws Exception{
        List<BoardEntity> list = boardRepository.findAllBySubjectEndsWith(search);
        List<BoardDTO> result = Arrays.asList(modelMapper.map(list, BoardDTO[].class));   //변환

        return result;
    }

    public List<BoardDTO> listSubjectContain(String search) throws Exception{
        List<BoardEntity> list = boardRepository.findAllBySubjectContains(search);
        List<BoardDTO> result = Arrays.asList(modelMapper.map(list, BoardDTO[].class));   //변환

        return result;
    }
    //수동으로 문자열이 포함되어 있는 제목을 조회
    public List<BoardDTO> listSubjectLike(String search) throws Exception{
        List<BoardEntity> list = boardRepository.findAllBySubjectLike("%"+search+"%");
        List<BoardDTO> result = Arrays.asList(modelMapper.map(list, BoardDTO[].class));   //변환

        return result;
    }

    //9. Query를 이용한 제목을 조회
    public List<BoardDTO> listSubjectSql(String search) throws Exception{
        List<BoardEntity> list = boardRepository.findAllBySubjectSql("%"+search+"%");
        List<BoardDTO> result = Arrays.asList(modelMapper.map(list, BoardDTO[].class));   //변환

        return result;
    }

    //10. 서로다른 변수를 연결하여 제목을 조회
    public List<BoardDTO> listSubjectSqlNo(String search) throws Exception{
        List<BoardEntity> list = boardRepository.findAllBySubjectSqlNo("%"+search+"%");
        List<BoardDTO> result = Arrays.asList(modelMapper.map(list, BoardDTO[].class));   //변환

        return result;
    }

    //11. 2개 이상의 필드로 조회
    public List<BoardDTO> listManyField(String search) throws Exception{
        List<BoardEntity> list = boardRepository.findAllBySubjectContainsOrUsernameContains(search, search);
        List<BoardDTO> result = Arrays.asList(modelMapper.map(list, BoardDTO[].class));   //변환

        return result;
    }

    //12
    public List<BoardDTO> listManyFieldSql(String search) throws Exception{
        List<BoardEntity> list = boardRepository.findAllByField("%"+search+"%", "%"+search+"%");
        List<BoardDTO> result = Arrays.asList(modelMapper.map(list, BoardDTO[].class));   //변환

        return result;
    }

    //13. 10보다 작은 게시물 조회
    public List<BoardDTO> listLessThan(int id) throws Exception{
        List<BoardEntity> list = boardRepository.findAllByIdLessThan(id);
        List<BoardDTO> result = Arrays.asList(modelMapper.map(list, BoardDTO[].class));   //변환

        return result;
    }

    //14. 조회수가 5보다 큰 게시물 조회
    public List<BoardDTO> listViewGreaterThan(int viewcnt) throws Exception{
        List<BoardEntity> list = boardRepository.findAllByViewcntGreaterThanOrderByViewcntDesc(viewcnt);
        List<BoardDTO> result = Arrays.asList(modelMapper.map(list, BoardDTO[].class));   //변환

        return result;
    }*/


 }
//테스트에서 동작 확인