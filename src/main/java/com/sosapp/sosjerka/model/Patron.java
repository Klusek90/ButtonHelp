package com.sosapp.sosjerka.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Patron {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String firstname;
    private String surname;
    private String nickname;
    private String mobile;
    private String home;
    private String office;

}