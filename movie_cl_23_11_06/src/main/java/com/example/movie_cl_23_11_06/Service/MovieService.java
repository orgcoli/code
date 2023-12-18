package com.example.movie_cl_23_11_06.Service;

import com.example.movie_cl_23_11_06.DTO.MovieDTO;
import com.example.movie_cl_23_11_06.Entity.MovieEntity;
import com.example.movie_cl_23_11_06.Repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;

@Service

@RequiredArgsConstructor
@Transactional
public class MovieService {
    @Value("${productloadPath}")
    private String productloadPath;
    private final MovieRepository movieRepository;
    private final FileService fileService;
    private final ModelMapper modelMapper = new ModelMapper();

    public void delete(Integer id) throws Exception{
        MovieEntity movieEntity = movieRepository.findById(id).orElseThrow();

        fileService.deleteFile(productloadPath, movieEntity.getImg());

        movieRepository.deleteById(id);
    }

    public MovieDTO detail(Integer id) throws  Exception{
        MovieEntity movieEntity = movieRepository.findById(id).orElseThrow();

        MovieDTO movieDTO = modelMapper.map(movieEntity, MovieDTO.class);
        return movieDTO;
    }

    //전체조회 나중에 페이지 처리 필요
    public List<MovieDTO> list() throws Exception{
        List<MovieEntity> movieEntities = movieRepository.findAll();

        List<MovieDTO> movieDTOS = Arrays.asList(modelMapper.map(movieEntities, MovieDTO[].class));

        return movieDTOS;
    }

    public void insert(MovieDTO movieDTO, MultipartFile imgFile) throws Exception{
        String originalFileName = imgFile.getOriginalFilename();
        String newFileName = "";

        if(originalFileName != null){
            newFileName = fileService.uploadFile(productloadPath,
                    originalFileName, imgFile.getBytes());
        }
        movieDTO.setImg((newFileName));

        MovieEntity movieEntity = modelMapper.map(movieDTO, MovieEntity.class);
        movieRepository.save(movieEntity);
    }

    public void update(MovieDTO movieDTO, MultipartFile imgFile)throws Exception{
        MovieEntity movieEntity = movieRepository.findById(movieDTO.getId()).orElseThrow();
        String deleteFile = movieEntity.getImg();

        String originalFileName = imgFile.getOriginalFilename();
        String newFileName = "";

        if(originalFileName.length() !=0){

            if (deleteFile.length() !=0){
                fileService.deleteFile(productloadPath, deleteFile);
            }

            newFileName = fileService.uploadFile(
                    productloadPath,
                    originalFileName,
                    imgFile.getBytes());

            movieDTO.setImg((newFileName));


        }
        movieDTO.setId(movieEntity.getId());


        MovieEntity data = modelMapper.map(movieDTO, MovieEntity.class);
        movieRepository.save(data);
    }

}
