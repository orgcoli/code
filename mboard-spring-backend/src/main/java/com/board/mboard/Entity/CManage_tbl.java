package com.board.mboard.Entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "cmanage_tbl")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class CManage_tbl {
    @Id
    private String cid;

    @Column(name = "cpassword", length = 20, nullable = false)
    private String cpassword;

    @Column(name = "cname", length = 10, nullable = false)
    private String cname;

    @Column(name = "cemail", length = 20)
    private String cemail;

    @CreatedDate
    @Column(name="regdate")
    private LocalDateTime regdate;

    public void change(String cpassword, String cname, String cemail){
        this.cpassword = cpassword;
        this.cname = cname;
        this.cemail = cemail;
    }
}
