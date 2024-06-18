package com.sosapp.sosjerka.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Patron {
    String name;
    String phoneNumber;

}