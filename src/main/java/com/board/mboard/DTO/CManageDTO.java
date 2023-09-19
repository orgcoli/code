package com.board.mboard.DTO;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class CManageDTO {
    private String cid;
    private String cpassword;
    private String cname;
    private String cemail;
    private LocalDateTime regdate;
}
