package com.veterinaryProyect.Veterinary_Clinic.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "breed")
    private String breed;

    @Column(name = "gender")
    private String gender;

    @Column(name = "identificationNumber", nullable = false)
    private String identificationNumber;

    @Column(name = "tutorFirstName")
    private String tutorFirstName;

    @Column(name = "tutorLastName")
    private String tutorLastName;

    @Column(name = "tutorPhoneNumber")
    private String tutorPhoneNumber;

    @Column(name = "treatment")
    private String treatment;

    @Column(name = "profileImage")
    private String profileImage;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Appointment> appointments;
}
