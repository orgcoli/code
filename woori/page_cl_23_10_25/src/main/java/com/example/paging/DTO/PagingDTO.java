/*
 * 프로그램명   : PagingDTO
 * 설명        : HTML에 값을 전달하기 위한 목적
 *              Entity 참고시 상속받은 Entity까지 확인하면서 작업
 *              Entity 1개에 여러개 DTO로 구성
 *              Entitydp 있는 변수를 제외할 수도 있음, 추가도 가능
 *              유효성 검사라고 부르는데 스프링 부트에서는 검증처리라고 한다.
 * 작 성 자    : 이민호
 * 작성일      : 2023년 10월 25일
 * 수정 사항 : 수정한 내용, 수정일자 수정자
 */

package com.example.paging.DTO;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class PagingDTO {
    private int id; //번호

    @NotBlank(message = "제목은 생략이 불가능합니다.")
    private String subject; //제목

    private String content; //내용

    @NotBlank(message = "작성자는 생략이 불가능합니다.")
    private String username;//작성자

    private int viewcnt;    //조회수 상세페이지 넘어갈떄 viewcnt=viewcnt+1 수정처리

    private LocalDateTime createdDate;  //상속받은 필드
}
