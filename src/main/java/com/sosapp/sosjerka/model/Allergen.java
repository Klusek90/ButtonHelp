package com.sosapp.sosjerka.model;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
public class Allergen {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String allergyFor;

}