package com.example.shopping_cl_23_11_02.Service;

import com.example.shopping_cl_23_11_02.DTO.ProductDTO;
import com.example.shopping_cl_23_11_02.Entity.ProductEntity;
import com.example.shopping_cl_23_11_02.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

//11.작업처리
//DTO는 관리자, 사용자 등 분리해서 사용
//기본 CRUD 구현, 메소드명은 파일명과 동일하게 작성
@Service

@RequiredArgsConstructor
@Transactional
public class ProductService {
    //파일이 저장될 경로
    @Value("${imgUploadLocation}")
    private String imgUploadLocation;
    //작업할 레포시토리
    private final ProductRepository productRepository;
    //파일저장을 위한 클래스
    private final FileService fileService;
    private final ModelMapper modelMapper = new ModelMapper();

    //삭제(Delete)
    public void remove(Integer id) throws Exception{
        //물리적위치에 저장된 이미지를 삭제
        ProductEntity productEntity = productRepository
                .findById(id)
                .orElseThrow(); //조회->저장

        fileService.deleteFile(imgUploadLocation, productEntity.getImg());
        //레코드를 삭제
        productRepository.deleteById(id);
    }
    //개별조회(Read)
    public ProductDTO detail(Integer id) throws Exception{
        ProductEntity productEntity = productRepository
                .findById(id)
                .orElseThrow(); //조회->저장
        ProductDTO productDTO = modelMapper.map(productEntity, ProductDTO.class);
        return productDTO;
    }
    //전체조회(Read)
    public List<ProductDTO> list() throws Exception{
        List<ProductEntity> productEntities =productRepository.findAll();

        List<ProductDTO> productDTOS = Arrays.asList(modelMapper.map(productEntities, ProductDTO[].class));

        return productDTOS;
    }
    //삽입(Create)
    public void register(ProductDTO productDTO, MultipartFile imgFile) throws Exception{
        String originalFileName = imgFile.getOriginalFilename();    //저장할 파일명
        String newFileName = "";

        if(originalFileName != null){   //파일이 존재하면
            newFileName = fileService.uploadFile(imgUploadLocation,
                    originalFileName,
                    imgFile.getBytes());

        }
        productDTO.setImg((newFileName));   //새로운 파일명을 재등록
        //변환
        ProductEntity productEntity = modelMapper.map(productDTO, ProductEntity.class);
        productRepository.save(productEntity);
    }
    //수정(update)
    public void modify(ProductDTO productDTO, MultipartFile imgFile) throws Exception{
        //기존파일 삭제
        ProductEntity productEntity = productRepository
                .findById(productDTO.getPid())
                .orElseThrow(); //조회->저장
        String deleteFile = productEntity.getImg();


        String originalFileName = imgFile.getOriginalFilename();    //저장할 파일명
        String newFileName = "";    //productEntity.getImg(); 넣으면 html 수정 안해도 됌.
        if(originalFileName.length() != 0){   //파일이 존재하면0
            //바꿀 파일이 있으면
            if(deleteFile.length() != 0){ //기존파일이 있으면
                fileService.deleteFile(imgUploadLocation, deleteFile);
            }

            newFileName = fileService.uploadFile(
                    imgUploadLocation,
                    originalFileName,
                    imgFile.getBytes());

            productDTO.setImg((newFileName));   //새로운 파일명을 재등록

        }
        productDTO.setPid(productEntity.getPid());



        //변환
        ProductEntity data = modelMapper.map(productDTO, ProductEntity.class);
        productRepository.save(data);
    }
}
