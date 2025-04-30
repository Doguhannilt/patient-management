package com.project.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotNull
    private String name;

    @NotNull
    @Email
    @Column(unique = true)
    private String email;

    private String number;

    private Specialization specialization;

    @NotNull
    private int yearsOfExperience;

    @NotNull
    private String hospitalName;

    @NotNull
    private String department;

    @NotNull
    private int licenseNumber;

    @NotNull
    private boolean available;

    @NotNull
    private int patientCount;

    private boolean getMaximumPatient;
}
