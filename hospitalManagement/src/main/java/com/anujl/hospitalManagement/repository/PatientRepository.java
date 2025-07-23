package com.anujl.hospitalManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anujl.hospitalManagement.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    
}
