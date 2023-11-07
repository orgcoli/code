package com.example.movie_cl_23_11_06.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

@Table(name = "movie")
@SequenceGenerator(
        name = "movie_SEQ",
        sequenceName = "movie_SEQ",
        initialValue = 1,
        allocationSize = 1
)

public class MovieEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "movie_SEQ")
    private Integer id;

    @Column(length = 100, nullable = false)
    private String movie;

    private String content;

    private String img;
}
