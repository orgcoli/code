package com.example.bookpr_231020.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Table(name = "book_tbl")
public class BookEntity extends BaseEntity{
    @Id
    @Column(name = "bid")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long bid;

    @Column(name = "bcode", nullable = false)
    private int bcode;

    @Column(name = "bsub", nullable = false, length = 50)
    private String bsub;

    @Column(name = "binfo", length = 200)
    private String binfo;

    @Column(name = "bwriter", nullable = false, length = 30)
    private String bwriter;

    @Column(name = "bcome", nullable = false, length = 30)
    private String bcom;

    @Column(name = "brel", nullable = false, length = 30)
    private String brel;

    @Column(name = "bprice")
    private int bprice;
}
