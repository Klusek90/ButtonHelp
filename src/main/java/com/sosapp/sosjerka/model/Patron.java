package com.sosapp.sosjerka.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Patron {
    private String name;
    private String phoneNumber;

}