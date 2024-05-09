package com.sonphattran.resumeportal.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "my_user_id")
    private List<Education> education = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "my_user_id")
    private List<Skill> skills = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "my_user_id")
    private List<Experience> experiences = new ArrayList<>();

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roles='" + roles + '\'' +
                ", active=" + active +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", updated=" + updated +
                '}';
    }
}
