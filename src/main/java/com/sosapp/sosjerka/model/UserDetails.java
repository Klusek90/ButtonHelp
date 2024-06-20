package com.sosapp.sosjerka.model;

import jakarta.persistence.*;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@Entity
@Data
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String email;
    private int age;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @Enumerated(EnumType.STRING)
    private UserType type;

//    @ElementCollection
//    @CollectionTable(name = "user_patrons", joinColumns = @JoinColumn(name = "user_id"))
//    private List<Patron> patronList;

    @Enumerated(EnumType.STRING)
    private BloodType bloodType;

//    @ElementCollection
//    @CollectionTable(name = "medical_history", joinColumns = @JoinColumn(name = "user_id"))
//    private List<MedicalHistory> history;

}
