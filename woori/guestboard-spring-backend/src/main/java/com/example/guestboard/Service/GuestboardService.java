package com.example.guestboard.Service;

import com.example.guestboard.DTO.GuestboardDTO;
import com.example.guestboard.Entity.GuestboardEntity;
import com.example.guestboard.Repository.GuestboardRepository;
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
public class GuestboardService {
    private final GuestboardRepository guestboardRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    //삽입
    public void register(GuestboardDTO guestboardDTO)throws Exception{
        GuestboardEntity guestboardEntity = modelMapper.map(guestboardDTO, GuestboardEntity.class);

        guestboardRepository.save(guestboardEntity);
    }

    //수정
    public void modify(GuestboardDTO guestboardDTO) throws Exception{
        int gno = guestboardDTO.getGno();   //조회할 번호
        Optional<GuestboardEntity> guestboardEntity = guestboardRepository.findById(gno);   //조회
        GuestboardEntity data = guestboardEntity.orElseThrow();
        //작업공간에 저장
        GuestboardEntity update = modelMapper.map(guestboardDTO, GuestboardEntity.class);
        update.setGno(data.getGno());
        guestboardRepository.save(update);

    }
    //조회
    public GuestboardDTO read(int gno) throws Exception{
        Optional<GuestboardEntity> guestboardEntity = guestboardRepository.findById(gno);

        GuestboardDTO guestboardDTO = modelMapper.map(guestboardEntity, GuestboardDTO.class);

        return guestboardDTO;
    }

    //삭제
    public void remove(int gno) throws Exception{
        guestboardRepository.deleteById(gno);
    }

    //조회
    public Page<GuestboardDTO> list(String type, int page, String keyword)throws Exception{
        int pageLimit = 10; //한 페이지 출력될 레코드의 수
        Page<GuestboardEntity> guestboardEntitie;
        Pageable pageable = PageRequest.of(page-1, pageLimit, Sort.by(Sort.Direction.DESC,"gno"));
        //if문을 이용해서
        if(type.equals("t") && keyword !=null){
            guestboardEntitie = guestboardRepository.searchTitle(keyword, pageable);
        }else if(type.equals("c") && keyword !=null){
            guestboardEntitie = guestboardRepository.searchContent(keyword, pageable);
        }else if(type.equals("w") && keyword !=null){
            guestboardEntitie = guestboardRepository.searchWriter(keyword, pageable);
        }else if(type.equals("tc") && keyword !=null){
            guestboardEntitie = guestboardRepository.searchTitleContent(keyword, pageable);
        }else if(type.equals("tcw") && keyword !=null){
            guestboardEntitie = guestboardRepository.searchTitleContentWriter(keyword, pageable);
        }else {
            guestboardEntitie = guestboardRepository.findAll(pageable);
        }

        //결과변환
        Page<GuestboardDTO> guestboardDTOS = guestboardEntitie.map(data-> GuestboardDTO.builder()
                .gno(data.getGno())
                .title(data.getTitle())
                .content(data.getContent())
                .writer(data.getWriter())
                .regDate(data.getRegDate())
                .modDate(data.getModDate())
                .build());

        return guestboardDTOS;
    }
}
