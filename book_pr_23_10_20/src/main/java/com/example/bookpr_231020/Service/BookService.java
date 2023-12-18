package com.example.bookpr_231020.Service;

import com.example.bookpr_231020.DTO.BookDTO;
import com.example.bookpr_231020.Entity.BookEntity;
import com.example.bookpr_231020.Repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    ModelMapper modelMapper = new ModelMapper();

    public void insert(BookDTO bookDTO) throws Exception{
        BookEntity bookEntity = modelMapper.map(bookDTO, BookEntity.class);

        bookRepository.save(bookEntity);
    }

    public void update(BookDTO bookDTO) throws Exception{
        BookEntity bookEntity = modelMapper.map(bookDTO, BookEntity.class);

        bookRepository.save(bookEntity);
    }

    public void delete(Long bid) throws Exception{
        bookRepository.deleteById(bid);
    }

    public List<BookDTO> selectAll() throws Exception{
        List<BookEntity> data = bookRepository.findAll();
        List<BookDTO> result = Arrays.asList(modelMapper.map(data, BookDTO[].class));
        return result;
    }

    public BookDTO selectOne(Long bid) throws Exception{
        Optional<BookEntity> data = bookRepository.findById(bid);
        BookDTO result = modelMapper.map(data, BookDTO.class);
        return result;
    }
}
