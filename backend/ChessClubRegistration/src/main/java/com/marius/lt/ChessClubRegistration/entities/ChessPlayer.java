package com.marius.lt.ChessClubRegistration.entities;

import com.marius.lt.ChessClubRegistration.entities.enums.Genders;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;

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
        return Genders.getGenderByPin(this.pin);
    }

    public String getDob() {
        String dateFromPin = Long.toString((this.pin / 10000) % 1000000);
        DateFormat inputFormat = new SimpleDateFormat("yyMMdd");
        DateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return outputFormat.format(inputFormat.parse(dateFromPin));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getTimeSinceStartedPlaying() {
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(this.startedPlaying, currentDate);
        return String.format("%d years %d days",
                period.getYears(),
                period.getMonths());
    }
}
