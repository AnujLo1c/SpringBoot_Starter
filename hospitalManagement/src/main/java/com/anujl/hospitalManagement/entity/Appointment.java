package com.anujl.hospitalManagement.entity;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.hibernate.annotations.NotFound;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String reason;

    private String status;

    private LocalDateTime appointmenDateTime;

    @ManyToOne
    @JoinColumn
    @NonNull
    private Patient patient;

    @ManyToOne
    @JoinColumn
    @NonNull
    private Doctor doctor;
 

}
