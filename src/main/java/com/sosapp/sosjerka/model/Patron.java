package com.sosapp.sosjerka.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;

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
    private String mobile;
    private String home;
    private String office;
    private int listPosition;

    public Patron() {

    }
}