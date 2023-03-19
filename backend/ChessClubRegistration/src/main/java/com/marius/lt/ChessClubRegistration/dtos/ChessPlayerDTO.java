package com.marius.lt.ChessClubRegistration.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ChessPlayerDTO {

    private Long id;
    private String name;
    private String lastname;
    private String email;
    private String gender;
    private int age;
    private String timeSinceStartedPlaying;
}
