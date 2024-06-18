package com.sosapp.sosjerka.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.util.List;

@Embeddable
@Data
public class MedicalHistory {

    private String illness;
    private Boolean current;
    private List<String> medicines;

}
