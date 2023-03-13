package com.marius.lt.ChessClubRegistration.dtos;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class ChessPlayerDTO {

    private Long pin;
    private String name;
    private String lastname;
    private String email;
    private String gender;
    private int age;
    private String timeSinceStartedPlaying;
}
