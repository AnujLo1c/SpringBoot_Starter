package com.anujl.hospitalManagement.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Department {
      
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
   
    @CreationTimestamp
    private LocalDateTime createdAt;
    

  @OneToOne
    private Doctor headDoctor;

@ManyToMany
     @JoinTable(
            name = "my_dpt_doctors"
           ,joinColumns = @JoinColumn(name = "dept")
             ,inverseJoinColumns = @JoinColumn(name = "doctors")
    )
    Set<Doctor> doctors=new HashSet<>();
    
}
