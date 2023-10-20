package com.example.crud.Service;

import com.example.crud.DTO.MemberDTO;
import com.example.crud.Entity.MemberEntity;
import com.example.crud.Repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;    //연동할 클래스
    ModelMapper modelMapper = new ModelMapper();        //변환용

    //Service 설계 참고(받는값, 보내는값), 예외처리를 반드시 적용
    public void insert(MemberDTO memberDTO) throws Exception{  //회원등록
        //변환(받은값, 변환할 클래스)
        MemberEntity memberEntity = modelMapper.map(memberDTO, MemberEntity.class);

        memberRepository.save(memberEntity);    //Entity가 필요
    }

    public void update(MemberDTO memberDTO) throws Exception{  //회원수정
        //기존에 수정할 데이터가 존재하는지를 확인
        //int id = memberDTO.getId();
        //Optional<MemberEntity> find = memberRepository.findById(id);
        //memberRepository.findById(memberDTO.getId());
        //MemberEntity data = find.orElseThrow(); //정상적으로 조회처리가 되었으면 저장

        MemberEntity memberEntity = modelMapper.map(memberDTO, MemberEntity.class);
        //memberEntity.setId(data.getId());   //기존내용

        memberRepository.save(memberEntity);    //Entity가 필요
    }
    public void delete(int id) throws Exception{  //회원삭제
        memberRepository.deleteById(id);
    }

    public List<MemberDTO> findAll() throws Exception{ //회원전체조회
        List<MemberEntity> memberEntityList = memberRepository.findAll();  //받는 값 없음, List로 변환
        List<MemberDTO> memberDTOList = Arrays.asList( modelMapper.map(memberEntityList, MemberDTO[].class));
        return memberDTOList;
        //return memberRepository.findAll(); 가능
    }

    public MemberDTO findOne(int id) throws Exception{ //회원개별조회회
        Optional<MemberEntity> memberEntity =memberRepository.findById(id);
        //변환
        MemberDTO memberDTO = modelMapper.map(memberEntity, MemberDTO.class);
        return memberDTO;
    }
}
//Controller에 해당하는 메소드를 연결해서 사용
