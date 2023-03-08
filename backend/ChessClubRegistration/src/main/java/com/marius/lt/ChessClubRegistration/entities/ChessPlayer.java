package com.marius.lt.ChessClubRegistration.entities;

import com.marius.lt.ChessClubRegistration.entities.enums.Genders;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class ChessPlayer {
    @Id
    @Column(name = "pin", nullable = false)
    private Long pin; // PERSONAL IDENTIFICATION NUMBER
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String lastname;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private LocalDate startedPlaying;

    public String getGender() {
        return String.valueOf(Genders.getGenderByPin(this.pin));
    }
}
