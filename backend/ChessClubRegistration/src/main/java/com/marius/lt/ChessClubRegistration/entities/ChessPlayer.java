package com.marius.lt.ChessClubRegistration.entities;

import com.marius.lt.ChessClubRegistration.entities.enums.Genders;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class ChessPlayer {
    @Id
    @Column(nullable = false)
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
        return Genders.getGenderByPin(this.getFirstDigitFromPin());
    }

    public String getTimeSinceStartedPlaying() {
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(this.startedPlaying, currentDate);
        return String.format("%d years %d months %d days", period.getYears(), period.getMonths(), period.getDays());
    }

    public int getAge() {
        return Period.between(this.parseDobFromPin(), LocalDate.now()).getYears();
    }

    private LocalDate parseDobFromPin() {
        String pin = String.valueOf(this.pin);
        int year = Integer.parseInt(pin.substring(1, 3));
        int month = Integer.parseInt(pin.substring(3, 5));
        int day = Integer.parseInt(pin.substring(5, 7));
        return LocalDate.of(this.getCentury() + year, month, day);
    }

    private int getFirstDigitFromPin() {
        return (int) (pin / 10000000000L);
    }

    private int getCentury() {
        int firstDigitFromPin = this.getFirstDigitFromPin();
        int century = 0;
        if (firstDigitFromPin == 3 || firstDigitFromPin == 4) {
            century = 1900;
        } else if (firstDigitFromPin == 5 || firstDigitFromPin == 6) {
            century = 2000;
        }
        return century;
    }
}
