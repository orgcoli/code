package com.example.todo_pr_23_10_27.Service;

import com.example.todo_pr_23_10_27.DTO.TodoDTO;
import com.example.todo_pr_23_10_27.Entity.TodoEntity;
import com.example.todo_pr_23_10_27.Repository.TodoRepository;
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
public class TodoService {
    private final TodoRepository todoRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public void insert(TodoDTO todoDTO) throws Exception{
        TodoEntity todoEntity = modelMapper.map(todoDTO, TodoEntity.class);

        todoRepository.save(todoEntity);
    }

    public void update(TodoDTO todoDTO) throws Exception{
        int lid = todoDTO.getLid();
        Optional<TodoEntity> todoEntity = todoRepository.findById(lid);
        TodoEntity data = todoEntity.orElseThrow();

        TodoEntity update = modelMapper.map(todoDTO, TodoEntity.class);
        update.setLid(data.getLid());

        todoRepository.save(update);
    }

    public void delete(int lid)throws Exception{
        todoRepository.deleteById(lid);
    }

    public TodoDTO detail(int lid) throws Exception{
        Optional<TodoEntity> todoEntity = todoRepository.findById(lid);

        TodoDTO todoDTO = modelMapper.map(todoEntity, TodoDTO.class);
        return todoDTO;
    }

    public Page<TodoDTO> list(Pageable page) throws Exception{
        int currentPage = page.getPageNumber()-1;
        int pageLimit = 5;

        Pageable pageable = PageRequest.of(currentPage, pageLimit, Sort.by(Sort.Direction.DESC, "lid"));

        Page<TodoEntity> todoEntityPage = todoRepository.findAll(pageable);

        Page<TodoDTO> todoDTOS = todoEntityPage.map(data->TodoDTO.builder()
                .lid(data.getLid())
                .ltitle(data.getLtitle())
                .lcontent(data.getLcontent())
                .fterm(data.getFterm())
                .lterm(data.getLterm())
                .limpt(data.getLimpt())
                .build());
        //나중에 필요시 mod, reg date 추가하기

        return todoDTOS;
    }
}
