package com.example.article.Service;

//의견작업(등록, 삭제, 토론글에 해당하는 의견목록, 좋아요, 싫어요)

import com.example.article.DTO.OpinionDTO;
import com.example.article.Entity.DiscussionEntity;
import com.example.article.Entity.OpinionEntity;
import com.example.article.Repository.DiscussionRepository;
import com.example.article.Repository.OpinionRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class OpinionService {
    private final OpinionRepository opinionRepository;
    private final ModelMapper modelMapper = new ModelMapper();
    private final DiscussionRepository discussionRepository;    //부모테이블

    //삭제(번호에 해당하는 자료를 삭제)
    public void remove(Integer id) throws Exception{
        opinionRepository.deleteById(id);
    }
    //등록(부모테이블의 레코드 번호, DTO 받아서 Entity 변환한 후 저장처리)
    public void register(int id,OpinionDTO opinionDTO) throws Exception{
        //부모테이블의 해당 레코드를 조회
        Optional<DiscussionEntity> disscusionEntity = discussionRepository.findById(id);
        DiscussionEntity data =disscusionEntity.orElseThrow();  //저장
        //변환
        //부모 테이블 정보가 존재하지 않는다
        OpinionEntity opinionEntity = modelMapper.map(opinionDTO, OpinionEntity.class);
        opinionEntity.setDiscussionEntity(data);    //부모레코드 정보를 추가

        opinionRepository.save(opinionEntity);  //저장장
    }
    //해당 토른글에 의견을 조회
    //토론번호에 해당하는 의견 자료들을 읽어서 전달
    public List<OpinionDTO> list(Integer id) throws Exception{
        //토론번호와 일치하는 자료를 조회

        List<OpinionEntity> opinionEntityList = opinionRepository.findByDiscussionid(id);
        //변환(Entity->DTO)
        List<OpinionDTO> opinionDTOS = Arrays.asList(modelMapper.map(opinionEntityList, OpinionDTO[].class));
        return opinionDTOS;
    }
    //좋아요
    //해당 의견번호에 좋아요 증가
    public void goodcnt(int id) throws Exception{
        opinionRepository.goodcnt(id);
    }

    //싫어요
    public void badcnt(int id) throws Exception{
        opinionRepository.badcnt(id);
    }

}
