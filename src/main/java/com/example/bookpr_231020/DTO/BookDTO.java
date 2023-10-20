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

    @NotNull(message = "분류코드는 생략이 불가능합니다.")
    private int bcode;

    @NotEmpty(message = "제목은 생략이 불가능합니다.")
    private String bsub;
    private String binfo;

    @NotEmpty(message = "저자는 생략이 불가능합니다.")
    private String bwriter;

    @NotEmpty(message = "출판사는 생략이 불가능합니다.")
    private String bcom;

    @NotEmpty(message = "발매일은 생략이 불가능합니다.")
    private String brel;
    private int bprice;

    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
}
