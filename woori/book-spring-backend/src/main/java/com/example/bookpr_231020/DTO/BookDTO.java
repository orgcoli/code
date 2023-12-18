package com.example.bookpr_231020.DTO;

import lombok.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDTO {
    private Long bid;

    private int bcode;

    @NotEmpty(message = "생략이 불가능합니다.")
    private String bsub;
    private String binfo;

    @NotEmpty(message = "생략이 불가능합니다.")
    private String bwriter;

    @NotEmpty(message = "생략이 불가능합니다.")
    private String bcom;

    @NotEmpty(message = "생략이 불가능합니다.")
    private String brel;
    private int bprice;

    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
}
