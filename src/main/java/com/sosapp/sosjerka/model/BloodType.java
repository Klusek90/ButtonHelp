package com.sosapp.sosjerka.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

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

    @JsonValue
    public String getBloodtype(){
        return bloodtype;
    }

    @Override
    public String toString() {
        return bloodtype;
    }
}
