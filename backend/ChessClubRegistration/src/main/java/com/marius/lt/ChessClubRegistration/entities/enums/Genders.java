package com.marius.lt.ChessClubRegistration.entities.enums;

public enum Genders {
    MALE("male", 3, 5),
    FEMALE("female", 4, 6);

    private final String gender;
    private final int twentiethCentury;
    private final int twentyFirstCentury;

    Genders(String gender, int twentiethCentury, int twentyFirstCentury) {
        this.gender = gender;
        this.twentiethCentury = twentiethCentury;
        this.twentyFirstCentury = twentyFirstCentury;
    }

    public static String getGenderByPin(Long pin) {
        long firstDigit = pin / 100000000000L;
        String gender = "unknown";
        for (Genders g : Genders.values()) {
            if (g.twentiethCentury == firstDigit || g.twentyFirstCentury == firstDigit) {
                gender = g.gender;
                break;
            }
        }
        return gender;
    }
}
