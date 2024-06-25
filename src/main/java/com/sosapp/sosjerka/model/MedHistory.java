package com.sosapp.sosjerka.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class MedHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String issueName;
    private boolean current;

    @Temporal(TemporalType.DATE)
    private Date fromDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private MedDetails medDetails;
}
