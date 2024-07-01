package com.sosapp.sosjerka.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
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
    private String firstname;
    private String lastname;
    private String email;
    private int age;
    @Pattern(regexp = "[0-9]+", message="Only numbers")
    private String mobile;
    @Pattern(regexp = "[0-9]+", message="Only numbers")
    private String home;

    @Enumerated(EnumType.STRING)
    private UserType type;

    //remove the inactive users
    private Boolean active;
}
