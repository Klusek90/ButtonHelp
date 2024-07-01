package com.sosapp.sosjerka.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Data
public class Patron {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private Long userId;
    private String firstname;
    private String surname;
    private String nickname;

    @Pattern(regexp = "[0-9]+", message="Only numbers")
    private String mobile;
    @Pattern(regexp = "[0-9]+", message="Only numbers")
    private String home;
    @Pattern(regexp = "[0-9]+", message="Only numbers")
    private String office;
    private int listPosition;

    public Patron() {

    }
}