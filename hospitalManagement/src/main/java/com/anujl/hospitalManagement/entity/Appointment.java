package com.anujl.hospitalManagement.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

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

    private LocalDateTime appointmentTime;

    @ManyToOne
    @JoinColumn
    @NonNull
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    @NonNull
    private Doctor doctor;
 

}
