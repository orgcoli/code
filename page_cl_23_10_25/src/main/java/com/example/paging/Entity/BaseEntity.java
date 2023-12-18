package com.example.paging.Entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

//오류는 실행 불가능
//경고는 실행은 가능, 규칙이나 예기치 않은 일이 발생한 가능성이 있는 경우
//스프링부트에 기본경고는 이름지정시 규칙이 틀린경우
//모든 테이블에서 사용할 공통 필드
//클래스 생성자, getter, setter, toString 작업
//Entity는 테이블의 필드와 연동
@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {
    @Column(name="created_Date", nullable = false, updatable = false)
    @CreatedDate
    private LocalDateTime createdDate;  //생성일

    @Column(name = "modified_Date")
    @LastModifiedDate
    private LocalDateTime modifiedDate; //수정일
    //Entity내에 변수 선언 후 필요한 메소드를 작성
    //변수가 추가 및 수정이 발생하면 메소드를 수정하는 시간이 오래걸린다.
    //개발자의 수정시간을 단축하기 위해서 lombok을 활용한다.
    //기본 메소드는 lombok으로 그외 메소드는 개발자가 작성

}
