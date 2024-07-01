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
    private String firstname;
    private String lastname;
    private String email;
    private int age;
    private String mobile;
    private String home;

    @Enumerated(EnumType.STRING)
    private UserType type;

    //remove the inactive users
    private Boolean active;
}
