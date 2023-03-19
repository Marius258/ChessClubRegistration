package com.marius.lt.ChessClubRegistration.dtos;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@Data
public class ChessPlayerPayloadDTO {

    @NotNull(message = "Pin must not be blank")
    @Min(value = 30000000000L, message = "Pin must be 11 digits long and start with 3 - 6")
    @Max(value = 69999999999L, message = "Pin must be 11 digits long and start with 3 - 6")
    private Long pin; // PERSONAL IDENTIFICATION NUMBER
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
