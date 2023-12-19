package com.example.guestboard.DTO;

import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//하단에 페이지 버튼에 관한 직업에 필요한 DTO
@Data
public class PageResultDTO<DTO, EN> {
    //[<][1][2][3][4][5][6][7][8][9][10][>]
    private List<DTO> dtoList;      //페이지 번호를 저장10페이지 1,2,3,4,5,6,.... 10
    private int totalPage;          //전체 페이지수를 저장
    private int page;               //현재 페이지 번호
    private int size;               //페이지당 항목의 갯수 전체 100개/10단위=10페이지
    private int start, end;         //시작페이지번호, 끝페이지번호
    private boolean prev, next;     //이전과 다음 버튼의 상태, 1페이지이면 이전(비활성화), 마지막페이지이면 다음(비활성화)
    private List<Integer> pageList; //페이지번호만 목록저장

    //페이지의 정보를 전달하는 메소드
    public PageResultDTO(Page<EN> result, Function<EN, DTO> fn){
        dtoList = result.stream().map(fn).collect(Collectors.toList());
        totalPage = result.getTotalPages();
        makePageList(result.getPageable()); //페이지 계산하는 메소드
    }

    private void makePageList(Pageable pageable){
        this.page = pageable.getPageNumber()+1;   //데이터베이스페이지+1 ==>화면 페이지 번호 size가 아닌 number
        this.size = pageable.getPageSize();

        int tempEnd = (int)(Math.ceil(page/10.0)*10);   //끝 페이지 번호
        start = tempEnd - 9;    //0~9 시작페이지 번호
        prev =  start>1;    //시작페이지가 1보다 크면 이전버튼 활성화
        end = totalPage>tempEnd?tempEnd:totalPage;  //마지막 번호 조건?참:거짓
        next = totalPage>tempEnd;
        //지정범위
        pageList = IntStream.rangeClosed(start,end).boxed().collect(Collectors.toList());
    }
}
