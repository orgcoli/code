package com.example.eval_pr_23_11_01.Service;

import com.example.eval_pr_23_11_01.DTO.EvalDTO;
import com.example.eval_pr_23_11_01.Entity.EvalEntity;
import com.example.eval_pr_23_11_01.Repository.EvalRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class EvalService {
    private final EvalRepository evalRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public void insert(EvalDTO evalDTO)throws Exception{
        EvalEntity evalEntity = modelMapper.map(evalDTO, EvalEntity.class);

        evalRepository.save(evalEntity);
    }

    //수정
    //조회
    public EvalDTO detail(Integer id)throws Exception{
        Optional<EvalEntity> evalEntity = evalRepository.findById(id);

        EvalDTO evalDTO = modelMapper.map(evalEntity, EvalDTO.class);

        return evalDTO;
    }
    //삭제
    public void delete(Integer id)throws Exception{
        evalRepository.deleteById(id);
    }

    public Page<EvalDTO> list(Pageable pageable, String keyword, String type) throws Exception{
        int curPage = pageable.getPageNumber()-1;
        int pageLimit = 3;

        Pageable ePage = PageRequest.of(curPage, pageLimit, Sort.by(Sort.Direction.DESC,"id"));
        Page<EvalEntity> evalEntities;

        //if문
        if(type.equals("p")&& keyword!=null){
            evalEntities = evalRepository.searchPname(keyword, ePage);
        }else if(type.equals("l")&& keyword!=null){
            evalEntities = evalRepository.searchLname(keyword, ePage);
        }else if(type.equals("e")&& keyword!=null){
            evalEntities = evalRepository.searchEtitle(keyword, ePage);
        }else if(type.equals("pl")&& keyword!=null){
            evalEntities = evalRepository.searchPnameLname(keyword, ePage);
        }else if(type.equals("ple")&& keyword!=null){
            evalEntities = evalRepository.searchPnameLnameEtitle(keyword, ePage);
        }else {
            evalEntities = evalRepository.findAll(ePage);
        }



        Page<EvalDTO> evalDTOS = evalEntities.map(data-> EvalDTO.builder()
                .id(data.getId())
                .userid(data.getUserid())
                .lname(data.getLname())
                .pname(data.getPname())
                .lyear(data.getLyear())
                .sdivide(data.getSdivide())
                .ldivide(data.getLdivide())
                .etitle(data.getEtitle())
                .econtent(data.getEcontent())
                .tscore(data.getTscore())
                .gscore(data.getGscore())
                .cscore(data.getCscore())
                .lscore(data.getLscore())
                .lcount(data.getLcount())
                .build());

        return evalDTOS;
    }

    public void lcount(Integer id) throws Exception{
        evalRepository.lcount(id);
    }
}
