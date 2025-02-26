package com.n01617765.j2ee_week3.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String firstName;

    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true, length = 100)
    private String userName;

    @Column(nullable = false)
    private String password;

    @Temporal(TemporalType.DATE)
    private Date DOB;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;

    @Column(nullable = false)
    private Boolean isAccountNonExpired = true;

    @Column(nullable = false)
    private Boolean isAccountNonLocked = true;

    @Column(nullable = false)
    private Boolean isCredentialsNonExpired = true;

    @Column(nullable = false)
    private Boolean isEnabled = true;

    // Set default values before persisting to the database
    @PrePersist
    protected void onCreate() {
        createdDate = new Date();
        modifiedDate = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        modifiedDate = new Date();
    }
}
