package com.marius.lt.ChessClubRegistration.entities.enums;

public enum Genders {
    MALE("male", 3, 5),
    FEMALE("female", 4, 6);

    private final String title;
    private final int twentiethCentury;
    private final int twentyFirstCentury;

    Genders(String title, int twentiethCentury, int twentyFirstCentury) {
        this.title = title;
        this.twentiethCentury = twentiethCentury;
        this.twentyFirstCentury = twentyFirstCentury;
    }

    public static String getGenderByPin(int firstDigitFromPin) {
        String gender = "unknown";
        for (Genders g : Genders.values()) {
            if (g.twentiethCentury == firstDigitFromPin || g.twentyFirstCentury == firstDigitFromPin) {
                gender = g.title;
                break;
            }
        }
        return gender;
    }
}
