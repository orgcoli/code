package com.example.guestboard.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


//폼에서 페이지 정보를 받아올 DTO
@Builder
@Data
@AllArgsConstructor
public class PageRequestDTO {
    //사용자가 정의한 멤버변수
    private int page;       //페이지번호
    private int size;       //페이지당 개수
    private String type;    //검색분류
    private String keyword; //검색어

    public PageRequestDTO(){
        this.page=1;    //기본값으로 페이지는 1페이지
        this.size=10;   //기본값으로 페이지당 항목개수는 10개
   }

   public Pageable getPageable(Sort sort){
        return PageRequest.of(page-1, size, sort);
        //페이지번호 화면에는    1,2,3,4,5...
        //데이터베이스          0,1,2,3,4,5...
        //그래서 page-1필요
   }
}
