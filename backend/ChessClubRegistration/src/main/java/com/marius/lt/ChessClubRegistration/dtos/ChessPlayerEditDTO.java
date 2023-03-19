package com.marius.lt.ChessClubRegistration.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@Data
public class ChessPlayerEditDTO {

    @NotBlank(message = "Name must not be blank")
    private String name;
    @NotBlank(message = "Lastname must not be blank")
    private String lastname;
    @NotBlank(message = "Email must not be blank")
    @Email(message = "Incorrect email format")
    private String email;
    @PastOrPresent(message = "Started playing date is in the future")
    private LocalDate startedPlaying;
}
