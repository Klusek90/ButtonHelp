package com.sosapp.sosjerka.model;

public enum BloodType {

    A_POSITIVE("A+"),
    A_NEGATIVE("A-"),
    B_POSITIVE("B+"),
    B_NEGATIVE("B-"),
    AB_POSITIVE("AB+"),
    AB_NEGATIVE("AB-"),
    O_POSITIVE("O+"),
    O_NEGATIVE("O-");

    private final String bloodtype;

    BloodType(String bloodtype) {
        this.bloodtype = bloodtype;
    }

    public String getDisplayName() {
        return bloodtype;
    }

    @Override
    public String toString() {
        return bloodtype;
    }
}
