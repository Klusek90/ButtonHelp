package com.sosapp.sosjerka.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class MedDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_details_id")
    private UserDetails userDetails;

    @Enumerated(EnumType.STRING)
    private BloodType bloodType;

    private String disabilty;

    private Boolean independentMobility;

    @OneToMany(mappedBy = "medDetails",fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Medicine> medicines;

    @OneToMany(mappedBy = "medDetails",fetch = FetchType.LAZY, orphanRemoval = true)
    private List<MedHistory> history;

    @ElementCollection
    private List<String> allergens;
}
