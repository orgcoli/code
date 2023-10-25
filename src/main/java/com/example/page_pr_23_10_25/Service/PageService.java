package com.example.page_pr_23_10_25.Service;

import com.example.page_pr_23_10_25.Repository.PageRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class PageService {
    private final PageRepository pageRepository;
    private final ModelMapper modelMapper = new ModelMapper();


}
