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

    @Column(columnDefinition = "VARCHAR(255) DEFAULT 'Adam'")
    private String firstName;

    @Column(columnDefinition = "VARCHAR(255) DEFAULT 'Smith'")
    private String lastName;

    @Column(columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean updated;
}
