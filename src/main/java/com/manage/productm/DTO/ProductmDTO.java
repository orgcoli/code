package com.manage.productm.DTO;

import lombok.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProductmDTO {
    private long pno;
    private String pname;
    private String pcontent;
    private Integer pprice;
    private Integer pamount;
    private LocalDateTime regdate;
}
