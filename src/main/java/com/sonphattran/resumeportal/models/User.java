package com.sonphattran.resumeportal.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(unique = true)
    private String username;

    @Column
    private String password;

    @Column
    private String roles;

    @Column
    private boolean isActive;
}
