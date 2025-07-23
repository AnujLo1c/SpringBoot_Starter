package com.anujl.hospitalManagement.entity;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.anujl.hospitalManagement.model.enums.BloodGroup;
import com.anujl.hospitalManagement.model.enums.Gender;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;
    
    private LocalDate birthDate;

    private String email;

    @Enumerated(EnumType.STRING)
    private BloodGroup bloodGroup;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    
    @JoinColumn(name="insurance_id")
    private Insurance insurance;

    @OneToMany(mappedBy = "patient", cascade = {CascadeType.REMOVE}, orphanRemoval = true, fetch = FetchType.EAGER)
    private final List<Appointment> Appointment=new ArrayList<>();


    
   @Override
public String toString() {
    return "Patient{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", gender=" + gender +
            ", birthDate=" + birthDate +
            ", email='" + email + '\'' +
            ", bloodGroup=" + bloodGroup +
            ", createdAt=" + createdAt +
            ", insurance=" + (insurance != null ? insurance : null) +
            ", appointmentsCount=" + (Appointment != null ? Appointment.size() : 0) +
            '}';
}

}
