package com.sonphattran.resumeportal.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "my_user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true)
    private String username;

    @Column
    private String password;

    @Column
    private String roles;

    @Column
    private boolean active;
}
