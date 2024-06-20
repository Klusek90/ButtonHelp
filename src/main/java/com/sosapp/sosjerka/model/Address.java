package com.sosapp.sosjerka.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String address1;
    private String address2;
    private String address3;

    @OneToOne
    @JoinColumn(name = "postcode_id")
    private Postcode postcode;
}
