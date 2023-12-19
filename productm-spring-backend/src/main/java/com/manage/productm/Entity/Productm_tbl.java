package com.manage.productm.Entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "productm_tbl")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)  //Entity 처리시 날짜처리
public class Productm_tbl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pno;

    @Column(name = "pname",length = 100,nullable = false)
    private String pname;

    @Column(name = "pcontent", length = 1000)
    private String pcontent;

    @Column(name = "pprice")
    private Integer pprice;

    @Column(name = "pamount", nullable = false )
    private Integer pamount;

    @CreatedDate
    @Column(name = "regdate")
    private LocalDateTime regdate;

    public void change(String pname, String pcontent,
                       Integer pprice, Integer pamount){
        this.pname = pname;
        this.pcontent = pcontent;
        this.pprice = pprice;
        this.pamount = pamount;
    }
}
