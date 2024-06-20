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

    private String medicineName;

    @Temporal(TemporalType.DATE)
    private Date startDate;

    private LocalTime times;



}
