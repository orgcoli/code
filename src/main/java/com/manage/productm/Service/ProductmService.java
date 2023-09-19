package com.manage.productm.Service;

import com.manage.productm.DTO.ProductmDTO;
import com.manage.productm.Entity.Productm_tbl;
import com.manage.productm.Repository.ProductmRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductmService {

    private final ProductmRepository productmRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    //Entity를 Controller에서 사용 가능한 DTO로 변환
    public List<ProductmDTO> selectAll(){
        List<Productm_tbl> result = productmRepository.findAll();
        List<ProductmDTO> resultDTO = Arrays.asList(modelMapper.map(result, ProductmDTO[].class));
        return resultDTO;
    }

    //Entity를 Controller에서 사용가능한 DTO로 변환
    public ProductmDTO selectOne(long pno) throws Exception{
        Optional<Productm_tbl> productm_tbl = productmRepository.findById(pno);
        return modelMapper.map(productm_tbl, ProductmDTO.class);
    }

    //DTO를 Repository에서 사용가능한 Entity로 변환
    public Productm_tbl insert(ProductmDTO productmDTO)throws Exception{
        Productm_tbl productm_tbl = modelMapper.map(productmDTO, Productm_tbl.class);
        return productmRepository.save(productm_tbl);   //Entity로 전달달
   }

    //Entity에서 수정할 메소드를 이용해서 부분수정작업
    public void update(ProductmDTO productmDTO)throws Exception{
        Long pno = productmDTO.getPno();
        Optional<Productm_tbl> productm_tbl = productmRepository.findById(pno);
        Productm_tbl update = productm_tbl.orElseThrow();   //찾은 값이 있으면 바꾼 뒤 저장, 없으면 작업중단
        update.change(productmDTO.getPname(), productmDTO.getPcontent(),
                productmDTO.getPprice(), productmDTO.getPamount());
        productmRepository.save(update);
    }
    public void delete(long pno) throws Exception{
        productmRepository.deleteById(pno);
    }
}
