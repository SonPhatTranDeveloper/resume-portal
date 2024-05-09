package com.sonphattran.resumeportal.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "experience")
@Data
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "VARCHAR(255) DEFAULT 'Title'", nullable = false)
    private String title;

    @Column(columnDefinition = "VARCHAR(255) DEFAULT 'Company'", nullable = false)
    private String company;

    @Column(columnDefinition = "VARCHAR(255) DEFAULT 'Company'", nullable = false)
    private String period;

    @Column(columnDefinition = "VARCHAR(1000) DEFAULT 'Description'", nullable = false)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "my_user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;
}
