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

    @OneToOne
    @JoinColumn(name = "contact_id")
    private Contact contact;

}