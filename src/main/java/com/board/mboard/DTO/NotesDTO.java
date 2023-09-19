package com.board.mboard.DTO;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class NotesDTO {
    private long no;
    private int type;
    private String title;
    private String content;
    private LocalDateTime nregdate;
    private LocalDateTime nmoddate;
}
