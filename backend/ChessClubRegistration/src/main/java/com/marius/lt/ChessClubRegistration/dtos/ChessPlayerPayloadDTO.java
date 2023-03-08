package com.marius.lt.ChessClubRegistration.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class ChessPlayerPayloadDTO {

    private Long pin; // PERSONAL IDENTIFICATION NUMBER
    private String name;
    private String lastname;
    private String email;
    private LocalDate startedPlaying;
}
