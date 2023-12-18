/*======================================================================================================
 * 프로그램명    : BaseEntity
 * 설명 : 테이블에 생성일, 수정일을 추가해주는 클래스
 *       @Getter, @Setter, @MappedSuperclass, @EntityListeners 사용
 *       Pagepr231025Application에 @EnableJpaAuditing 사용 필수
 *       createdDate : 생성일(null불가, 수정불가, 테이블 열 이름 created_Date)
 *       modifiedDate : 수정일(테이블 열 이름 modified_Date)
 * 작성자 : 이민호
 * 작성일 : 2023-10-25
 * 수정사항 : ----
 ======================================================================================================*/


package com.example.page_pr_23_10_25.Entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {
    @Column(name = "created_Date", nullable = false, updatable = false)
    @CreatedDate
    private LocalDateTime createdDate;

    @Column(name = "modified_Date")
    @LastModifiedDate
    private LocalDateTime modifiedDate;

}
