package com.board.mboard.Service;

import com.board.mboard.DTO.CManageDTO;
import com.board.mboard.Entity.CManage_tbl;
import com.board.mboard.Repository.CManageRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CManageService {

    private final CManageRepository cManageRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public List<CManageDTO> selectAll(){
        List<CManage_tbl> result = cManageRepository.findAll();
        List<CManageDTO> resultDTO = Arrays.asList(modelMapper.map(result, CManageDTO[].class));
        return resultDTO;
    }

    public CManageDTO SelectOne(String cid) throws Exception{
        Optional<CManage_tbl> result = cManageRepository.findById(cid);
        return modelMapper.map(result, CManageDTO.class);
    }

    public CManage_tbl insert(CManageDTO cManageDTO) throws Exception{
        CManage_tbl result = modelMapper.map(cManageDTO, CManage_tbl.class);
        return cManageRepository.save(result);
    }

    public void update(CManageDTO cManageDTO) throws Exception{
        String cid = cManageDTO.getCid();
        Optional<CManage_tbl> result = cManageRepository.findById(cid);
        CManage_tbl update = result.orElseThrow();
        update.change(cManageDTO.getCpassword(), cManageDTO.getCname(),
                cManageDTO.getCemail());
        cManageRepository.save(update);
    }

    public void delete(String cid) throws Exception{
        cManageRepository.deleteById(cid);
    }
}
