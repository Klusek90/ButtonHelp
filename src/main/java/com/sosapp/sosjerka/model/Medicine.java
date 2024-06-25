package com.sosapp.sosjerka.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private MedDetails medDetails;

    private String medicineName;
    private int dose;

    @Temporal(TemporalType.DATE)
    private Date startToUse;

    @ElementCollection
    private List<LocalTime> scheduleTime;

}
