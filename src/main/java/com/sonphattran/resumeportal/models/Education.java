package com.sonphattran.resumeportal.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "education")
@Data
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "VARCHAR(255) DEFAULT 'University'")
    private String university;

    @Column(columnDefinition = "VARCHAR(255) DEFAULT 'Degree'")
    private String degree;

    @Column(columnDefinition = "VARCHAR(255) DEFAULT 'Details'")
    private String details;

    @Column(columnDefinition = "VARCHAR(255) DEFAULT 'Period'")
    private String period;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "my_user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;
}
